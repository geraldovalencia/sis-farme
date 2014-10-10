package Dao;

import javax.persistence.EntityManager;

import Entidades.Unknow;

public class UknowDao extends GenericoDao<Unknow> {

	public UknowDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Unknow> entityClass() {
		return Unknow.class;
	}

}
