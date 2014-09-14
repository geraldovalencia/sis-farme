package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Produto;
import cadastroClientes.Venda;

public class ListarVendasServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListarVendasServet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String vendaId = request.getParameter("vendaId");	

//
		List<Venda> vendasListagem = new ArrayList<Venda>();
		
		
		//Recebendo Pagina do JSP------------------------------------------------------
		int qtdePag = Facada.getQtdeVendasPag();
		String valorPag = request.getParameter("pag");
		//Verificando a Pagina��o vinda do JSP
		System.out.println("Numero de Pagina = "+ qtdePag);
		
		Integer pag = null;
		try{
			if (valorPag == null || valorPag.equals("0")) {
				pag = 0;
				System.out.println("IF - P�gina igual a null ou 0");
			}
			else{
				pag = Integer.parseInt(valorPag);
				System.out.println("ELSE_ Conversao da Pag-String to INT");
			}
		}
		catch(NumberFormatException e){
			throw new ServletException("Problema com o par�metro da pagina��o");
		}
		//-----------------------------------FIM DA PAGINA��O-----------

		
		//Ultimo Detalhe Pagina��o-------------------------------------
		request.setAttribute("qtdePages", qtdePag);
		System.out.println("DETALHES -------------- PAGINA��O------------------");
		System.out.println("request.setAttribute(\"qtdePages\", qtdePag); == "+qtdePag);
		System.out.println("qtde de indices? "+vendasListagem.size());
		System.out.println("FIM----- -------------- PAGINA��O------------------");
		
		vendasListagem = Facada.listarVendasLimitadas(pag);
		List <Venda> todasVendas = Facada.listarTodasVendas();
		double totalDeVenda = 0;
		for (Venda venda : todasVendas) {
			double vendaValor = venda.getTotal();
			totalDeVenda += vendaValor;
		}
		request.setAttribute("vendasListagem", vendasListagem);
		request.setAttribute("totalDeVenda", totalDeVenda);
		
		request.getRequestDispatcher("pags/venda/listarVendas.jsp").forward(request, response);
		
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
