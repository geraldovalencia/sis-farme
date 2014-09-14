package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Categoria;


public class removerCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public removerCategoriaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idCategoria = request.getParameter("idCategoria");

		try {
			Facada.excluirCategoria(new Long(idCategoria));
			
			request.setAttribute("mensagem", "Categoria Excluida com sucesso!");
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "N�o foi poss�vel excluir a categoria!");
		}


		request.getRequestDispatcher("listarCategorias.du").forward(request, response);

	}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
