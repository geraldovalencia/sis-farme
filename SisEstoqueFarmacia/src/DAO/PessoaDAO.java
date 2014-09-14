package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cadastroClientes.Pessoa;
import cadastroClientes.Pessoa;

public class PessoaDAO extends AbstractDao<Pessoa>{
	

	public PessoaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Pessoa> entityClass() {
		// TODO Auto-generated method stub
		return Pessoa.class;
	}

	

}
