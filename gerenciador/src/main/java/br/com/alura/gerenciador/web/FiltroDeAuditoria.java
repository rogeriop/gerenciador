package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario.logado");
		if (usuarioLogado==null) {
			System.out.println("Usuário deslogado acessando a URI " + uri);
		} else {
			System.out.println("Usuário " + usuarioLogado.getEmail()  + " acessando a URI " + uri);
		}
		
//		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
//		HttpServletResponse resp = (HttpServletResponse) response;
//		if (cookie == null) {
//			System.out.println("Usuário deslogado acessando a URI " + uri);
//		} else {
//			cookie.setMaxAge(60 * 10);
//			resp.addCookie(cookie);
//			System.out.println("Usuário " + cookie.getValue()  + " acessando a URI " + uri);
//		}
		chain.doFilter(request, response);
	}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
