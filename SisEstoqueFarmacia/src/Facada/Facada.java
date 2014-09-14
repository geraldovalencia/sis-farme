package Facada;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cadastroClientes.Administrador;
import cadastroClientes.Categoria;
import cadastroClientes.Compra;
import cadastroClientes.Farmaceutico;
import cadastroClientes.Gerente;
import cadastroClientes.ItemMovimento;
import cadastroClientes.Movimento;
import cadastroClientes.Pessoa;
import cadastroClientes.PessoaFisica;
import cadastroClientes.PessoaJuridica;
import cadastroClientes.Produto;
import cadastroClientes.Unidade;
import cadastroClientes.Usuario;


import cadastroClientes.Venda;
import cadastroClientes.Vendedor;
import DAO.AdministradorDAO;
import DAO.CategoriaDAO;
import DAO.CompraDAO;
import DAO.FarmaceuticoDAO;
import DAO.GerenteDAO;
import DAO.ItemMovimentoDAO;
import DAO.MovimentoDAO;
import DAO.PessoaDAO;
import DAO.PessoaFisicaDAO;
import DAO.PessoaJuridicaDAO;
import DAO.ProdutoDAO;
import DAO.UnidadeDAO;
import DAO.UsuarioDAO;
import DAO.VendaDAO;
import DAO.VendedorDAO;
import DAO.hashUtil;


public class Facada {
	
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("farmacia2");

	
	/*------------------------------------------------------------------------------------*/
										/*[USUARIO]*/
	/*------------------------------------------------------------------------------------*/
	public static Usuario logarUsuario(String login, String senha){
//	                                           val           123
		senha = hashUtil.stringToMD5(senha);
		EntityManager manager = factory.createEntityManager();		
		UsuarioDAO usuarioDao = new UsuarioDAO(manager);
		List<Usuario> usuarios = usuarioDao.logarUsuario(login, senha);
		
		if(usuarios.isEmpty() || login == ""){
			System.out.println("Login incorreto");
		}
		else{
		 return usuarios.get(0);
		}
		return null;
	}
	
	public static List<Usuario> listarTodosUsuarios() {
		EntityManager manager = factory.createEntityManager();
		UsuarioDAO usDao = new UsuarioDAO(manager);
		return usDao.listarTodos();
	}
	//----------------------------------FAZENDO BUSCA COM PAGINAÇAO - USUARIOS
	
	public static List<Usuario> listarUsuariosLimitados(int pag) {
		EntityManager manager = factory.createEntityManager();
		UsuarioDAO projetoDao = new UsuarioDAO(manager);
		return projetoDao.listarTodosLimitado(pag);
	}
	public static int getQtdePag() {
		EntityManager manager = factory.createEntityManager();
		UsuarioDAO projetoDao = new UsuarioDAO(manager);
		return projetoDao.getQuantidade();
	}
	
	// ----------------------------------------------FIM PAGINAÇAO - USUARIOS
	
