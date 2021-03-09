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
public class comentarioLike {

    private Usuario usuario;
    private Comentario comentario;

    public comentarioLike() {
    }

    public comentarioLike(Usuario usuario, Comentario comentario) {
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "comentarioLike{" + "usuario=" + usuario + ", comentario=" + comentario + '}';
    }

}
