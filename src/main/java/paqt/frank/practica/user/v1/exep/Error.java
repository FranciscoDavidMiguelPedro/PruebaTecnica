package paqt.frank.practica.user.v1.exep;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import paqt.frank.practica.user.v1.enums.EMensajeException;



@NoArgsConstructor
@AllArgsConstructor
public class Error implements Serializable {

	// warning agregado
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String mensaje;
	private String folio;
	private String info;
	private List<String> detalles;
	
	/**
	 * Constructor Enum.
	 * 
	 * @param error
	 */
	public Error(EMensajeException error, String folio, List<String> detalles) {
		super();
		this.codigo = error.getCodigo();
		this.mensaje = error.getMensaje();
		this.info = error.getInfo();
		this.folio = folio;
		this.detalles = detalles == null ? Collections.emptyList() : new ArrayList<>(detalles);
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the detalles
	 */
	public List<String> getDetalles() {
		if (detalles == null || detalles.isEmpty()) {
			return Collections.emptyList();
		}

		return new ArrayList<>(detalles);
	}

	/**
	 * @param detalles the detalles to set
	 */
	public void setDetalles(List<String> detalles) {
		if (detalles == null || detalles.isEmpty()) {
			return;
		}

		this.detalles = Collections.unmodifiableList(detalles);
	}

}
