package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facada.Facada;
import cadastroClientes.Compra;
import cadastroClientes.Venda;

public class SalvarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalvarCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Pedido (COMPRA) realizada com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente fazer a operação outra vez.</h5></div>";
		String apagarClienteSessao = "<c:remove var='fornecedor' scope='session' />";
		
		
		System.out.println("-----------------[Open - Salvar COMPRA]-----------------");
		HttpSession session = request.getSession(false);
		
		String total = request.getParameter("total");
		
		Compra compra = (Compra) request.getSession().getAttribute("compra");
		
		compra.setTotal(new Float(total));
		
		try{
			Facada.efetuarCompra(compra);
			session.setAttribute("message", message);
			session.setAttribute("apagarClienteSessao", apagarClienteSessao);
			
			session.removeAttribute("compra");
			response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
		}catch(Exception e){
			System.out.println("Erro em salvar a compra." + e.getMessage());
			session.setAttribute("messageErro", messageErro);
			response.sendRedirect("TelaCadastroCompraServlet.du");
			session.setAttribute("apagarClienteSessao", apagarClienteSessao);
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
