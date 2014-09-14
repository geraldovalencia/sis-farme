package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Categoria;
import cadastroClientes.Produto;

//No sistema da farm√°cia, √© necess√°rio a Regra de Neg√≥cio da emiss√£o do SNGPC !!! LEMBRAR
public class ListarCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoria = request.getParameter("categoria");
		
		List<Categoria> categorias = null;
		
		
		//Recebendo Pagina do JSP------------------------------------------------------
				int qtdePag = Facada.getQtdePagPF(); //MUDAR PARA O TIPO DA CLASSE SERVLET NO FACADE
				String valorPag = request.getParameter("pag");
				//Verificando a PaginaÁ„o vinda do JSP
				System.out.println("Numero de Pagina = "+ qtdePag);
				
				Integer pag = null;
				try{
					if (valorPag == null || valorPag.equals("0")) {
						pag = 0;
						System.out.println("IF - P·gina igual a null ou 0");
					}
					else{
						pag = Integer.parseInt(valorPag);
						System.out.println("ELSE_ Conversao da Pag-String to INT");
					}
				}
				catch(NumberFormatException e){
					throw new ServletException("Problema com o par‚metro da paginaÁ„o");
				}
				//-----------------------------------FIM DA PAGINA«√O-----------
		
		if(categoria != null && !categoria.equals("")){
			categorias = Facada.buscarCategoriaPorNome(categoria);
		}
		else{
			categorias = Facada.listarCategoriasLimitados(pag);
		}
		//Ultimo Detalhe PaginaÁ„o-------------------------------------
				request.setAttribute("qtdePages", qtdePag);
				System.out.println("DETALHES -------------- PAGINA«√O------------------");
				System.out.println("request.setAttribute(\"qtdePages\", qtdePag); == "+qtdePag);
				System.out.println("qtde de indices? "+categorias.size());
				System.out.println("FIM----- -------------- PAGINA«√O------------------");
				//---------------------------------------------FIM DETALHES
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("pags/categorias/listarCategoria.jsp")
		.forward(request, response);
		
	}
		/*
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");	
		out.println("<body>");
		String mensagem = (String) request.getAttribute("msg");
		
		if(mensagem !=null && !mensagem.equals("")){
			
		}
		
		
		out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
		out.println("<h3 align='center' >Listar Categoria</h3>");
		///listarProdutoServlet.du
		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
		out.println("<form method='post' action='/SisEstoqueFarmacia/listarCategorias.du'>");
		
		out.println("<div align='center' class='pesquisa'>");
			out.println("<input type='text' name='filtro' value='"+(filtro != null && !filtro.equals("")? filtro : "")+"'>");
			out.println("<input type='submit' value='Pesquisar'>");
		out.println("</form><br />");
		out.println("</div>");
		
		//Todo link √© get. Ent√£o no servlet √© mister que se use o DoGet
		//out.println("<a href='/SisEstoqueFarmacia/telaCadastroCategoria.du'>Novo</a><br />");
		

		out.println("<table align='center' border='1' cellpadding='3'>");
			out.println("<tr cellpadding='5'><th>Codigo</th>");
			out.println("<th cellpadding='5'>Categoria</th>");
			out.println("<th cellpadding='5'>Acoes</th></tr>");
				
			for (Categoria categoria : categorias) {
			out.println("<tr>");
			out.println("<td align='center'>");
			out.println(categoria.getId());
			out.println("</td>");
			
			out.println("<td align='center'>");
			out.println(categoria.getNome());
			out.println("</td>");
			
			out.println("<td>");
			out.println("<a href='/SisEstoqueFarmacia/EditarCategoriaServlet.du?idCategoria="+categoria.getId()+"'>editar</a> <a href='/SisEstoqueFarmacia/removerCategoriaServlet.du?idCategoria="+categoria.getId()+"'>remover</a>");
			out.println("</td>");
			out.println("</tr>");
			
			}
			

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
	*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
