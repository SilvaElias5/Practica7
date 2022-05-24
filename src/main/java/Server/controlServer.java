package Server;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Modelo_Us;
import Sentencias.Sentencias_cls;

/**
 * 
 * @author silva
 * por estaclase se controla todosobre losmetodos y clases implementadas
 */
public class controlServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public controlServer() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
 * direccionamiento a las paginas jsp y se prueban sentencias en consola 
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion.equals("crear")) {
			System.out.println("Presionado crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
			
			
		} else if(opcion.equals("listar")) {
			
			Sentencias_cls stn = new Sentencias_cls();
			List<Modelo_Us> lista = new ArrayList<>();
			try {
				lista =stn.obtener();
				System.out.println("Listado de usuarios desde control servlet");
				for (Modelo_Us modelo_Us : lista) {
					System.out.println(modelo_Us);
				}
				
				
				System.out.println("Listado de usuarios por  tipo ");
					System.out.println(stn.obtenerTipo());
					
					System.out.println("Listado de usuarios por  estatus ");
					System.out.println(stn.obtenerEstatus());
				
				
				
				
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);
			} catch (Exception e) {
				System.out.println("No se pudo listar " + e);
			}

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		Modelo_Us model = new Modelo_Us();
		Sentencias_cls sent = new Sentencias_cls();
		model.setNombre_pila(request.getParameter("nombre"));
		model.setApellido_paterno(request.getParameter("paterno"));
		model.setApellido_materno(request.getParameter("materno"));
		model.setServicio(request.getParameter("servicio"));
		model.setFecha_nacimiento(Integer.parseInt(request.getParameter("fecha")));
		model.setPlan(request.getParameter("plan"));
		model.setEstatus(request.getParameter("estatus"));
		try {
			sent.insetar(model);
			System.out.println("Se inserto dato desde el controlServer");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			System.out.println("No Se inserto dato desde el controlServer"+e);
			e.printStackTrace();
		}
		
		
		//doGet(request, response);
	}

}
