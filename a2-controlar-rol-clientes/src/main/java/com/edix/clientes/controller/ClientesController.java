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
/*
 * Con la etiqueta @Controller indicamos que se trata de un controlador y que va a llevar todo lo que 
 * tenga que ver con Clientes. 
 * Con la etiqueta @RequestMapping estamos sacando el factor comun de la URL.
 */
@Controller
@RequestMapping("/clientes")
public class ClientesController {
	/*
	 * Con la etiqueta @Autowired nos aseguramos que en tiempo de ejecucion Spring, busque una clase que 
	 * implemente esta interfaz.
	 */
	@Autowired
	private IntUsuarioDao udao;

	@Autowired
	private IntEventoDao edao;
	
	@Autowired
	private IntReservaDao rdao;
	/*
	 * Con este metodo estamos enviando el formulario para realizar el login
	 */
	@GetMapping("/login")
	public String mostrarFormLogin(Model model) {
		return "FormLogin";
	}
	/*
	 * Este metodo y el anterior llevan la misma URL, esto es posible ya que uno es mandado por GET y otro 
	 * por POST.
	 * Con este metodo nos permite logarnos y entrar en la sesion del usuario.
	 * Cuando el usuario se ha logado correctamente se imprime el mensajer "Login del usuario realizado"
	 * en el caso contrario imprime "Login del usuario no realizado".
	 */
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
	/*
	 * Con este metodo cerramos la sesion del usuario
	 */
	@GetMapping("/cerrarSesion")
	public String procCerrarSesion(HttpSession sesion, Usuario usuario) {
		sesion.setAttribute("sesionUsuario", null);
		System.out.println(sesion.getAttribute("sesionUsuario"));
		return "forward:/inicio";
	}
	/*
	 * Con este metodo mostramos los eventos activos para el usuario
	 */
	@GetMapping("/activos")
	public String mostrarActivos(Model model) {
		return "forward:/activosCliente";
	}
	/*
	 * Con este metodo mostramos los eventos destacados para el usuario
	 */
	@GetMapping("/destacados")
	public String mostrarDestacados(Model model) {
		return "forward:/clientes";
	}
	/*
	 * Con este metodo mostramos los detalles del evento.
	 * En los parametros se recoge con la etiqueta @PathVariable el "id" y le pedimos que transforme el 
	 * String a un entero. 
	 */
	@GetMapping("/detalle/{id}")
	public String mostrarDetalle(Model model, @PathVariable("id") int idEvento) {
		Evento evento = edao.findById(idEvento);
		model.addAttribute("evento", evento);
		model.addAttribute("totalReservas", rdao.obtenerId());
		model.addAttribute("quedan", rdao.entradasRestantes(evento));
		return "DetalleEvento";
	}
	/*
	 * Con este metodo realizamos la reserva de un evento a traves del "id" en la sesion del cliente. 
	 * En el caso de que la reserva fuese correcta imprime un mensaje que dice "Todo correcto, reserva realizada"
	 * en caso contrario "Problemas al dar de alta, reserva no realizada"
	 */
	@PostMapping("/reservar/{id}")
	public String procReserva(@PathVariable( "id" ) int idEvento, HttpSession sesion, RedirectAttributes rattr, @RequestParam("cantidad") int cantidad) {
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
	/*
	 * Con esta etiqueta y el siguiente metodo informamos a Spring de que me pase el String a Date de java.util
	 */
	@InitBinder // Con este método se soluciona el parseo del formato de la fecha.
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	/*
	 * Con este metodo vemos una lista con todas la reservas.
	 */
	@GetMapping("/reservas")
	public String verReservas(Model model) {
		// Le paso una lista de TODAS las reservas.
		model.addAttribute("listadoReservas", rdao.buscarTodos());
		return "Reservas";
	}
}
