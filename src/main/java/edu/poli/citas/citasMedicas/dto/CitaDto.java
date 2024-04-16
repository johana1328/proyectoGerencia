package edu.poli.citas.citasMedicas.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import edu.poli.citas.citasMedicas.model.UsuarioModel;

public class CitaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private UsuarioModel doctor;
	private UsuarioModel paciente;
	private Date fecha;
	private Date hora;
	private String centroMedico;
	private List<AutorizacionDto> autorizacion;
	private List<NovedadDto> novedades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioModel getDoctor() {
		return doctor;
	}

	public void setDoctor(UsuarioModel doctor) {
		this.doctor = doctor;
	}

	public UsuarioModel getPaciente() {
		return paciente;
	}

	public void setPaciente(UsuarioModel paciente) {
		this.paciente = paciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getCentroMedico() {
		return centroMedico;
	}

	public void setCentroMedico(String centroMedico) {
		this.centroMedico = centroMedico;
	}

	public List<AutorizacionDto> getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(List<AutorizacionDto> autorizacion) {
		this.autorizacion = autorizacion;
	}

	public List<NovedadDto> getNovedades() {
		return novedades;
	}

	public void setNovedades(List<NovedadDto> novedades) {
		this.novedades = novedades;
	}

}
