/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

/**
 *
 * @author alorp
 */
public class Favorito {

    private Usuario usuario;
    private Anuncio anuncio;

    public Favorito() {
    }

    public Favorito(Usuario usuario, Anuncio anuncio) {
        this.usuario = usuario;
        this.anuncio = anuncio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    @Override
    public String toString() {
        return "Favorito{" + "usuario=" + usuario + ", anuncio=" + anuncio + '}';
    }

}
