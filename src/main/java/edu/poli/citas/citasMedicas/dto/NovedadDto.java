package edu.poli.citas.citasMedicas.dto;

import java.io.Serializable;

public class NovedadDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String observacion;
	private CitaDto cita;
	
	private Long idCita;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public CitaDto getCita() {
		return cita;
	}

	public void setCita(CitaDto cita) {
		this.cita = cita;
	}

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

}
