package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {
	
	final Cookie[] cookies;
	public Cookies (Cookie[] cookies) {
		this.cookies = cookies;
	}
	
	public Cookie getUsuarioLogado() {
		if (cookies == null) {
			return null;
		}
		for(Cookie co :cookies) {
			if (co.getName().equals("usuario.logado")) {
				return co;
			}
		}
		return null;

	}
	
}
