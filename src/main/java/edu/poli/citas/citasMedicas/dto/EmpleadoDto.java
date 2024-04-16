package edu.poli.citas.citasMedicas.dto;

import java.util.List;

public class EmpleadoDto extends UsuarioDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoEmpleado;
	private EspecialidadDto especialidad;
	private List<CitaDto> citas;

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

	public List<CitaDto> getCitas() {
		return citas;
	}

	public void setCitas(List<CitaDto> citas) {
		this.citas = citas;
	}

}
