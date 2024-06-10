package paqt.frank.practica.user.v1.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import paqt.frank.practica.user.v1.constant.Constantes;
import paqt.frank.practica.user.v1.dto.UsuarioDto;
import paqt.frank.practica.user.v1.enums.EMensajeException;
import paqt.frank.practica.user.v1.error.ErrorGener;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * contructor vasio
	 */
	public UsuarioDaoImpl() {
		super();
	}

	@Override
	public Integer registrarUsuario(UsuarioDto usuario) {
		LOGGER.info("Método para registrar Usuario");
		Integer userId = null;
		try {
			StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_RegistrarUsuario");

			// Registrar los parámetros del procedimiento almacenado
			storedProcedure.registerStoredProcedureParameter("login", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("password", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("cliente", Float.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("fechaBaja", Date.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("intentos", Float.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("fechaRevocado", Date.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("fechaVigencia", Date.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("noAcceso", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("apellidoPaterno", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("apellidoMaterno", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("area", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("NextID", Integer.class, ParameterMode.OUT);

			// Pasar los valores de los parámetros
			storedProcedure.setParameter("login", usuario.getLogin());
			storedProcedure.setParameter("password", usuario.getPassword());
			storedProcedure.setParameter("nombre", usuario.getNombre());
			storedProcedure.setParameter("cliente", usuario.getCliente());
			storedProcedure.setParameter("email", usuario.getEmail());
			storedProcedure.setParameter("fechaBaja", usuario.getFechaBaja());
			storedProcedure.setParameter("intentos", usuario.getIntentos());
			storedProcedure.setParameter("fechaRevocado", usuario.getFechaRevocado());
			storedProcedure.setParameter("fechaVigencia", usuario.getFechaVigencia());
			storedProcedure.setParameter("noAcceso", usuario.getNoAcceso());
			storedProcedure.setParameter("apellidoPaterno", usuario.getApellidoPaterno());
			storedProcedure.setParameter("apellidoMaterno", usuario.getApellidoMaterno());
			storedProcedure.setParameter("area", usuario.getArea());

			// Ejecutar el procedimiento almacenado
			storedProcedure.execute();
			// Obtener el ID del usuario recién creado
			userId = (Integer) storedProcedure.getOutputParameterValue("NextID");

			LOGGER.info("Ejecución del sp");

		} catch (Exception e) {
			LOGGER.error("Error al registar Usuario", e);
			ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_400), EMensajeException.E400);
		}
		return userId;
	}

	@Override
	public String actualizarUsuario(UsuarioDto usuario) {
		LOGGER.info("Método para Actualizar Usuario");
		String respUsuario = null;
		try {
			StoredProcedureQuery storedProcedure = entityManager
					.createStoredProcedureQuery("sp_ActualizarUsuarioPorID");

			// Registrar los parámetros del procedimiento almacenado
			storedProcedure.registerStoredProcedureParameter("FIID", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("login", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("password", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("cliente", Float.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("fechaBaja", Date.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("status", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("intentos", Float.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("fechaRevocado", Date.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("fechaVigencia", Date.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("noAcceso", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("apellidoPaterno", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("apellidoMaterno", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("area", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("mensaje", String.class, ParameterMode.OUT);

			// Pasar los valores de los parámetros
			storedProcedure.setParameter("FIID", usuario.getFiid());
			storedProcedure.setParameter("login", usuario.getLogin());
			storedProcedure.setParameter("password", usuario.getPassword());
			storedProcedure.setParameter("nombre", usuario.getNombre());
			storedProcedure.setParameter("cliente", usuario.getCliente());
			storedProcedure.setParameter("email", usuario.getEmail());
			storedProcedure.setParameter("fechaBaja", usuario.getFechaBaja());
			storedProcedure.setParameter("status", usuario.getStatus());
			storedProcedure.setParameter("intentos", usuario.getIntentos());
			storedProcedure.setParameter("fechaRevocado", usuario.getFechaRevocado());
			storedProcedure.setParameter("fechaVigencia", usuario.getFechaVigencia());
			storedProcedure.setParameter("noAcceso", usuario.getNoAcceso());
			storedProcedure.setParameter("apellidoPaterno", usuario.getApellidoPaterno());
			storedProcedure.setParameter("apellidoMaterno", usuario.getApellidoMaterno());
			storedProcedure.setParameter("area", usuario.getArea());

			// Ejecutar el procedimiento almacenado
			storedProcedure.execute();

			// Obtener el valor del parámetro de salida
			respUsuario = (String) storedProcedure.getOutputParameterValue("mensaje");
			LOGGER.info("Ejecución del sp");

		} catch (Exception e) {
			LOGGER.error("Error al actualizar el Usuario", e);
			ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_400), EMensajeException.E400);
		}
		return respUsuario;
	}

	@Override
	public String eliminarUsuarioPorId(Integer id) {
		LOGGER.info("Método para ELIMINAR Usuario");
	    String respUsuario = null;
	    try {
	        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_EliminarUsuarioPorID");

	        // Registrar los parámetros del procedimiento almacenado
	        storedProcedure.registerStoredProcedureParameter("FIID", Integer.class, ParameterMode.IN);
	        storedProcedure.registerStoredProcedureParameter("Mensaje", String.class, ParameterMode.OUT);

	        // Pasar los valores de los parámetros
	        storedProcedure.setParameter("FIID", id);

	        // Ejecutar el procedimiento almacenado
	        storedProcedure.execute();
	        LOGGER.info("Ejecución del sp");
	        // Obtener el resultado
	        respUsuario = (String) storedProcedure.getOutputParameterValue("Mensaje");

	    } catch (Exception e) {
	        LOGGER.error("Error al eliminar el Usuario", e);
	        ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_400), EMensajeException.E400);
	    }
	    return respUsuario;
	}

	@Override
	public boolean validarUsuario(String login, String password) {
		LOGGER.info("Método para Validar si existe Usuario");
	    boolean validacion = false;
	    try {
	        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_ValidarUsuario");

	        // Registrar los parámetros del procedimiento almacenado
	        storedProcedure.registerStoredProcedureParameter("login", String.class, ParameterMode.IN);
	        storedProcedure.registerStoredProcedureParameter("password", String.class, ParameterMode.IN);

	        // Pasar los valores de los parámetros
	        storedProcedure.setParameter("login", login);
	        storedProcedure.setParameter("password", password);

	        // Ejecutar el procedimiento almacenado
	        storedProcedure.execute();
	        LOGGER.info("Ejecución del sp");
	        // Obtener el resultado
	        String result = (String) storedProcedure.getSingleResult();

	        // Comprobar el resultado
	        validacion = result.equals("Validación exitosa");

	    } catch (Exception e) {
	        LOGGER.error("Error al validar el Usuario", e);
	        ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_400), EMensajeException.E400);
	    }
	    return validacion;
	}

	@Override
	public List<UsuarioDto> buscarUsuariosPorStatus(String status) {
		LOGGER.info("Método para Validar STATUS Usuario");
		 List<UsuarioDto> usuarios = new ArrayList<>();
		    try {
		        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_BuscarUsuariosPorStatus");

		        // Registrar los parámetros del procedimiento almacenado
		        storedProcedure.registerStoredProcedureParameter("status", String.class, ParameterMode.IN);

		        // Pasar los valores de los parámetros
		        storedProcedure.setParameter("status", status);

		        // Ejecutar el procedimiento almacenado
		        storedProcedure.execute();
		        LOGGER.info("Ejecución del sp");
		        // Obtener el resultado
		        usuarios = storedProcedure.getResultList();

		    } catch (Exception e) {
		        LOGGER.error("Error al buscar los Usuarios por status", e);
		        ErrorGener.excepcionGenerica(Arrays.asList(Constantes.MSJ_DETALLE_400), EMensajeException.E400);
		    }
		    return usuarios;
	}

}
