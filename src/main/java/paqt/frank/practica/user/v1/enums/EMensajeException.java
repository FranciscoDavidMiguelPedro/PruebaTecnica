package paqt.frank.practica.user.v1.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeración que define los mensajes de excepción personalizados.
 */

@Getter
@AllArgsConstructor
public enum EMensajeException {

	/*
	 * Bloque de variables.
	 */

	E400("400.Generic-Error.400001",
			"Solicitud mal formada",
			"https://example.com/error#400.Generic-Error.400001"),
	E404("404.Generic-Error.404001",
			"Información no encontrada",
			"https://example.com/error#404.Generic-Error.404001"),
	E500("500.Generic-Error.500001", 
			"Error interno del servidor.",
			"https://example.com/error#500.Generic-Error.500001");

	private String codigo;
	private String mensaje;
	private String info;

}
