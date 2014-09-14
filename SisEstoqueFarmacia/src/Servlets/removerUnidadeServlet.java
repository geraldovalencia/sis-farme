package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;

public class removerUnidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public removerUnidadeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String idUnidade = request.getParameter("idUnidade");

		try {
			Facada.excluirUnidade(new Long(idUnidade));
			
			request.setAttribute("mensagem", "Unidade Excluida com sucesso!");
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "Não foi possível excluir a unidade!");
		}


		request.getRequestDispatcher("ListarUnidadeServlet.du").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
