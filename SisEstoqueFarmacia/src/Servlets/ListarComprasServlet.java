package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Compra;
import cadastroClientes.Venda;

public class ListarComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListarComprasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Compra> comprasListagem = new ArrayList<Compra>();
		
		//Recebendo Pagina do JSP------------------------------------------------------
				int qtdePag = Facada.getQtdeComprasPag();
				String valorPag = request.getParameter("pag");
				//Verificando a Paginação vinda do JSP
				System.out.println("Numero de Pagina = "+ qtdePag);
				
				Integer pag = null;
				try{
					if (valorPag == null || valorPag.equals("0")) {
						pag = 0;
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
		
		
		
		comprasListagem = Facada.listarComprasLimitadas(pag);
		
		List <Compra> todasCompras = Facada.listarTodasCompras();
		double totalDeCompra = 0;
		for (Compra compra : todasCompras) {
			double vendaValor = compra.getTotal();
			totalDeCompra += vendaValor;
		}
		
		//Ultimo Detalhe Paginação-------------------------------------
				request.setAttribute("qtdePages", qtdePag);
				System.out.println("DETALHES -------------- PAGINAÇÃO------------------");
				System.out.println("request.setAttribute(\"qtdePages\", qtdePag); == "+qtdePag);
				System.out.println("qtde de indices? "+comprasListagem.size());
				System.out.println("FIM----- -------------- PAGINAÇÃO------------------");
				//---------------------------------------------FIM DETALHES
		
		request.setAttribute("comprasListagem", comprasListagem);
		request.setAttribute("totalDeCompra", totalDeCompra);
		
		request.getRequestDispatcher("pags/compra/listarCompras.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
