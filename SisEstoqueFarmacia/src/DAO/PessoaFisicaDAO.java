package DAO;

import javax.persistence.EntityManager;

import cadastroClientes.PessoaFisica;

public class PessoaFisicaDAO extends AbstractDao<PessoaFisica>{

	public PessoaFisicaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<PessoaFisica> entityClass() {
		return PessoaFisica.class;
	}
	
	
	

}
