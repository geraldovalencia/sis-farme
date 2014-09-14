package execucao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Produto;
import entidadesDAO.ProdutoDAO;

public class Fachada {//A fachada é a classe que tem os métodos que serão usados pelo sistema. Serve como um "banco de dados de métodos"
	
	private static Scanner teclado = new Scanner (System.in);
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisEstok");
	static String TextoMenuOpcao = "Digite aqui sua opção: "; 
	
	
	public static void titulo() {//Aqui o sistema cria o título do menu
		System.out.println("########################################################################################");
		System.out.println("                                  SISTEMA DE ESTOQUE                                    ");
		System.out.println("                                        ESTOK                                           ");
		System.out.println("########################################################################################");
	}

	public static void iniciarOpcoes(String texto){
		titulo();
		
		System.out.println("1. Adicionar Produto");
		System.out.println("2. Buscar Mercadoria");
		System.out.println("3. Remover Mercadoria");
		System.out.println("4. Listar Produtos");
		System.out.println("5. Busca por Fabricante: ");
		System.out.println();
		System.out.println(texto);
		
	}
	
	public static void MenuPrincipal(){
		
		int numeroTelaInicial = 0;
		boolean selecOpcao = false;
		String aviso = "Digite uma opção com Caracter Numérico: ";
		
		while (!selecOpcao){
			String EntradaOpcao = teclado.nextLine();
			
			if(EntradaOpcao.equals("")){
				iniciarOpcoes(aviso);	
				continue;	//Aqui ele imprime a mensagem e continua para fora do if, continuando o if
			}
			try {	//Aqui ele começa o TRY convertendo o EntradaEstoque para o Int e setando a conversao na variavel QtEstoque
				numeroTelaInicial = Integer.parseInt(EntradaOpcao);
				if(numeroTelaInicial < 0){	//Verifica se a variavel convertida estpa menor que zero
					continue;
				}
				selecOpcao = true;	//Muda o valor do booleanop para true e assim, não voltar a repetir o while
			} catch (Exception e) {
				//Caso de erro em algum laço antes do catch, a variavel booleana fica false e reinicia o while
				System.out.println("Erro na Opção.");
				System.out.println("Por Favor, é necessário digitar um numeral: ");
				iniciarOpcoes(aviso);
			}
			
		}
		
		switch (numeroTelaInicial){
		case 1:{
			Fachada.titulo();
			Fachada.criarProduto();
			break;
			}
		case 2: {
			Fachada.titulo();
			Fachada.buscarProdutoPorNome();
			break;
			}
		case 3:{
			Fachada.titulo();
			Fachada.removerProduto();			
			break;
			}
		case 4:{
			Fachada.titulo();
			Fachada.listarProdutos();
			break;
			}
		case 5:{
			Fachada.titulo();
			Fachada.buscarProdutoPorFabricante();
			break;
			}
		default:{
			System.out.println("\nOpção incorreta!");
			Fachada.pause();
			break;
			}
		}
	}
	
	public static List<Produto> buscarProdutoPorNome() {
		System.out.println("Digite o nome do Produto: ");
		String nomeIn = teclado.nextLine();
		EntityManager manager = factory.createEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(manager);
		List<Produto> resultadoPesquisa = produtoDao.buscarPorNome(nomeIn);
		System.out.println("\n|---------------------------------[Busca de Produtos]----------------------------------|");
		for (Produto produto : resultadoPesquisa) {
		System.out.println("\nO id do produto é: " + produto.getId()
						+ "\nO produto encontado foi: " + produto.getNome().toString() + 
						"\nFabricante: " + produto.getFabricante().toString() +
						"\nPreço: " + produto.getPreco() +
						"\nDescrição do Produto: " + produto.getDescricao().toString() +
						"\nQnd no Estoque: " + produto.getQtEstoque() +
						"\n|--------------------------------------------------------------------------------------|");
		}
		System.out.println("\nPressione ENTER para continuar...");
		teclado.nextLine();
		iniciarOpcoes(TextoMenuOpcao);
		MenuPrincipal();
		return resultadoPesquisa;
	}
	
