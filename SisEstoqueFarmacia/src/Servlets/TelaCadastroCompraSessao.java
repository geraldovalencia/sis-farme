package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facada.Facada;
import cadastroClientes.PessoaFisica;
import cadastroClientes.PessoaJuridica;

public class TelaCadastroCompraSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TelaCadastroCompraSessao() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigoFornecedor =  request.getParameter("codigofornecedor");
		String fornecedorNome =  request.getParameter("fornecedorNome");
		
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro na transação de sessão do cliente.</h5></div>";
		HttpSession session = request.getSession(false);
		
		
		PessoaJuridica pj;
		
		if( fornecedorNome != null && !fornecedorNome.equals("") && codigoFornecedor != null){
			pj = Facada.buscarPessoaJuridicaPorId(Long.parseLong(codigoFornecedor));
			session.setAttribute("fornecedor", pj);
			response.sendRedirect("TelaCadastroCompraServlet.du");
		}else{
			System.out.println("Erro na transação de sessão do Fornecedor");
			session.setAttribute("messageErro", messageErro);
			response.sendRedirect("TelaCadastroCompraServlet.du");			
		};
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
