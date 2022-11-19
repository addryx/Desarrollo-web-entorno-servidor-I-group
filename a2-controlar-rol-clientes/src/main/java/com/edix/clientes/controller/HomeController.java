package com.edix.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edix.clientes.modelo.beans.Evento;
import com.edix.clientes.modelo.repository.IntEventoDao;

@Controller
public class HomeController {
	
	@Autowired
	private IntEventoDao edao;
	
	@GetMapping ("/inicio")
	public String procesarInicio (Model model) {
		List<Evento> lista = edao.buscarTodos();
		List<Evento> listaActivos = edao.mostrarActivos();
		List<Evento> listaDestacados = edao.mostrarDestacados();
		// List<Usuario> listaUsuario = udao.buscarUsuarios();
		model.addAttribute("listaEventos", lista);
		model.addAttribute("listaActivos", listaActivos);
		model.addAttribute("listaDestacados", listaDestacados);
		// model.addAttribute("listaUsuario", listaUsuario);
		return "Inicio";
	}
	
	@GetMapping ("/clientes")
	public String procesarClientes (Model model) {
		List<Evento> lista = edao.buscarTodos();
		List<Evento> listaActivos = edao.mostrarActivos();
		List<Evento> listaDestacados = edao.mostrarDestacados();
		model.addAttribute("listaEventos", lista);
		model.addAttribute("listaActivos", listaActivos);
		model.addAttribute("listaDestacados", listaDestacados);
		return "InicioCliente";
	}
	
	@GetMapping ("/activosCliente")
	public String procesarActivos (Model model) {
		List<Evento> lista = edao.buscarTodos();
		List<Evento> listaActivos = edao.mostrarActivos();
		List<Evento> listaDestacados = edao.mostrarDestacados();
		model.addAttribute("listaEventos", lista);
		model.addAttribute("listaActivos", listaActivos);
		model.addAttribute("listaDestacados", listaDestacados);
		return "ActivosCliente";
	}

}
