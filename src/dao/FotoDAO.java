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

        PreparedStatement stmt, stmt2;
        try {
            stmt = connection.prepareStatement("select * from foto, fotografo WHERE foto.idFotografo = fotografo.idFotografo");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Foto foto = new Foto();
                foto.setIdFoto(rs.getInt("idFoto"));
                foto.setTitulo(rs.getString("titulo"));
                foto.setCaminho(rs.getString("caminho"));
                foto.setDescricao(rs.getString("foto.descricao"));
                foto.setIdFoto(rs.getInt("idFotografo"));
                foto.setNomeFotografo(rs.getString("nome"));

                stmt2 = connection.prepareStatement("SELECT tags FROM tag WHERE idFoto = ?");
                stmt2.setInt(1, rs.getInt("idFoto"));
                ResultSet rs2 = stmt2.executeQuery();
                ArrayList<String> tags = new ArrayList<>();
                while (rs2.next()){
                    tags.add(rs2.getString("tags"));
                }
                foto.setTags(tags);
                fotos.add(foto);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fotos;
    }
    public List<Foto> getFotosByTag(String tag) {
        List<Foto> fotos = new ArrayList<>();

        PreparedStatement stmt, stmt2;
        try {
            stmt = connection.prepareStatement("select * from foto, fotografo, tag WHERE foto.idFotografo = fotografo.idFotografo AND foto.idFoto = tag.idFoto AND tags = ?");

            stmt.setString(1, tag);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Foto foto = new Foto();
                foto.setIdFoto(rs.getInt("idFoto"));
                foto.setTitulo(rs.getString("titulo"));
                foto.setCaminho(rs.getString("caminho"));
                foto.setDescricao(rs.getString("foto.descricao"));
                foto.setIdFoto(rs.getInt("idFotografo"));
                foto.setNomeFotografo(rs.getString("nome"));

                stmt2 = connection.prepareStatement("SELECT tags FROM tag WHERE idFoto = ?");
                stmt2.setInt(1, rs.getInt("idFoto"));
                ResultSet rs2 = stmt2.executeQuery();
                ArrayList<String> tags = new ArrayList<>();
                while (rs2.next()){
                    tags.add(rs2.getString("tags"));
                }
                foto.setTags(tags);
                fotos.add(foto);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fotos;
    }
    public void adiconarFoto(Foto foto){
        PreparedStatement stmt;
        try{
            stmt = connection.prepareStatement("INSERT INTO foto (titulo, caminho, descricao, idFotografo) VALUES (?,?,?,1)");
            stmt.setString(1, foto.getTitulo());
            stmt.setString(2, foto.getCaminho());
            stmt.setString(3, foto.getDescricao());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarFoto(Foto foto){
        PreparedStatement stmt;
        try{
            stmt = connection.prepareStatement("UPDATE foto SET titulo = ?, caminho = ?, descricao = ? WHERE idFoto = ?");
            stmt.setString(1, foto.getTitulo());
            stmt.setString(2, foto.getCaminho());
            stmt.setString(3, foto.getDescricao());
            stmt.setInt(4,foto.getIdFoto());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletarFoto(Foto foto){
        PreparedStatement stmt;
        try{
            stmt = connection.prepareStatement("DELETE FROM foto WHERE idFoto = ?");
            stmt.setInt(1,foto.getIdFoto());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