	public static List<Produto> buscarProdutoPorFabricante() {
		System.out.println("Digite o nome do Fabricante: ");
		String fabricanteIn = teclado.nextLine();
		EntityManager manager = factory.createEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(manager);
		List<Produto> resultadoPesquisa = produtoDao.buscarPorFabricante(fabricanteIn);
		System.out.println("\n|---------------------------------[Busca de Produtos]----------------------------------|");
		for (Produto produto : resultadoPesquisa) {
		System.out.println("\nO id do produto é: " + produto.getId()
						+ "\nO produto encontado foi: " + produto.getNome().toString() + 
							"\nFabricante: " + produto.getFabricante().toString() +
							"\nPreço: " + produto.getPreco() +
							"\nDescrição do Produto: " + produto.getDescricao().toString() +
							"\nQnd no Estoque: " + produto.getQtEstoque() +
							"\n|--------------------------------------------------------------------------------------|");
		}
		System.out.println("\nPressione ENTER para continuar...");
		teclado.nextLine();
		iniciarOpcoes(TextoMenuOpcao);
		MenuPrincipal();
		return resultadoPesquisa;
		
	}
	
	public static void listarProdutos(){
		
			EntityManager manager = factory.createEntityManager();
			ProdutoDAO produtoDao = new ProdutoDAO(manager);
			List<Produto> resultadoPesquisa = produtoDao.listarTodos();
			System.out.println("\n|---------------------------------[Listagem de Produtos]----------------------------------|");
			for (Produto produto : resultadoPesquisa) {
				System.out.println("\nO id do produto é: " + produto.getId()
						+ "\nO produto encontado foi: " + produto.getNome().toString() + 
						"\nFabricante: " + produto.getFabricante().toString() +
						"\nPreço: " + produto.getPreco() +
						"\nDescrição do Produto: " + produto.getDescricao().toString() +
						"\nQnd no Estoque: " + produto.getQtEstoque() +
						"\n|--------------------------------------------------------------------------------------|");
			}
			System.out.println("\nPressione ENTER para continuar...");
			teclado.nextLine();
			iniciarOpcoes(TextoMenuOpcao);
			MenuPrincipal();
	}
	
