package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cadastroClientes.Compra;

public class CompraDAO extends AbstractDao<Compra>{

	public CompraDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Compra> entityClass() {
		// TODO Auto-generated method stub
		return Compra.class;
	}
	

}
