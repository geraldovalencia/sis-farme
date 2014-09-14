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
import cadastroClientes.Unidade;

import com.google.gson.Gson;

/**
 * Servlet implementation class AutoCompleteunidadeservlet
 */
public class AutoCompleteUnidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompleteUnidadeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");	
		List<Unidade> unidades = new ArrayList<Unidade>();
		if(filtro != null && !filtro.equals("")){
			unidades = Facada.buscarunidadePorNome(filtro);
		}
		else{
			unidades = Facada.listarTodasUnidades();
		}
		
		Map<String,String> mapa = new LinkedHashMap<String, String>();
		
		for (Unidade unidade : unidades) {
			mapa.put(String.valueOf(unidade.getId()), unidade.getNome());
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
