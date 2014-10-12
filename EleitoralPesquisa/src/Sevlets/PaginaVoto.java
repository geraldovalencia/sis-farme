package Sevlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class PaginaVoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaginaVoto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("------------------------------------------");
		System.out.println("Abriu a página votação. Pela primeira vez.");
		//response.sendRedirect("pag/votacao.jsp");
		HttpSession session = null;
		
		Cookie[] cookieVotos = request.getCookies();
		String val = null;
					
		//Se existir o COOKIE, redireciona, pois a pessoa já votou.
		//Comentar este if, caso queira desabilitar os cookies.<-------------
		
		if(cookieVotos != null){
			System.out.println("Entrou no IF cookie != nulo");	
			for (Cookie cookie : cookieVotos){
				System.out.println("Entrou no Foeach de Cookies.");
				if("votouCompleto".equals(cookie.getName())){
					
					session = request.getSession(false);
					System.out.println("Entrou no IF do foreach do coockie e chamou votouTodos.JSP");
					request.getRequestDispatcher("pag/votouTodos.jsp").forward(
							request, response);
					return;
				}
			}
		}
		
		
			System.out.println("Já que o cookie nao existe, chama votacao.JSP");
			session = request.getSession(true);
			
			String votarGovernador = null;
			String votarPresidente = null;
			
			request.getSession().setAttribute("votarGovernador", votarGovernador);
			request.getSession().setAttribute("votarPresidente", votarPresidente);
			
			response.sendRedirect("pag/votacao.jsp");
	
	}

}
