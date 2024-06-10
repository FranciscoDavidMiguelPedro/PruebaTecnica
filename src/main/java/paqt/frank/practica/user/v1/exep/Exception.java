package paqt.frank.practica.user.v1.exep;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import paqt.frank.practica.user.v1.enums.EMensajeException;

/**
 * Clase que representa una excepción de la API.
 */

@Getter
@Setter
@AllArgsConstructor
public class Exception extends RuntimeException {

	private static final long serialVersionUID = -4136207952002860718L;

	private final EMensajeException option;
	private final Error body;
	private final String error;

	/**
	 * Constructor de clase
	 * 
	 * @param folio    de tipo string
	 * @param detalles de tipo lista de string
	 * @param option   de tipo enum.
	 */
	public Exception(String folio, List<String> detalles, EMensajeException option) {
		super(option.getMensaje());
		this.option = option;
		this.body = new Error(option.getCodigo(), option.getMensaje(), folio, option.getInfo(), detalles);
		this.error = "";

	}

	/**
	 * Constructor
	 * 
	 * @param detalles
	 * @param option
	 */
	public Exception(List<String> detalles, EMensajeException option) {
		super();
		this.option = option;
		this.body = new Error(option.getCodigo(), option.getMensaje(), null, option.getInfo(), detalles);
		this.error = "";
	}

	/**
	 * Constructor
	 * 
	 * @param detalles
	 * @param option
	 */
	public Exception(String detalles, EMensajeException option) {
		super();
		this.option = option;
		this.body = new Error(option.getCodigo(), option.getMensaje(), null, option.getInfo(),
				Arrays.asList(detalles));
		this.error = detalles;
	}

	/**
	 * Constructor
	 * 
	 * @param folio
	 * @param detalles
	 * @param option
	 */
	public Exception(String folio, String detalles, EMensajeException option) {
		super(option.getMensaje());
		this.option = option;
		this.body = new Error(option.getCodigo(), option.getMensaje(), folio, option.getInfo(),
				Arrays.asList(detalles));
		this.error = detalles;
	}

}
