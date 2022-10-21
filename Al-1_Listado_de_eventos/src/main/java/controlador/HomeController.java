package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.EventoDaoImpl;
import modelo.dao.IntEventoDao;
import modelo.javabeans.Evento;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeController() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {

	}

	/**
	 * Me pongo en contacto con la capa de dao.
	 * La capa de dao me proporciona a partir del findAll la lista de datos.
	 * Esto lo meto en un atributo (le hemos llamado listaEventos y le hemos metido la lista en esa variable.
	 * Después se lo paso al index.jsp para que lo pinte. 
	 * Ahora nos vamos al index.jsp para recuperar la lista. 
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IntEventoDao ievento = new EventoDaoImpl();
		List<Evento> lista = ievento.buscarTodos(); 
		request.setAttribute("listaEventos", lista);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

}