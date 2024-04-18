package edu.poli.citas.citasMedicas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "CITA")
public class CitaModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false,  fetch = FetchType.EAGER)
	@JoinColumn(name = "doctor")
	private UsuarioModel doctor;

	@ManyToOne(optional = false,  fetch = FetchType.EAGER)
	@JoinColumn(name = "paciente")
	private UsuarioModel paciente;

	@Column(name = "FECHA")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "HORA")
	@Temporal(TemporalType.TIME)
	private Date hora;

	@Column(name = "CENTRO_MEDICO")
	private String centroMedico;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cita")
	private List<AutorizacionModel> autorizacion;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cita")
	private List<NovedadModel> novedades;

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

	public List<AutorizacionModel> getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(List<AutorizacionModel> autorizacion) {
		this.autorizacion = autorizacion;
	}

	public List<NovedadModel> getNovedades() {
		return novedades;
	}

	public void setNovedades(List<NovedadModel> novedades) {
		this.novedades = novedades;
	}

}