	public static void removerProduto(){
		EntityManager manager = factory.createEntityManager();	
		ProdutoDAO pDao = new ProdutoDAO(manager);	
		
		System.out.println("Digite o id do Produto que deseja remover: ");
		
		int idIn = Integer.parseInt(teclado.nextLine());
		
		
		Produto produto = pDao.buscarPorId(idIn);
		
		if(produto ==null){
			System.out.println("Erro macacada");
			return;
		}			
		
		System.out.println("Tem certeza que deseja remover o produto: " + produto.getNome().toString() + "?"
							+ "\nDigite 1: SIM"
							+ "\nDigite 2: NÃO");
		int numeroRemover = Integer.parseInt(teclado.nextLine());
		switch (numeroRemover) {
		case 1:{
			manager.getTransaction().begin();
			pDao.remover(produto);		
			manager.getTransaction().commit();
			manager.close();
			MensagemRemover();
			}
			break;
		default:
			MensagemNaoRemover();
			break;
		}
		
		

	}
	
	
	public static void criarProduto() {
		EntityManager manager = factory.createEntityManager();
		Produto p = new Produto();//Criando o produto
		ProdutoDAO pdao = new ProdutoDAO(manager);
		
		
			System.out.println("Digite o nome do produto que você quer:");
			String nomeIn = teclado.nextLine();//Criando os atributos vazios que receberão os dados digitados e que serão passados para salvar no banco
			while(nomeIn.equals("")){
				System.out.println("Por favor! Digite o nome do produto que você quer:");
				nomeIn = teclado.nextLine();
			}
			if (!nomeIn.equals("")){
				p.setNome(nomeIn);//Passando para o banco de dados
			}
			System.out.println("\nDigite uma descrição simples do produto:");
			String descricaoIn = teclado.nextLine();//Criando os atributos vazios que receberão os dados digitados e que serão passados para salvar no banco
			while(descricaoIn.equals("")){
				System.out.println("\nAmigo, Digite uma descrição simples do produto:");
				descricaoIn = teclado.nextLine();
			}
			if (!descricaoIn.equals("")){
				p.setDescricao(descricaoIn);//Passando para o banco de dados
			}
			//Convertendo o String em DATE---------------------------------------------------------------------------
			System.out.println("\nDigite a data da entrada: ex. 13/02/1990  : ");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
			java.sql.Date data = null;
			while(data== null){
			try {
				String dataEntrada = teclado.nextLine();
				data = new java.sql.Date(format.parse(dataEntrada).getTime());
			} catch (ParseException e) {
				//e.printStackTrace();
				System.out.println("Erro na data.");
				System.out.println("Por Favor, escreva valores numéricos. Ex: 22/12/2014: ");
				}
			}
			p.setDataEntrada(data);
			//Convertendo o String em DATE---------------------------------------------------------------------------
			
			System.out.println("\nDigite o nome do Fabricante: ");
			String fabricanteIn = teclado.nextLine();
			while(fabricanteIn.equals("")){
				System.out.println("\nÉ necessário digitar o nome do Fabricante: ");
				fabricanteIn = teclado.nextLine();
			}
			if (!fabricanteIn.equals("")){
				p.setFabricante(fabricanteIn);
			}
			
			
//-------------------------------------------------------------------------------------------------------
			
			
			
			System.out.println("\nDigite a quantidade no estoque: ");
			int qtEstoqueIn = 0;
			boolean deuCerto = false;
			
			while (!deuCerto){	//Aqui ele faz um boleano negativo, pois se nenhuma das condições abaixo for saciada, o while irá ser repetir.
				String EntradaEstoque = teclado.nextLine();		//Aqui ele Espera o usuario digitar um valor
				
				if(EntradaEstoque.equals("")){	//Faz uma verificação se o usuario digitou string vazia
					System.out.print("\nDigite a quantidade no estoque com Caracter Numérico: ");
					continue;	//Aqui ele imprime a mensagem e continua para fora do if, continuando o if
				}
				try {	//Aqui ele começa o TRY convertendo o EntradaEstoque para o Int e setando a conversao na variavel QtEstoque
					qtEstoqueIn = Integer.parseInt(EntradaEstoque);
					if(qtEstoqueIn < 0){	//Verifica se a variavel convertida estpa menor que zero
						System.out.println("\nÉ necessário digitar a quantidade igual ou maior que 0: ");
						continue;
					}
					deuCerto = true;	//Muda o valor do booleanop para true e assim, não voltar a repetir o while
				} catch (Exception e) {
					//Caso de erro em algum laço antes do catch, a variavel booleana fica false e reinicia o while
					System.out.println("Erro na Quantidade.");
					System.out.println("Por Favor, é necessário digitar um numeral: ");
				}
				
			}
			p.setQtEstoque(qtEstoqueIn);	//Aqui é método que irá persistir no banco, com a garantia que a variavel recebeu um INT
				
					
//----------------------------------------------------------------------------------------------------------			
			
			System.out.println("\nDigite o preço da mercadoria: R$");
			System.out.println("\n ex: R$ 40.50 ");
			
			double qtPrecoIn = 0;
			boolean deuCertoPreco = false;
			while (!deuCertoPreco){
				String EntradaPreco = teclado.nextLine();
				
				if(EntradaPreco.equals("")){
					System.out.print("\nDigite o preço com Caracter Numérico: ");
					continue;
				}
				try {
					qtPrecoIn = Double.parseDouble(EntradaPreco);
					if(qtPrecoIn < 0){
						System.out.println("\nÉ necessário digitar o preço maior que zero: ");
						continue;
					}
					deuCertoPreco = true;
				} catch (Exception e) {
					System.out.println("Erro no Preço.");
					System.out.println("Por Favor, é necessário digitar um numeral: ");
				}
				
			}
			p.setPreco(qtPrecoIn);
			
			manager.persist(p);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			factory.close();
			MensagemSalvar();
		}
	
		
		
		public static void pause() {//Esse método serve para parar o sistema após operação
			System.out.println("\nPressione ENTER para continuar...");
			teclado.nextLine();
			iniciarOpcoes(TextoMenuOpcao);
			MenuPrincipal();
		}
		
		public static void MensagemSalvar() {//Esse método serve para parar o sistema após operação
			System.out.println("\nProduto Salvo com sucesso!");
			System.out.println("\nPressione ENTER para continuar...");
			teclado.nextLine();
			iniciarOpcoes(TextoMenuOpcao);
			MenuPrincipal();
		}
		public static void MensagemRemover() {//Esse método serve para parar o sistema após operação
			System.out.println("\nProduto Removido com sucesso!");
			System.out.println("\nPressione ENTER para continuar...");
			teclado.nextLine();
			iniciarOpcoes(TextoMenuOpcao);
			MenuPrincipal();
		}
		public static void MensagemNaoRemover() {//Esse método serve para parar o sistema após operação
			System.out.println("\nO Produto Não foi Removido!");
			System.out.println("\nPressione ENTER para continuar...");
			teclado.nextLine();
			iniciarOpcoes(TextoMenuOpcao);
			MenuPrincipal();
		}
}
