

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet(urlPatterns="/NovaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaEmpresa() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		request.setAttribute("nome", nome);
		request.getRequestDispatcher("/WEB-INF/paginas/NovaEmpresa.jsp").forward(request, response);
		
	}


}
