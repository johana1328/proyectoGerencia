package edu.poli.citas.citasMedicas.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESPECIALIDAD")
public class EspecialidadModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPCION", length = 50)
	private String descropcion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "especialidad")
	private List<EmpleadoModel> empleados;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescropcion() {
		return descropcion;
	}

	public void setDescropcion(String descropcion) {
		this.descropcion = descropcion;
	}

	public List<EmpleadoModel> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadoModel> empleados) {
		this.empleados = empleados;
	}

}
