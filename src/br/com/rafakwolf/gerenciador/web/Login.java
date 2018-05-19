package br.com.rafakwolf.gerenciador.web;

import br.com.rafakwolf.gerenciador.Usuario;
import br.com.rafakwolf.gerenciador.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        PrintWriter writer = resp.getWriter();

        Usuario usuario = new UsuarioDao().buscaPorEmailESenha(email, senha);
        if (usuario==null){
            writer.println("<html><body>Usuario invalido</body><html>");
        }else
        {
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", usuario);
            writer.println("<html><body>Usuario logado: "+email+"</body><html>");
        }
    }
}
