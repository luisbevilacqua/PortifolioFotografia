package acao;

import dao.FotoDAO;
import dao.FotografoDAO;
import modelo.Foto;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.logging.Level;

/**
 * Created by luis on 19/08/16.
 */
public class Adicionar implements Acao{
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String titulo = request.getParameter("titulo");
        Part filePart = request.getPart("caminho");
        String caminho = getFileName(filePart);
        String descricao = request.getParameter("descricao");

        System.out.print(caminho);
        final PrintWriter writer = response.getWriter();
        OutputStream out = new FileOutputStream(new File(System.getProperty("user.home") + File.separator + "IdeaProjects/PortifolioFotografia/web/resources" + File.separator + caminho));
        InputStream filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        System.out.println("New file " + caminho + " created at ");

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
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
