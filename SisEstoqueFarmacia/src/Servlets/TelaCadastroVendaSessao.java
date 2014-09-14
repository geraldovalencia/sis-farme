package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facada.Facada;
import cadastroClientes.PessoaFisica;
import cadastroClientes.Produto;

public class TelaCadastroVendaSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TelaCadastroVendaSessao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigoCliente =  request.getParameter("codigoCliente");
		String clienteNome =  request.getParameter("clienteNome");
		
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro na transação de sessão do cliente.</h5></div>";
		HttpSession session = request.getSession(false);
		
		
		PessoaFisica p;
		
		if( clienteNome != null && !clienteNome.equals("") && codigoCliente != null){
			p = Facada.buscarPessoaFisicaPorId(Long.parseLong(codigoCliente));
			session.setAttribute("cliente", p);
			response.sendRedirect("TelaCadastroVendaServlet.du");
		}else{
			System.out.println("Erro na transação de sessão do cliente");
			session.setAttribute("messageErro", messageErro);
			response.sendRedirect("TelaCadastroVendaServlet.du");			
		};
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
