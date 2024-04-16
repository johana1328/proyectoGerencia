package edu.poli.citas.citasMedicas.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USUARIO")
public class UsuarioModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DOCUMENTO", nullable = false, length = 20)
	private String documento;

	@Column(name = "NOMBRE", nullable = false, length = 50)
	private String nombre;

	@Column(name = "APELLIDO", length = 50)
	private String apellido;

	@Column(name = "TIPO_DOCUMENTO", nullable = false, length = 8)
	@Enumerated(value = EnumType.STRING)
	private DocumentType tipoDocumneto;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "paciente")
	private List<CitaModel> citas;

	private String password;

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

	public DocumentType getTipoDocumneto() {
		return tipoDocumneto;
	}

	public void setTipoDocumneto(DocumentType tipoDocumneto) {
		this.tipoDocumneto = tipoDocumneto;
	}

	public List<CitaModel> getCitas() {
		return citas;
	}

	public void setCitas(List<CitaModel> citas) {
		this.citas = citas;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
