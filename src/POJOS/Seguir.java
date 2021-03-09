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
public class Seguir {

    private Usuario usuario;
    private String seguidor;

    public Seguir() {
    }

    public Seguir(Usuario usuario, String seguidor) {
        this.usuario = usuario;
        this.seguidor = seguidor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
    public String getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(String seguidor) {
        this.seguidor = seguidor;
    }

    @Override
    public String toString() {
        return "Seguir{" + "usuario=" + usuario + ", seguidor=" + seguidor + '}';
    }

}
