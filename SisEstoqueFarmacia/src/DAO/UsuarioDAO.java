package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import Facada.Facada;
import cadastroClientes.Usuario;

public class UsuarioDAO extends AbstractDao<Usuario>{
	

	
		public UsuarioDAO(EntityManager manager) {
			super(manager);
		}
	
		@Override
		public Class<Usuario> entityClass() {
			return Usuario.class;
		}
			
		public List<Usuario> logarUsuario(String login, String senha){
			
		    
	        Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha ");  
	        query.setParameter("login", login);  
	        query.setParameter("senha", senha); 
	        
	       return query.getResultList();
		}
		
		
}
