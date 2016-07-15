package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by luis on 15/07/16.
 */
public class ConexaoBD {
    public Connection getConnection(){
        System.out.println("Conectando ao banco de dados");
        try {
            String url = "jdbc:mysql://localhost/portfolioDB";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
