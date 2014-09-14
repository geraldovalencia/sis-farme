package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facada.Facada;
import cadastroClientes.Administrador;
import cadastroClientes.Farmaceutico;
import cadastroClientes.Tipo;
import cadastroClientes.Usuario;

/**
 * Servlet implementation class TelaCadastroFarmaceuticoServlet
 */
public class TelaCadastroFarmaceuticoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelaCadastroFarmaceuticoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar um vendedor diferente.</h5></div>";
		
		HttpSession session = request.getSession(false);
		
		System.out.println("abriu a tela de cadastro de Farmaceutico");
		
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String crf = request.getParameter("crf");
		String titulacao = request.getParameter("titulacao");
		String matricula = request.getParameter("matricula");
		String cpf = request.getParameter("cpf");
		
		Farmaceutico user = new Farmaceutico();
		
		if (login != null && senha != null) {
			System.out.println("Fez os testes para a persistencia.");
			user.setLogin(login);
			user.setSenha(senha);
			user.setCrf(crf);
			user.setMatricula(matricula);
			user.setTitulacao(titulacao);
			user.setTipo(Tipo.FARMACEUTICO);
			user.setNome(nome);
			user.setCpf(cpf);
			try{
				Facada.salvarUsuario(user);
				session.setAttribute("message", message);
				response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
			}catch(Exception e){
				System.out.println("Erro em salvar o Farmaceutico.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("TelaCadastroFarmaceutico.du");
			}
			return;
		}
		
		List<Usuario> usuarios = Facada.listarTodosUsuarios();

		request.setAttribute("login", login);
		request.setAttribute("senha", senha);
		request.setAttribute("nome", nome);
		request.setAttribute("crf", crf);
		request.setAttribute("cpf", cpf);
		request.setAttribute("titulacao", titulacao);
		request.getRequestDispatcher("pags/farmaceutico/novoFarmaceutico.jsp").forward(
				request, response);
	}

}
