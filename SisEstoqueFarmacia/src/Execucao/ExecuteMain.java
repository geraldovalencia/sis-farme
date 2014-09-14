package Execucao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.ItemMovimentoDAO;
import DAO.MovimentoDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import Facada.Facada;

import cadastroClientes.Compra;
import cadastroClientes.ItemMovimento;
import cadastroClientes.Movimento;
import cadastroClientes.Produto;
import cadastroClientes.Usuario;

public class ExecuteMain {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("farmacia");
		EntityManager manager = factory.createEntityManager();
		
		Compra compra = new Compra();
		
		
		Produto carro = new Produto(1l);
		Produto bola = new Produto(2l);
		
		
		
		ItemMovimento itm1 = new ItemMovimento();
		ItemMovimento itm2 = new ItemMovimento();
		itm1.setProduto(carro);
		itm2.setProduto(bola);
		itm1.setPreco(3.5);
		itm2.setPreco(4.5);
		compra.setUsuario(new Usuario());
		
		compra.setItemMovimentos(new ArrayList<ItemMovimento>());
		compra.getItemMovimentos().add(itm1);
		compra.getItemMovimentos().add(itm2);
		Facada.efetuarCompra(compra);
		
		MovimentoDAO mdao = new MovimentoDAO(manager);
		ItemMovimentoDAO itmDao = new ItemMovimentoDAO(manager);
		mdao.ListarTodosMovimentos(compra);
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String[] args) {
		 
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("farmacia");
	EntityManager manager = factory.createEntityManager();
		Usuario u = new Usuario();
		u.setLogin("robson");
		u.setMatricula(124L);
		u.setNome("Robson Safadao");
		u.setSenha("123");
		
		UsuarioDAO udao = new UsuarioDAO(manager);
		manager.persist(u);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		factory.close();
		
	
		
	}*/

}
