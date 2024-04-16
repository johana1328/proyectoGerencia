package edu.poli.citas.citasMedicas.dto;

import java.io.Serializable;

public class MedicamentoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private AutorizacionDto autorizacion;
	private String nombre;
	private Long cantidad;
	private String posologia;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AutorizacionDto getAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacion(AutorizacionDto autorizacion) {
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
