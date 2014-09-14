package DAO;

import javax.persistence.EntityManager;

import cadastroClientes.Farmaceutico;

public class FarmaceuticoDAO extends AbstractDao<Farmaceutico>{

	public FarmaceuticoDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Farmaceutico> entityClass() {
		// TODO Auto-generated method stub
		return Farmaceutico.class;
	}

}
