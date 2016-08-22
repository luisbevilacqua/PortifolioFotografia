package acao;

import dao.FotoDAO;
import modelo.Foto;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luis on 20/08/16.
 */
public class Deletar implements Acao {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        System.out.println("id >>> "+ id);
        Foto foto = new Foto();
        foto.setIdFoto(Integer.parseInt(id));
        FotoDAO bd = new FotoDAO();

        bd.deletarFoto(foto);
        request.setAttribute("msg","Foto deletada com sucesso!");
        RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
        rd.forward(request, response);
    }
}
