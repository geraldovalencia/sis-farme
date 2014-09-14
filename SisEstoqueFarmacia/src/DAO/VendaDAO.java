package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cadastroClientes.Venda;

public class VendaDAO extends AbstractDao<Venda>{

	
	public VendaDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Venda> entityClass() {
		// TODO Auto-generated method stub
		return Venda.class;
	}
	public ArrayList<Venda> listarTodasVendasComControlado(){
//		Query query = manager.createQuery("SELECT v, i.produto FROM Venda v, ItemMovimento i LEFT OUTER JOIN v.produto p");
		Query query = manager.createQuery("SELECT v FROM Venda v JOIN v.itemMovimentos itemMovimento WHERE itemMovimento.produto.categoria.controlado = TRUE");
//		venda
//		itemmovimento
//		produto
//		categoria
//		  controlado
//		
		return (ArrayList<Venda>) query.getResultList();
	}
}
