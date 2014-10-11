package Sevlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VotacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VotacaoServlet() {
        super();
            }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String votarGovernador = null;
		String votarPresidente = null;
		String votarTodos = null;
		
		String dilma = request.getParameter("dilma");
		String aecio = request.getParameter("aecio");
		String ricardo = request.getParameter("ricardo");
		String cassio = request.getParameter("cassio");
		String nuloGovernador = request.getParameter("nuloGovernador");
		String nuloPresidente = request.getParameter("nuloPresidente");

		if(ricardo != null || cassio != null || nuloGovernador != null){
			System.out.println("Cassio ou Ricardo não são nulos. Votou Governador.");
			votarGovernador = "ok";
			
		}
		if(dilma != null || aecio != null || nuloPresidente != null ){
			System.out.println("dilma ou aecio não são nulos. Votou Presidente.");
			votarPresidente = "okPresidente";
		}
		
		if(votarGovernador != null ){
			System.out.println("Setou na sessao Votar Governador.");
			request.getSession().setAttribute("votarGovernador", votarGovernador);
		}
		if(votarPresidente != null ){
			System.out.println("Setou na sessao Votar Presidente.");
			request.getSession().setAttribute("votarPresidente", votarPresidente);
		}
		
//		System.out.println(dilma);
//		
//		if(dilma != null && !dilma.equals("")){ 
//			
//			Cookie cookieVoto = new Cookie("myVotoDilma","Votou em Dilma");
//			response.addCookie(cookieVoto);
//			System.out.println("Setou");
//		}
//		
		if(votarPresidente != null){
			
			votarTodos = "votouTodos";
			request.getSession().setAttribute("votarTodos", votarTodos);
			
			Cookie cookieVoto = new Cookie("votouTotal","votou");
			response.addCookie(cookieVoto);
			System.out.println("Setou o cookie de voto total.");
			
			
			request.getRequestDispatcher("pag/votouTodos.jsp").forward(
					request, response);
			//Lembrar de setar os cookies para nao carregar votação apos a mesma
		}else{
			
			request.getSession().setAttribute("votarGovernador", votarGovernador);
			request.getSession().setAttribute("votarPresidente", votarPresidente);
			request.getRequestDispatcher("pag/votacao.jsp").forward(
					request, response);
		}
	}

}
