package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

import Facada.Facada;
import cadastroClientes.Administrador;
import cadastroClientes.Farmaceutico;
import cadastroClientes.Gerente;
import cadastroClientes.Usuario;


public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlets() {
        super();
        // TODO Auto-generated constructor stub
    }
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Veio no Login");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println(login);
		
		if (login == null || login.equals("")||senha==null||senha.equals("") ){
			response.sendRedirect("login.html");
			return;// Pra sair da tela 
		}
		System.out.println("Verificou e Login não é Nulo ou Vazio! Usuário: ");
		try{
			Usuario usuarioLogado = Facada.logarUsuario(login,senha);
			System.out.println("-----------------------------------------------");
			System.out.println("Usuário: " + usuarioLogado.getNome().toString());
			if (usuarioLogado == null) {
				System.out.println("Tentou Verificar se o usuário do banco é nulo e redirecionou para Login");
				response.sendRedirect("login.html");
				return;
		}if (usuarioLogado != null){
			
			HttpSession session = request.getSession(true);
			request.getSession().setAttribute("usuarioLogado", usuarioLogado);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
			String dataAtual = sdf.format( new Date( System.currentTimeMillis() ) );
			
			System.out.println("Data: " + dataAtual);
			
			request.getSession().setAttribute("dataAtual", dataAtual);
			
			if(usuarioLogado instanceof Administrador){
				request.getSession().setAttribute("usuarioLogado", (Administrador)usuarioLogado);
			}else if (usuarioLogado instanceof Farmaceutico){
				request.getSession().setAttribute("usuarioLogado", (Farmaceutico)usuarioLogado);
			}else if (usuarioLogado instanceof Gerente){
				request.getSession().setAttribute("usuarioLogado", (Gerente)usuarioLogado);
			}
			
			response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
			System.out.println("Redirecionou para JSP e validou tipo de usuário");
		//	response.sendRedirect("/pags/produtos/listarProdutos.jsp");
		}
		}catch(Exception e){
			System.out.println("Considerou o Usuário Logado Nulo e jogou para Login");
			response.sendRedirect("login.html");
	}
}
}