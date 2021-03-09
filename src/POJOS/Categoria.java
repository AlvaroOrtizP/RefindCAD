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
public class Categoria {

    private Integer categoriaId;
    private String titulo;
    private String descripcion;
    private String foto;

    public Categoria() {
    }

    public Categoria(Integer categoriaId, String titulo, String descripcion, String foto) {
        this.categoriaId = categoriaId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Categoria{" + "categoriaId=" + categoriaId + ", titulo=" + titulo + ", descripcion=" + descripcion + ", foto=" + foto + '}';
    }

}
