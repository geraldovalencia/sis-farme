package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cadastroClientes.Administrador;
import cadastroClientes.Tipo;
import cadastroClientes.Usuario;
import Facada.Facada;

public class TelaCadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TelaCadastroUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar um usuário diferente.</h5></div>";
		
		System.out.println("abriu a tela de cadastro de Administrador");
		
		HttpSession session = request.getSession(false);
		
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String empresaTerceirizada = request.getParameter("empresaTerceirizada");
		String matricula = request.getParameter("matricula");
		String cpf = request.getParameter("cpf");
		
		Administrador user = new Administrador();
		
		if (login != null && senha != null) {
			user.setLogin(login);
			user.setSenha(senha);
			user.setTipo(Tipo.ADMINISTRADOR);
			user.setNome(nome);
			user.setMatricula(matricula);
			user.setCpf(cpf);
			user.setEmpresaTerceirizada(empresaTerceirizada);
			try{
				Facada.salvarUsuario(user);
				session.setAttribute("message", message);
				response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
			}catch(Exception e){
				System.out.println("Erro em salvar o Usuário.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("TelaCadastroUsuario.du");
			}
			return;
			
		}
		
		List<Usuario> usuarios = Facada.listarTodosUsuarios();

		request.setAttribute("login", login);
		request.setAttribute("senha", senha);
		request.setAttribute("nome", nome);
		request.setAttribute("cpf", cpf);
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("pags/usuario/novoUsuario.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
