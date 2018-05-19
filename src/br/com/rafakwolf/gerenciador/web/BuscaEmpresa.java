package br.com.rafakwolf.gerenciador.web;

import br.com.rafakwolf.gerenciador.Empresa;
import br.com.rafakwolf.gerenciador.dao.EmpresaDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class BuscaEmpresa implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String filtro = req.getParameter("filtro");
        Collection<Empresa> empresas = new EmpresaDao().buscaPorSimilaridade(filtro);
        req.setAttribute("empresas",empresas);
        return "/WEB-INF/paginas/buscaEmpresa.jsp";
    }
}
