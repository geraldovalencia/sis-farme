package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MovimentoDAO;
import Facada.Facada;
import cadastroClientes.Movimento;
import cadastroClientes.Pessoa;
import cadastroClientes.PessoaFisica;
import cadastroClientes.Venda;

/**
 * Servlet implementation class RelatorioCompraClienteServlet
 */
public class RelatorioCompraClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioCompraClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		String pessoaId = null;
		
		//Recebendo Pagina do JSP------------------------------------------------------
				int qtdePag = Facada.getQtdePagRelatório(); //Lembrar de mudar de acordo com o tipo de servlet e medoto na Facada
				String valorPag = request.getParameter("pag");
				//Verificando a Paginação vinda do JSP
				System.out.println("Numero de Pagina = "+ qtdePag);
				
				Integer pag = null;
				try{
					if (valorPag == null || valorPag.equals("0")) {
						pag = 0;
						pessoaId = request.getParameter("pessoaId");
						if(pessoaId != null && !pessoaId.equals("")){
							session.setAttribute("pessoaId", pessoaId);
						}
						System.out.println("IF - Página igual a null ou 0");
					}
					else{
						pag = Integer.parseInt(valorPag);
						System.out.println("ELSE_ Conversao da Pag-String to INT");
					}
				}
				catch(NumberFormatException e){
					throw new ServletException("Problema com o parâmetro da paginação");
				}
				//-----------------------------------FIM DA PAGINAÇÃO-----------
		
		
		PessoaFisica p = new PessoaFisica();
		List<Venda> v = null;
		
		if( pessoaId != null && !pessoaId.equals("")){
			p = Facada.buscarPessoaFisicaPorId(new Long(pessoaId));
			session.setAttribute("p", p);
			v = Facada.relatorioVendaCliente(p, pag);
			System.out.println("NOME: "+p.getNome());
		}else{
			p = (PessoaFisica)session.getAttribute("p");
			v = Facada.relatorioVendaCliente(p, pag);
		}
//		if(!pessoaId.equals("")){
//			p = Facada.buscarPessoaFisicaPorId(new Long(pessoaId));
//			System.out.println("NOME: "+p.getNome());
//		}
		
//		if(!nomePessoa.equals("")){
//			p = (Pessoa) Facada.buscarpessoaPorNome(nomePessoa);
//		}
		
//		try {
//			v = Facada.relatorioVendaCliente(p);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println("Erro na pesquisa da pessoa.");
//		}
		System.out.println(v);
		session.setAttribute("vendasRelatorio", v);
		session.setAttribute("pessoaIdRelatório", p);
		//Ultimo Detalhe Paginação-------------------------------------
				request.setAttribute("qtdePages", qtdePag);
				System.out.println("DETALHES -------------- PAGINAÇÃO------------------");
				System.out.println("request.setAttribute(\"qtdePages\", qtdePag); == "+qtdePag);
				System.out.println("FIM----- -------------- PAGINAÇÃO------------------");
				//---------------------------------------------FIM DETALHES
		request.getRequestDispatcher("pags/relatorios/consultaVendaCliente.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
