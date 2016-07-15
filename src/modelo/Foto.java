package modelo;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by luis on 15/07/16.
 */
public class Foto {
    String titulo;
    ArrayList<String> tags;
    Image imagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }
}
