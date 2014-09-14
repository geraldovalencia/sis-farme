package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Endereco;
import cadastroClientes.PessoaFisica;
import cadastroClientes.PessoaFisica;
import cadastroClientes.PessoaJuridica;
import cadastroClientes.Uf;

/**
 * Servlet implementation class EditarClientes
 */
public class EditarClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	PessoaFisica pessoa = null;
    	
		String idpessoaFisica = request.getParameter("idpessoaFisica");
		String idPessoaTelaEdicao = request.getParameter("idpessoaAposEdicao");
		String nome = request.getParameter("nome");
		String celular = request.getParameter("celular");
		String emal = request.getParameter("emal");
		String cpf = request.getParameter("cpf");
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
			pessoa = Facada.buscarPessoaFisicaPorId(Long.parseLong(idPessoaTelaEdicao));
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
			pessoa.setCpf(cpf);
			pessoa.setEmal(emal);
			pessoa.setTelefone(telefone);
			
			pessoa.setRg(rg);
			pessoa.setUf(Uf.valueOf(uf));
			pessoa.setOrgaoExpedidor(orgaoExpedidor);
			
			Facada.alterarPessoaFisica(pessoa);
			response.sendRedirect("/SisEstoqueFarmacia/ListarClientes.du");
			return;
			
		}
		PessoaFisica p = Facada.buscarPessoaFisicaPorId(new Long(idpessoaFisica));
		request.setAttribute("ufs", Uf.values());
		request.setAttribute("pessoa", p);
		request.getRequestDispatcher("pags/clientes/editarCliente.jsp").forward(request, response);	
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
