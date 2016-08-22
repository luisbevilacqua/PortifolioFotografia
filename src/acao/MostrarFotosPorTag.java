package acao;

import dao.FotoDAO;
import modelo.Foto;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luis on 16/07/16.
 */
public class MostrarFotosPorTag implements Acao{
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Foto> fotos;
        String listaFotos = "";
        String descricao;
        // obtem parametros do request
        String tag = request.getParameter("srch-term");
        FotoDAO bd = new FotoDAO();
        fotos = bd.getFotosByTag(tag);
        String nomeFotografo = "Yasmin Fontes";//fotos.get(0).getNomeFotografo();
        ArrayList<String> tags;
        for (Foto foto : fotos) {
            if(foto.getDescricao() != null){
                descricao = foto.getDescricao();
            }else{
                descricao= "<br>";
            }
            tags = foto.getTags();
            listaFotos +=" <div class=\"col-md-6 col-lg-6 portfolio-item\">\n" +
                    "        <a href=\"/resources/"+foto.getCaminho()+"\"  data-lightbox=\"example-set\"  data-title=\""+descricao+"\">\n" +
                    "            <img class=\"img-responsive\" src=\"/resources/" + foto.getCaminho() + "\"alt=\"\" height=\"400\">" +
                    "        </a>\n" +
                    "        <h3>\n" +
                    "            <a href=\"#\">"+ foto.getTitulo() +"" +
                    "               <small>" + foto.getNomeFotografo() + "</small>" +
                    "           </a>\n" +
                    "        </h3>\n" +
                    "        <p>" + descricao + "</p>\n" +
                    "        <form  action=\"controller\" method=\"post\">"+
                    "        <p> Tags: ";



            for(int i=0; i< tags.size();i++){

                listaFotos +=  "   <button type=\"submit\" class=\"btn btn-link\" name=\"srch-term\" value=\""+tags.get(i)+"\">"+tags.get(i)+"</button>" ;//"<input type=\"submit\" value=\""+ tags.get(i)+"\">";
                ;
                ;
            }
            listaFotos +=
                    "<input type=\"hidden\" name=\"opcao\" value=\"MostrarFotosPorTag\">"+" </form></p>\n"+
                            "    </div>";
        }
        String init = "" + tag.charAt(0);
        tag = init.toUpperCase() + tag.substring(1).toLowerCase();

        request.setAttribute("listaFotos", listaFotos);
        request.setAttribute("nomeTag", tag);
        request.setAttribute("nomeFotografo",nomeFotografo);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/busca.jsp");
        System.out.println(tag + "<<<<AQUi");
        rd.forward(request, response);




    }
}

