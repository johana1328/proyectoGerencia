package edu.poli.citas.citasMedicas.dto;

import java.io.Serializable;
import java.util.List;

public class UsuarioDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String documento;
	private String nombre;
	private String apellido;
	private String tipoDocumneto;
	private String password;
	private List<CitaDto> citas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDocumneto() {
		return tipoDocumneto;
	}

	public void setTipoDocumneto(String tipoDocumneto) {
		this.tipoDocumneto = tipoDocumneto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CitaDto> getCitas() {
		return citas;
	}

	public void setCitas(List<CitaDto> citas) {
		this.citas = citas;
	}

}
