package br.com.rafakwolf.gerenciador.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/executar")
public class MainController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tarefa = req.getParameter("tarefa");

        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }

        tarefa = "br.com.rafakwolf.gerenciador.web." + tarefa;

        try {
            Class<?> tipo = Class.forName(tarefa);
            Tarefa instance = (Tarefa) tipo.newInstance();
            String pagina = instance.executa(req, resp);
            RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ServletException(e);
        }
    }
}
