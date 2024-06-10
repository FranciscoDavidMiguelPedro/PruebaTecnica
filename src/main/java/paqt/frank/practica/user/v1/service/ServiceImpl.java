package paqt.frank.practica.user.v1.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import paqt.frank.practica.user.v1.constant.Constantes;
import paqt.frank.practica.user.v1.constant.Folio;
import paqt.frank.practica.user.v1.dao.IUsuarioDao;
import paqt.frank.practica.user.v1.dto.UsuarioDto;
import paqt.frank.practica.user.v1.enums.EMensajeException;
import paqt.frank.practica.user.v1.error.ErrorGener;
import paqt.frank.practica.user.v1.modresp.RespuestaGen;

@Service
public class ServiceImpl implements IService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceImpl.class);

	@Autowired
	private IUsuarioDao iUsuarioDao;
	
	@Override
	public RespuestaGen<Integer> registrarUsuario(UsuarioDto usuario) {
		LOGGER.info("Registrar Usuario del Service Implements");
		RespuestaGen<Integer> respuesta = new RespuestaGen<>();
		Integer info = iUsuarioDao.registrarUsuario(usuario);

		if (ObjectUtils.isEmpty(info)) {
			ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_404), EMensajeException.E404);

		}
		respuesta.setFolio(Folio.generarFolio());
		respuesta.setResultado(info);
		respuesta.setMensaje(Constantes.MSJ_OPERACION_EXITOSA);
		return respuesta;
	}

	@Override
	public RespuestaGen<String> actualizarUsuario(UsuarioDto usuario) {
		String info= iUsuarioDao.actualizarUsuario(usuario);
		RespuestaGen<String> respuesta= null;
		respuesta = new RespuestaGen<>();
		if (ObjectUtils.isEmpty(info)) {
			ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_404), EMensajeException.E404);
		}
		respuesta.setFolio(Folio.generarFolio());
		respuesta.setMensaje(Constantes.MSJ_OPERACION_EXITOSA);
		respuesta.setResultado(info);
		return respuesta;
	}
	
	@Override
	public RespuestaGen<String> eliminarUsuarioPorId(Integer id) {
		String info = iUsuarioDao.eliminarUsuarioPorId(id);
		RespuestaGen<String> respuesta = null;
		respuesta = new RespuestaGen<>();
		
		if (ObjectUtils.isEmpty(info)) {
			ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_404), EMensajeException.E404);
		}
		respuesta.setFolio(Folio.generarFolio());
		respuesta.setMensaje(Constantes.MSJ_OPERACION_EXITOSA);
		respuesta.setResultado(info);
		return respuesta;
	}

	@Override
	public RespuestaGen<Boolean> validarUsuario(String login, String password) {
		Boolean info = iUsuarioDao.validarUsuario(login,password);
		RespuestaGen<Boolean> respuesta = null;
		respuesta = new RespuestaGen<>();
		
		if (ObjectUtils.isEmpty(info)) {
			ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_404), EMensajeException.E404);
		}
		respuesta.setFolio(Folio.generarFolio());
		respuesta.setMensaje(Constantes.MSJ_OPERACION_EXITOSA);
		respuesta.setResultado(info);
		return respuesta;
	}

	@Override
	public RespuestaGen<List<UsuarioDto>> buscarUsuariosPorStatus(String status) {
		List<UsuarioDto> info = iUsuarioDao.buscarUsuariosPorStatus(status);
		RespuestaGen<List<UsuarioDto>> respuesta = null;
		respuesta = new RespuestaGen<>();
		
		if (ObjectUtils.isEmpty(info)) {
			ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_404), EMensajeException.E404);
		}
		respuesta.setFolio(Folio.generarFolio());
		respuesta.setMensaje(Constantes.MSJ_OPERACION_EXITOSA);
		respuesta.setResultado(info);
		return respuesta;
	
	}

	

}
