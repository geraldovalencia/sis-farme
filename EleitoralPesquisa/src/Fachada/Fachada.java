package Fachada;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dao.CandidatoDao;
import Entidades.Candidato;
import Entidades.DesconhecidoGovernador;
import Entidades.DesconhecidoSenador;
import Entidades.Governador;
import Entidades.Presidente;
import Entidades.Senador;
import Entidades.Unknow;

public class Fachada {
	
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("eleitoral");
	
	/*---------------------------------------------------------------------------------------- *
	 * 										| CANDIDATO |									   *		
	 *-----------------------------------------------------------------------------------------*/
	
	public static void cadastrarCandidato(Candidato c){
		
		EntityManager manager = factory.createEntityManager();		
		CandidatoDao cDao = new CandidatoDao(manager);
		manager.getTransaction().begin();
		
		if(c instanceof Presidente){
			System.out.println("Candidato = Presidente");
			cDao.salvar((Presidente)c);	
		}else if(c instanceof Governador){
			System.out.println("Candidato = Governador");
			cDao.salvar((Governador)c);
		}else if(c instanceof Senador){
			System.out.println("Candidato = Senador: " + c.getNome());
			cDao.salvar((Senador)c);
		}else if(c instanceof Unknow){
			System.out.println("Candidato = Desconhecido: " + c.getNome());
			cDao.salvar((Unknow)c);
		}else if(c instanceof DesconhecidoGovernador){
			System.out.println("Candidato = DesconhecidoGov: " + c.getNome());
			cDao.salvar((DesconhecidoGovernador)c);
		}else if(c instanceof DesconhecidoSenador){
			System.out.println("Candidato = DesconhecidoSen: " + c.getNome());
			cDao.salvar((DesconhecidoSenador)c);
		}
		
		manager.getTransaction().commit();
		manager.close();
	
	}
public static void alterarCandidato(Candidato c){
		
		EntityManager manager = factory.createEntityManager();		
		CandidatoDao cDao = new CandidatoDao(manager);
		manager.getTransaction().begin();
		
		if(c instanceof Presidente){
			System.out.println("Candidato = Presidente");
			cDao.alterar((Presidente)c);	
		}else if(c instanceof Governador){
			System.out.println("Candidato = Governador");
			cDao.alterar((Governador)c);
		}else if(c instanceof Senador){
			System.out.println("Candidato = Senador: " + c.getNome());
			cDao.alterar((Senador)c);
		}else if(c instanceof Unknow){
			System.out.println("Candidato = Desconhecido: " + c.getNome());
			cDao.alterar((Unknow)c);
		}else if(c instanceof DesconhecidoGovernador){
			System.out.println("Candidato = DesconhecidoGov: " + c.getNome());
			cDao.alterar((DesconhecidoGovernador)c);
		}else if(c instanceof DesconhecidoSenador){
			System.out.println("Candidato = DesconhecidoSen: " + c.getNome());
			cDao.alterar((DesconhecidoSenador)c);
		}
		
		manager.getTransaction().commit();
		manager.close();
	
	}

}
