package paqt.frank.practica.user.v1.error;

import java.util.List;

import paqt.frank.practica.user.v1.constant.Folio;
import paqt.frank.practica.user.v1.enums.EMensajeException;
import paqt.frank.practica.user.v1.exep.Exception;

/**
 * Clase utilitaria para manejar excepciones genéricas.
 */
public final class ErrorGener {

	/**
	 * Constructor privado para prevenir la instanciación de la clase.
	 */
	private ErrorGener() {
		super();
	}

	/**
	 * Método para construir y lanzar una excepción genérica.
	 * 
	 * @param listaError Lista de descripciones del error.
	 * @param mensaje    Descripción general del error.
	 */
	public static void excepcionGenerica(List<String> listaError, EMensajeException mensaje) {
		throw new Exception(Folio.generarFolio(), listaError, mensaje);
	}

}
