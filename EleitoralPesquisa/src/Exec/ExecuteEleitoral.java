package Exec;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dao.PresidenteDao;
import Entidades.DesconhecidoGovernador;
import Entidades.DesconhecidoSenador;
import Entidades.Governador;
import Entidades.Presidente;
import Entidades.Senador;
import Entidades.Unknow;
import Fachada.Fachada;

public class ExecuteEleitoral {

	public static void main(String[] args) {
	
		EntityManagerFactory fctory = Persistence.createEntityManagerFactory("eleitoral");
		EntityManager manager = fctory.createEntityManager();
		
		String semPartido = "Sem Partido";
		
		Fachada f = new Fachada();
//		Senador jose, lucelio, wilson, walter;
//		
//		
//		jose = new Senador();
//		jose.setNome("José Maranhão");
//		jose.setNumero("155");
//		jose.setPartido("PMDB");
//		jose.setColigacao("Renovação de Verdade");
//		jose.setVotos(0);
//		
//		lucelio = new Senador();
//		lucelio.setNome("Lucélio Cartaxo");
//		lucelio.setNumero("133");
//		lucelio.setPartido("PT");
//		lucelio.setColigacao("A Força do trabalho");
//		lucelio.setVotos(0);
//		
//		walter = new Senador();
//		walter.setNome("Walter Brito");
//		walter.setNumero("360");
//		walter.setPartido("PTC");
//		walter.setColigacao("PTC");
//		walter.setVotos(0);
//		
//		wilson = new Senador();
//		wilson.setNome("Wilson Santiago");
//		wilson.setNumero("145");
//		wilson.setPartido("PTB");
//		wilson.setColigacao("A vontade do Povo");
//		wilson.setVotos(0);
//		
//		f.cadastrarCandidato(lucelio);
//		f.cadastrarCandidato(walter);
//		f.cadastrarCandidato(wilson);
//		f.cadastrarCandidato(jose);
//		
//		
//// ---------------------------|   CADASTRO DE GOVERNADORES   |-------------------
//		
//		Governador ricardo, vital, major, cassio;
//		
//		ricardo = new Governador();
//		ricardo.setNome("Ricardo Coutinho");
//		ricardo.setNumero("40");
//		ricardo.setColigacao("A Força do trabalho");
//		ricardo.setPartido("PSB");
//		ricardo.setVotos(0);
//		
//		vital = new Governador();
//		vital.setNome("Vital do Rêgo Filho");
//		vital.setNumero("15");
//		vital.setColigacao("Renovação de Verdade");
//		vital.setPartido("PMDB");
//		vital.setVotos(0);
//		
//		major = new Governador();
//		major.setNome("fbio Rodrigues de Oliveira");
//		major.setNumero("90");
//		major.setColigacao("PROS");
//		major.setPartido("PROS");
//		major.setVotos(0);
//		
//		cassio = new Governador();
//		cassio.setNome("Cassio Rodrigues da Cunha Lima");
//		cassio.setNumero("45");
//		cassio.setColigacao("A vontade do povo");
//		cassio.setPartido("PSDB");
//		cassio.setVotos(0);
//
//		f.cadastrarCandidato(cassio);
//		f.cadastrarCandidato(major);
//		f.cadastrarCandidato(vital);
//		f.cadastrarCandidato(ricardo);
//		
////---------------------------|   CADASTRO DE PRESIDENTES   |-------------------
//		
//		Presidente dilma, marina, aecio, pastor;
//		
//		dilma = new Presidente();
//		dilma.setNome("Dilma Rousseff");
//		dilma.setColigacao("Com a Força do Povo");
//		dilma.setPartido("PT");
//		dilma.setNumero("13");
//		dilma.setVotos(0);
//		
//		
//		marina = new Presidente();
//		marina.setNome("Marina Silva");
//		marina.setColigacao("Unidos pelo Brasil");
//		marina.setPartido("PSB");
//		marina.setNumero("40");
//		
//		aecio = new Presidente();
//		aecio.setNome("Aécio Neves");
//		aecio.setColigacao("Muda Brasil");
//		aecio.setPartido("PSDB");
//		aecio.setNumero("45");
//		
//		pastor = new Presidente();
//		pastor.setNome("Pastor Everaldo");
//		pastor.setColigacao("PSC");
//		pastor.setPartido("PSC");
//		pastor.setNumero("20");
//		
//		Unknow un = new Unknow();
//		un.setNome("Desconhecido");
//		un.setPartido("Sem partido");
//		un.setVotos(0);
//		
//		marina.setVotos(0);
//		pastor.setVotos(0);
//		aecio.setVotos(0);
//		
//		f.cadastrarCandidato(un);
//		f.cadastrarCandidato(dilma);
//		f.cadastrarCandidato(aecio);
//		f.cadastrarCandidato(pastor);
//		f.cadastrarCandidato(marina);
		
//		DesconhecidoGovernador dg = new DesconhecidoGovernador();
//		dg.setNome("DesconhecidoGovernador");
//		dg.setPartido(semPartido);
//		dg.setVotos(0);
//		
//		DesconhecidoSenador ds = new DesconhecidoSenador();
//		ds.setNome("DesconhecidoSenador");
//		ds.setPartido(semPartido);
//		ds.setVotos(0);
//		
//		f.cadastrarCandidato(ds);
//		f.cadastrarCandidato(dg);
//		System.out.println("rodou");
		
	}
}
