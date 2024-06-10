package paqt.frank.practica.user.v1.modresp;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespuestaGen<T> {

	/*
	 * Bloque de variables.
	 */
	private String mensaje;
	private String folio;
	private T resultado;

	
}
