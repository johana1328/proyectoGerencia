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
@Table(name = "AUTORIZACION")
public class AutorizacionModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FECHA", updatable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cita")
	private CitaModel cita;

	@Column(name = "DESCRIPCION", length = 200)
	private String descripcion;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "autorizacion")
	private List<MedicamentoModel> medicamentos;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "autorizacion")
	private List<ExamenModel> examenes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public CitaModel getCita() {
		return cita;
	}

	public void setCita(CitaModel cita) {
		this.cita = cita;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<MedicamentoModel> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<MedicamentoModel> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public List<ExamenModel> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<ExamenModel> examenes) {
		this.examenes = examenes;
	}

}
