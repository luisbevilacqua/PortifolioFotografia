package acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luis on 15/07/16.
 */
public interface Acao {
    public void executa(HttpServletRequest request, HttpServletResponse response)
        throws Exception;
}
