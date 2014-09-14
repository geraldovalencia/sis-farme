package DAO;

import javax.persistence.EntityManager;

import cadastroClientes.Gerente;

public class GerenteDAO extends AbstractDao<Gerente>{

	public GerenteDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Gerente> entityClass() {
		// TODO Auto-generated method stub
		return Gerente.class;
	}

}
