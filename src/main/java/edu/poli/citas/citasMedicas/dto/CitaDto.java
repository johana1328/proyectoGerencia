package edu.poli.citas.citasMedicas.dto;

import java.io.Serializable;
import java.util.List;

public class CitaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private UsuarioDto doctor;
	private UsuarioDto paciente;
	private String fecha;
	private String hora;
	private String centroMedico;
	private List<AutorizacionDto> autorizacion;
	private List<NovedadDto> novedades;
	
	private String especialidad;

	private Long idDoctor;
	private Long idPaciente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioDto getDoctor() {
		return doctor;
	}

	public void setDoctor(UsuarioDto doctor) {
		this.doctor = doctor;
	}

	public UsuarioDto getPaciente() {
		return paciente;
	}

	public void setPaciente(UsuarioDto paciente) {
		this.paciente = paciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
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

	public Long getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
