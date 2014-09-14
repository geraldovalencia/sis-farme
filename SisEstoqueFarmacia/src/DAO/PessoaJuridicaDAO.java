package DAO;

import javax.persistence.EntityManager;

import cadastroClientes.PessoaJuridica;

public class PessoaJuridicaDAO extends AbstractDao<PessoaJuridica>{

	public PessoaJuridicaDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<PessoaJuridica> entityClass() {
		// TODO Auto-generated method stub
		return PessoaJuridica.class;
	}
	
	
	
	

}
