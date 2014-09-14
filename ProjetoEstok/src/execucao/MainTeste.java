package execucao;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainTeste {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisEstok");
		EntityManager manager = factory.createEntityManager();
		
//		Produto carro = new Produto(0, "gol", "O melhor carro do Brasil", null, "Wolksvagem", 40, 40.000);
//		
//		ProdutoDAO pdao = new ProdutoDAO(manager);
//		manager.persist(carro);
//		manager.getTransaction().begin();
//		manager.getTransaction().commit();
//		factory.close();
		
//----------------------[Telas de Venda]-------------------------------------------
		
		Fachada.iniciarOpcoes("Digite uma opção: ");	//Inicia a tela de Opções
		Fachada.MenuPrincipal();   //Abre o Menu Principal
			
			

	}
}