package DAO;

import javax.persistence.EntityManager;

import cadastroClientes.Administrador;

public class AdministradorDAO extends AbstractDao<Administrador>{

	public AdministradorDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Administrador> entityClass() {
		// TODO Auto-generated method stub
		return Administrador.class;
	}

}
