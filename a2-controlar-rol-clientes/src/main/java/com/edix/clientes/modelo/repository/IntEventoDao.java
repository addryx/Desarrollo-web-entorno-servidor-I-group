package com.edix.clientes.modelo.repository;

import java.util.List;
import com.edix.clientes.modelo.beans.Evento;

public interface IntEventoDao {
	List<Evento> buscarTodos();
	Evento findById(int idEvento);
	
	int insertarEvento(Evento evento);
	int eliminarEvento(Evento evento);
	int eliminarEvento(int idEvento);
	int cancelarEvento (int idEvento);
	List<Evento> mostrarActivos();
	List<Evento> mostrarDestacados();
	int detalleEvento (Evento evento);
	int detalleEvento (int idEvento);
}