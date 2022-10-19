package modelo.javabeans;


import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idEvento;
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private int duracion;
	private String direccion;
	private String estado;
	private char destacado;
	private int aforoMaximo;
	private int minimoAsistencia;
	private double precioDecimal;
	private Tipo tipo;
	
	public Evento() {
		// TODO Auto-generated constructor stub
	}

	public Evento(int idEvento, String nombre, String descripcion, String fechaInicio, int duracion, String direccion,
			String estado, char destacado, int aforoMaximo, int minimoAsistencia, double precioDecimal, Tipo tipo) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
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

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
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

	public char getDestacado() {
		return destacado;
	}

	public void setDestacado(char destacado) {
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
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