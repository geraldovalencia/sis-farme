package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Entidades.AbstractEntidade;

public abstract class GenericoDao<E extends AbstractEntidade> {
	
	EntityManagerFactory factory;
	EntityManager manager;
	
	public GenericoDao(EntityManager manager){
		this.manager = manager;
	}
	
	public void salvar(E entity){
		manager.persist(entity);
	}
	
	public void alterar(E entity){
		manager.merge(entity);
	}
	
	public void remover(E entity){
		manager.remove(entity);
		
	}

	public abstract Class<E> entityClass(); //Para criar o EntityClass nas fulanoDAO precida desse class abstrato
	
	

}
