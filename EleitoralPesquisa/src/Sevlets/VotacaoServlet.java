package Sevlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Candidato;
import Entidades.DesconhecidoGovernador;
import Entidades.Governador;
import Entidades.Presidente;
import Entidades.Unknow;
import Fachada.Fachada;

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
		
		List<Candidato> candidatos = new ArrayList<Candidato>(); //Armazenará todos os candidatos do Banco.
		
		int votos = 0;

		if(ricardo != null || cassio != null || nuloGovernador != null){
			System.out.println("Cassio ou Ricardo não são nulos. Votou Governador.");
			votarGovernador = "ok";
			
			if(ricardo != null){
				
				System.out.println("Votou no Governador Ricardo.");
				
				Governador govRicardo = new Governador();
				candidatos = Fachada.listarTodosCandidatos();
				
				int votosAtualGovernador = 0;
				votos = 1;
				for (Candidato candidato : candidatos) {
						
						if(candidato.getId() == 39){
							votosAtualGovernador = candidato.getVotos();
							votosAtualGovernador += votos;
							System.out.println("Votos atuais de Ricardo: " + votosAtualGovernador);
							
							govRicardo = Fachada.buscarGovernadorPorId(39l);
							govRicardo.setVotos(votosAtualGovernador);
							Fachada.alterarCandidato(govRicardo);
						}
				}
				
				System.out.println("Cadastrou: ");
				System.out.println(govRicardo.getNome());
				System.out.println(govRicardo.getVotos());
			}
			
			//No caso de Votarem em CASSIO, abre esse IF.
			
			if(cassio != null){
				
				System.out.println("Votou no Governador Cassio.");
				
				Governador govCassio = new Governador();
				candidatos = Fachada.listarTodosCandidatos();
				
				int votosAtualGovernador = 0;
				votos = 1;
				for (Candidato candidato : candidatos) {
						
						if(candidato.getId() == 36){
							votosAtualGovernador = candidato.getVotos();
							votosAtualGovernador += votos;
							System.out.println("Votos atuais de Cassio: " + votosAtualGovernador);
							
							govCassio = Fachada.buscarGovernadorPorId(36l);
							govCassio.setVotos(votosAtualGovernador);
							Fachada.alterarCandidato(govCassio);
						}
				}
				
				System.out.println("Cadastrou: ");
				System.out.println(govCassio.getNome());
				System.out.println(govCassio.getVotos());
			}
			
			//No Caso de votar Nulo para Governador
			
			if(nuloGovernador != null){
				
				System.out.println("Votou no Governador NULO.");
				
				//Lembrando que não é do tipo governador e sim do DesconhecidoGovernador
				DesconhecidoGovernador govNulo = new DesconhecidoGovernador();
				candidatos = Fachada.listarTodosCandidatos();
				
				int votosAtualGovernador = 0;
				votos = 1;
				for (Candidato candidato : candidatos) {
						
						if(candidato.getId() == 46){
							votosAtualGovernador = candidato.getVotos();
							votosAtualGovernador += votos;
							System.out.println("Votos atuais de NULO Governador: " + votosAtualGovernador);
							
							govNulo = Fachada.buscarDesconhecidoGovernadorPorId(46l);
							govNulo.setVotos(votosAtualGovernador);
							Fachada.alterarCandidato(govNulo);
						}
				}
				
				System.out.println("Cadastrou: ");
				System.out.println(govNulo.getNome());
				System.out.println(govNulo.getVotos());
			}
			
		}
		if(dilma != null || aecio != null || nuloPresidente != null ){
			System.out.println("dilma ou aecio não são nulos. Votou Presidente.");
			votarPresidente = "okPresidente";
			
			//Se votar em Dilma abre esse:
			
			if(dilma != null){
				
				System.out.println("Votou no Governador Cassio.");
				
				Presidente presDilma = new Presidente();
				candidatos = Fachada.listarTodosCandidatos();
				
				int votosAtualGovernador = 0;
				votos = 1;
				for (Candidato candidato : candidatos) {
						
						if(candidato.getId() == 41){
							votosAtualGovernador = candidato.getVotos();
							votosAtualGovernador += votos;
							System.out.println("Votos atuais de Dilma: " + votosAtualGovernador);
							
							presDilma = Fachada.buscarPresidentePorId(41l);
							presDilma.setVotos(votosAtualGovernador);
							Fachada.alterarCandidato(presDilma);
						}
				}
				
				System.out.println("Cadastrou: ");
				System.out.println(presDilma.getNome());
				System.out.println(presDilma.getVotos());
			}
			
			if(aecio != null){
				
				System.out.println("Votou no Governador Cassio.");
				
				Presidente presAecio = new Presidente();
				candidatos = Fachada.listarTodosCandidatos();
				
				int votosAtualGovernador = 0;
				votos = 1;
				for (Candidato candidato : candidatos) {
						
						if(candidato.getId() == 42){
							votosAtualGovernador = candidato.getVotos();
							votosAtualGovernador += votos;
							System.out.println("Votos atuais de Dilma: " + votosAtualGovernador);
							
							presAecio = Fachada.buscarPresidentePorId(42l);
							presAecio.setVotos(votosAtualGovernador);
							Fachada.alterarCandidato(presAecio);
						}
				}
				
				System.out.println("Cadastrou: ");
				System.out.println(presAecio.getNome());
				System.out.println(presAecio.getVotos());
			}
			
			//Presidente NULO <-----------
			
			if(nuloPresidente != null){
				
				System.out.println("Votou no Governador NULO.");
				
				//Lembrando que não é do tipo governador e sim do DesconhecidoGovernador
				Unknow presNulo = new Unknow();
				candidatos = Fachada.listarTodosCandidatos();
				
				int votosAtualGovernador = 0;
				votos = 1;
				for (Candidato candidato : candidatos) {
						
						if(candidato.getId() == 40){
							votosAtualGovernador = candidato.getVotos();
							votosAtualGovernador += votos;
							System.out.println("Votos atuais de NULO Presidente: " + votosAtualGovernador);
							
							presNulo = Fachada.buscarUnknowPresidentePorId(40l);
							presNulo.setVotos(votosAtualGovernador);
							Fachada.alterarCandidato(presNulo);
						}
				}
				
				System.out.println("Cadastrou: ");
				System.out.println(presNulo.getNome());
				System.out.println(presNulo.getVotos());
			}
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
