package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Categoria;

public class EditarCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditarCategoriaServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				
		String idCategoria = request.getParameter("idCategoria");
		String filtro = request.getParameter("filtro");
		String checaControlado = request.getParameter("checaControlado");
		Categoria categoria = new Categoria();
		
		if (idCategoria != null && !idCategoria.equals("")) {
			categoria = Facada.buscarCategoriaPorId((Long.parseLong(idCategoria)));
		}
	
		if(filtro != null && !filtro.equals("")){
			
			categoria.setNome(filtro);
			categoria.setId(Long.parseLong(idCategoria));
			if (checaControlado != null){
				categoria.setControlado(true);
			} else {
				categoria.setControlado(false);
			}
			Facada.alterarCategoria(categoria);
			request.setAttribute("msg", "Categoria cadastrada com sucesso");
			response.sendRedirect("/SisEstoqueFarmacia/listarCategorias.du");
			
			return;
		}
		request.setAttribute("categoria", categoria);
		request.setAttribute("filtro", filtro);
		request.getRequestDispatcher("pags/categorias/editarCategoria.jsp").forward(request, response);
		
				
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");	
//		out.println("<body>");
//		out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
//		out.println("<h3 align='center' >Editar Categoria</h3>");
//		///listarProdutoServlet.du
//		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//		out.println("<form method='get' action='/SisEstoqueFarmacia/EditarCategoriaServlet.du'>");
//
//		out.println("Id Categoria: <input type='text' name='idCategoria' value='"
//				+ (categoria != null ? categoria.getId() : null) + "'/>");
//		out.println("<br />");
//		
//		out.println("Nova categoria: <input type='text' name='filtro' value='"
//				+ (categoria != null ? categoria.getNome() : null) + "'/>");
//		out.println("<br />");
//		
//		//out.println("Inserir Categoria: <input type='text' name='filtro' value='"+(filtro != null && !filtro.equals("")? filtro : "")+"'>");
//		out.println("<input type='submit' value='Editar categoria'>");
//		out.println("</form><br />");
//		
//		out.println("</body>");
//		out.println("</html>");
		
		//No botão de salvar do servlet cria um objeto categoria, seta e no fim chama o metodo da fachada de salvar categoria
		
	}

			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
