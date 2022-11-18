package com.edix.clientes.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.clientes.modelo.beans.Tipo;

@Repository
public class TipoDaoImpl implements IntTipoDao{

	private List<Tipo> listaTipos;
	
	public TipoDaoImpl() {
		listaTipos = new ArrayList<>();
		cargarDatos();
	}

	private void cargarDatos() {
		listaTipos.add(new Tipo(1, "Concierto", "Eventos de música"));
		listaTipos.add(new Tipo(2, "Despedida", "Despedida de soltero"));
		listaTipos.add(new Tipo(3, "Cumpleaños", "Celebración del aniversario de una persona"));
		listaTipos.add(new Tipo(4, "Boda", "Encuentro donde dos personas se casan"));
	}

	@Override
	public List<Tipo> findAll() {
		return listaTipos;
	}
}
