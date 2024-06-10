package paqt.frank.practica.user.v1.service;

import java.util.List;

import paqt.frank.practica.user.v1.dto.UsuarioDto;
import paqt.frank.practica.user.v1.modresp.RespuestaGen;

public interface IService {

	/**
	 * Metodo para hacer Registro completo
	 * 
	 * @param usuario
	 * @return RespuestaGenerica
	 */
	RespuestaGen<Integer> registrarUsuario(UsuarioDto usuario);

	/***
	 * Metodo para hacer la actualizacion del registro por Id
	 * 
	 * @param usuario
	 * @return RespuestaGenerica
	 */
	RespuestaGen<String> actualizarUsuario(UsuarioDto usuario);

	/**
	 * Metdo para hacer la eliminacion del registro por id
	 * 
	 * @param id
	 * @return RespuestaGenerica
	 */
	RespuestaGen<String> eliminarUsuarioPorId(Integer id);

	/**
	 * Validacion de la busqueda del registro existente mediante logeo y pasword
	 * 
	 * @param login
	 * @param password
	 * @return RespuestaGenerica
	 */
	RespuestaGen<Boolean> validarUsuario(String login, String password);

	/**
	 * Metodo para hacer la busqueda mediante el estatus
	 * 
	 * @param status
	 * @return RespuestaGenerica
	 */
	RespuestaGen<List<UsuarioDto>> buscarUsuariosPorStatus(String status);

}
