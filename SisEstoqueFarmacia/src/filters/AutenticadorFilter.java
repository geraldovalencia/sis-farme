package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cadastroClientes.Usuario;

/**
 * Servlet Filter implementation class AutenticadorFilter
 */
public class AutenticadorFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("usuarioLogado");
		
		int i = req.getSession().getAttribute("i") == null ? 0 : (Integer) req.getSession().getAttribute("i");
		
		
		if(session == null){
			System.out.println("Sessão Nula, retorna Login");
			resp.sendRedirect("/SisEstoqueFarmacia/");
			return;
		}
		if(usuarioLogado == null){
			resp.sendRedirect("/SisEstoqueFarmacia/");
			System.out.println("usuario Logado é: "+ usuarioLogado + " Então, volta Login!");
			return;
		}else{
		i++;
		req.getSession().setAttribute("i", i);
		chain.doFilter(request, response);
		
		if(i == 1){
			System.out.println("-----------------------------------------------");
			System.out.println("FILTRADO POR: Geraldo - AtenticarFilter");
			System.out.println("-----------------------------------------------");
			System.out.println("usuario Logado: "+ usuarioLogado.getNome());
			System.out.println("usuario Tipo: "+ usuarioLogado.getTipo());
			}
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}