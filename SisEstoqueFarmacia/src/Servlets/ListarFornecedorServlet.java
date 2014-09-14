package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Endereco;
import cadastroClientes.PessoaJuridica;

public class ListarFornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarFornecedorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String filtro = request.getParameter("filtro");

		
		List<PessoaJuridica> juridicas = new ArrayList<PessoaJuridica>();
		
		
		//Recebendo Pagina do JSP------------------------------------------------------
				int qtdePag = Facada.getQtdePagPJ(); //MUDAR PARA O TIPO DA CLASSE SERVLET NO FACADE
				String valorPag = request.getParameter("pag");
				//Verificando a Paginação vinda do JSP
				System.out.println("Numero de Pagina = "+ qtdePag);
				
				Integer pag = null;
				try{
					if (valorPag == null || valorPag.equals("0")) {
						pag = 0;
						System.out.println("IF - Página igual a null ou 0");
					}
					else{
						pag = Integer.parseInt(valorPag);
						System.out.println("ELSE_ Conversao da Pag-String to INT");
					}
				}
				catch(NumberFormatException e){
					throw new ServletException("Problema com o parâmetro da paginação");
				}
				//-----------------------------------FIM DA PAGINAÇÃO-----------
		
		
		
		if(filtro != null && !filtro.equals("")){
			juridicas = Facada.buscarPessoaJuridicaPorNome(filtro);
		}
		else{
			juridicas = Facada.listarPJLimitados(pag);
		}
		//Ultimo Detalhe Paginação-------------------------------------
				request.setAttribute("qtdePages", qtdePag);
				System.out.println("DETALHES -------------- PAGINAÇÃO------------------");
				System.out.println("request.setAttribute(\"qtdePages\", qtdePag); == "+qtdePag);
				System.out.println("qtde de indices? "+juridicas.size());
				System.out.println("FIM----- -------------- PAGINAÇÃO------------------");
		request.setAttribute("juridicas", juridicas);
		
		request.getRequestDispatcher("pags/fornecedores/listarFornecedores.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
