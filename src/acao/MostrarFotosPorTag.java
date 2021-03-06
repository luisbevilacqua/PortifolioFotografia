package acao;

import dao.FotoDAO;
import modelo.Foto;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by luis on 16/07/16.
 */
public class MostrarFotosPorTag implements Acao{
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Foto> fotos;
        String listaFotos = "";
        String descricao = "";
        // obtem parametros do request
        String tag = request.getParameter("srch-term");

        FotoDAO bd = new FotoDAO();
        fotos = bd.getFotosByTag(tag);

        for (Foto foto : fotos) {
            if(foto.getDescricao() != null){
                descricao = foto.getDescricao();
            }else{
                descricao= "<br>";
            }
            listaFotos +=" <div class=\"col-md-6 col-lg-8 portfolio-item\">\n" +
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
        String init = "" + tag.charAt(0);
        tag = init.toUpperCase() + tag.substring(1);

        request.setAttribute("listaFotos", listaFotos);
        request.setAttribute("nomeTag", tag);
        RequestDispatcher rd = request.getRequestDispatcher("/busca.jsp");
        rd.forward(request, response);
    }
}

