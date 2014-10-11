package Sevlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaginaVoto
 */
public class PaginaVoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaginaVoto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Abriu a página votação. Pela primeira vez.");
		//response.sendRedirect("pag/votacao.jsp");
		HttpSession session = null;
		
		Cookie[] cookieVotos = request.getCookies();
		String val = null;
		if(cookieVotos != null){
			
			for (Cookie cookie : cookieVotos){
				if("votouTotal".equals(cookie.getName())){
					
					session = request.getSession(false);
					
					request.getRequestDispatcher("pag/votouTodos.jsp").forward(
							request, response);
				}
			}
		}else{
			
			session = request.getSession(true);
			
			String votarGovernador = null;
			String votarPresidente = null;
			
			request.getSession().setAttribute("votarGovernador", votarGovernador);
			request.getSession().setAttribute("votarPresidente", votarPresidente);
			
			response.sendRedirect("pag/votacao.jsp");
		}
	
	}

}
