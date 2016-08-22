package servlet;

import acao.Acao;
import acao.MostrarTodasFotos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by luis on 15/07/16.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcao = request.getParameter("opcao");
        String nomeDaClasse = "acao." + opcao;
        System.out.println("CLASSE >>> "+nomeDaClasse);
        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            acao.executa(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro: ",e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
