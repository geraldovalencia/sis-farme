package DAO;

import javax.persistence.EntityManager;

import cadastroClientes.Unidade;

public class UnidadeDAO extends AbstractDao<Unidade>{

	public UnidadeDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Unidade> entityClass() {
		return Unidade.class;
	}

}
