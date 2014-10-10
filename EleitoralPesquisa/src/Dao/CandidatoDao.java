package Dao;

import javax.persistence.EntityManager;

import Entidades.Candidato;

public class CandidatoDao extends GenericoDao<Candidato> {

	public CandidatoDao(EntityManager manager) {
		super(manager);
	}
	
	@Override
	public Class<Candidato> entityClass() { //Para funcionar, criar em Generico dao a class <E> generica abstrata
		return Candidato.class;
	}

}
