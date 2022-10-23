package modelo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.javabeans.Evento;
import modelo.javabeans.Tipo;

public class EventoDaoImpl implements IntEventoDao {

	private List<Evento> lista;

	/*
	 * Creamos una lista con los eventos, posteriormente la rellenamos con el método cargarDatos().
	 */
	public EventoDaoImpl() {
		lista = new ArrayList<>();
		cargarDatos();
	}
	
	/*
	 * Creamos los objetos de "Tipo" que posteriormente son añadidos al constructor de cada evento, añadiendo estos directamente a la lista.
	 */
	private void cargarDatos() {
		Tipo tipo1 = new Tipo(1, "Concierto", "Eventos de música");
		Tipo tipo2 = new Tipo(2, "Despedida", "Despedida de soltero");
		Tipo tipo3 = new Tipo(3, "Cumpleaños", "Celebración del aniversario de una persona");
		Tipo tipo4 = new Tipo(4, "Boda", "Encuentro donde dos personas se casan");

		lista.add(new Evento(1, "Concierto de AC/DC", "Última gira del grupo", new Date(), 120, "C/ Avenida Reyes, 10",
				"Activo", "S", 38000, 18000, 79.99, 1));
		lista.add(new Evento(2, "Despedida de Antonio", "Se casa con Marta", new Date(), 180, "C/ Arturo Ruiz, 14",
				"Activo", "S", 18, 18, 100, 2));
		lista.add(new Evento(3, "Cumpleaños Sara", "25 aniversario", new Date(), 90, "C/ Plaza Pinares, 8", "Activo",
				"S", 70, 50, 15.50, 3));
		lista.add(new Evento(4, "Boda de Martin y Lucia", "Boda en el campo", new Date(), 240, "C/ Diseminados, 12",
				"Cancelado", "S", 180, 180, 110, 4));
	}

	/*
	 * Método que nos devuelve toda la lista de eventos.
	 */
	@Override
	public List<Evento> buscarTodos() {
		return lista;
	}
	
	public void setLista(List<Evento> lista) {
		this.lista = lista;
	}

	/*
	 * Método que nos devuelve un evento concreto basandonos en el idEvento.
	 */
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

	/*
	 * Método que detecta si el evento ha sido introducido previamente o no, devuelve 1 si lo ha insertado y
	 * 0 si ha detectado que ya exíste.
	 */
	@Override
	public int insertarEvento(Evento evento) {
		if (!lista.contains(evento)) {
			lista.add(evento);
			return 1;
		}
		return 0;
	}

	/*
	@Override
	public int editarEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos == -1) {
			return 0;
		} else {
			return (lista.set(pos, evento) != null) ? 1 : 0;
		}
	}
	*/
	
	/*
	 * Método que elimina un evento utilizando el lista.remove con el parámetro objeto evento, 
	 * como devuevle un entero, tenemos que utilizar el condicional ?1:0 para
	 * transformar de booleano a entero.
	 */
	@Override
	public int eliminarEvento(Evento evento) {
		return lista.remove(evento) ? 1 : 0;
	}

	/*
	 * Método igual que el anterior, pero le llega el parámetro idEvento.
	 * Se crea un evento auxiliar, al cual se le asocia idEvento, y luego se busca este dentro del array para ser eliminado.
	 */
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

	/*
	 * Método que busca a traves del parámetro idEvento dentro del array, y una vez lo encuentra le cambia el estado a "cancelado".
	 */
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

	/*
	 * Método que crea un array de eventos e inserta dentro de este solo los eventos que tienen el estado como "activo".
	 */
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