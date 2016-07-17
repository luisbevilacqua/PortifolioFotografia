package dao;

import jdbc.ConexaoBD;
import modelo.Fotografo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luis on 16/07/16.
 */
public class FotografoDAO {
    private Connection connection;
    public FotografoDAO() {
        this.connection = new ConexaoBD().getConnection();
    }

    public Fotografo getFotografo() {
        Fotografo fotografo = new Fotografo();

        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fotografo, contato WHERE fotografo.idFotografo = contato.idFotografo");
            ResultSet rs = stmt.executeQuery();

            rs.next();

            fotografo.setIdFotografo(rs.getInt("idFotografo"));
            fotografo.setNome(rs.getString("nome"));
            fotografo.setDescricao(rs.getString("descricao"));
            fotografo.setFotoPerfil(rs.getString("fotoPerfil"));
            fotografo.setLogin(rs.getString("login"));
            fotografo.setSenha(rs.getString("senha"));
            fotografo.setTelefone(rs.getString("telefone"));
            fotografo.setEmail(rs.getString("email"));
            fotografo.setFacebook(rs.getString("facebook"));
            fotografo.setInstagram(rs.getString("instagram"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fotografo;
    }

    public boolean logar(String login, String senha){
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fotografo WHERE login = ? AND senha = ?");

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
