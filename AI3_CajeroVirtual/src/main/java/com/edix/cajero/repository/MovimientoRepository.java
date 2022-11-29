package com.edix.cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.cajero.modelo.entitybeans.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{

}
