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
import cadastroClientes.Categoria;
import cadastroClientes.Produto;

import com.google.gson.Gson;

/**
 * Servlet implementation class AutoCompleteCategoriaServlet
 */
public class AutoCompleteCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompleteCategoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");	
		List<Categoria> categorias = new ArrayList<Categoria>();
		if(filtro != null && !filtro.equals("")){
			categorias = Facada.buscarCategoriaPorNome(filtro);
		}
		else{
			categorias = Facada.listarTodasCategorias();
		}
		
		Map<String,String> mapa = new LinkedHashMap<String, String>();
		
		for (Categoria categoria : categorias) {
			mapa.put(String.valueOf(categoria.getId()), categoria.getNome());
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
