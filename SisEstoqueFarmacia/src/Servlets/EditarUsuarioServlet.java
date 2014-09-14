package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facada.Facada;
import cadastroClientes.Administrador;
import cadastroClientes.Categoria;
import cadastroClientes.Endereco;
import cadastroClientes.Farmaceutico;
import cadastroClientes.Gerente;
import cadastroClientes.PessoaJuridica;
import cadastroClientes.Tipo;
import cadastroClientes.Usuario;
import cadastroClientes.Vendedor;
public class EditarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Tipo ADMINISTRADOR = null;

	public EditarUsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Usuario userEdit = null;
		
		
		String idUserAposEdicao = request.getParameter("idUserAposEdicao");
		
		String idusuario = (String) request.getSession().getAttribute(("idusuario"));

		// Pegando os valores após a edição para persistir

		// VALORES GENÉRICOS----------------------------------------------------
		String nome = request.getParameter("nome");
		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");
		
		// VALORES DE ADM-------------------------------------------------------
		String empresaTerceirizada = request.getParameter("empresaTerceirizada");
		
		// VALORES DE FARMACEUTICO-----------------------------------------------
		String crf = request.getParameter("crf");
		String titulacao = request.getParameter("titulacao");
		
		// VALORES DE GERENTE e VENDEDOR-----------------------------------------------
		String setor = request.getParameter("setor");
		String setorVendedor = request.getParameter("setorVendedor");
		
		//MENSAGEM DE ERRO
		String message = "<div style='width:20%' align='center' class='alert alert-warning'><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div style='width:20%' align='center' class='alert alert-danger'><h5>Erro! Tente cadastrar um usuário diferente.</h5></div>";

		//Usa a sessão EXistente
		HttpSession session = request.getSession(false);

		if (idUserAposEdicao != null && !idUserAposEdicao.equals("")) {
			
			userEdit = Facada.buscarUsuarioPorId(Long.parseLong(idUserAposEdicao));
			
			if(userEdit instanceof Administrador){
				Administrador adm = Facada.buscarAdmPorId(Long.parseLong(idUserAposEdicao));
				System.out.println("EDITOU em Instaceof o Tipo em Usuário");
				adm.setSenha(senha);
				adm.setTipo(Tipo.ADMINISTRADOR);
				adm.setNome(nome);
				adm.setMatricula(matricula);
				adm.setEmpresaTerceirizada(empresaTerceirizada);
				adm.setCpf(cpf);
				userEdit = adm;
			}else if(userEdit instanceof Farmaceutico){
				Farmaceutico far = Facada.buscarFarmaceuticoPorId(Long.parseLong(idUserAposEdicao));
				System.out.println("EDITOU em Instaceof o Tipo em Farmaceutico");
				far.setSenha(senha);
				far.setTipo(Tipo.FARMACEUTICO);
				far.setNome(nome);
				far.setMatricula(matricula);
				far.setCrf(crf);
				far.setTitulacao(titulacao);
				far.setCpf(cpf);
				userEdit = far;
			}else if(userEdit instanceof Gerente){
				Gerente ger = Facada.buscarGerentePorId(Long.parseLong(idUserAposEdicao));
				System.out.println("EDITOU em Instaceof o Tipo em Gerente");
				ger.setSenha(senha);
				ger.setTipo(Tipo.GERENTE);
				ger.setNome(nome);
				ger.setMatricula(matricula);
				ger.setSetor(setor);
				ger.setCpf(cpf);
				userEdit = ger;
			}else if(userEdit instanceof Vendedor){
				Vendedor ven = Facada.buscarVendedorPorId(Long.parseLong(idUserAposEdicao));
				System.out.println("EDITOU em Instaceof o Tipo em Vendedor");
				ven.setSenha(senha);
				ven.setTipo(Tipo.VENDEDOR);
				ven.setNome(nome);
				ven.setMatricula(matricula);
				ven.setSetorVendedor(setorVendedor);
				ven.setCpf(cpf);
				userEdit = ven;
			}
			
			try{
				Facada.AlterarUsuario(userEdit);
				session.setAttribute("message", message);
				response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
			}catch(Exception e){
				System.out.println("Erro em salvar o Usuário.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("ListarUsuarios.du");
			}
			return;
		}
		
		Usuario usuarioSessao = Facada.buscarUsuarioPorId(new Long(idusuario));
		Farmaceutico farma = Facada.buscarFarmaceuticoPorId(new Long(idusuario));
		Administrador adm = Facada.buscarAdmPorId(new Long(idusuario));
		Gerente ger = Facada.buscarGerentePorId(new Long(idusuario));
		Vendedor ven = Facada.buscarVendedorPorId(new Long(idusuario));
		
		request.setAttribute("userEdit", usuarioSessao);
		request.setAttribute("farmaceutico", farma);
		request.setAttribute("adm", adm);
		request.setAttribute("ger", ger);
		request.setAttribute("ven", ven);
		request.getSession().removeAttribute(idusuario);
		
		
		//ajustar para onde vai mandar o request, pois ele manda qualquer user para essa pagina
		//ideia, tentar usar os C:if do jstl na pagina assim como foi feito com o menu
		//Ta pegando a edição
		
		
		request.getRequestDispatcher("pags/usuario/editarUsuario.jsp").forward(
				request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
