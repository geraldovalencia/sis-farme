package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;

/**
 * Servlet implementation class removerFornecedorServlet
 */
public class removerFornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removerFornecedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out = response.getWriter();
		String idpessoaJuridica = request.getParameter("idpessoaJuridica");

		try {
			Facada.excluirPessoaJuridica(new Long(idpessoaJuridica));
			
			request.setAttribute("mensagem", "Fornecedor Excluido com sucesso!");
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "N�o foi poss�vel excluir o Fornecedor!");
		}


		request.getRequestDispatcher("ListarFornecedorServlet.du").forward(request, response);

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
