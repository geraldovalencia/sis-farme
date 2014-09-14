package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facada.Facada;
import cadastroClientes.Gerente;
import cadastroClientes.Tipo;
import cadastroClientes.Usuario;
import cadastroClientes.Vendedor;

public class TelaCadastroVendedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TelaCadastroVendedor() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("abriu a tela de cadastro de Vendedor");
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar um vendedor diferente.</h5></div>";
		
		HttpSession session = request.getSession(false);

		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String setor = request.getParameter("setor");
		String matricula = request.getParameter("matricula");
		String cpf = request.getParameter("cpf");

		Vendedor user = new Vendedor();

		if (login != null && senha != null) {
			user.setLogin(login);
			user.setSenha(senha);
			user.setTipo(Tipo.VENDEDOR);
			user.setNome(nome);
			user.setSetorVendedor(setor);
			user.setMatricula(matricula);
			user.setCpf(cpf);
			
			try{
				Facada.salvarUsuario(user);
				session.setAttribute("message", message);
				response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
			}catch(Exception e){
				System.out.println("Erro em salvar o vendedor.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("TelaCadastroVendedor.du");
			}
			return;
		}

		List<Usuario> usuarios = Facada.listarTodosUsuarios();

		request.setAttribute("login", login);
		request.setAttribute("senha", senha);
		request.setAttribute("nome", nome);
		request.setAttribute("cpf", cpf);
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("pags/vendedor/novoVendedor.jsp").forward(
				request, response);
	}

}
