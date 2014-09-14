package DAO;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cadastroClientes.Compra;
import cadastroClientes.ItemMovimento;
import cadastroClientes.Movimento;
import cadastroClientes.PessoaFisica;
import cadastroClientes.Produto;
import cadastroClientes.Venda;

public class MovimentoDAO extends AbstractDao<Movimento> {

	public MovimentoDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	
	int paginacao = 8;
	
	float valorTotal = 0;
	

	@Override
	public Class<Movimento> entityClass() {
		// TODO Auto-generated method stub
		return Movimento.class;
	}
	
	public List<Produto> ListarTodosMovimentos(Movimento mov){

		Query query = manager.createQuery("Select mov from Movimento mov");
		return query.getResultList();

	}
	
	public void salvarCompra(Compra movimento) {
		Collection<ItemMovimento> mov = movimento.getItemMovimentos();

		
		for (ItemMovimento itemMovimento : mov) {
			/* Calcula total da movimentação */
			valorTotal += itemMovimento.getPreco() * itemMovimento.getQuantidade();

			/* Acrescenta no Estoque */
			Double qtde_estoque = itemMovimento.getProduto().getQtde_estoque() + itemMovimento.getQuantidade();
			itemMovimento.getProduto().setQtde_estoque(qtde_estoque);
			manager.merge(itemMovimento.getProduto());
		}

		movimento.setTotal(valorTotal);

		manager.persist(movimento);
	}

	public void salvarVenda(Venda movimento) {
		Collection<ItemMovimento> mov = movimento.getItemMovimentos();

		/* Checar disponibilidade de cada produto no estoque */
		for (ItemMovimento itemMovimento : mov) {

			if (itemMovimento.getQuantidade() > itemMovimento.getProduto().getQtde_estoque()) {
				throw new RuntimeException("Valor em estoque insuficiente do produto " + itemMovimento.getProduto().getNome()
						+ ", quantidade em Estoque é: " + itemMovimento.getProduto().getQtde_estoque());
			}
		}

		/* Atualizar estoque */
		for (ItemMovimento itemMovimento : mov) {
			Produto prod = itemMovimento.getProduto();
			prod.setQtde_estoque(prod.getQtde_estoque() - itemMovimento.getQuantidade());
			manager.merge(prod);

			/* Calcula total da movimentação */
			valorTotal += itemMovimento.getPreco() * itemMovimento.getQuantidade();
		}

		movimento.setTotal(valorTotal - movimento.getDesconto());

		manager.persist(movimento);
	}

	// Relatorio de Movimentos por Intervalo de Datas
	public List<Movimento> relatorioMovimentosIntervaloData(String dataInicial, String dataFinal) {

		Query query = manager.createQuery("select v from Movimento v where " + "v.data between :inicio AND :fim ");

		query.setParameter("inicio", converteData(dataInicial));
		query.setParameter("fim", converteData(dataFinal));

		List<Movimento> intervaloMovimentos = query.getResultList();

		if (intervaloMovimentos == null || intervaloMovimentos.isEmpty()) {
			throw new RuntimeException("Nenhum movimento neste per�odo");
		}

		return intervaloMovimentos;

	}

	// Visualizar compras anteriores de um dado cliente;
	public List<Venda> relatorioVendaCliente(PessoaFisica pf, int pag) {
		
		Query query = manager.createQuery("select v from Venda v where " + "v.pf = :pessoaFisica").setMaxResults(this.paginacao);

		query.setParameter("pessoaFisica", pf);

		List<Venda> historicoPessoa = query.getResultList();

		if (historicoPessoa == null || historicoPessoa.isEmpty()) {
			throw new RuntimeException("Nenhum movimento deste cliente");
		}

		return historicoPessoa;

	}
	public int getQtdePagRelat�rio() {
		Query query = manager.createQuery("Select count(e) from " + entityClass().getSimpleName() + " e ");
		return ((Number) query.getSingleResult()).intValue()/this.paginacao;
	}
//	public List<Movimento> relatorioCompraCliente(Pessoa pessoa) {
//
//		Query query = manager.createQuery("select v from Movimento v where " + "v.pessoa = :pessoaBusca");
//
//		query.setParameter("pessoaBusca", pessoa);
//
//		List<Movimento> historicoPessoa = query.getResultList();
//
//		if (historicoPessoa == null || historicoPessoa.isEmpty()) {
//			throw new RuntimeException("Nenhum movimento deste cliente");
//		}
//
//		return historicoPessoa;
//
//	}

	// Gerar relatório dos fornecedores por produto que ofereceram um dado
	// produto com o menor preço registrado.
	public List<Object[]> relatorioProdMenorPreco() {

		Query query = manager
				.createQuery("select i.movimento.pessoa.nome, i.produto.nome ,preco from ItemMovimento i where i.preco = (select min(it.preco) from ItemMovimento it where it.produto.id = i.produto.id)");

		List<Object[]> result = query.getResultList();

		return result;

	}
	

}
