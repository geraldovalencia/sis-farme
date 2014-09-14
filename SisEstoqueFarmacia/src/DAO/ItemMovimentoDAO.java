package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cadastroClientes.ItemMovimento;
import cadastroClientes.Movimento;
import cadastroClientes.Pessoa;
import cadastroClientes.Produto;

public class ItemMovimentoDAO extends AbstractDao<ItemMovimento> {

	public ItemMovimentoDAO(EntityManager manager) {
		super(manager);
		
	}

	@Override
	public Class<ItemMovimento> entityClass() {
		return  ItemMovimento.class;
	}
	
	public List<Produto> RelatorioDeVendaPorData(ItemMovimento mov){

		Query query = manager.createQuery("select mov.movimento.pessoaJuridica.nome, i.produto.nome from ItemMovimento mov where i.preco =(select min(it.preco) from ItemMovimento it where it.produto.id = i.produto.id");
		return query.getResultList();
	}
	
	public List<Produto> RelatorioCompraMenorValor(Pessoa pessoa_id, ItemMovimento itemmovimento, Movimento movimento ){

		Query query = manager.createQuery("select pessoa_id as Pessoa,min(itemmovimento.preco) as MenorValor,itemmovimento.produto_id as Produto from movimento,itemmovimento where itemmovimento.movimento_id=movimento.id and movimento.dtype = 'Compra' group by itemmovimento.produto_id,pessoa_id;");
		return query.getResultList();
	}
	
	
	

}
