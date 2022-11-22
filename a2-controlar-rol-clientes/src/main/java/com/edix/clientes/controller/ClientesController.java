package com.edix.clientes.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.clientes.modelo.beans.Evento;
import com.edix.clientes.modelo.beans.Reserva;
import com.edix.clientes.modelo.beans.Usuario;
import com.edix.clientes.modelo.repository.IntEventoDao;
import com.edix.clientes.modelo.repository.IntReservaDao;
import com.edix.clientes.modelo.repository.IntUsuarioDao;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private IntUsuarioDao udao;

	@Autowired
	private IntEventoDao edao;
	
	@Autowired
	private IntReservaDao rdao;

	@GetMapping("/login")
	public String mostrarFormLogin(Model model) {
		return "FormLogin";
	}

	@PostMapping("/login")
	public String procLogin(HttpSession sesion, Usuario usuario, RedirectAttributes rattr) {
		
		if (udao.comprobarLogin(usuario.getPassword(), usuario.getUsername()) == 1) {
			
			rattr.addFlashAttribute("mensaje", "Login del usuario realizado.");
			sesion.setAttribute("sesionUsuario", usuario);
			sesion.setAttribute( "idUsuarioLogeado", usuario.getIdUsuario());
			
			System.out.println(sesion.getAttribute("sesionUsuario"));
			return "redirect:/clientes";
		} else {
			rattr.addFlashAttribute("mensaje", "Login del usuario no realizado.");
			return "redirect:/inicio";
		}
	}
	
	

	@GetMapping("/cerrarSesion")
	public String procCerrarSesion(HttpSession sesion, Usuario usuario) {
		sesion.setAttribute("sesionUsuario", null);
		System.out.println(sesion.getAttribute("sesionUsuario"));
		return "forward:/inicio";
	}

	@GetMapping("/activos")
	public String mostrarActivos(Model model) {
		return "forward:/activosCliente";
	}

	@GetMapping("/destacados")
	public String mostrarDestacados(Model model) {
		return "forward:/clientes";
	}

	@GetMapping("/detalle/{id}")
	public String mostrarDetalle(Model model, @PathVariable("id") int idEvento) {
		Evento evento = edao.findById(idEvento);
		model.addAttribute("evento", evento);
		return "DetalleEvento";
	}

	@PostMapping("/reservar/{id}") 
	public String procReserva(@PathVariable( "id" ) int idEvento, HttpSession sesion, RedirectAttributes rattr, @RequestParam("cantidad") int cantidad) {
		
		
		System.out.println(idEvento);
		System.out.println(cantidad);
		
		Reserva nuevaReserva = new Reserva(rdao.obtenerId(), edao.findById(idEvento), (Usuario) sesion.getAttribute("usuario"),
			edao.findById(idEvento).getPrecioDecimal(), "hola", cantidad);
		
		int reservaCreada = rdao.reservar(nuevaReserva);
		
		if (reservaCreada == 1 ) {
			rattr.addFlashAttribute("mensaje", "Todo correcto, mensaje reserva realizada.");
		} else {
			rattr.addFlashAttribute("mensaje", "Problemas al dar de alta, reserva no realizada.");
		}
		return "redirect:/clientes";
	}
	

	@InitBinder // Con este método se soluciona el parseo del formato de la fecha.
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	
		@GetMapping("/reservas")
		public String verReservas(Model model) {
			
			// Le paso una lista de TODAS las reservas.
			
			model.addAttribute("listadoReservas", rdao.buscarTodos());
			
			return "Reservas";
			
		}
}
