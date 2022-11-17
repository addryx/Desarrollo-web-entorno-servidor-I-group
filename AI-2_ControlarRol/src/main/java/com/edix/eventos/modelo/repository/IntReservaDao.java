package com.edix.eventos.modelo.repository;

import java.util.List;

import com.edix.eventos.modelo.beans.Evento;
import com.edix.eventos.modelo.beans.Reserva;

public interface IntReservaDao {
	
	List<Reserva> buscarTodos();
	Reserva findById (int idReserva);
	
	int altaReserva (Evento evento);
	int altaReserva (int idEvento);

}
