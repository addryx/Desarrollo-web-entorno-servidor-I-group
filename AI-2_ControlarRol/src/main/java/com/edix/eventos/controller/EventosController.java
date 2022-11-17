package com.edix.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.eventos.modelo.beans.Evento;
import com.edix.eventos.modelo.repository.IntEventoDao;


// Con la anotación "@RequestMapping" lo que hacemos es que todo lo que vea que es /eventos nos lo traiga a este controlador.
@Controller
@RequestMapping("/Eventos")
public class EventosController {
	
	@Autowired
	private IntEventoDao edao;
	
	/*
	 * Aquí ponemos la anotación @GetMapping y al lado la ruta desde donde se va a hacer el GET. 
	 * el id entre llaves, es la que va a entrar por parámetro, y lo vamos a convertir en un entero con idEvento.
	 * 
	 * Primero creamos un objeto de evento, pasándole el evento que me ha llegado por parámetro. 
	 * Con esto, nos creamos un atributo evento.
	 */
	@GetMapping("/editar/{id}")
	public String editarEvento (Model model, @PathVariable ("id") int idEvento) {
		
		
		Evento evento = edao.findById(idEvento);
		model.addAttribute("evento", evento);
		
		// También se podría hacer directamente: 
		// model.addAttribute("evento", edao.findById(idEvento));
		
		return "editarEvento";
	}

	
	
	/*
	 * Creamos una clase para eliminar un evento, pasándole por parámetro el model y el idEvento convertido a entero
	 * desde el Atributo "id".
	 */
	@GetMapping("/eliminar")
	public String eliminarEvento (Model model, @RequestAttribute("id") int idEvento) {
		
		if (edao.eliminarEvento(idEvento)== 1)
			model.addAttribute("mensaje", "Evento eliminado");
		else 
			model.addAttribute("mensaje", "Evento no eliminado");
		
		// Se devuelve al JSP inicio.
		return "forward:/inicio";
	}
	
	/*
	@GetMapping("/alta")
	
	@PostMapping("/alta")
	*/
}
