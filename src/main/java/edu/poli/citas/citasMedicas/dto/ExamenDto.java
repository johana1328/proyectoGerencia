package edu.poli.citas.citasMedicas.dto;

import java.io.Serializable;
import java.util.Date;

public class ExamenDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private AutorizacionDto autorizacion;
	private String tipo;
	private String centroMedico;
	private Date fechaExamen;
	private String resultado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AutorizacionDto getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(AutorizacionDto autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCentroMedico() {
		return centroMedico;
	}

	public void setCentroMedico(String centroMedico) {
		this.centroMedico = centroMedico;
	}

	public Date getFechaExamen() {
		return fechaExamen;
	}

	public void setFechaExamen(Date fechaExamen) {
		this.fechaExamen = fechaExamen;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
