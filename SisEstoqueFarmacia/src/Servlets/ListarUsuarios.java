package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.Usuario;

public class ListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListarUsuarios() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filtro = request.getParameter("filtro");
		int iCont = request.getSession().getAttribute("iCont") == null ? 0 : (Integer) request.getSession().getAttribute("iCont");
		
		//Recebendo Pagina do JSP------------------------------------------------------
				int qtdePag = Facada.getQtdePag();
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
		
		
		List<Usuario> usuarios = null;
		
		
		if(filtro != null && !filtro.equals("")){
			usuarios = Facada.buscarUsuarioPorNome(filtro);
		}
		else{
			usuarios = Facada.listarUsuariosLimitados(pag);// Mudou para o listar limitados	
		}
		iCont++;
		request.getSession().setAttribute("iCont", iCont);
		request.setAttribute("usuarios", usuarios);
		if(iCont == 1){
			System.out.println("-----------------------------------------------");
			System.out.println("Abrir Listagem de Usuários          ");
			System.out.println("-----------------------------------------------");
			for (Usuario usuario : usuarios) {
				System.out.println("O id : " + usuario.getId()
					+ "\nNome: " + usuario.getNome().toString() + 
					"\n-----------------------------------------------");
			}
				
		}
		//Ultimo Detalhe Paginação-------------------------------------
				request.setAttribute("qtdePages", qtdePag);
				System.out.println("DETALHES -------------- PAGINAÇÃO------------------");
				System.out.println("request.setAttribute(\"qtdePages\", qtdePag); == "+qtdePag);
				System.out.println("qtde de indices? "+usuarios.size());
				System.out.println("FIM----- -------------- PAGINAÇÃO------------------");
				//---------------------------------------------FIM DETALHES
		request.getRequestDispatcher("pags/usuario/listarUsuarios.jsp").forward(request, response);
	}

}
