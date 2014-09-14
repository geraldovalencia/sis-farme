package Servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cadastroClientes.Movimento;
import cadastroClientes.Pessoa;
import cadastroClientes.PessoaFisica;
import cadastroClientes.Produto;
import cadastroClientes.Usuario;
import cadastroClientes.Venda;
import Facada.Facada;

public class SalvarVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalvarVendaServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Venda realizada com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente fazer a operação outra vez.</h5></div>";
		String apagarClienteSessao = "<c:remove var='cliente' scope='session' />";
		
		
		System.out.println("-----------------[Open - Salvar Venda]-----------------");
		HttpSession session = request.getSession(false);
		
		String total = request.getParameter("total");
		
		Venda venda = (Venda) request.getSession().getAttribute("venda");
		
		venda.setTotal(new Float(total));
		
		try{
			Facada.efetuarVenda(venda);
			session.setAttribute("message", message);
			session.setAttribute("apagarClienteSessao", apagarClienteSessao);
			
			session.removeAttribute("venda");
			response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
		}catch(Exception e){
			System.out.println("Erro em salvar a venda." + e.getMessage());
			session.setAttribute("messageErro", messageErro);
			response.sendRedirect("TelaCadastroVendaServlet.du");
			session.setAttribute("apagarClienteSessao", apagarClienteSessao);
		}
		return;
	}

}
