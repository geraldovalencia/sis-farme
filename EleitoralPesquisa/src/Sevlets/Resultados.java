package Sevlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resultados
 */
public class Resultados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resultados() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//QUando redireciona para este servilet a partir de um link, necessariamente o método
		//usado é o GET. LINK = GET
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Exemplo emergencial de remover Cookie
		
		//Quando descomentar este, COMENTAR O DISPACHER ABAIXO <------------
		
		
		/*
		Cookie[] cookieVotos = request.getCookies();
		if(cookieVotos != null){
			
			for (Cookie cookie : cookieVotos){
				if("votouTotal".equals(cookie.getName())){
					cookie.setValue(null);
					cookie.setMaxAge(0);
					//cookie.setPath(theSamePathAsYouUsedBeforeIfAny);
					response.addCookie(cookie);
					System.out.println("Apagou a merda do cookie");
					if(cookie.getValue() == null){
						String ckApagado = "Apagou o Cookie.";
						request.getSession().setAttribute("ckApagado", ckApagado);
						
						request.getRequestDispatcher("pag/resultados.jsp").forward(
								request, response);
					}else{
						request.getRequestDispatcher("index.html").forward(
								request, response);
					}
				}
			}
		}
		
		*/
		
		
	//	Dispachando para o JSP
	//OBS, quando descomentar o apagar cookie, COMENTAR ESTE <------
		
		
		request.getRequestDispatcher("pag/resultados.jsp").forward(
				request, response);
	}

}
