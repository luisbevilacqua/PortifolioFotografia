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
public class MostrarTodasAsFotosAdm implements Acao{
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Foto> fotos;
        String listaFotos = "";
        String descricao;
        // obtem parametros do request
        int contador = 1;
        FotoDAO bd = new FotoDAO();
        fotos = bd.getFotos();
        ArrayList<String> tags;
        for (Foto foto : fotos) {
            if(foto.getDescricao() != null){
                descricao = foto.getDescricao();
            }else{
                descricao="<br>";
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

                listaFotos +=  "   <button  type=\"submit\" class=\"btn btn-link\" name=\"srch-term\" value=\""+tags.get(i)+"\">"+tags.get(i)+"</button>" ;//"<input type=\"submit\" value=\""+ tags.get(i)+"\">";
                ;
                ;
            }
            listaFotos +=
                    "<input type=\"hidden\" name=\"opcao\" value=\"MostrarFotosPorTag\">"+" </form></p>\n"+
                            "  <form action=\"controller\" method=\"post\">\n" +
                            "    <button style=\"background-color:red;\"class=\"btn btn-warning\" type=\"submit\" value=\"Deletar\" >Deletar</button>\n" +
                            "     <input type=\"hidden\"  name=\"id\" value=\""+ foto.getIdFoto() +"\">\n" +
                            "    <input type=\"hidden\" name=\"opcao\" value=\"Deletar\">\n" +
                            "</form>"+
                    "  <form action=\"controller\" method=\"post\">\n" +
                    "    <button \"class=\"btn btn-warning\" type=\"submit\" value=\"Alterar\" >Alterar</button>\n" +
                    "     <input type=\"hidden\"  name=\"id\" value=\""+ foto.getIdFoto() +"\">\n" +
                    "    <input type=\"hidden\" name=\"opcao\" value=\"Deletar\">\n" +
                    "</form>" + "</div>";
        }

        request.setAttribute("nomeTag", "Todos");
        request.setAttribute("listaFotos", listaFotos);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        //rd.forward(request, response);
    }
}
