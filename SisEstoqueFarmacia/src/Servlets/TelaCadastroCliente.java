package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facada.Facada;
import cadastroClientes.Endereco;
import cadastroClientes.PessoaFisica;
import cadastroClientes.PessoaJuridica;
import cadastroClientes.Uf;

/**
 * Servlet implementation class TelaCadastroCliente
 */
public class TelaCadastroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TelaCadastroCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar um cliente diferente.</h5></div>";
		HttpSession session = request.getSession(false);
		
		
		String filtro = request.getParameter("filtro");
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
		
		
	
		if(filtro != null && !filtro.equals("")){
			PessoaFisica pf = new PessoaFisica();
			Endereco end = new Endereco();
			end.setBairro(bairro);
			end.setCep(cep);
			end.setCidade(cidade);
			end.setNumero(numero);
			end.setEstado(estado);
			end.setRua(rua);
			
			pf.setNome(filtro);
			pf.setCelular(celular);
			pf.setEmal(emal);
			pf.setEndereco(end);
			pf.setCpf(cpf);
			pf.setTelefone(telefone);
			
			pf.setRg(rg);
			pf.setUf(Uf.valueOf(uf));
			pf.setOrgaoExpedidor(orgaoExpedidor);
			
			try {
				Facada.cadastrarPessoaFisica(pf);
				session.setAttribute("message", message);
				response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
				
			} catch(Exception e){
				System.out.println("Erro em salvar o Cliente.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("TelaCadastroCliente.du");
			}
			return;
		}
		
		
		
		request.setAttribute("filtro", filtro);
		request.setAttribute("celular", celular);
		request.setAttribute("emal", emal);
		request.setAttribute("cpf", cpf);
		request.setAttribute("telefone", telefone);
		request.setAttribute("rua", rua);
		request.setAttribute("cep", cep);
		request.setAttribute("bairro", bairro);
		request.setAttribute("cidade", cidade);
		request.setAttribute("numero", numero);
		request.setAttribute("estado", estado);
		request.setAttribute("rg", rg);
		request.setAttribute("uf", uf);
		request.setAttribute("ufs", Uf.values());
		request.setAttribute("orgaoExpedidor", orgaoExpedidor);
		
		request.getRequestDispatcher("pags/clientes/novoCliente.jsp").forward(request, response);
						
		
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");	
//		out.println("<body>");
//		out.println("<h1 align='center' >SIS Estoque Farmacia</h1></td>");
//		out.println("<h3 align='center' >Cadastrar Cliente</h3>");
//		///listarProdutoServlet.du
//		out.println("<td align='center'><h4><a href='/SisEstoqueFarmacia/ListarProdutoServlet.du'>Voltar</a></h4></td>");
//		out.println("<form method='get' action='/SisEstoqueFarmacia/TelaCadastroCliente.du'>");
//
//		out.println("Inserir Cliente: <input type='text' name='filtro' value='"+(filtro != null && !filtro.equals("")? filtro : "")+"'>");
//		out.println("<br />");
//		out.println("Celular: <input type='text' name='celular' value='"+(celular != null && !celular.equals("")? celular : "")+"'>");
//		out.println("<br />");
//		out.println("Email: <input type='text' name='emal' value='"+(emal != null && !emal.equals("")? emal : "")+"'>");
//		out.println("CPF: <input type='text' name='cpf' value='"+(cpf != null && !cpf.equals("")? cpf : "")+"'>");
//		out.println("<br />");
//		out.println("Telefone: <input type='text' name='telefone' value='"+(telefone != null && !telefone.equals("")? telefone : "")+"'>");
//		out.println("<br />");
//		out.println("Rua: <input type='text' name='rua' value='"+(rua != null && !rua.equals("")? rua : "")+"'>");
//		out.println("<br />");
//		out.println("Numero: <input type='text' name='numero' value='"+(numero != null && !numero.equals("")? numero : "")+"'>");
//		out.println("<br />");
//		out.println("Cep: <input type='text' name='cep' value='"+(cep != null && !cep.equals("")? cep : "")+"'>");
//		out.println("<br />");
//		out.println("Bairro: <input type='text' name='bairro' value='"+(bairro != null && !bairro.equals("")? bairro : "")+"'>");
//		out.println("<br />");
//		out.println("Cidade: <input type='text' name='cidade' value='"+(cidade != null && !cidade.equals("")? cidade : "")+"'>");
//		out.println("<br />");
//		out.println("Estado: <input type='text' name='estado' value='"+(estado != null && !estado.equals("")? estado : "")+"'>");
//		out.println("<br />");
//		out.println("<input type='submit' value='Inserir Cliente'>");
//		out.println("</form><br />");
//		
//		out.println("</body>");
//		out.println("</html>");
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
