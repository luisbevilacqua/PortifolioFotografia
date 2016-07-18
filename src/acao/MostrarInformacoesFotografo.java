package acao;

import dao.FotoDAO;
import dao.FotografoDAO;
import modelo.Foto;
import modelo.Fotografo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by luis on 16/07/16.
 */
public class MostrarInformacoesFotografo implements Acao {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String infos = "";
        Fotografo fotografo = new Fotografo();
        FotografoDAO bd = new FotografoDAO();
        fotografo = bd.getFotografo();

        infos = "<div class=\"col-lg-4 col-md-4 col-sm-6 col-xm-12\">" +
                "   <img src=\"resources/"+ fotografo.getFotoPerfil() +"\" width=\"200\">" +
                "</div>" +
                "<div class=\"col-lg-4 col-md-4 col-sm-6 col-xm-12\">" +
                "       <h2>" + fotografo.getNome() + "</h2><br>" +
                       fotografo.getDescricao()  + "<br><br>" +
                "       Telefone: " + fotografo.getTelefone() + "<br>" +
                "       <a href=\"mailto:" + fotografo.getEmail() + "\">" + fotografo.getEmail() + "</a><br>" +
                "       <a href=\"http://" + fotografo.getFacebook() + "\">Facebook</a><br>" +
                "       <a href=\"http://instagram.com/" + fotografo.getInstagram() + "\">Instagram</a><br>" +
                "</div>";
        request.setAttribute("infos", infos);
        request.setAttribute("nomeFotografo",fotografo.getNome());
        RequestDispatcher rd = request.getRequestDispatcher("/sobre.jsp");
    }
}
