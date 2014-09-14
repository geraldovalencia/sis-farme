package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facada.Facada;
import cadastroClientes.Categoria;
import cadastroClientes.Unidade;


public class TelaCadastroUnidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TelaCadastroUnidadeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar um unidade diferente.</h5></div>";
		HttpSession session = request.getSession(false);
		
		
		String filtro = request.getParameter("filtro");
		Unidade unidade = new Unidade();
		
		if(filtro != null && !filtro.equals("")){
			
			unidade.setNome(filtro);
			try {
				Facada.salvarUnidades(unidade);
				session.setAttribute("message", message);
				response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
			}catch(Exception e){
				System.out.println("Erro em salvar a Unidade.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("TelaCadastroUnidadeServlet.du");
			}
			
			return;
		}
		request.setAttribute("filtro", filtro);
		request.getRequestDispatcher("pags/unidades/novaUnidade.jsp").forward(request, response);
		
//				
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");	
//		out.println("<body>");
//		out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
//		out.println("<h3 align='center' >Cadastrar Unidade</h3>");
//		
//		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//		out.println("<form method='get' action='/SisEstoqueFarmacia/TelaCadastroUnidadeServlet.du'>");
//			
//		out.println("Nova Unidade: <input type='text' name='filtro' value='"+(filtro != null && !filtro.equals("")? filtro : "")+"'>");
//		out.println("<input type='submit' value='Inserir Unidade'>");
//		out.println("</form><br />");
//		
//		out.println("</body>");
//		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
