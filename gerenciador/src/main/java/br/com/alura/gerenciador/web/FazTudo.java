package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="FazTudo")
public class FazTudo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String tarefa =req.getParameter("tarefa");
		System.out.println("Passei 1");
		
		if (tarefa == null) throw new IllegalArgumentException("Tarefa não informada!");
		try {
			String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
			Class tipo = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) tipo.newInstance();
			String pagina = instancia.executa(req, resp);
			System.out.println("Passei 2");
			req.getRequestDispatcher(pagina).forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
	}
}
