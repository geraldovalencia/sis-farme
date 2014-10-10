package Dao;

import javax.persistence.EntityManager;

import Entidades.DesconhecidoGovernador;

public class DesconhecidoGovernadorDao extends GenericoDao<DesconhecidoGovernador> {

	public DesconhecidoGovernadorDao(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<DesconhecidoGovernador> entityClass() {
		// TODO Auto-generated method stub
		return DesconhecidoGovernador.class;
	}

}
