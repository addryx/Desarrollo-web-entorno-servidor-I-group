package com.edix.cajero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edix.cajero.modelo.entitybeans.Cuenta;
import com.edix.cajero.repository.CuentaRepository;

@Controller
public class CuentaController {
	
	@Autowired
	private CuentaRepository crepo;
	
	@GetMapping("/inicio")
	public String procInicio(Model model) {
		
		/*
		 * Creamos un objeto cuenta.
		 * A este objeto le pasamos el repositorio con todos los datos y le decimos que busque la familia 1.
		 * Si lo encuentra, me devuelve la familia.
		 * Si no lo encuentra (orElse) que me devuelva un null. 
		 */
		Cuenta cuenta = crepo.findById(1).orElse(null);
		model.addAttribute("cuenta", cuenta);
		return "pruebasjpa";
	}

}
