package com.edix.eventos.modelo.repository;

import java.util.List;
import com.edix.eventos.modelo.beans.Evento;



public interface IntEventoDao {
	List<Evento> buscarTodos();
	Evento findById(int idEvento);
	
	int insertarEvento(Evento evento);
	// int editarEvento(Evento evento);
	int eliminarEvento(Evento evento);
	int eliminarEvento(int idEvento);
	int cancelarEvento (int idEvento);
	List<Evento> mostrarActivos();
}