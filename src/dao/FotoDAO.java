package dao;

import jdbc.ConexaoBD;
import modelo.Foto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luis on 15/07/16.
 */
public class FotoDAO {
    private Connection connection;
    public FotoDAO() {
        this.connection = new ConexaoBD().getConnection();
    }

    public List<Foto> getFotos() {
        List<Foto> fotos = new ArrayList<>();

        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("select * from foto");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Foto foto = new Foto();
                foto.setIdFoto(rs.getInt("idFoto"));
                foto.setTitulo(rs.getString("titulo"));
                foto.setCaminho(rs.getString("caminho"));
                foto.setDescricao(rs.getString("descricao"));
                foto.setIdFoto(rs.getInt("idFotografo"));

                fotos.add(foto);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fotos;
    }
}
