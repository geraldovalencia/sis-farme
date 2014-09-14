package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.*;

public class EditarFornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarFornecedorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
				
		PessoaJuridica pessoa = null;
		String idpessoaJuridica = request.getParameter("idpessoaJuridica");
		String idPessoaTelaEdicao = request.getParameter("idpessoaAposEdicao");
		String nome = request.getParameter("nome");
		String celular = request.getParameter("celular");
		String emal = request.getParameter("emal");
		String cnpj = request.getParameter("cnpj");
		String telefone = request.getParameter("telefone");
		String rua = request.getParameter("rua");
		String cep = request.getParameter("cep");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String numero = request.getParameter("numero");
		String estado = request.getParameter("estado");
		
		String rg = request.getParameter("rg");
		String uf = request.getParameter("uf");
		String orgaoExpedidor = request.getParameter("orgaoExpedidor");

		if (idPessoaTelaEdicao != null && !idPessoaTelaEdicao.equals("")) {
			pessoa = Facada.buscarPessoaJuridicaPorId(Long.parseLong(idPessoaTelaEdicao));
			Endereco end = new Endereco();
			end.setRua(rua);
			end.setNumero(numero);
			end.setCep(cep);
			end.setBairro(bairro);
			end.setCidade(cidade);
			end.setEstado(estado);
			pessoa.setEndereco(end);
			pessoa.setNome(nome);
			pessoa.setCelular(celular);
			pessoa.setCnpj(cnpj);
			pessoa.setEmal(emal);
			pessoa.setTelefone(telefone);
			
			pessoa.setRg(rg);
			pessoa.setUf(Uf.valueOf(uf));
			pessoa.setOrgaoExpedidor(orgaoExpedidor);
			
			Facada.alterarPessoaJuridica(pessoa);
			response.sendRedirect("/SisEstoqueFarmacia/ListarFornecedorServlet.du");
			return;
			
		}
		request.setAttribute("ufs", Uf.values());
		PessoaJuridica p = Facada.buscarPessoaJuridicaPorId(new Long(idpessoaJuridica));
		request.setAttribute("pessoa", p);
		request.getRequestDispatcher("pags/fornecedores/editarFornecedor.jsp").forward(request, response);
			
		
//		out.println("<h1 align='center' >SIS Estoque Farmacia</h1>");
//		out.println("<h3 align='center' >Editar Fornecedor</h3>");
//		
//		out.println("<div align='center' >");//DIV---------------------
//		// /listarProdutoServlet.du
//		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//		out.println("<form method='get' action='/SisEstoqueFarmacia/EditarFornecedorServlet.du'>");
//		out.println("Id Fornecedor: <input type='text' name='idpessoaJuridica' value='"
//				+ (pessoa != null ? pessoa.getId() : null) + "'/>");
//		out.println("<br />");
//		out.println("Nome: <input type='text' name='nome' value='"
//				+ (pessoa != null ? pessoa.getNome() : "") + "'/>");
//		out.println("<br />");
//		out.println("Email: <input type='text' name='emal' value='"
//				+ (pessoa != null ? pessoa.getEmal() : "") + "'/>");
//		out.println("CNPJ: <input type='text' name='cnpj' value='"
//				+ (pessoa != null ? pessoa.getCnpj() : "") + "'/>");
//		out.println("<br />");
//		out.println("Telefone: <input type='text' name='telefone' value='"
//				+ (pessoa != null ? pessoa.getTelefone() : "") + "'/>");
//		out.println("<br />");
//		out.println("Celular: <input type='text' name='celular' value='"
//				+ (pessoa != null ? pessoa.getCelular(): null) + "'/>");
//		out.println("<br />");
//		out.println("Rua: <input type='text' name='rua' value='"
//				+ (pessoa != null ? pessoa.getEndereco().getRua() : null) + "'/>");
//		out.println("<br />");
//		out.println("Numero: <input type='text' name='numero' value='"
//				+ (pessoa != null ? pessoa.getEndereco().getNumero() : null) + "'/>");
//		out.println("<br />");
//		out.println("CEP: <input type='text' name='cep' value='"
//				+ (pessoa != null ? pessoa.getEndereco().getCep() : null) + "'/>");
//		out.println("<br />");
//		out.println("Bairro: <input type='text' name='bairro' value='"
//				+ (pessoa != null ? pessoa.getEndereco().getBairro() : null) + "'/>");
//		out.println("<br />");
//		out.println("Cidade: <input type='text' name='cidade' value='"
//				+ (pessoa != null ? pessoa.getEndereco().getCidade() : null) + "'/>");
//		out.println("<br />");
//		out.println("Estado: <input type='text' name='estado' value='"
//				+ (pessoa != null ? pessoa.getEndereco().getEstado(): null) + "'/>");
//		out.println("<br />");
//		out.println("<br />");
//		
//		
//		
//		out.println("<input type='submit' value='Editar Fornecedor' name='botao'/>");
//		out.println("</form><br />");
//		out.println("</div>");//DIV---------------------;
//		out.println("</body>");
//		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
//
//		PrintWriter out = response.getWriter();
//		Pessoa pessoa = null;
//		PessoaJuridica pjur = null;
//		String id = request.getParameter("idpessoaJuridica");
//
//		if (id != null && !id.equals("")) {
//			pessoa = Facada.buscarPessoaPorId(new Long(id));
//
//		}
//		String nome = request.getParameter("nome");
//
//		if (nome != null && !nome.equals("")) {
//			Pessoa p1 = new Pessoa();
//			p1.setNome(nome);
//			Facada.salvarPessoa(p1);
//			request.setAttribute("msg", "Pessoa cadastrada com sucesso");
//			request.getRequestDispatcher("ListarFornecedorServlet.du").forward(
//					request, response);
//
//			return;
//		}
//
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
//		// /listarProdutoServlet.du
//		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//		out.println("<form method='get' action='/SisEstoqueFarmacia/EditarFornecedorServlet.du'>");
//
//		out.println("Id Fornecedor: <input type='text' name='idpessoaJuridica' value='"
//				+ (pjur != null ? pessoa.getId() : null) + "'/>");
//		out.println("<br />");
//		out.println("Nome: <input type='text' name='nome' value='"
//				+ (pessoa != null ? pessoa.getNome() : "") + "'/>");
//		out.println("<br />");
//		out.println("Email: <input type='text' name='emal' value='"
//				+ (pessoa != null ? pessoa.getEmal() : "") + "'/>");
//		out.println("CNPJ: <input type='text' name='cnpj' value='"
//				+ (pessoa != null ? pjur.getCnpj() : "") + "'/>");
//		out.println("<br />");
//		out.println("Telefone: <input type='text' name='telefone' value='"
//				+ (pessoa != null ? pessoa.getTelefone() : "") + "'/>");
//		out.println("<br />");
//		out.println("<input type='submit' value='Inserir Fornecedor'/>");
//		out.println("</form><br />");
//
//		out.println("</body>");
//		out.println("</html>");
	}

}
