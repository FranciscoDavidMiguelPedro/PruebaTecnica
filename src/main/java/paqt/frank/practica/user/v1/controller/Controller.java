package paqt.frank.practica.user.v1.controller;

import java.sql.SQLException;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import paqt.frank.practica.user.v1.constant.Constantes;
import paqt.frank.practica.user.v1.dto.UsuarioDto;
import paqt.frank.practica.user.v1.modresp.RespuestaGen;
import paqt.frank.practica.user.v1.service.ServiceImpl;


@RestController
@RequestMapping(Constantes.BASEPATH)
@Validated
public class Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	public Controller() {
		super();
	}

	@Autowired
	ServiceImpl serviceImpl;

	@PostMapping(value = Constantes.PATH_CREAR_USUARIO)
	@ResponseStatus(HttpStatus.CREATED)
	public RespuestaGen<Integer> crearUsuario( @RequestBody UsuarioDto usuarioDto) throws SQLException {
		LOGGER.info("Registro Usuario  ... inicia");
		return serviceImpl.registrarUsuario(usuarioDto);
	}
	
	
	@PutMapping(value = Constantes.PATH_ACTUALIZAR)
	@ResponseStatus(HttpStatus.OK)
	public RespuestaGen<String> actualizarUsuario( @RequestBody UsuarioDto usuarioDto) throws SQLException {
		LOGGER.info("Actualizacion Usuario  ... inicia");
		return serviceImpl.actualizarUsuario(usuarioDto);
	}
	
	@DeleteMapping(value = Constantes.PATH_ELIMINAR)
	@ResponseStatus(HttpStatus.OK)
	public RespuestaGen<String> eliminarUsuario(@PathVariable Integer idUsuario) throws SQLException {
		LOGGER.info("Eliminar Usuario ... inicia");
	    return serviceImpl.eliminarUsuarioPorId(idUsuario);
	}
	
	@GetMapping(value = Constantes.PATH_VALIDACION)
	@ResponseStatus(HttpStatus.OK)
	public RespuestaGen<Boolean> validarUsuario( @RequestBody UsuarioDto usuarioDto) throws SQLException {
		LOGGER.info("Valida Usuario  ... inicia");
		return serviceImpl.validarUsuario(usuarioDto.getLogin(), usuarioDto.getPassword());
	}
	
	@GetMapping(value = Constantes.PATH_STATUS)
	@ResponseStatus(HttpStatus.OK)
	public RespuestaGen<List<UsuarioDto>> buscarUsuariosPorStatus(@PathVariable String status) throws SQLException {
		LOGGER.info("Busca Usuario por Status... inicia");
	    return serviceImpl.buscarUsuariosPorStatus(status);
	}
	
	
}
