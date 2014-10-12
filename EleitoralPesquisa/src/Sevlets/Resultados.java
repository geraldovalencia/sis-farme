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
import Fachada.Fachada;

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
		
		//Listando todos os candidatos................
		List<Candidato> candidatos = new ArrayList<Candidato>();
		candidatos = Fachada.listarTodosCandidatos();
		
		//GOVERNADORES ---------------------------------------------------.
		
		int votosRicardo = 0;
		int votosCassio = 0;
		int votosNuloGov = 0;
		
		//PRESIDENTES ---------------------------------------------------.
		
		int votosAecio = 0;
		int votosDilma = 0;
		int votosNuloPres = 0;
		
		for (Candidato candidato : candidatos) {
			
			if(candidato.getId() == 39){//Ricardo
				votosRicardo = candidato.getVotos();
				System.out.println("Votos atuais de Ricardo: " + votosRicardo);
				request.getSession().setAttribute("votosRicardo", votosRicardo);
			}
			if(candidato.getId() == 36){//Cassio
				votosCassio = candidato.getVotos();
				System.out.println("Votos atuais de Cassio: " + votosCassio);
				request.getSession().setAttribute("votosCassio", votosCassio);
			}
			if(candidato.getId() == 46){//NULOGovernador
				votosNuloGov = candidato.getVotos();
				System.out.println("Votos atuais de votosNuloGov: " + votosNuloGov);
				request.getSession().setAttribute("votosNuloGov", votosNuloGov);
			}
			if(candidato.getId() == 42){//AECIO
				votosAecio = candidato.getVotos();
				System.out.println("Votos atuais de Aecio: " + votosAecio);
				request.getSession().setAttribute("votosAecio", votosAecio);
			}
			if(candidato.getId() == 41){//Dilma
				votosDilma = candidato.getVotos();
				System.out.println("Votos atuais de Dilma: " + votosDilma);
				request.getSession().setAttribute("votosDilma", votosDilma);
			}
			if(candidato.getId() == 40){//votosNuloPres
				votosNuloPres = candidato.getVotos();
				System.out.println("Votos atuais de votosNuloPres: " + votosNuloPres);
				request.getSession().setAttribute("votosNuloPres", votosNuloPres);
			}
	}
		
		
//		Dispachando para o JSP
		//OBS, quando descomentar o apagar cookie, COMENTAR ESTE <------
		request.getRequestDispatcher("pag/resultados.jsp").forward(
				request, response);
	}

}
