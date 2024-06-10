package paqt.frank.practica.user.v1.constant;


public final class Constantes {


	/**
	 * path base del microservicio
	 */
	public static final String BASEPATH = "/prueba/tecnica/v1";
	
	/**
	 * path para validar el número celular
	 */
	public static final String PATH_CREAR_USUARIO = "/crear/usuarios";
	
	public static final String PATH_ACTUALIZAR = "/actualizar/usuarios";
	public static final String PATH_ELIMINAR = "/usuario/{idUsuario}";
	public static final String PATH_VALIDACION= "/usuario/validacion";
	public static final String PATH_STATUS= "/usuario/status/{status}";


	// FECHAS
	public static final String FORMATO_LOCALE_MX = "es_MX";
	public static final String FORMATO_FECHA = "yyyyMMddHHmmss";

	// Mensajes
	public static final String MSJ_OPERACION_EXITOSA = "Operación exitosa";

	/**
	 * Codigos de error
	 */
	public static final Integer COD_200 = 200;
	public static final Integer COD_400 = 400;
	public static final Integer COD_404 = 404;
	public static final Integer COD_500 = 500;

	/**
	 * Código 400
	 */
	public static final String MSJ_CODIGO_400 = "400.Generic-Error.400001";
	public static final String MSJ_MENSAJE_400 = "Solicitud mal Ingresada";
	public static final String MSJ_INFO_400 = "https://example.com/error#400.Generic-Error.400001";
	public static final String MSJ_CAMPO_REQUERIDO = "Campo Requerido: ";
	public static final String MSJ_DETALLE_400 = "Parámetros no válidos, por favor valide su información.";


	/**
	 * Código 404
	 */
	public static final String MSJ_CODIGO_404 = "404.Generic-Error.404001";
	public static final String MSJ_MENSAJE_404 = "Información no encontrada";
	public static final String MSJ_INFO_404 = "https://example.com/error#404.Generic-Error.404001";
	public static final String MSJ_DETALLE_404 = "No se obtuvo información relacionada a la consulta.";

	/**
	 * Código 500
	 */
	public static final String MSJ_CODIGO_500 = "500.Generic-Error.500001";
	public static final String MSJ_MENSAJE_500 = "Error interno del servidor.";
	public static final String MSJ_INFO_500 = "https://example.com/error#500.Generic-Error.500001";
	public static final String MSJ_DETALLE_500 = "Ocurrió un problema en el servidor.";


}
