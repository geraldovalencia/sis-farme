package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;

/**
 * Servlet implementation class removerProdutoServlet
 */
public class removerProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removerProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

	String idProduto = request.getParameter("idProduto");

	try {
		Facada.excluirProduto(new Long(idProduto));
		
		request.setAttribute("mensagem", "Produto Excluido com sucesso!");
		
	} catch (Exception e) {
		request.setAttribute("mensagem", "N�o foi poss�vel excluir o produto!");
	}


	request.getRequestDispatcher("ListarProdutoServlet.du").forward(request, response);

}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
