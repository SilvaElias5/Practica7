package Server;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import Modelo.Modelo_Us;
import Sentencias.Sentencias_cls;


public class controlServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public controlServer() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion.equals("crear")) {
			System.out.println("Presionado crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		} else if(opcion.equals("listar")) {
			System.out.println("Presionado listar");
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
