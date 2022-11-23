package com.edix.clientes.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.clientes.modelo.beans.Evento;
import com.edix.clientes.modelo.beans.Reserva;
import com.edix.clientes.modelo.beans.Usuario;
/*
 * Con la etiqueta @Repository indicamos que es un repositorio de datos y que como lleva implicita la etiqueta
 * @Component estamos indicando que esta clase pasa a ser un componente de Spring
 */
@Repository
public class ReservaDaoImpl implements IntReservaDao{

	private List<Reserva> lista;
	
	public ReservaDaoImpl() {
		lista = new ArrayList<>();
		cargarDatos();
	}
	
	private void cargarDatos() {

		IntEventoDao evento = new EventoDaoImpl();
		IntUsuarioDao usuario = new UsuarioDaoImpl();
		
		lista.add( new Reserva ( 1, evento.findById(1), usuario.findById(1), evento.findById(1).getPrecioDecimal(), "Ejemplo de observaciones 01", 3 ) );
		lista.add( new Reserva ( 2, evento.findById(2), usuario.findById(2), evento.findById(2).getPrecioDecimal(), "Ejemplo de observaciones 02", 4 ) );
		lista.add( new Reserva ( 3, evento.findById(3), usuario.findById(1), evento.findById(3).getPrecioDecimal(), "Ejemplo de observaciones 03", 5 ) );
		lista.add( new Reserva ( 4, evento.findById(4), usuario.findById(2), evento.findById(4).getPrecioDecimal(), "Ejemplo de observaciones 04", 6 ) );
		
	}

	@Override
	public List<Reserva> buscarTodos() {
		return lista;
	}
	/*
	 * Con este metodo buscamos una reserva con su idReserva
	 * 
	 */
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
	/*
	 * con este metodo añadimo una reserva a la lista. 
	 * Si la reserva no se encuentra en la lista, se añade y retorna '1', en caso contrario devuelve '0'
	 */
	@Override
	public int reservar(Reserva reserva) {
		if (!lista.contains(reserva)) {
			lista.add(reserva);
			return 1;
		}
			return 0;
	}

	@Override
	public int totalReservas() {
		// Devuelvo el total de elementos en la lista, para saber cuantas reservas se han hecho.
		return lista.size();
	}

	@Override
	public int obtenerId() {
		// Para que no se repita el id le asigno el total de elementos + 1.
		return (lista.size() + 1 );
	}
	/*
	 * Con este metodo calculamos cuantas plazas quedan para los eventos
	 * A traves de un foreach recorremos la lista y calcula cuantas entradas quedan.
	 */
	@Override
	public int entradasRestantes(Evento evento) {
		int totalAforo = evento.getAforoMaximo();
		int idEvento = evento.getIdEvento();
		int cantidadTotal = 0;
		
		for (Reserva ele : lista) {
			if(idEvento == ele.getEvento().getIdEvento()){
				cantidadTotal = cantidadTotal + ele.getCantidad();
			}
		}
		int quedan = totalAforo-cantidadTotal;
		return quedan;
	}
}
