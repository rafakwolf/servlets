package br.com.rafakwolf.gerenciador.web;

import br.com.rafakwolf.gerenciador.Empresa;
import br.com.rafakwolf.gerenciador.dao.EmpresaDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresa implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String nome = req.getParameter("nome");
        Empresa empresa = new Empresa(nome);
        new EmpresaDao().adiciona(empresa);
        req.setAttribute("empresa", empresa);
        return "/WEB-INF/paginas/novaEmpresa.jsp";
    }
}
