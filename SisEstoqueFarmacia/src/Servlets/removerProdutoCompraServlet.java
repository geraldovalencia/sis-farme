package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cadastroClientes.Compra;

/**
 * Servlet implementation class removerProdutoCompraServlet
 */
public class removerProdutoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removerProdutoCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int iditem = Integer.parseInt(request.getParameter("iditem"));
		
		String message = "<div style='width:20%; 'margin-top:-1%;' align='center' class='alert alert-warning'><h5>Produto removido da Compra.</h5></div><br>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente fazer a operação outra vez.</h5></div><br>";
		
		System.out.println("-----------------[Open - Remover Produto da Venda]-----------------");
		HttpSession session = request.getSession(false);
		
		if (iditem != 0){
			try{
				Compra vendaSessao = (Compra) session.getAttribute("compra");
				vendaSessao.removerItemPorID(iditem);
				session.setAttribute("compra", vendaSessao);
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("TelaCadastroCompraServlet.du");
			}catch(Exception e){
				System.out.println("Erro em remover produto da Compra." + e.getMessage());
				session.setAttribute("message", message);
				response.sendRedirect("TelaCadastroCompraServlet.du");
			}
			return;
			
		}
		
		request.getRequestDispatcher("pags/compra/novaCompra.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
