package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cadastroClientes.Farmaceutico;
import cadastroClientes.Usuario;


public class EmitirRelatorioSngpcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmitirRelatorioSngpcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		System.out.println("-----------------------------------------------");
		System.out.println("Open - SNGPC GERADOR");
		
		Usuario usuario = new Usuario();
		
		HttpSession session = request.getSession(false);
		
		usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuario instanceof Farmaceutico){
			request.getRequestDispatcher("pags/sngpc/sngpc.jsp")
			.forward(request, response);
		}else{
			String message = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Não tem Privilégios suficientes.</h5></div>";
			System.out.println("Sem Privilégios. Redirect Principal");
			session.setAttribute("message", message);
			response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
