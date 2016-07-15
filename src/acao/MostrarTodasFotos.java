package acao;

import dao.FotoDAO;
import modelo.Foto;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luis on 15/07/16.
 */
public class MostrarTodasFotos implements Acao{
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Foto> fotos;
        String listaFotos = "";

        // obtem parametros do request

        FotoDAO bd = new FotoDAO();
        fotos = bd.getFotos();

        for (Foto foto : fotos) {
            listaFotos += foto.getTitulo() + "<br><img src=\"" + foto.getCaminho() + "\"><br>";
        }

        request.setAttribute("listaFotos", listaFotos);
        RequestDispatcher rd = request.getRequestDispatcher("/albums.jsp");
        rd.forward(request, response);
    }
}
