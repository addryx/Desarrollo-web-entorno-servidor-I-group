package com.edix.eventos.modelo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Reserva implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private int idReserva;
	private int idEvento;
	private int idUsuario;
	private double precioVenta;
	private String observaciones;
	private int cantidad;


	public Reserva() {
		super();
	}


	public Reserva(int idReserva, int idEvento, int idUsuario, double precioVenta, String observaciones, int cantidad) {
		super();
		this.idReserva = idReserva;
		this.idEvento = idEvento;
		this.idUsuario = idUsuario;
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


	public int getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cantidad, idEvento, idReserva, idUsuario, observaciones, precioVenta);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva) obj;
		return cantidad == other.cantidad && idEvento == other.idEvento && idReserva == other.idReserva
				&& idUsuario == other.idUsuario && Objects.equals(observaciones, other.observaciones)
				&& Double.doubleToLongBits(precioVenta) == Double.doubleToLongBits(other.precioVenta);
	}


	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idEvento=" + idEvento + ", idUsuario=" + idUsuario
				+ ", precioVenta=" + precioVenta + ", observaciones=" + observaciones + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
}
