package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;

/**
 * Servlet implementation class removerUsuarioServlet
 */
public class removerUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public removerUsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUsuario = request.getParameter("idUsuario");

		try {
			Facada.excluirUsuario(new Long(idUsuario));
			
			request.setAttribute("mensagem", "Fornecedor Excluido com sucesso!");
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "N�o foi poss�vel excluir o Fornecedor!");
		}


		request.getRequestDispatcher("ListarUsuarios.du").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
