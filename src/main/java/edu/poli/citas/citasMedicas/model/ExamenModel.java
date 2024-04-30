package edu.poli.citas.citasMedicas.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "EXAMEN")
public class ExamenModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "autorizacion")
	private AutorizacionModel autorizacion;

	@Column(name = "TIPO", length = 100)
	private String tipo;

	@Column(name = "CENTRO_MEDICO", length = 100)
	private String centroMedico;

	@Column(name = "FECHA", updatable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaExamen;

	@Column(name = "RESULTADO", length = 200)
	private String resultado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AutorizacionModel getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(AutorizacionModel autorizacion) {
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
