package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facada.Facada;
import cadastroClientes.PessoaFisica;

import com.google.gson.Gson;

/**
 * Servlet implementation class AutoCompleteClienteServlet
 */
public class AutoCompleteClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompleteClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");	
		List<PessoaFisica> fisicas = new ArrayList<PessoaFisica>();
		if(filtro != null && !filtro.equals("")){
			fisicas = Facada.buscarPessoaFisicaPorNome(filtro);
		}
		else{
			fisicas = Facada.listarTodasPessoaFisicas();
		}
		
		Map<String,String> mapa = new LinkedHashMap<String, String>();
		
		
		for (PessoaFisica pessoaFisica : fisicas) {
			mapa.put(String.valueOf(pessoaFisica.getId()), pessoaFisica.getNome());
			System.out.println(pessoaFisica.getId() + " : " + mapa.put(String.valueOf(pessoaFisica.getId()), pessoaFisica.getNome()));
		}
		
		String json = null;
		
		json = new Gson().toJson(mapa);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
