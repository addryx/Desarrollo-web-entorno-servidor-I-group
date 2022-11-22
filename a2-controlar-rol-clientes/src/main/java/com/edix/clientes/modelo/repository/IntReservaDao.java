package com.edix.clientes.modelo.repository;

import java.util.List;

import com.edix.clientes.modelo.beans.Evento;
import com.edix.clientes.modelo.beans.Reserva;

public interface IntReservaDao {
	List<Reserva> buscarTodos();
	Reserva findById(int idReserva);
	
	int totalReservas();
	int obtenerId();
	int reservar(Reserva reserva);
	int entradasRestantes(Evento evento);
}
