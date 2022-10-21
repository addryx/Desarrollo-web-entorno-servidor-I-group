package modelo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.javabeans.Evento;
import modelo.javabeans.Tipo;

public class EventoDaoImpl implements IntEventoDao {

	private List<Evento> lista;

	public EventoDaoImpl() {
		lista = new ArrayList<>();
		cargarDatos();
	}

	private void cargarDatos() {
		Tipo tipo1 = new Tipo(1, "Concierto", "Eventos de música");
		Tipo tipo2 = new Tipo(2, "Despedida", "Despedida de soltero");
		Tipo tipo3 = new Tipo(3, "Cumpleaños", "Celebración del aniversario de una persona");
		Tipo tipo4 = new Tipo(4, "Boda", "Encuentro donde dos personas se casan");

		lista.add(new Evento(1, "Concierto de AC/DC", "Última gira del grupo", new Date(), 120, "C/ Avenida Reyes, 10",
				"Activo", 'A', 38000, 18000, 79.99, tipo1));
		lista.add(new Evento(2, "Despedida de Antonio", "Se casa con Marta", new Date(), 180, "C/ Arturo Ruiz, 14",
				"Confirmado", 'B', 18, 18, 100, tipo2));
		lista.add(new Evento(3, "Cumpleaños Sara", "25 aniversario", new Date(), 90, "C/ Plaza Pinares, 8", "Pendiente",
				'C', 70, 50, 15.50, tipo3));
		lista.add(new Evento(4, "Boda de Martin y Lucia", "Boda en el campo", new Date(), 240, "C/ Diseminados, 12",
				"Confirmado", 'D', 180, 180, 110, tipo4));
	}

	@Override
	public List<Evento> buscarTodos() {
		return lista;
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
	public int editarEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos == -1) {
			return 0;
		} else {
			return (lista.set(pos, evento) != null) ? 1 : 0;
		}
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
		if (evento == null) {
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
}