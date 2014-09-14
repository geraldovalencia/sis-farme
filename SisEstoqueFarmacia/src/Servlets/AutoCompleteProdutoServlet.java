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
import cadastroClientes.Produto;

import com.google.gson.Gson;

public class AutoCompleteProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AutoCompleteProdutoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filtro = request.getParameter("filtro");	
		List<Produto> produtos = new ArrayList<Produto>();
		if(filtro != null && !filtro.equals("")){
			produtos = Facada.buscarProdutoPorNome(filtro);
		}
		else{
			produtos = Facada.listarTodosProdutos();
		}
		
		Map<String,String> mapa = new LinkedHashMap<String, String>();
		
		for (Produto produto : produtos) {
			mapa.put(String.valueOf(produto.getId()), produto.getNome());
			System.out.println(produto.getId() + " : " + produto.getNome());
		}
		
		String json = null;
		
		json = new Gson().toJson(mapa);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
