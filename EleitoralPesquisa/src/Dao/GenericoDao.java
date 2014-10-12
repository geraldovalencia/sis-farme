package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import Entidades.AbstractEntidade;

public abstract class GenericoDao<E extends AbstractEntidade> {

	EntityManagerFactory factory;
	EntityManager manager;

	public GenericoDao(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(E entity) {
		manager.persist(entity);
	}

	public void alterar(E entity) {
		manager.merge(entity);
	}

	public void remover(E entity) {
		manager.remove(entity);

	}

	public abstract Class<E> entityClass(); // Para criar o EntityClass nas
											// fulanoDAO precida desse class
											// abstrato

	public List<E> buscarPorNome(String nome) {

		Query query = manager.createQuery("SELECT e FROM "
				+ entityClass().getSimpleName()
				+ " e WHERE upper(e.nome) like upper(:nome)");

		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}
	
	public List<E> listarTodos(){
		Query query = manager.createQuery("Select e from " 
						+entityClass().getSimpleName() + " e ORDER  BY (e.id)" );
		
		return query.getResultList();
	}
	
	public E buscarPorId(Long id){
		return manager.find(entityClass(), id);
	}

}
