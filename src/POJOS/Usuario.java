/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.io.Serializable;

/**
 *
 * @author alorp
 */
public class Usuario implements Serializable{

    private String usuarioFirebase;
    private String nombre;
    private String apellido;
    private String email;
    private String biografia;
    private String foto;
    private Integer creador;

    public Usuario() {
    }

    public Usuario(String usuarioFirebase, String nombre, String apellido, String email, String biografia, String foto, Integer creador) {
        this.usuarioFirebase = usuarioFirebase;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.biografia = biografia;
        this.foto = foto;
        this.creador = creador;
    }

    public String getUsuarioFirebase() {
        return usuarioFirebase;
    }

    public void setUsuarioFirebase(String usuarioFirebase) {
        this.usuarioFirebase = usuarioFirebase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getCreador() {
        return creador;
    }

    public void setCreador(Integer creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuarioFirebase=" + usuarioFirebase + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", biografia=" + biografia + ", foto=" + foto + ", creador=" + creador + '}';
    }

}
