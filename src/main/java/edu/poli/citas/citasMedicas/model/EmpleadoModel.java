package edu.poli.citas.citasMedicas.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADO")
public class EmpleadoModel extends UsuarioModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "TIPO_EMPLEADO", nullable = false, length = 8)
	@Enumerated(value = EnumType.STRING)
	private EmpleadoType tipoEmpleado;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ESPECIALIDAD", referencedColumnName = "ID")
	private EspecialidadModel especialidad;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor")
	private List<CitaModel> citas;

	public EmpleadoType getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(EmpleadoType tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public EspecialidadModel getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadModel especialidad) {
		this.especialidad = especialidad;
	}

	public List<CitaModel> getCitas() {
		return citas;
	}

	public void setCitas(List<CitaModel> citas) {
		this.citas = citas;
	}

}
