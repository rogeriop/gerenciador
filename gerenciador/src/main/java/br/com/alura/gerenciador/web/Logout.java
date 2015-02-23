package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
//		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		HttpSession session = req.getSession();
		session.removeAttribute("usuario.logado");
		PrintWriter writer = resp.getWriter();
//		if (cookie == null) {
			writer.println("<html><body>Usuário não estava logado</body></html>");
			
//		} else {
		
//			cookie.setMaxAge(0);
//			resp.addCookie(cookie);
			
//		}
	}

}
