package com.edix.clientes.modelo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.clientes.modelo.beans.Evento;
import com.edix.clientes.modelo.beans.Reserva;

@Repository
public class ReservaDaoImpl implements IntReservaDao{

	private List<Reserva> lista;
	
	@Override
	public List<Reserva> buscarTodos() {
		return lista;
	}

	@Override
	public Reserva findById(int idReserva) {
		Reserva aux = new Reserva();
		aux.setIdReserva(idReserva);
		int pos = lista.indexOf(aux);
		if (pos == 1) {
			return null;
		} else {
			return (lista.get(pos));
		}
	}

	@Override
	public int reservar(Reserva reserva) {
		if (!lista.contains(reserva)) {
			
			return 1;
		}
		return 0;
	}
	
}
