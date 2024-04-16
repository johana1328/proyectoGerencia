package edu.poli.citas.citasMedicas.dto;

import java.io.Serializable;
import java.util.List;

public class EspecialidadDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descropcion;
	private List<EmpleadoDto> empleados;

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

	public List<EmpleadoDto> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadoDto> empleados) {
		this.empleados = empleados;
	}

}
