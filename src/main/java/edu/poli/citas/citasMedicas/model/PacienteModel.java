package edu.poli.citas.citasMedicas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PACIENTE")
public class PacienteModel extends UsuarioModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "TELEFONO", nullable = false, length = 20)
	private String telefono;

	@Column(name = "CORREO", length = 20)
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
