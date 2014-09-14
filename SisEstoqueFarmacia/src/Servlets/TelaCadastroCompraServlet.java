package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.cache.ReadWriteCache.Item;

import cadastroClientes.Compra;
import cadastroClientes.ItemMovimento;
import cadastroClientes.PessoaJuridica;
import cadastroClientes.Produto;
import cadastroClientes.Usuario;
import Facada.Facada;


/**
 * Servlet implementation class TelaCadastroCompraServlet
 */
public class TelaCadastroCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Compra realizada com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar um vendedor diferente.</h5></div>";
		
		
		System.out.println("-----------------------------------------------");
		System.out.println("----- (1) abriu sevlet Compra------");
		String produtoNome =  request.getParameter("produtoNome");//Nome do Produto
		String idProduto =  request.getParameter("codigoProduto");//ID do Produto
		String idUsuario = request.getParameter("idUsuario");
		String codigofornecedorCompra = request.getParameter("codigofornecedor");
		
		String data = (String) request.getSession().getAttribute("dataAtual");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		  
		Date dataCompra = null;
		PessoaJuridica pj= null;
		
		if (data!= null){
			try {
				dataCompra = sdf.parse(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int quantidade = 0;
		
		if (request.getParameter("quantidade")!= null){
			quantidade =  Integer.parseInt(request.getParameter("quantidade").trim());
			System.out.println("----- (2) Quantidade = " + quantidade);
		}else{
			System.out.println("----- (2) Fez teste da Quantidade = " + quantidade);
		}
		
		
		if(codigofornecedorCompra != null){
			
			pj = Facada.buscarPessoaJuridicaPorId(new Long(codigofornecedorCompra));
			System.out.println("Fornecedor encontrado: "+ pj.getNome());
		}
		
		if(idProduto != null && codigofornecedorCompra != null){
			System.out.println("-----------------------------------------------");
			System.out.println("Produto id: " +  idProduto);
			Produto pd = Facada.buscarProdutoPorId(new Long(idProduto));
			
			System.out.println("Produto Nome: " +  pd.getNome());
			System.out.println("Produto Nome vindo da Compra: " +  produtoNome);
			System.out.println("Produto Preço: R$" +  pd.getPrecovenda());
			System.out.println("Quantidade: " +  quantidade);
			System.out.println("Preço Total do Produto: R$" +  pd.getPrecovenda() * quantidade);
			System.out.println("Nome do fornecedor: " +  pj.getNome());
			System.out.println("Data da Compra: " +  dataCompra);
			
			System.out.println("-----------------------------------------------");
		}
		
		Compra compra =  (Compra) request.getSession().getAttribute("compra");
		
		if(compra == null){
			System.out.println("----- (3) Verificação de Compra Nula!");
			Compra c = new Compra();
			c.setItemMovimentos(new ArrayList<ItemMovimento>());
			request.getSession().setAttribute("compra",c);
			System.out.println("----- (4) criou Compra na sessão e setou array de itensMov.");
		}
		
			if(idProduto != null && quantidade > 0){
				ItemMovimento item = new ItemMovimento();
				item.setMovimento(compra); //Setou Tipo de Movimento
				
				Produto p = Facada.buscarProdutoPorId(new Long(idProduto));
				Usuario user = Facada.buscarUsuarioPorId(new Long(idUsuario));
				//Setou no item do Movimento um produto enviado do JSP
				item.setProduto(p);
				//Setou no item do Movimento a quantidade do produto enviado do JSP
				item.setQuantidade(quantidade);
				
				double qtdEstoque = p.getQtde_estoque();
				System.out.println("Quantidade do produto "+ p.getNome() + 
						" no Estoque = " +p.getQtde_estoque());
				
//				if(quantidade > 0){
//					try {
//						System.out.println("Subtração: "+ qtdEstoque + " - " + quantidade);
//						qtdEstoque =- quantidade;
//						p.setQtde_estoque(qtdEstoque);
//						Facada.alterarProduto(p);
//					} catch (Exception e) {
//						HttpSession session = request.getSession(false);
//						String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Quantidade Insulficiente em Estoque.</h5></div>";
//						System.out.println("Erro em reduzir do Estoque.");
//						session.setAttribute("messageErro", messageErro);
//						response.sendRedirect("TelaCadastroCompraServlet.du");
//					}
//				}
				
				//Setou na Compra o item de movimento
				compra.getItemMovimentos().add(item);
				compra.setData(dataCompra);
				compra.setUsuario(user);
				compra.setPj(pj);
				request.getSession().setAttribute("compra", compra);
			}
		
		System.out.println("----- (5) Fez listagem de Fornecedores, Produtos.");
	    List<PessoaJuridica> juridicas = Facada.listarTodasPessoaJuridicas();
	    List<Produto> produtos = Facada.listarTodosProdutos();
	    
		System.out.println("----- (6) Setou os atributos no request -> JSP");
	    request.getSession().setAttribute("juridicasCompra", juridicas);
	    request.getSession().setAttribute("produtos", produtos);
	    request.getSession().setAttribute("quantidade", quantidade);
	    request.getSession().setAttribute("dataCompra", dataCompra);
	    
		request.getRequestDispatcher("pags/compra/novaCompra.jsp")
		.forward(request, response);
		
	    
//		PrintWriter out = response.getWriter();
//				
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");	
//		out.println("<body>");
//		
//		out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
//		out.println("<h3 align='center' >Cadastrar Compra</h3>");
//
//		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//		out.println("<table align='center' cellpadding='5'>");
//		out.println("<tr>");
////		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/listarCategorias.du'>Categorias</a></h4></td>");
////		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarUnidadeServlet.du'>Unidades</a></h4></td>");
//		out.println("</tr>");
//		out.println("</table>");
//		
//		out.println("<form method='post' action='TelaCadastroCompraServlet.du'>");
//		out.println("<h4>Fornecedor</h4>");
//		out.println("<select name='fornecedor'>");
//
//		out.println("<option value=''> -- Selecione -- </option>");
//
//		for (PessoaJuridica fornecedor : juridicas) {
//			out.println("<option value='" + fornecedor.getId() + "'> " + fornecedor.getNome() + " </option>");
//		}
//		out.println("</select>");
//		
//		out.println("<br />");
//		out.println("<br />");
//		
//
//		out.println("<h4>Produto</h4>");
//		out.println("<select name='idProduto'>");
//
//		out.println("<option value=''> -- Selecione -- </option>");
//
//		for (Produto produto : produtos) {
//			out.println("<option value='" + produto.getId() + "'> " + produto.getNome() + " </option>");
//		}
//		out.println("</select>");
//		
//		out.println("<h4>Quantidade</h4>");
//		out.println("<input type='text' name='quantidade'/>");
//		
//		out.println("<h4>Preco</h4>");
//		out.println("<input type='text' name='preco'/>");
//		
//		out.println("<input type='submit' value='Adicionar'/>");
//		
//		out.println("</form>");
//		
//		out.println("<table align='center' width='680' border='1' cellpadding='1' cellspacing='0'>");
//		out.println("<tr>");
//		out.println("<tr>");
//		out.println("<td align='center'><h4>Codigo</h4></td>");
//		out.println("<td align='center'><h4>Unidade</h4></td>");
//		out.println("<td align='center'><h4>Produto</h4></td>");
//		out.println("<td align='center'><h4>Quantidade</h4></td>");
//		out.println("<td align='center'><h4>Preco</h4></td>");
//		out.println("<td align='center'><h4>Acao</h4></td>");
//		out.println("</tr>");
//		if(compra != null){
//			for (ItemMovimento item : compra.getItemMovimentos()) {
//				out.println("<tr align='center'>");
//				out.println("<td>");
//				out.println(item.getProdutos().getId());
//				out.println("</td>");
//				
//				out.println("<td align='center'>");
//				out.println(item.getProdutos().getUnidade().getNome());
//				out.println("</td>");
//				
//				out.println("<td>");
//				out.println(item.getProdutos().getNome());
//				out.println("</td>");
//				
//				out.println("<td>");
//				out.println(item.getQuantidade());
//				out.println("</td>");
//				
//				out.println("<td align='center'>");
//				out.println("R$ "+item.getPreco());
//				out.println("</td>");
//				
//				out.println("<td>");
//				out.println("</td>");
//			
//			}
//			out.println("</tr>");
//		}
//		out.println("</table>");
//		out.println("</body>");
//		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
