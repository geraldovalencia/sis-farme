package DAO;

import javax.persistence.EntityManager;

import cadastroClientes.Vendedor;

public class VendedorDAO extends AbstractDao<Vendedor> {

	public VendedorDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Vendedor> entityClass() {
		// TODO Auto-generated method stub
		return Vendedor.class;
	}

}
