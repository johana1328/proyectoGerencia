package edu.poli.citas.citasMedicas.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEDICAMENTO")
public class MedicamentoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false,  fetch = FetchType.EAGER)
	@JoinColumn(name = "autorizacion")
	private AutorizacionModel autorizacion;

	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

	@Column(name = "CANTIDAD")
	private Long cantidad;

	@Column(name = "POSOLOGIA", nullable = false, length = 300)
	private String posologia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AutorizacionModel getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(AutorizacionModel autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

}
