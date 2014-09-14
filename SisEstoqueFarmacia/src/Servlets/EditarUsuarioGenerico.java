package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import Facada.Facada;
import cadastroClientes.Administrador;
import cadastroClientes.Farmaceutico;
import cadastroClientes.Gerente;
import cadastroClientes.Usuario;

public class EditarUsuarioGenerico extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditarUsuarioGenerico() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idusuario = request.getParameter("idusuario");
		String usuarioTipo = request.getParameter("usuarioTipo");
		
		System.out.println("-----------------------------------------------");
		System.out.println("Abriu Servlet EditGenerico. O Id é: " + idusuario + " e o tipo é: " + usuarioTipo);
		
		if(idusuario != null ){
			
			request.getSession().setAttribute("idusuario", idusuario);
			request.getSession().setAttribute("usuarioTipo", usuarioTipo);
			
			if(usuarioTipo.equals("ADMINISTRADOR")){
				response.sendRedirect("EditarUsuarioServlet.du");
			}else if (usuarioTipo.equals("FARMACEUTICO")){
				request.getSession().setAttribute("idusuario", idusuario);
				response.sendRedirect("EditarUsuarioServlet.du");
			}else if (usuarioTipo.equals("VENDEDOR")){
				response.sendRedirect("EditarUsuarioServlet.du");
			}else if (usuarioTipo.equals("GERENTE")){
				response.sendRedirect("EditarUsuarioServlet.du");
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
