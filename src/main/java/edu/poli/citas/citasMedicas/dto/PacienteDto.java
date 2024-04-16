package edu.poli.citas.citasMedicas.dto;

public class PacienteDto extends UsuarioDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String telefono;
	private String correo;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
