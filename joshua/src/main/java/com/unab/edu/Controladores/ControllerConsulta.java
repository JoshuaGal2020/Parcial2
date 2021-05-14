package com.unab.edu.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.unab.edu.DAO.ClsConsulta;
import com.unab.edu.Entidades.Consulta;

/**
 * Servlet implementation class ControllerConsulta
 */
public class ControllerConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String eliminar = request.getParameter("Eliminar");
		String Id = request.getParameter("Id");
		
		ClsConsulta consulta = new ClsConsulta();
		Consulta consul = new Consulta();
		
		if (eliminar != null) {
			HttpSession sesion = (HttpSession) request.getSession();
			String usuSession = String.valueOf(sesion.getAttribute("nombre"));
			
			if(usuSession.equals(null) || usuSession.equals("null")){
				response.sendRedirect("index.jsp");
			}
			else{
				consul.setId(Integer.parseInt(Id));
				consulta.EliminarConsulta(consul);
				response.sendRedirect("index.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		Gson json = new Gson();
		ClsConsulta consulta = new ClsConsulta();

		response.getWriter().append(json.toJson(consulta.ListadoUSUARIOS()));
	}

}
