package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Facada.Facada;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastroClientes.Produto;

/**
 * Servlet implementation class ListarProdutoServlet
 */
public class ListarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeProduto = request.getParameter("nomeProduto");
		
		//Recebendo Pagina do JSP------------------------------------------------------
		int qtdePag = Facada.getQtdePagProdutos(); // LEMBRAR DE MUDAR ISSO PARA O TIPO DA CLASSE
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
		
		List<Produto> produtos = new ArrayList<Produto>();

		if( nomeProduto != null && !nomeProduto.equals("")){
			produtos = Facada.buscarProdutoPorNome(nomeProduto);
			//para remover o produto criar um servlet so pra fazer isso listando o id e o produto apenas

		}else{
			produtos = Facada.listarProdutosLimitados(pag);	// Mudou para o listar limitados		
		};
		//Ultimo Detalhe Paginação-------------------------------------
		request.setAttribute("qtdePages", qtdePag);
		System.out.println("DETALHES -------------- PAGINAÇÃO------------------");
		System.out.println("request.setAttribute(\"qtdePages\", qtdePag); == "+qtdePag);
		System.out.println("qtde de indices? "+produtos.size());
		System.out.println("FIM----- -------------- PAGINAÇÃO------------------");
		//---------------------------------------------FIM DETALHES
		
		request.setAttribute("produtos", produtos);
		request.getRequestDispatcher("pags/produtos/listarProdutos.jsp")
		.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	
	
}
