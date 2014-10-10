package Dao;

import javax.persistence.EntityManager;

import Entidades.Senador;

public class SenadorDao extends GenericoDao<Senador>{
	
	public SenadorDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Senador> entityClass() {
		return Senador.class;
	}
	
	

}
