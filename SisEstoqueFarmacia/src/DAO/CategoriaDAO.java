package DAO;

import javax.persistence.EntityManager;

import cadastroClientes.Categoria;

public class CategoriaDAO  extends AbstractDao<Categoria>{

	public CategoriaDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Categoria> entityClass() {
		// TODO Auto-generated method stub
		return Categoria.class;
	}
	
	

}
