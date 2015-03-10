package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
public class Login implements Tarefa {

	public String executa(HttpServletRequest request, HttpServletResponse response)  {
		String email;
		String senha;
		
		email = request.getParameter("email");
		senha = request.getParameter("senha");
		
		Usuario usu = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		if (usu == null) {
			return "/WEB-INF/paginas/loginNaoEfetuado.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usu);
			return "/WEB-INF/paginas/loginEfetuado.jsp";
		}
		
	}

}
