package edu.poli.citas.citasMedicas.dto;

import java.util.List;

public class EmpleadoDto extends UsuarioDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoEmpleado;
	private EspecialidadDto especialidad;

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public EspecialidadDto getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadDto especialidad) {
		this.especialidad = especialidad;
	}

}
