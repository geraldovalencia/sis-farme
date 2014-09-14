package entidadesDAO;

import javax.persistence.EntityManager;

import entidades.Produto;

public class ProdutoDAO extends GenericoDAO<Produto>{

	public ProdutoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Produto> entityClass() {
		return Produto.class;
	}
	

}
