package DAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import cadastroClientes.AbstractEntity;

public abstract class AbstractDao<E extends AbstractEntity> {
	
	/* Aqui nessa classe, todos os m�todos ser�o automaticamente heredados por todos as entidades DAOS*/
	
	EntityManagerFactory factory;
	EntityManager manager;
	
	public AbstractDao(EntityManager manager){
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
		
	public List<E> buscarPorNome(String nome){
		
		Query query = manager.createQuery("SELECT e FROM "
				+entityClass().getSimpleName()  + " e WHERE upper(e.nome) like upper(:nome)");

		query.setParameter("nome","%" + nome + "%");
				return query.getResultList();
	}
	
		
	public abstract Class<E> entityClass();
	
	public E buscarPorId(Long id){
		return manager.find(entityClass(), id);
	}
	
	public List<E> listarTodos(){
		Query query = manager.createQuery("Select e from " 
						+entityClass().getSimpleName() + " e ORDER  BY (e.id)" );
		
		return query.getResultList();
	}
	
	public List<E> listarTodosComTesteControlado(){
		Query query = manager.createQuery("Select i FROM ItemMovimento i WHERE i.produto.categoria.controlado = TRUE");
		
		return query.getResultList();
	}
	
	public Date converteData(String data) {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		try {
			Date dt = df.parse(data);
			return dt;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}
	int paginacao=8;
	
	public List<E> listarTodosLimitado(int pag) {
		Query query = manager.createQuery("Select e from " + entityClass().getSimpleName() + " e ORDER  BY (e.id)").setMaxResults(this.paginacao);
		query.setFirstResult(pag);
		return query.getResultList();
	}
	
	public int getQuantidade() {
		Query query = manager.createQuery("Select count(e) from " + entityClass().getSimpleName() + " e ");
		return ((Number) query.getSingleResult()).intValue()/this.paginacao;
	}
}
