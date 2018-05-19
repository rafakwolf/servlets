package br.com.rafakwolf.gerenciador.web;

import br.com.rafakwolf.gerenciador.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FiltroAudit implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String uri = req.getRequestURI();

        String usuario = getUsuario(req);
        System.out.println("Usuário " + usuario + " acessando a uri: "+ uri);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getUsuario(HttpServletRequest req) {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
        if (usuario==null) return "<deslogado>";
        return usuario.getEmail();
    }
}
