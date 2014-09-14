package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cadastroClientes.Venda;
import Facada.Facada;

/**
 * Servlet implementation class removerProdutoVendaServlet
 */
public class removerProdutoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public removerProdutoVendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iditem = Integer.parseInt(request.getParameter("iditem"));
		
		String message = "<div style='width:20%; 'margin-top:-1%;' align='center' class='alert alert-warning'><h5>Produto removido da Venda.</h5></div><br>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente fazer a operação outra vez.</h5></div><br>";
		
		System.out.println("-----------------[Open - Remover Produto da Venda]-----------------");
		HttpSession session = request.getSession(false);
		
		if (iditem != 0){
			try{
				Venda vendaSessao = (Venda) session.getAttribute("venda");
				vendaSessao.removerItemPorID(iditem);
				session.setAttribute("venda", vendaSessao);
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("TelaCadastroVendaServlet.du");
			}catch(Exception e){
				System.out.println("Erro em remover produto da venda." + e.getMessage());
				session.setAttribute("message", message);
				response.sendRedirect("TelaCadastroVendaServlet.du");
			}
			return;
			
		}
		
		request.getRequestDispatcher("pags/venda/novaVenda.jsp")
		.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
