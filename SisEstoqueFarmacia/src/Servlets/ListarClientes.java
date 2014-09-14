package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.PessoaFisica;
import cadastroClientes.PessoaJuridica;

/**
 * Servlet implementation class ListarClientes
 */
public class ListarClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");
		List<PessoaFisica> fisicas = new ArrayList<PessoaFisica>();
		
		//Recebendo Pagina do JSP------------------------------------------------------
		int qtdePag = Facada.getQtdePagPF(); //MUDAR PARA O TIPO DA CLASSE SERVLET NO FACADE
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
			fisicas = Facada.buscarPessoaFisicaPorNome(filtro);
		}
		else{
			fisicas = Facada.listarPFLimitados(pag);
		}
		
		//Ultimo Detalhe Paginação-------------------------------------
		request.setAttribute("qtdePages", qtdePag);
		System.out.println("DETALHES -------------- PAGINAÇÃO------------------");
		System.out.println("request.setAttribute(\"qtdePages\", qtdePag); == "+qtdePag);
		System.out.println("qtde de indices? "+fisicas.size());
		System.out.println("FIM----- -------------- PAGINAÇÃO------------------");
		//---------------------------------------------FIM DETALHES
		
		request.setAttribute("fisicas", fisicas);
		
		request.getRequestDispatcher("pags/clientes/listarClientes.jsp").forward(request, response);
		
		//	String mensagem = (String) request.getAttribute("msg");

//		out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
//		out.println("<h3 align='center' >Listar Clientes</h3>");
//		///listarProdutoServlet.du
//		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//		out.println("<form method='post' action='/SisEstoqueFarmacia/ListarClientes.du'>");
//		
//		out.println("<div align='center' class='pesquisa'>");
//			out.println("<input type='text' name='filtro' value='"+(filtro != null && !filtro.equals("")? filtro : "")+"'>");
//			out.println("<input type='submit' value='Pesquisar'>");
//		out.println("</form><br />");
//		out.println("</div>");
//		
//			out.println("<table align='center' border='1' cellpadding='3'>");
//			out.println("<th cellspacing='2'>Codigo</th>");
//			out.println("<th cellpadding='3'>Nome</th>");
//			out.println("<th cellpadding='3'>CPF</th>");
//			out.println("<th cellpadding='3'>Telefone</th>");
//			out.println("<th cellpadding='3'>Bairro</th>");
//			out.println("<th cellpadding='3'>CEP</th>");
//			out.println("<th cellpadding='3'>Rua</th>");
//			out.println("<th cellpadding='3'>Numero</th>");
//			out.println("<th cellpadding='3'>Cidade</th>");
//			out.println("<th cellpadding='3'>Estado</th>");
//			out.println("<th cellpadding='3'>Acoes</th>");
//				
//			for (PessoaFisica pessoaFisica : fisicas) {
//				
//			out.println("<tr>");
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getId());
//			out.println("</td>");
//				
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getNome());
//			out.println("</td>");
//			
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getCpf());
//			out.println("</td>");
//			
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getTelefone());
//			out.println("</td>");
//
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getEndereco().getBairro());
//			out.println("</td>");
//			
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getEndereco().getCep());
//			out.println("</td>");
//			
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getEndereco().getRua());
//			out.println("</td>");
//			
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getEndereco().getNumero());
//			out.println("</td>");
//			
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getEndereco().getCidade());
//			out.println("</td>");
//			
//			out.println("<td align='center'>");
//			out.println(pessoaFisica.getEndereco().getEstado());
//			out.println("</td>");
//			
//			
//			out.println("<td>");
//			out.println("<a href='/SisEstoqueFarmacia/EditarClientes.du?idpessoaFisica="+pessoaFisica.getId()+"'>editar</a> <a href='/SisEstoqueFarmacia/removerClientes.du?idpessoaFisica="+pessoaFisica.getId()+"'>remover</a>");
//			out.println("</td>");
//			
//			
//			out.println("</tr>");
//			
//			}

	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
