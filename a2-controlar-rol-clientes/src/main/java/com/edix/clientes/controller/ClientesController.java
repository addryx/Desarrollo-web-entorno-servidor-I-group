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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.clientes.modelo.beans.Usuario;
import com.edix.clientes.modelo.repository.IntUsuarioDao;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private IntUsuarioDao udao;
	
	@GetMapping("/login")
	public String mostrarFormLogin(Model model) {
			return "FormLogin";
	}
	 
	@PostMapping("/login")
		public String procLogin(HttpSession sesion, Usuario usuario, RedirectAttributes rattr) {
			if (udao.comprobarLogin(usuario.getPassword(), usuario.getUsername()) == 1) {
				rattr.addFlashAttribute("mensaje", "Login del usuario realizado.");
				sesion.setAttribute("sesionUsuario", usuario);
			} else {
				rattr.addFlashAttribute("mensaje", "Login del usuario no realizado.");
			}
			return "redirect:/clientes";
		}
	
	/*
	 @GetMapping("/cerrarSesion")
	*/
	
	@GetMapping("/activos")
	public String mostrarActivos(Model model) {
			return "vistaCliente";
	}
	
	/*
	 @GetMapping("/destacados")
	*/
	
	/*
	 @GetMapping("/detalle/{id}")
	*/
	
	/*
	 @GetMapping("/reservar/{id}")
	*/
	 
	 @InitBinder // Con este método se soluciona el parseo del formato de la fecha.
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			sdf.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		}
	
}