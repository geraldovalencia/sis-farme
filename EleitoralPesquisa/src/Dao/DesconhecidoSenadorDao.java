package Dao;

import javax.persistence.EntityManager;

import Entidades.DesconhecidoSenador;

public class DesconhecidoSenadorDao extends GenericoDao<DesconhecidoSenador>{

	public DesconhecidoSenadorDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<DesconhecidoSenador> entityClass() {
		// TODO Auto-generated method stub
		return DesconhecidoSenador.class;
	}

}
