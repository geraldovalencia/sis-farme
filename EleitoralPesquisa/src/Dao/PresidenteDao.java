package Dao;

import javax.persistence.EntityManager;

import Entidades.Presidente;

public class PresidenteDao extends GenericoDao<Presidente> {

	public PresidenteDao(EntityManager manager) {
		super(manager);
	}
	@Override
	public Class<Presidente> entityClass() {
		return Presidente.class;
	}

}
