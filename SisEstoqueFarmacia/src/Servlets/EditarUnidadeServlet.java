package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Unidade;

/**
 * Servlet implementation class EditarUnidadeServlet
 */
public class EditarUnidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarUnidadeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String idUnidade = request.getParameter("idUnidade");
		String filtro = request.getParameter("filtro");
		Unidade unidade = new Unidade();
		
		if (idUnidade != null && !idUnidade.equals("")) {
			unidade = Facada.buscarUnidadePorId((Long.parseLong(idUnidade)));
		}
	
		if(filtro != null && !filtro.equals("")){
			
			unidade.setNome(filtro);
			unidade.setId(Long.parseLong(idUnidade));
			Facada.alterarUnidade(unidade);
			request.setAttribute("msg", "Unidade alterada com sucesso");
			request.getRequestDispatcher("ListarUnidadeServlet.du").forward(request, response);
			
			return;
		}
		
		request.setAttribute("unidade", unidade);
		request.setAttribute("filtro", filtro);
		request.getRequestDispatcher("pags/unidades/editarUnidade.jsp").forward(request, response);
		
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");	
//		out.println("<body>");
//		out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
//		out.println("<h3 align='center' >Editar Unidade</h3>");
//		
//		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//		out.println("<form method='get' action='/SisEstoqueFarmacia/EditarUnidadeServlet.du'>");
//		
//		out.println("Id Unidade: <input type='text' name='idUnidade' value='"
//				+ (unidade != null ? unidade.getId() : null) + "'/>");
//		out.println("<br />");
//		
//		out.println("Nova Unidade: <input type='text' name='filtro' value='"
//				+ (unidade != null ? unidade.getNome() : null) + "'/>");
//		out.println("<br />");
//		
//		
////		out.println("Nova Unidade: <input type='text' name='filtro' value='"+(filtro != null && !filtro.equals("")? filtro : "")+"'>");
//		out.println("<input type='submit' value='Editar Unidade'>");
//		out.println("</form><br />");
//		
//		out.println("</body>");
//		out.println("</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
