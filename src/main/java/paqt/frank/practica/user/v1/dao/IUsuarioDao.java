package paqt.frank.practica.user.v1.dao;

import java.util.List;

import paqt.frank.practica.user.v1.dto.UsuarioDto;

public interface IUsuarioDao {

	/**
	 * Metodo para hacer Registro completo
	 * @param usuario
	 * @return 
	 */
	Integer registrarUsuario(UsuarioDto usuario);

	/***
	 * Metodo para hacer la actualizacion del registro por Id
	 * @param usuario
	 */
	String actualizarUsuario(UsuarioDto usuario);
	
	/**
	 * Metdo para hacer la eliminacion del registro por id 
	 * @param id
	 */
	String eliminarUsuarioPorId(Integer id);
	
	
	/**
	 * Validacion de la busqueda del registro existente mediante logeo y pasword
	 * @param login
	 * @param password
	 * @return
	 */
	boolean validarUsuario(String login, String password);
	
	/**
	 * Metodo para hacer la busqueda mediante el estatus
	 * @param status
	 * @return
	 */
	List<UsuarioDto> buscarUsuariosPorStatus(String status);
}
