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
import cadastroClientes.PessoaJuridica;
import cadastroClientes.Unidade;

import com.google.gson.Gson;

/**
 * Servlet implementation class AutoCompleteFornecedorServlet
 */
public class AutoCompleteFornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompleteFornecedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");	
		
		List<PessoaJuridica> juridicas = new ArrayList<PessoaJuridica>();
		
		if(filtro != null && !filtro.equals("")){
			juridicas = Facada.buscarPessoaJuridicaPorNome(filtro);
		}
		else{
			juridicas = Facada.listarTodasPessoaJuridicas();
		}
		
		Map<String,String> mapa = new LinkedHashMap<String, String>();
		
		for (PessoaJuridica pessoaJuridica : juridicas) {
			mapa.put(String.valueOf(pessoaJuridica.getId()), pessoaJuridica.getNome());
		}
		
		String json = null;
		
		json = new Gson().toJson(mapa);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
