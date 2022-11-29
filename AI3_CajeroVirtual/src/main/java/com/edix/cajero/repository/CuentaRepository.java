package com.edix.cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.cajero.modelo.entitybeans.Cuenta;


/*
 * Creo un repositorio que extiende de la clase JpaRepository.
 * Como extiende de él, todos sus métodos los va a poder utilizar este repositorio. 
 * Ponemos la clase Cuenta. 
 * Cuando hagamos un @Autowired va a implementar todos los métodos de JpaRepository.
 */

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{

}
