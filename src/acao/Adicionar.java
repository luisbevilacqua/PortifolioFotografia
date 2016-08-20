package acao;

import dao.FotoDAO;
import dao.FotografoDAO;
import modelo.Foto;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luis on 19/08/16.
 */
public class Adicionar implements Acao{
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String titulo = request.getParameter("titulo");
        String caminho = request.getParameter("caminho");
        String descricao = request.getParameter("descricao");

        Foto foto = new Foto();
        foto.setTitulo(titulo);
        foto.setCaminho(caminho);
        foto.setDescricao(descricao);
        FotoDAO bd = new FotoDAO();

        bd.adiconarFoto(foto);
        request.setAttribute("msg","Foto adicionada com sucesso!");
        RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
        rd.forward(request, response);
    }
}
