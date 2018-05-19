package br.com.rafakwolf.gerenciador.web;

import javax.servlet.http.Cookie;

public class MyCookies {

    private final Cookie[] cookies;

    public MyCookies(Cookie[] cookies) {
        this.cookies = cookies;
    }

    public Cookie buscarUsuarioLogado(){
        if (this.cookies==null)
            return null;

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("usuario.logado")){
                return cookie;
            }
        }
        return null;
    }
}