	public static void salvarUsuario(Usuario usuario){
		EntityManager manager = factory.createEntityManager();		
		UsuarioDAO usuarioDao = new UsuarioDAO(manager);
		usuario.setSenha(hashUtil.stringToMD5(usuario.getSenha()));
		manager.getTransaction().begin();
		if(usuario instanceof Administrador){
			System.out.println("Salvou em Instaceof o Tipo em Usuário");
			usuarioDao.salvar((Administrador)usuario);	
		}else if(usuario instanceof Farmaceutico){
			System.out.println("Salvou em Instaceof o Tipo em Farmaceutico");
			usuarioDao.salvar((Farmaceutico)usuario);
		}else if(usuario instanceof Gerente){
			System.out.println("Salvou em Instaceof o Tipo em Gerente");
			usuarioDao.salvar((Gerente)usuario);
		}else if(usuario instanceof Vendedor){
			System.out.println("Salvou em Instaceof o Tipo em Vendedor");
			usuarioDao.salvar((Vendedor)usuario);
		}
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static void AlterarUsuario(Usuario usuario){
		EntityManager manager = factory.createEntityManager();		
		UsuarioDAO uDao = new UsuarioDAO(manager);
		usuario.setSenha(hashUtil.stringToMD5(usuario.getSenha()));
		manager.getTransaction().begin();
		if(usuario instanceof Administrador){
			System.out.println("Salvou em Instaceof o Tipo em Usuário");
			uDao.alterar((Administrador)usuario);	
		}else if(usuario instanceof Farmaceutico){
			System.out.println("Salvou em Instaceof o Tipo em Farmaceutico");
			uDao.alterar((Farmaceutico)usuario);
		}else if(usuario instanceof Gerente){
			System.out.println("Salvou em Instaceof o Tipo em Gerente");
			uDao.alterar((Gerente)usuario);
		}else if(usuario instanceof Vendedor){
			System.out.println("Salvou em Instaceof o Tipo em Vendedor");
			uDao.alterar((Vendedor)usuario);
		}
		manager.getTransaction().commit();
		manager.close();}
	
	
	public static void verificarSenha(Usuario usuario){
		usuario.setSenha(hashUtil.stringToMD5(usuario.getSenha()));
		return;
		}
	
	public static void excluirUsuario(Long id){	
		EntityManager manager = factory.createEntityManager();	
		UsuarioDAO uDao = new UsuarioDAO(manager);	
		Usuario usuario = uDao.buscarPorId(id);

		manager.getTransaction().begin();
		uDao.remover(usuario);		
		manager.getTransaction().commit();
		manager.close();

		}
		
	public static Usuario buscarUsuarioPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		UsuarioDAO pessoaDao = new UsuarioDAO(manager);
		return pessoaDao.buscarPorId(id);
		}
	
