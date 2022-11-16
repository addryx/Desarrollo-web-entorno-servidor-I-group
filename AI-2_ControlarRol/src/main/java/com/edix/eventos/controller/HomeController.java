package com.edix.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edix.eventos.modelo.beans.Evento;
import com.edix.eventos.modelo.repository.IntEventoDao;


// Lo primero que tenemos que hacer es decirle al Homecontroller que es un controlador, con la anotación correspondiente
@Controller
public class HomeController {
	
	/* Por cada URL distinta que nos llega al proyecto tenemos que crear un método. 
	 * 
	 * Por GET -> Todo lo que nos llega de la barra de navegación y desde los href. 
	 * Por POST -> Formularios. 
	 * 
	 * Desde un jsp no se puede llamar directamente a otro jsp ya que puede necesitar datos de una BBDD
	 * y esto se hace mediante un controlador, desde el método GET. 
	 * 
	 * Todo lo que venga por GET necesitamos un método public String n_metodo (par) 
	 * En cuanto a los parámetros le podemos inyectar lo que queramos, como un model. 
	 * Objeto de sesión, objeto request, objeto response... Lo que queramos. 
	 * Todo lo que nos haga falta para el método y lo que nos pueda proporcionar Spring entrará por parámetro.
	 * 
	 * En la anotación del GET, tiene que ser "@GetMattin" + la ruta, que será única en todos los servlets que tengamos
	 * Solo puede haber dos rutas iguales, pero una tiene que ir con @GetMapping y la otra con @PostMapping
	 * 
	 */
	
	// Primero necesitamos el dao o repositorio.
	// Se crea una variable de tipo interface para cuando el JSP venga al controlador a pedirle datos. 
	// Se crea un objeto con el new, porque necesita buscar datos en una BBDD o repositorio.
	// En tiempo de ejecución busca una clase que implemente a esta interface, la crea y la hace singleton. 
	// Para que esto ocurra, tiene que tener la anotación "@Autowired"
	
	@Autowired
	private IntEventoDao edao;
	
	
	// El Model en tiempo de ejecución crea un objeto de la clase model. 
	// El Model es muy parecido al HttpRequest
	@GetMapping ("/inicio")
	public String procesarInicio (Model model) {
		
		List<Evento> lista = edao.buscarTodos();
		List<Evento> listaActivos = edao.mostrarActivos();
		model.addAttribute("listaEventos", lista);
		model.addAttribute("listaActivos", listaActivos);
		
		return "index";
	}

}
