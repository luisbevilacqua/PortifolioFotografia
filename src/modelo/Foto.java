package modelo;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by luis on 15/07/16.
 */
public class Foto {
    private int idFoto;
    private String titulo;
    private String caminho;
    private String descricao;
    private int idFotografo;
    private String nomeFotografo;
    private ArrayList<String> tags;

    public String getNomeFotografo() {
        return nomeFotografo;
    }

    public void setNomeFotografo(String nomeFotografo) {
        this.nomeFotografo = nomeFotografo;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdFotografo() {
        return idFotografo;
    }

    public void setIdFotografo(int idFotografo) {
        this.idFotografo = idFotografo;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
