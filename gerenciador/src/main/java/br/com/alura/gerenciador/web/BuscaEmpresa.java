package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


public class BuscaEmpresa implements Tarefa {

	public String executa(HttpServletRequest req, HttpServletResponse resp)	 {
		
		String argumento = req.getParameter("argumento");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(argumento);

		req.setAttribute("empresas", empresas);
		
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
		
	}
}
