package entidadesDAO;

import java.util.List;

import javax.persistence.*;

public abstract class GenericoDAO<E> {

	EntityManagerFactory factory;
	EntityManager manager;
	public abstract Class<E> entityClass();
	
	public GenericoDAO(EntityManager manager){
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
	
	public E buscarPorId(int id){
		return manager.find(entityClass(), id);
	}

	public List<E> buscarPorNome(String nome){//Essa pesquisa em JPQL faz a busca do produto pelo nome
		
		Query query = manager.createQuery("SELECT e FROM "
				+entityClass().getSimpleName()  + " e WHERE upper(e.nome) like upper(:nome)");

		query.setParameter("nome","%" + nome + "%");
				return query.getResultList();
	}
	
public List<E> buscarPorFabricante(String fabricante){//Essa pesquisa em JPQL faz a busca do produto pelo nome
		
		Query query = manager.createQuery("SELECT e FROM "
				+entityClass().getSimpleName()  + " e WHERE upper(e.fabricante) like upper(:fabricante)");

		query.setParameter("fabricante","%" + fabricante + "%");
				return query.getResultList();
	}
	
	public List<E> listarTodos(){
		Query query = manager.createQuery("Select e from " 
						+entityClass().getSimpleName() + " e ORDER  BY (e.id)" );
		
		return query.getResultList();
	}
	
}
