package com.edix.clientes.modelo.beans;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idEvento;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private int duracion;
	private String direccion;
	private String estado;
	private String destacado;
	private int aforoMaximo;
	private int minimoAsistencia;
	private double precioDecimal;
	private int tipo;
	
	public Evento() {
		
	}

	public Evento(int idEvento, String nombre, String descripcion, Date fechaInicio, int duracion, String direccion,
			String estado, String destacado, int aforoMaximo, int minimoAsistencia, double precioDecimal, int tipo) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = new Date();
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforoMaximo = aforoMaximo;
		this.minimoAsistencia = minimoAsistencia;
		this.precioDecimal = precioDecimal;
		this.tipo = tipo;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDestacado() {
		return destacado;
	}

	public void setDestacado(String destacado) {
		this.destacado = destacado;
	}

	public int getAforoMaximo() {
		return aforoMaximo;
	}

	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}

	public int getMinimoAsistencia() {
		return minimoAsistencia;
	}

	public void setMinimoAsistencia(int minimoAsistencia) {
		this.minimoAsistencia = minimoAsistencia;
	}

	public double getPrecioDecimal() {
		return precioDecimal;
	}

	public void setPrecioDecimal(double precioDecimal) {
		this.precioDecimal = precioDecimal;
	}

	public String getTipo() {
		if (tipo == 1) {
			return "Concierto";
		} else if (tipo == 2){
			return "Despedida";
		} else if (tipo == 3){
			return "Cumplea??os";
		} else {
			return "Boda";
		}
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		return idEvento == other.idEvento;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", duracion=" + duracion + ", direccion=" + direccion + ", estado=" + estado
				+ ", destacado=" + destacado + ", aforoMaximo=" + aforoMaximo + ", minimoAsistencia=" + minimoAsistencia
				+ ", precioDecimal=" + precioDecimal + ", tipo=" + tipo + "]";
	}
	
}