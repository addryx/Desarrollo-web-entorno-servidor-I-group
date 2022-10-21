package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.EventoDaoImpl;
import modelo.dao.IntEventoDao;
import modelo.javabeans.Evento;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet("/Eventos")
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		switch(opcion) {
			case "activos":
				procActivos(request,  response);
				break;
			case "alta":
				procAlta( request,  response);
				break;
			case "editar":
				procEditar(request,  response);
				break;
			case "eliminar":
				procEliminar(request,  response);
				break;
			case "cancelar":
				procCancelar(request,  response);
				break;
			default:
		System.out.println("opcion incorrecta : " + opcion);
		}
	}
	
	protected void procActivos (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	
	protected void procAlta (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Evento evento = new Evento();
		evento.setIdEvento(Integer.parseInt(request.getParameter("idEvento")));
		evento.setNombre(request.getParameter("idNombre"));
		evento.setDescripcion(request.getParameter("descripcion"));
		//evento.setFechaInicio(request.getParameter("fechaInicio"));
		evento.setDuracion(Integer.parseInt(request.getParameter("duracion")));
		evento.setDireccion(request.getParameter("direccion"));
		evento.setEstado(request.getParameter("estado"));
		//evento.setDestacado(x.charAt((request.getParameter("destacado")));
		evento.setAforoMaximo(Integer.parseInt(request.getParameter("aforoMaximo")));
		evento.setMinimoAsistencia(Integer.parseInt(request.getParameter("minimoAsistencia")));
		evento.setPrecioDecimal(Double.parseDouble(request.getParameter("precioDecimal")));
		//evento.setTipo(Object.parseObj(request.getParameter("tipo")));
		

	}
	
	/**
	 * Nos creamos una variable id que es igual al parámetro "id" (hay que hacer un casting)
	 * Ahora nos creamos una variable del tipo interface.
	 * Nos creamos una variable de tipo Evento donde le pasamos el id del evento, recogido por parámetro. 
	 * Ahora le damos el atributo que queremo. 
	 * Y con el requestDispatcher lo mandamos a otro JSP. 
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void procEditar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		IntEventoDao ievento = new EventoDaoImpl();
		Evento evento = ievento.findById(id);
		request.setAttribute("evento", evento);
		request.getRequestDispatcher("editarEvento.jsp").forward(request, response);
	}
	
	protected void procEliminar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void procCancelar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
