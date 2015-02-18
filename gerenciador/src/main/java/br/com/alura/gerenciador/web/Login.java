package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email;
		String senha;
		
		email = request.getParameter("email");
		senha = request.getParameter("senha");
		
		Usuario usu = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer = response.getWriter();
		
		if (usu == null) {
			writer.println("<html><body>Usuário ou senha inválido</body></html>");
		} else {
			Cookie cookie = new Cookie("usuario.logado", email);
			response.addCookie(cookie);
			writer.println("<html><body>Usuário " + email + " logado</body></html>");
		}
		
	}

}
