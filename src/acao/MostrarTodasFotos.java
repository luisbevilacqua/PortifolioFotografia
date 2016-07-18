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
        String descricao=" ";
        // obtem parametros do request

        FotoDAO bd = new FotoDAO();
        fotos = bd.getFotos();

        for (Foto foto : fotos) {
            if(foto.getDescricao() != null){
                descricao = foto.getDescricao();
            }else{
                descricao="<br>";
            }
            listaFotos +=" <div class=\"col-md-6 col-lg-6 portfolio-item\">\n" +
                    "        <a href=\"#\">\n" +
                    "            <img class=\"img-responsive\" src=\"/resources/" + foto.getCaminho() + "\"alt=\"\" height=\"400\">" +
                    "        </a>\n" +
                    "        <h3>\n" +
                    "            <a href=\"#\">"+ foto.getTitulo() +"" +
                    "               <small>" + foto.getNomeFotografo() + "</small>" +
                    "           </a>\n" +
                    "        </h3>\n" +
                    "        <p>" + descricao + "</p>\n" +
                    "    </div>";
        }

        request.setAttribute("nomeTag", "Todos");
        request.setAttribute("listaFotos", listaFotos);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        //rd.forward(request, response);
    }
}
