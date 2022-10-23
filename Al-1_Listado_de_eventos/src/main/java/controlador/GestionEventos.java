package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.ParseException;

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

@WebServlet("/Eventos")
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionEventos() {
		super();
	}
	
	IntEventoDao edao = new EventoDaoImpl();
	
	/**
	 * En el método service creamos un switch, dentro de éste tenemos las opciones que tendrá disponible el usuario, y para no desarrollar
	 * los métodos todos juntos, se vincula a un método externo.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		switch (opcion) {
		/* Hemos quitado ésta opción porque no es necesaria ni hay un botón en la interfaz para sacar la lista de activos, ya que ya sale.
		case "activos":
			procActivos(request, response);
			break;
		*/
		case "alta":
			try {
				procAlta(request, response);
			} catch (ServletException | IOException | java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "editar":
			procEditar(request, response);
			break;
		case "eliminar":
			procEliminar(request, response);
			break;
		case "cancelar":
			procCancelar(request, response);
			break;
		default:
			System.out.println("Opcion incorrecta: " + opcion);
		}
	}

	/**
	protected void procActivos(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		IntEventoDao edao = new EventoDaoImpl();
		edao.mostrarActivos();
		request.getRequestDispatcher("inicio").forward(request, response);
	}
	*/

	/**
	 * En este método se crea un nuevo evento, y en cada una de las variables del objeto evento se meten los datos recibidos a través del
	 * request.getParameter.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws java.text.ParseException 
	 */
	protected void procAlta(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, java.text.ParseException {
		
		Evento evento = new Evento();
		
		evento.setIdEvento(Integer.parseInt(request.getParameter("idEvento")));
		evento.setNombre(request.getParameter("nombre"));
		evento.setDescripcion(request.getParameter("descripcion"));
		
		Date fechaDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fechaDate = sdf.parse(request.getParameter("fechaInicio"));
		evento.setFechaInicio(fechaDate);
		
		evento.setDuracion(Integer.parseInt(request.getParameter("duracion")));
		evento.setDireccion(request.getParameter("direccion"));
		evento.setEstado(request.getParameter("estado"));
		evento.setDestacado(request.getParameter("destacado"));
		evento.setAforoMaximo(Integer.parseInt(request.getParameter("aforoMaximo")));
		evento.setMinimoAsistencia(Integer.parseInt(request.getParameter("minimoAsistencia")));
		evento.setPrecioDecimal(Double.parseDouble(request.getParameter("precioDecimal")));
		evento.setTipo(Integer.parseInt(request.getParameter("tipo")));
		
		//edao.insertarEvento(evento);
		
		String mensaje = null;
		if(edao.insertarEvento(evento)==1) {
			mensaje = "Alta realizada correctamente.";
		}else {
			mensaje = "Alta no realizada.";
		}
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("listaEventosActivos", ((EventoDaoImpl)edao).mostrarActivos());
		request.getRequestDispatcher("inicio").forward(request, response);
	}

	/**
	 * Nos creamos una variable id que es igual al parámetro "id" (hay que hacer un
	 * casting) Ahora nos creamos una variable del tipo interface. Nos creamos una
	 * variable de tipo Evento donde le pasamos el id del evento, recogido por
	 * parámetro. Ahora le damos el atributo que queremo. Y con el requestDispatcher
	 * lo mandamos a otro JSP.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void procEditar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Evento evento = edao.findById(id);
		
		request.setAttribute("evento", evento);
		request.getSession().setAttribute("listaEventosActivos", ((EventoDaoImpl)edao).mostrarActivos());
		request.getRequestDispatcher("editarEvento.jsp").forward(request, response);
	}

	/**
	 * Este método comprueba si el método eliminarEvento devuelve 1 o 0, si exíste lo elimina, si no devuelve un mensaje de error al usuario.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void procEliminar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		edao.eliminarEvento(id);
		
		String mensaje = null;
		if(edao.eliminarEvento(id)==0) {
			mensaje = "Evento eliminado correctamente.";
		}else {
			mensaje = "Error. El evento no se ha podido eliminar.";
		}
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("listaEventosActivos", ((EventoDaoImpl)edao).mostrarActivos());
		request.getRequestDispatcher("inicio").forward(request, response);
	}

	/**
	 * Este método comprueba si el evento exíste, si exíste lo elimina, si no devuelve un mensaje de error al usuario.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void procCancelar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		edao.cancelarEvento(id);
		
		String mensaje = null;
		if(edao.cancelarEvento(id)==0) {
			mensaje = "Evento cancelado correctamente.";
		}else {
			mensaje = "Error. El evento no se ha podido cancelar.";
		}
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("listaEventosActivos", ((EventoDaoImpl)edao).mostrarActivos());
		request.getRequestDispatcher("inicio").forward(request, response);
	}
}
