package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

}
