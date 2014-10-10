package Dao;

import javax.persistence.EntityManager;

import Entidades.Governador;

public class GovernadorDao extends GenericoDao<Governador> {
	
	//Se não extender Governador de Candidato ele nao considera a entidade p o genericoDao

	public GovernadorDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Governador> entityClass() {
		return Governador.class;
	}

}