	public static Administrador buscarAdmPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		AdministradorDAO aDao = new AdministradorDAO(manager);
		return aDao.buscarPorId (id);
		}
	
	public static Farmaceutico buscarFarmaceuticoPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		FarmaceuticoDAO fDao = new FarmaceuticoDAO(manager);
		return fDao.buscarPorId (id);
		}
	public static Gerente buscarGerentePorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		GerenteDAO fDao = new GerenteDAO(manager);
		return fDao.buscarPorId (id);
		}
	
	public static Vendedor buscarVendedorPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		VendedorDAO fDao = new VendedorDAO(manager);
		return fDao.buscarPorId (id);
		}
	
	public static List<Usuario> buscarUsuarioPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		UsuarioDAO usuarioDao = new UsuarioDAO(manager);
		return usuarioDao.buscarPorNome(nome);
		}
	
	
	
	/*------------------------------------------------------------------------------------*/
										/*[PRODUTOS]*/
	/*------------------------------------------------------------------------------------*/
	
	public static void cadastrarProduto(Produto produto){

		EntityManager manager = factory.createEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(manager);
		System.out.println("FACHADA nome "+produto.getNome());
		System.out.println("FACHADA categoria "+produto.getCategoria().getNome());
		System.out.println("FACHADA unidade "+produto.getUnidade().getNome());
		System.out.println("FACHADA preço "+produto.getPrecovenda());
		System.out.println("FACHADA QT Estoque "+produto.getQtde_estoque());
		System.out.println("Vai salvar produto agora:");
		produtoDao.salvar(produto);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
	}
	public static List<Produto> listarTodosProdutos(){	
		EntityManager manager = factory.createEntityManager();	
		ProdutoDAO pDao = new ProdutoDAO(manager);	
		return pDao.listarTodos();
	}
	public static void alterarProduto(Produto produto){
		EntityManager manager = factory.createEntityManager();		
		ProdutoDAO produtoDao = new ProdutoDAO(manager);

		manager.getTransaction().begin();
		produtoDao.alterar(produto);		
		manager.getTransaction().commit();
		manager.close();
	}
	
	//----------------------------------FAZENDO BUSCA COM PAGINAÇAO - PRODUTOS
	
		public static List<Produto> listarProdutosLimitados(int pag) {
			EntityManager manager = factory.createEntityManager();
			ProdutoDAO projetoDao = new ProdutoDAO(manager);
			return projetoDao.listarTodosLimitado(pag);
		}
		public static int getQtdePagProdutos() {
			EntityManager manager = factory.createEntityManager();
			ProdutoDAO projetoDao = new ProdutoDAO(manager);
			return projetoDao.getQuantidade();
		}
		
		// ----------------------------------------------FIM PAGINAÇAO - PRODUTOS
	
	public static void excluirProduto(Long id){	
		EntityManager manager = factory.createEntityManager();	
		ProdutoDAO pDao = new ProdutoDAO(manager);	
		Produto produto = pDao.buscarPorId(id);

		manager.getTransaction().begin();
		pDao.remover(produto);		
		manager.getTransaction().commit();
		manager.close();

	}
	
	public static Produto buscarProdutoPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(manager);
		return produtoDao.buscarPorId(id);
	}
	
	public static List<Produto> buscarProdutoPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(manager);
		return produtoDao.buscarPorNome(nome);
	}
	
	/*------------------------------------------------------------------------------------*/
										/*[CATEGORIAS]*/
	/*------------------------------------------------------------------------------------*/

	public static void salvarCategoria(Categoria categoria){
		
		EntityManager manager = factory.createEntityManager();		
		CategoriaDAO categoriaDao = new CategoriaDAO(manager);
		manager.getTransaction().begin();
		categoriaDao.salvar(categoria);		
		manager.getTransaction().commit();
		manager.close();
	
	}
	public static List<Categoria> listarTodasCategorias(){	
		EntityManager manager = factory.createEntityManager();	
		CategoriaDAO cDao = new CategoriaDAO(manager);	
		
		return cDao.listarTodos();
	}
	
	//----------------------------------FAZENDO BUSCA COM PAGINAÇAO - Categorias
	
		public static List<Categoria> listarCategoriasLimitados(int pag) {
			EntityManager manager = factory.createEntityManager();
			CategoriaDAO projetoDao = new CategoriaDAO(manager);
			return projetoDao.listarTodosLimitado(pag);
		}
		public static int getQtdePagCategorias() {
			EntityManager manager = factory.createEntityManager();
			CategoriaDAO projetoDao = new CategoriaDAO(manager);
			return projetoDao.getQuantidade();
		}
		
		// ----------------------------------------------FIM PAGINAÇAO - Categorias
	
	public static void alterarCategoria(Categoria categoria){

		EntityManager manager = factory.createEntityManager();		
		CategoriaDAO categoriaDao = new CategoriaDAO(manager);

		manager.getTransaction().begin();
		categoriaDao.alterar(categoria);		
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static void excluirCategoria(Long id){	
		EntityManager manager = factory.createEntityManager();	
		CategoriaDAO cDao = new CategoriaDAO(manager);	
		Categoria categoria = cDao.buscarPorId(id);

		manager.getTransaction().begin();
		cDao.remover(categoria);		
		manager.getTransaction().commit();
		manager.close();

	}
	
	public static Categoria buscarCategoriaPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		CategoriaDAO pessoaDao = new CategoriaDAO(manager);
		return pessoaDao.buscarPorId(id);
	}
	public static List<Categoria> buscarCategoriaPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		CategoriaDAO categoriaDao = new CategoriaDAO(manager);
		return categoriaDao.buscarPorNome(nome);
	}
	
	/*------------------------------------------------------------------------------------*/
										  /*[CLIENTE]*/
	/*------------------------------------------------------------------------------------*/
	
		
	public static void cadastrarPessoaFisica(PessoaFisica pessoaFisica){
		
		EntityManager manager = factory.createEntityManager();		
		PessoaFisicaDAO pessoaFisicaDao = new PessoaFisicaDAO(manager);
		manager.getTransaction().begin();
		pessoaFisicaDao.salvar(pessoaFisica);		
		manager.getTransaction().commit();
		manager.close();
	
	}
	public static List<PessoaFisica> listarTodasPessoaFisicas(){	
		EntityManager manager = factory.createEntityManager();	
		PessoaFisicaDAO pDao = new PessoaFisicaDAO(manager);	
		
		return pDao.listarTodos();
	}
	
	//----------------------------------FAZENDO BUSCA COM PAGINAÇAO - PF
	
			public static List<PessoaFisica> listarPFLimitados(int pag) {
				EntityManager manager = factory.createEntityManager();
				PessoaFisicaDAO projetoDao = new PessoaFisicaDAO(manager);
				return projetoDao.listarTodosLimitado(pag);
			}
			public static int getQtdePagPF() {
				EntityManager manager = factory.createEntityManager();
				PessoaFisicaDAO projetoDao = new PessoaFisicaDAO(manager);
				return projetoDao.getQuantidade();
			}
			
			// ----------------------------------------------FIM PAGINAÇAO - PF
	
	
	public static void alterarPessoaFisica(PessoaFisica pf){
		EntityManager manager = factory.createEntityManager();		
		PessoaFisicaDAO pfDao = new PessoaFisicaDAO(manager);

		manager.getTransaction().begin();
		pfDao.alterar(pf);		
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static void excluirPessoaFisica(Long id){	
		EntityManager manager = factory.createEntityManager();	
		PessoaFisicaDAO pfDao = new PessoaFisicaDAO(manager);	
		PessoaFisica pf = pfDao.buscarPorId(id);

		manager.getTransaction().begin();
		pfDao.remover(pf);		
		manager.getTransaction().commit();
		manager.close();

	}
	
	public static PessoaFisica buscarPessoaFisicaPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		PessoaFisicaDAO pfDao = new PessoaFisicaDAO(manager);
		return pfDao.buscarPorId(id);
	}
	public static List<PessoaFisica> buscarPessoaFisicaPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		PessoaFisicaDAO pfDao = new PessoaFisicaDAO(manager);
		return pfDao.buscarPorNome(nome);
	}
	
	
	
	/*------------------------------------------------------------------------------------*/
											/*[PESSOA]*/
	/*------------------------------------------------------------------------------------*/
	
	public static void salvarPessoa(Pessoa pessoa) {
		EntityManager manager = factory.createEntityManager();
		PessoaDAO pessoaDao = new PessoaDAO(manager);
		pessoaDao.salvar(pessoa);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
	}

	public static void atualizarPessoa(Pessoa pessoa) {
		EntityManager manager = factory.createEntityManager();
		PessoaDAO pessoaDao = new PessoaDAO(manager);
		pessoaDao.alterar(pessoa);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
	}

	public static List<Pessoa> buscarpessoaPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		PessoaDAO pessoaDao = new PessoaDAO(manager);
		return pessoaDao.buscarPorNome(nome);
	}

	public static Pessoa buscarPessoaPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		PessoaDAO pessoaDao = new PessoaDAO(manager);
		return pessoaDao.buscarPorId(id);
	}
	

	public static List<Pessoa> listarpessoas() {
		EntityManager manager = factory.createEntityManager();
		PessoaDAO pessoaDao = new PessoaDAO(manager);
		return pessoaDao.listarTodos();
	}
	
	/* -----------------------------------------------------------------------------------*/
									  /*[FORNECEDORES]*/
	/*------------------------------------------------------------------------------------*/
	
	public static void cadastrarPessoaJuridica(PessoaJuridica pj){
		
		EntityManager manager = factory.createEntityManager();		
		PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO(manager);
		manager.getTransaction().begin();
		pjDao.salvar(pj);		
		manager.getTransaction().commit();
		manager.close();
	
	}
	public static List<PessoaJuridica> listarTodasPessoaJuridicas(){	
		EntityManager manager = factory.createEntityManager();	
		PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO(manager);	
		
		return pjDao.listarTodos();
	}
	
	
	//----------------------------------FAZENDO BUSCA COM PAGINAÇAO - Pj
	
	public static List<PessoaJuridica> listarPJLimitados(int pag) {
		EntityManager manager = factory.createEntityManager();
		PessoaJuridicaDAO projetoDao = new PessoaJuridicaDAO(manager);
		return projetoDao.listarTodosLimitado(pag);
	}
	public static int getQtdePagPJ() {
		EntityManager manager = factory.createEntityManager();
		PessoaJuridicaDAO projetoDao = new PessoaJuridicaDAO(manager);
		return projetoDao.getQuantidade();
	}
	
	// ----------------------------------------------FIM PAGINAÇAO - Pj
	
	public static void alterarPessoaJuridica(PessoaJuridica pj){
		EntityManager manager = factory.createEntityManager();		
		PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO(manager);
		manager.getTransaction().begin();
		pjDao.alterar(pj);
		manager.getTransaction().commit();
		manager.close();}
	
		public static void excluirPessoaJuridica(Long id){	
			EntityManager manager = factory.createEntityManager();	
			PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO(manager);	
			PessoaJuridica pj = pjDao.buscarPorId(id);
	
			manager.getTransaction().begin();
			pjDao.remover(pj);		
			manager.getTransaction().commit();
			manager.close();

	}
		public static PessoaJuridica buscarPessoaJuridicaPorId(Long id) {
			EntityManager manager = factory.createEntityManager();
			PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO(manager);
			return pjDao.buscarPorId(id);
		}
		public static List<PessoaJuridica> buscarPessoaJuridicaPorNome(String nome) {
			EntityManager manager = factory.createEntityManager();
			PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO(manager);
			return pjDao.buscarPorNome(nome);
		}
		
	/*------------------------------------------------------------------------------------*/
									/*[ITEM_MOVIMENTO]*/
	/*------------------------------------------------------------------------------------*/
		
		public static void salvarItemMovimento(ItemMovimento itemMovimento) {
			EntityManager manager = factory.createEntityManager();
			ItemMovimentoDAO itemMovimentoDao = new ItemMovimentoDAO(manager);
			itemMovimentoDao.salvar(itemMovimento);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			manager.close();
		}

		public static ItemMovimento buscarItemMovimentoPorId(Long id) {
			EntityManager manager = factory.createEntityManager();
			ItemMovimentoDAO pessoaDao = new ItemMovimentoDAO(manager);
			return pessoaDao.buscarPorId(id);
		}

		public static List<ItemMovimento> buscaritemMovimentoPorNome(String nome) {
			EntityManager manager = factory.createEntityManager();
			ItemMovimentoDAO itemMovimentoDao = new ItemMovimentoDAO(manager);
			return itemMovimentoDao.buscarPorNome(nome);
		}

		public static List<ItemMovimento> listaritemMovimentos() {
			EntityManager manager = factory.createEntityManager();
			ItemMovimentoDAO itemMovimentoDao = new ItemMovimentoDAO(manager);
			return itemMovimentoDao.listarTodos();
		}
		
		public static void excluirItemMoviment(Long id){	
			EntityManager manager = factory.createEntityManager();	
			ItemMovimentoDAO itDao = new ItemMovimentoDAO(manager);	
			ItemMovimento it = itDao.buscarPorId(id);
	
			manager.getTransaction().begin();
			itDao.remover(it);		
			manager.getTransaction().commit();
			manager.close();

	}
	/* -----------------------------------------------------------------------------------*/
										/*[OPERACOES]*/
	/*------------------------------------------------------------------------------------*/

	public static void efetuarCompra(Compra compra){
		
		EntityManager manager = factory.createEntityManager();
		
		CompraDAO cdao = new CompraDAO(manager);
		ProdutoDAO produtoDao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		
		for (ItemMovimento itemMov: compra.getItemMovimentos()){
			Produto p = produtoDao.buscarPorId(itemMov.getProduto().getId());
			p.setQtde_estoque(p.getQtde_estoque()+itemMov.getQuantidade());
			itemMov.setMovimento(compra);
			produtoDao.salvar(p);
		}
		cdao.salvar(compra);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static void efetuarVenda(Venda venda){
		
	EntityManager manager = factory.createEntityManager();
			
			VendaDAO vdao = new VendaDAO(manager);
			ProdutoDAO produtoDao = new ProdutoDAO(manager);
			manager.getTransaction().begin();
			
			for (ItemMovimento itemMov: venda.getItemMovimentos()){
				Produto p = produtoDao.buscarPorId(itemMov.getProduto().getId());
				p.setQtde_estoque(p.getQtde_estoque()-itemMov.getQuantidade());
				itemMov.setMovimento(venda);
				produtoDao.salvar(p);
			}
			vdao.salvar(venda);
			manager.getTransaction().commit();
			manager.close();
	}
	
	public static List<Venda> listarTodasVendas() {
		EntityManager manager = factory.createEntityManager();
		VendaDAO vdao = new VendaDAO(manager);
		return vdao.listarTodos();
	}
	
	//----------------------------------FAZENDO BUSCA COM PAGINAÇAO - Vendas
	
			public static List<Venda> listarVendasLimitadas(int pag) {
				EntityManager manager = factory.createEntityManager();
				VendaDAO projetoDao = new VendaDAO(manager);
				return projetoDao.listarTodosLimitado(pag);
			}
			public static int getQtdeVendasPag() {
				EntityManager manager = factory.createEntityManager();
				VendaDAO projetoDao = new VendaDAO(manager);
				return projetoDao.getQuantidade();
			}
			
			// ----------------------------------------------FIM PAGINAÇAO - Vendas
	
	public static List<ItemMovimento> listarTodosComTesteControlados() {
		EntityManager manager = factory.createEntityManager();
		ItemMovimentoDAO vdao = new ItemMovimentoDAO(manager);
		return vdao.listarTodosComTesteControlado();
	}
	
	public static ArrayList<Venda> listarTodasVendasComControlado() {
		EntityManager manager = factory.createEntityManager();
		VendaDAO vdao = new VendaDAO(manager);
		return vdao.listarTodasVendasComControlado();
	}


	/* -----------------------------------------------------------------------------------*/
										/*[MOVIMIENTOS]*/
	/*------------------------------------------------------------------------------------*/
	
	public static void salvarVenda(Venda movimento) {
		EntityManager manager = factory.createEntityManager();
		MovimentoDAO movimentoDao = new MovimentoDAO(manager);
		movimentoDao.salvar(movimento);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
	}
	
	//---PAGINAÇÃO--------------------------- RELATORIO----------------PAGINAÇÂO
	public static List<Venda> relatorioVendaCliente(PessoaFisica pf, int pag){
		EntityManager manager = factory.createEntityManager();
		MovimentoDAO movimentoDao = new MovimentoDAO(manager);
		return movimentoDao.relatorioVendaCliente(pf, pag);
	}
	
	public static int getQtdePagRelatório() {
		EntityManager manager = factory.createEntityManager();
		MovimentoDAO projetoDao = new MovimentoDAO(manager);
		return projetoDao.getQuantidade();
	}
	
	public static List<Compra> listarTodasCompras() {
		EntityManager manager = factory.createEntityManager();
		CompraDAO vdao = new CompraDAO(manager);
		return vdao.listarTodos();
	}
	
	//----------------------------------FAZENDO BUSCA COM PAGINAÇAO - Compras
	
		public static List<Compra> listarComprasLimitadas(int pag) {
			EntityManager manager = factory.createEntityManager();
			CompraDAO projetoDao = new CompraDAO(manager);
			return projetoDao.listarTodosLimitado(pag);
		}
		public static int getQtdeComprasPag() {
			EntityManager manager = factory.createEntityManager();
			CompraDAO projetoDao = new CompraDAO(manager);
			return projetoDao.getQuantidade();
		}
		
		// ----------------------------------------------FIM PAGINAÇAO - Compras

	public static void salvarCompra(Compra movimento) {
		EntityManager manager = factory.createEntityManager();
		MovimentoDAO movimentoDao = new MovimentoDAO(manager);
		movimentoDao.salvar(movimento);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
	}

	public static void removerMovimento(Movimento movimento) {
		EntityManager manager = factory.createEntityManager();
		MovimentoDAO movimentoDao = new MovimentoDAO(manager);
		Movimento movimentoBusca = manager.find(Movimento.class, movimento.getId());
		movimentoDao.remover(movimentoBusca);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();

	}

	public static Movimento buscarMovimentoPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		MovimentoDAO pessoaDao = new MovimentoDAO(manager);
		return pessoaDao.buscarPorId(id);
	}

	public static List<Movimento> buscarmovimentoPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		MovimentoDAO movimentoDao = new MovimentoDAO(manager);
		return movimentoDao.buscarPorNome(nome);
	}

	public static List<Movimento> listarmovimentos() {
		EntityManager manager = factory.createEntityManager();
		MovimentoDAO movimentoDao = new MovimentoDAO(manager);
		return movimentoDao.listarTodos();
	}
	/* -----------------------------------------------------------------------------------*/
										/*[UNIDADES]*/
	/*------------------------------------------------------------------------------------*/
	
	
		
		public static void salvarUnidades(Unidade unidade){
			EntityManager manager = factory.createEntityManager();
			UnidadeDAO unidadeDao = new UnidadeDAO(manager);
			unidadeDao.salvar(unidade);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			manager.close();
		}

		public static Unidade  buscarUnidadePorId(Long id) {
			EntityManager manager = factory.createEntityManager();
			UnidadeDAO pessoaDao = new UnidadeDAO(manager);
			return pessoaDao.buscarPorId(id);
		}

		public static List<Unidade> buscarunidadePorNome(String nome) {
			EntityManager manager = factory.createEntityManager();
			UnidadeDAO unidadeDao = new UnidadeDAO(manager);
			return unidadeDao.buscarPorNome(nome);
		}

		public static List<Unidade> listarTodasUnidades() {
			EntityManager manager = factory.createEntityManager();
			UnidadeDAO unidadeDao = new UnidadeDAO(manager);
			return unidadeDao.listarTodos();
		}
		
		//----------------------------------FAZENDO BUSCA COM PAGINAÇAO - Unidade
		
			public static List<Unidade> listarUnidadesLimitados(int pag) {
				EntityManager manager = factory.createEntityManager();
				UnidadeDAO projetoDao = new UnidadeDAO(manager);
				return projetoDao.listarTodosLimitado(pag);
			}
			public static int getQtdePagUnidades() {
				EntityManager manager = factory.createEntityManager();
				UnidadeDAO projetoDao = new UnidadeDAO(manager);
				return projetoDao.getQuantidade();
			}
			
			// ----------------------------------------------FIM PAGINAÇAO - Unidade
		
		
		public static void excluirUnidade(Long id){	
			EntityManager manager = factory.createEntityManager();	
			UnidadeDAO uDao = new UnidadeDAO(manager);	
			Unidade unidade = uDao.buscarPorId(id);
	
			manager.getTransaction().begin();
			uDao.remover(unidade);		
			manager.getTransaction().commit();
			manager.close();
		}
		
		public static void alterarUnidade (Unidade unidade){
			EntityManager manager = factory.createEntityManager();		
			UnidadeDAO uDao = new UnidadeDAO(manager);

			manager.getTransaction().begin();
			Unidade  und = uDao.buscarPorId(unidade.getId());
			
			
			if(und!=null){
			und.setId(unidade.getId());	
			und.setNome(unidade.getNome());
			
			uDao.alterar(und);
			}
			manager.getTransaction().commit();
			manager.close();}

//		Compra compra = new Compra();
//		Produto carro = new Produto();
//		Produto bola = new Produto();
//		ItemMovimento itm1 = new ItemMovimento();
//		ItemMovimento itm2 = new ItemMovimento();
//		itm1.setProduto(carro);
//		itm2.setProduto(bola);
//		compra.setItemMovimentos(new ArrayList<ItemMovimento>());
//		compra.getItemMovimentos().add(itm1);
//		compra.getItemMovimentos().add(itm2);
//		efetuarCompra(compra);
		




	
}
