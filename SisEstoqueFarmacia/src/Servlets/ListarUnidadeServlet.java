package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastroClientes.Unidade;
import Facada.Facada;


public class ListarUnidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarUnidadeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
				
				String filtro = request.getParameter("filtro");
				
				List<Unidade> unidades = null;
				
				
				//Recebendo Pagina do JSP------------------------------------------------------
				int qtdePag = Facada.getQtdePagUnidades(); //MUDAR PARA O TIPO DA CLASSE SERVLET NO FACADE
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
					unidades = Facada.buscarunidadePorNome(filtro);
				}
				else{
					unidades = Facada.listarUnidadesLimitados(pag);
				}
				
				//Ultimo Detalhe Paginação-------------------------------------
				request.setAttribute("qtdePages", qtdePag);
				System.out.println("DETALHES -------------- PAGINAÇÃO------------------");
				System.out.println("request.setAttribute(\"qtdePages\", qtdePag); == "+qtdePag);
				System.out.println("qtde de indices? "+unidades.size());
				System.out.println("FIM----- -------------- PAGINAÇÃO------------------");
				//---------------------------------------------FIM DETALHES
				request.setAttribute("unidades", unidades);
				request.getRequestDispatcher("pags/unidades/listarUnidades.jsp")
				.forward(request, response);
				
//				out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
//				out.println("<h3 align='center' >Listar Unidade</h3>");
//				///listarProdutoServlet.du
//				out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//				out.println("<form method='post' action='/SisEstoqueFarmacia/ListarUnidadeServlet.du'>");
//				
//				out.println("<div align='center' class='pesquisa'>");
//					out.println("<input type='text' name='filtro' value='"+(filtro != null && !filtro.equals("")? filtro : "")+"'>");
//					out.println("<input type='submit' value='Pesquisar'>");
//				out.println("</form><br />");
//				out.println("</div>");
//				
//				//Todo link Ã© get. EntÃ£o no servlet Ã© mister que se use o DoGet
//				//out.println("<a href='/SisEstoqueFarmacia/telaCadastroCategoria.du'>Novo</a><br />");
//				
//
//				out.println("<table align='center' border='1' cellpadding='3'>");
//					out.println("<tr cellpadding='5'><th>Codigo</th>");
//					out.println("<th cellpadding='5'>Unidades</th>");
//					out.println("<th cellpadding='5'>Acoes</th></tr>");
//						
//					for (Unidade unidade : unidades) {
//					out.println("<tr>");
//					out.println("<td align='center'>");
//					out.println(unidade.getId());
//					out.println("</td>");
//					
//					out.println("<td align='center'>");
//					out.println(unidade.getNome());
//					out.println("</td>");
//					
//					out.println("<td>");
//					out.println("<a href='/SisEstoqueFarmacia/EditarUnidadeServlet.du?idUnidade="+unidade.getId()+"'>editar</a> <a href='/SisEstoqueFarmacia/removerUnidadeServlet.du?idUnidade="+unidade.getId()+"'>remover</a>");
//					out.println("</td>");
//					
//					
//					out.println("</tr>");
//					
//					}
//
//				out.println("</table>");
//				out.println("</body>");
//				out.println("</html>");
				
			}
			
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
