package com.edix.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edix.clientes.modelo.beans.Evento;
import com.edix.clientes.modelo.repository.IntEventoDao;
/*
 * Con la clase HomeController llevamos la pagina principal  y el login
 * Con la etiqueta @Controller indicamos que esta clase es controlador y un componente de Spring
 * Todos los metodos reciben por parametro un objeto de la clase Model, que es muy parecido al objeto 
 * request de la clase HttpServletRequest
 */
@Controller
public class HomeController {
	/*
	 * Con la etiqueta @Autowired nos aseguramos que en tiempo de ejecucion Spring, busque una clase que 
	 * implemente esta interfaz. 
	 * Le damos el nombre del bean y la clase a la que pertenece.
	 */
	@Autowired
	private IntEventoDao edao;
	
	/*
	 * Ponemos la etiqueta @GetMapping ya que la petición viene por GET
	 * El metodo asociado se encargara de mostrar lista, listasActivos y listaDestacados en el inicio
	 */
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
	/*
	 * El metodo asociado se encargara de mostrar lista, listasActivos y listaDestacados en el InicioCliente
	 */
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
	/*
	 * El metodo asociado se encargara de mostrar lista, listasActivos y listaDestacados en el ActivosCliente
	 */
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
