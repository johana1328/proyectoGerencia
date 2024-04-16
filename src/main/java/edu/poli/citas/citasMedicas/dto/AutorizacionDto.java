package edu.poli.citas.citasMedicas.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import edu.poli.citas.citasMedicas.model.CitaModel;

public class AutorizacionDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fecha;
	private CitaModel cita;
	private String descripcion;
	private List<MedicamentoDto> medicamentos;
	private List<ExamenDto> examenes;

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

	public List<MedicamentoDto> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<MedicamentoDto> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public List<ExamenDto> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<ExamenDto> examenes) {
		this.examenes = examenes;
	}

}
