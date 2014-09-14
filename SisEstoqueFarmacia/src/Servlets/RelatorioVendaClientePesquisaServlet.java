package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.RepositoryIdHelper;

import Facada.Facada;

/**
 * Servlet implementation class RelatorioVendaClientePesquisaServlet
 */
public class RelatorioVendaClientePesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioVendaClientePesquisaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pessoaId = request.getParameter("pessoaId");

		if(pessoaId != null && !pessoaId.equals("")){
			request.setAttribute("pessoaId", pessoaId);
			request.getRequestDispatcher("RelatorioCompraClienteServlet.du").forward(request, response);
		}else{
			request.getRequestDispatcher("pags/relatorios/telaConsultaVendaCliente.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
