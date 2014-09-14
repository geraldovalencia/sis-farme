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

import Facada.Facada;
import cadastroClientes.Pessoa;
import cadastroClientes.Usuario;
import cadastroClientes.Venda;
import cadastroClientes.ItemMovimento;
import cadastroClientes.PessoaFisica;
import cadastroClientes.Produto;
import cadastroClientes.Venda;

/**
 * Servlet implementation class TelaCadastroVendaServlet
 */
public class TelaCadastroVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TelaCadastroVendaServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Venda realizada com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar um vendedor diferente.</h5></div>";
		
		
		System.out.println("-----------------------------------------------");
		System.out.println("----- (1) abriu sevlet venda------");
		String produtoNome =  request.getParameter("produtoNome");//Nome do Produto
		String idProduto =  request.getParameter("codigoProduto");//ID do Produto
		String idUsuario = request.getParameter("idUsuario");
		String codigoClienteVenda = request.getParameter("codigoCliente");
		
		String data = (String) request.getSession().getAttribute("dataAtual");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		  
		Date dataVenda = null;
		PessoaFisica pf=null;
		
		if (data!= null){
			try {
				dataVenda = sdf.parse(data);
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
		
		
		if(codigoClienteVenda != null){
			
			pf = Facada.buscarPessoaFisicaPorId(new Long(codigoClienteVenda));
		}
		
		if(idProduto != null && codigoClienteVenda != null){
			System.out.println("-----------------------------------------------");
			System.out.println("Produto id: " +  idProduto);
			Produto pd = Facada.buscarProdutoPorId(new Long(idProduto));
			
			System.out.println("Produto Nome: " +  pd.getNome());
			System.out.println("Produto Nome vindo da Venda: " +  produtoNome);
			System.out.println("Produto Preço: R$" +  pd.getPrecovenda());
			System.out.println("Quantidade: " +  quantidade);
			System.out.println("Preço Total do Produto: R$" +  pd.getPrecovenda() * quantidade);
			System.out.println("Nome do Cliente: " +  pf.getNome());
			System.out.println("Data da Venda: " +  dataVenda);
			
			System.out.println("-----------------------------------------------");
		}
		
		Venda venda =  (Venda) request.getSession().getAttribute("venda");
		
		if(venda == null){
			System.out.println("----- (3) Verificação de Venda Nula!");
			Venda c = new Venda();
			c.setItemMovimentos(new ArrayList<ItemMovimento>());
			request.getSession().setAttribute("venda",c);
			System.out.println("----- (4) criou venda na sessão e setou array de itensMov.");
		}
		
			if(idProduto != null && quantidade > 0){
				ItemMovimento item = new ItemMovimento();
				item.setMovimento(venda); //Setou Tipo de Movimento
				
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
//						response.sendRedirect("TelaCadastroVendaServlet.du");
//					}
//				}
				
				//Setou na venda o item de movimento
				venda.getItemMovimentos().add(item);
				venda.setData(dataVenda);
				venda.setUsuario(user);
				venda.setPf(pf);
				request.getSession().setAttribute("venda", venda);
			}
		
		System.out.println("----- (5) Fez listagem de Pessoas Fisicas, Produtos.");
	    List<PessoaFisica> fisicas = Facada.listarTodasPessoaFisicas();
	    List<Produto> produtos = Facada.listarTodosProdutos();
	    
		System.out.println("----- (6) Setou os atributos no request -> JSP");
	    request.getSession().setAttribute("fisicas", fisicas);
	    request.getSession().setAttribute("produtos", produtos);
	    request.getSession().setAttribute("quantidade", quantidade);
	    request.getSession().setAttribute("dataVenda", dataVenda);
	    
		request.getRequestDispatcher("pags/venda/novaVenda.jsp")
		.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
