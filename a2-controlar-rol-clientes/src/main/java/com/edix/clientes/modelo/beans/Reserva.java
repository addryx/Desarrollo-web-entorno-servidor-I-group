package com.edix.clientes.modelo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Reserva implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idReserva;
	private Evento evento;
	private Usuario usuario;
	private double precioVenta;
	private String observaciones;
	private int cantidad;
	
	public Reserva() {
	}

	public Reserva(int idReserva, Evento evento, Usuario usuario, double precioVenta, String observaciones,
			int cantidad) {
		super();
		this.idReserva = idReserva;
		this.evento = evento;
		this.usuario = usuario;
		this.precioVenta = precioVenta;
		this.observaciones = observaciones;
		this.cantidad = cantidad;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva) obj;
		return idReserva == other.idReserva;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", evento=" + evento + ", usuario=" + usuario + ", precioVenta="
				+ precioVenta + ", observaciones=" + observaciones + ", cantidad=" + cantidad + "]";
	}
	
}
