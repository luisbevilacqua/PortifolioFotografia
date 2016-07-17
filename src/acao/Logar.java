package acao;

import dao.FotografoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luis on 16/07/16.
 */
public class Logar implements Acao{
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        FotografoDAO bd = new FotografoDAO();

        if(!bd.logar(login, senha)){
            request.setAttribute("msg","Usuário ou senha incorretos");
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("/editor.jsp");
            rd.forward(request, response);
        }
    }
}
