package com.edix.clientes.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.edix.clientes.modelo.beans.Evento;

@Repository
public class EventoDaoImpl implements IntEventoDao {

	private List<Evento> lista;

	public EventoDaoImpl() {
		lista = new ArrayList<>();
		cargarDatos();
	}

	private void cargarDatos() {
		lista.add(new Evento(1, "Concierto de AC/DC", "Última gira del grupo", new Date(), 120, "C/ Avenida Reyes, 10",
				"Activo", "S", 38000, 18000, 79.99, 1));
		lista.add(new Evento(2, "Despedida de Antonio", "Se casa con Marta", new Date(), 180, "C/ Arturo Ruiz, 14",
				"Activo", "S", 18, 18, 100, 2));
		lista.add(new Evento(3, "Cumpleaños Sara", "25 aniversario", new Date(), 90, "C/ Plaza Pinares, 8", "Activo",
				"S", 70, 50, 15.50, 3));
		lista.add(new Evento(4, "Boda de Martin y Lucia", "Boda en el campo", new Date(), 240, "C/ Diseminados, 12",
				"Cancelado", "S", 180, 180, 110, 4));
	}

	@Override
	public List<Evento> buscarTodos() {
		return lista;
	}
	
	public void setLista(List<Evento> lista) {
		this.lista = lista;
	}

	@Override
	public Evento findById(int idEvento) {
		Evento aux = new Evento();
		aux.setIdEvento(idEvento);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return (lista.get(pos));
		}
	}

	@Override
	public int insertarEvento(Evento evento) {
		if (!lista.contains(evento)) {
			lista.add(evento);
			return 1;
		}
		return 0;
	}

	
	@Override
	public int eliminarEvento(Evento evento) {
		return lista.remove(evento) ? 1 : 0;
	}

	@Override
	public int eliminarEvento(int idEvento) {
		Evento aux = new Evento();
		aux.setIdEvento(idEvento);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return 0;
		} else {
			return (lista.remove(pos) != null) ? 1 : 0;
		}
	}

	@Override
	public int cancelarEvento(int idEvento) {
		Evento evento = findById(idEvento);
		if(evento.getEstado().equals("Cancelado")) {
			return 0;
		} else {
			evento.setEstado("Cancelado");
			return 1;
		}
	}

	@Override
	public List<Evento> mostrarActivos() {
		List<Evento> activos = new ArrayList<>();
		for (Evento ele : lista) {
			if (ele.getEstado().equals("Activo")) {
				activos.add(ele);
			}
		}
		return activos;
	}

	@Override
	public List<Evento> mostrarDestacados() {
		List<Evento> destacados = new ArrayList<>();
		for (Evento ele : lista) {
			if (ele.getDestacado().equals("S")) {
				destacados.add(ele);
			}
		}
		return destacados;
	}

	@Override
	public int detalleEvento(Evento evento) {
		// TO DO
		return 0;
	}

	@Override
	public int detalleEvento(int idEvento) {
		Evento evento = findById(idEvento);
		//evento.getNombre();
		evento.toString();
		return 0;
	}
	
	
	
	
	
	
	
}