package com.edix.clientes.modelo.repository;

import java.util.List;

import com.edix.clientes.modelo.beans.Tipo;

public interface IntTipoDao {

	List<Tipo> findAll();
}
