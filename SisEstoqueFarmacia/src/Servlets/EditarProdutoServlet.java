package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

import Facada.Facada;
import cadastroClientes.Categoria;
import cadastroClientes.PessoaJuridica;
import cadastroClientes.Produto;
import cadastroClientes.Unidade;

public class EditarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarProdutoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar um produto diferente.</h5></div>";
		HttpSession session = request.getSession(false);

		Produto p = new Produto();
		
		String idProduto = request.getParameter("idProduto");
		String idProdutoAposEdicao = request.getParameter("idProdutoAposEdicao");
		String novoProduto = request.getParameter("novoProduto");
		String cat = request.getParameter("categoria");
		String unid = request.getParameter("unidade");
		String preco = request.getParameter("preco");
		String qtde_estoque = request.getParameter("qtde_estoque");
		String marca = request.getParameter("marca");

		// Implementar do JSP
		String numeroLoteMedicamento = request
				.getParameter("numeroLoteMedicamento");
		String pessoaJuridica = request.getParameter("pessoaJuridica");
		String registroMSMedicamento = request
				.getParameter("registroMSMedicamento");
		String dataRecebimentoMedicamento = request
				.getParameter("dataRecebimentoMedicamento");

		// Tratando o Request de data para tipo data
		Calendar dataEntrada = null;

		System.out.println("Vai entrar no While");

		if (dataRecebimentoMedicamento == null) {
			System.out.println("Data Vazia, pular conversão agora..");
		} else {
			Date date;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy")
						.parse(dataRecebimentoMedicamento);
				

				dataEntrada = Calendar.getInstance();
				dataEntrada.setTime(date);
				
			} catch (ParseException e) {
				System.out.println("A data em String, não veio Vazia e houve conversão String-Date");
				e.printStackTrace();
			}

		}

		if (idProdutoAposEdicao != null) {
			Produto prod = new Produto();
			prod = Facada.buscarProdutoPorId(new Long(idProdutoAposEdicao));
			prod.setNome(novoProduto);
			Categoria c = Facada.buscarCategoriaPorId(new Long(cat));
			prod.setCategoria(c);// Converte o string do parameter
			Unidade u = Facada.buscarUnidadePorId(new Long(unid));
			prod.setUnidade(u);
			// Relativo a implementar no XML
			prod.setDataRecebimentoMedicamento(dataEntrada);
			prod.setNumeroLoteMedicamento(numeroLoteMedicamento);
			prod.setRegistroMSMedicamento(registroMSMedicamento);
			prod.setMarca(marca);
			// PessoaJuridica pj = Facada.buscarPessoaJuridicaPorId(new
			// PessoaJuridica(pessoaJuridica));
			// prod.setPessoaJuridica(pj);

			prod.setQtde_estoque(new Double(qtde_estoque));
			prod.setPrecovenda(new Double(preco));

			System.out
					.println("====================[Nova Entrada]===========================");
			System.out.println("Nome do Produto: " + cat);
			System.out.println("Categoria do Produto: " + cat);
			System.out.println("Unidade do Produto: " + cat);
			System.out.println("Unidade do produto: " + unid);
			System.out.println("Preço do produto:  " + preco);
			System.out.println("QT: " + qtde_estoque);
			System.out.println("numeroLoteMedicamento:  "
					+ registroMSMedicamento);
			System.out.println("numeroLoteMedicamento: "
					+ numeroLoteMedicamento);
			System.out.println("dataRecebimentoMedicamento: " + dataEntrada);
			System.out
					.println("=========================[FIM]==============================");
			try {
				Facada.alterarProduto(prod);
				session.setAttribute("message", message);
				response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
				
			} catch(Exception e){
				System.out.println("Erro em salvar o produto.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("TelaCadastroProdutoServlet.du");
			}
			return;
		}

		p = Facada.buscarProdutoPorId(new Long(idProduto));
		List<Categoria> categorias = Facada.listarTodasCategorias();
		List<Unidade> unidades = Facada.listarTodasUnidades();
		List<PessoaJuridica> Pjuridicas = Facada.listarTodasPessoaJuridicas();

		request.setAttribute("produtoEditar", p);
		request.setAttribute("categorias", categorias);
		request.setAttribute("unidades", unidades);
		request.setAttribute("Pjuridicas", Pjuridicas);

		request.getRequestDispatcher("/pags/produtos/editarProduto.jsp").forward(
				request, response);
		
		
		// out.println("<html>");
		// out.println("<head>");
		// out.println("</head>");
		// out.println("</body>");
		// out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
		// out.println("<h3 align='center' >Cadastrar Produto</h3>");
		// ///listarProdutoServlet.du
		// out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
		//
		// out.println("<form method='post' action='TelaCadastroProdutoServlet.du'>");
		//
		// out.println("<h4>Categoria</h4>");
		// out.println("<select name='categoria'>");
		// out.println("<option value=''> -- Selecione -- </option>");
		//
		// for (Categoria categoria : categorias) {
		// out.println("<option value='" + categoria.getId() + "'> " +
		// categoria.getNome() + " </option>");
		// }
		// out.println("</select>");
		// out.println("<br />");
		// out.println("<h4>Unidade</h4>");
		// out.println("<select name='unidade'>");
		// out.println("<option value=''> -- Selecione -- </option>");
		//
		// for (Unidade unidade : unidades) {
		// out.println("<option value='" + unidade.getId() + "'> " +
		// unidade.getNome() + " </option>");
		// }
		// out.println("</select>");
		// out.println("<br />");
		// out.println("<br />");
		// out.println("Novo Produto: <input type='text' name='novoProduto'>");
		// out.println("<br />");
		// out.println("<br />");
		// //---------------------------------------------------------------
		// out.println("Preco:<input type='text' name='preco' />");
		// out.println("<br />");
		// out.println("<br />");
		// out.println("Quantidade: <input type='text' name='qtdade'>");
		// out.println("<br />");
		// out.println("<br />");
		// out.println("<br />");
		// out.println("<input type='submit' value='Salva'>");
		//
		// out.println("</form>");
		//
		// out.println("</body>");
		// out.println("</html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
