package paqt.frank.practica.user.v1.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer fiid;
    private String login;
    private String password;
    private String nombre;
    private Float cliente;
    private String email;
    private Date fechaAlta;
    private Date fechaBaja;
    private String status;
    private Float intentos;
    private Date fechaRevocado;
    private Date fechaVigencia;
    private Integer noAcceso;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer area;
    private Date fechaModificacion;
	

}
