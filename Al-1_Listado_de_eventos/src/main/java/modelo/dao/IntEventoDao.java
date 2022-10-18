package modelo.dao;

import java.util.List;

import modelo.javabeans.Evento;

public interface IntEventoDao {
	List<Evento> buscarTodos();
	Evento findById(int idEvento);
	
	int insertarEvento(Evento evento);
	int editarEvento(Evento evento);
	int eliminarEvento(Evento evento);
	int eliminarEvento(int idEvento);
	int cancelarEvento(Evento evento);
}