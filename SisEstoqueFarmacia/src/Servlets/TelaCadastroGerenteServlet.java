package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Gerente;
import cadastroClientes.Tipo;
import cadastroClientes.Usuario;

/**
 * Servlet implementation class TelaCadastroGerenteServlet
 */
public class TelaCadastroGerenteServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

	    public TelaCadastroGerenteServlet() {
	        super();
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			System.out.println("abriu a tela de cadastro de Gerente");
			
			String login = request.getParameter("login");
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			String setor = request.getParameter("setor");
			String matricula = request.getParameter("matricula");
			String cpf = request.getParameter("cpf");
			
			Gerente user = new Gerente();
			
			if (login != null && senha != null) {
				user.setLogin(login);
				user.setSenha(senha);
				user.setTipo(Tipo.GERENTE);
				user.setNome(nome);
				user.setSetor(setor);
				user.setMatricula(matricula);
				user.getSetor();
				user.setCpf(cpf);
				Facada.salvarUsuario(user);
				response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
				return;
			}
			
			List<Usuario> usuarios = Facada.listarTodosUsuarios();

			request.setAttribute("login", login);
			request.setAttribute("senha", senha);
			request.setAttribute("nome", nome);
			request.setAttribute("cpf", cpf);
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("pags/gerente/novoGerente.jsp").forward(
					request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	}
