package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cadastroClientes.Movimento;
import cadastroClientes.Produto;



public class ProdutoDAO extends AbstractDao<Produto>{

	public ProdutoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Produto> entityClass() {
		return Produto.class;
	}
		
	

}
