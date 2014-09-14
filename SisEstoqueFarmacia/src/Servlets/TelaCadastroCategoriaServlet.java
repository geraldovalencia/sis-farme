package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facada.Facada;
import cadastroClientes.Categoria;
import cadastroClientes.Unidade;

/**
 * Servlet implementation class TelaCadastroCategoriaServlet
 */
public class TelaCadastroCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar uma categoria diferente.</h5></div>";
		HttpSession session = request.getSession(false);
		
		String filtro = request.getParameter("filtro");
		String checaControlado = request.getParameter("checaControlado");
		//boolean checaControlado = Boolean.valueOf(request.getParameter("checaControlado")); 
	
		if(filtro != null && !filtro.equals("")){
			Categoria categoria = new Categoria();
			categoria.setNome(filtro);
			if (checaControlado != null){
				categoria.setControlado(true);
			} else {
				categoria.setControlado(false);
			}
			try {
				Facada.salvarCategoria(categoria);
				session.setAttribute("message", message);
				response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
			} catch(Exception e){
				System.out.println("Erro em salvar a categoria.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("telaCadastroCategoria.du");
			}
			return;
		}
		request.setAttribute("filtro", filtro);
		request.getRequestDispatcher("pags/categorias/novaCategoria.jsp").forward(request, response);
		
		
				
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");	
//		out.println("<body>");
//		out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
//		out.println("<h3 align='center' >Cadastrar Categoria</h3>");
//		
//		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//		out.println("<form method='get' action='/SisEstoqueFarmacia/telaCadastroCategoria.du'>");
//
//		out.println("Inserir Categoria: <input type='text' name='filtro' value='"+(filtro != null && !filtro.equals("")? filtro : "")+"'>");
//		out.println("<input type='submit' value='Inserir categoria'>");
//		out.println("</form><br />");
//		
//		out.println("</body>");
//		out.println("</html>");
		
		//No botão de salvar do servlet cria um objeto categoria, seta e no fim chama o metodo da fachada de salvar categoria
		
	}



}
