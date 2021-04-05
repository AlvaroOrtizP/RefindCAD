/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refindcad;

import Controlador.RefindCAD;
import POJOS.Anuncio;
import POJOS.Categoria;
import POJOS.ExcepcionRefind;
import POJOS.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alorp
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String opcion = "";
        do {
            System.out.println("Opcion 1: actualizar usuario");
            System.out.println("Opcion 2: mostrar un usuario");
            System.out.println("Opcion 3: insertar favorito");
            System.out.println("Opcion 4: eliminar un favorito");
            System.out.println("Opcion 5: obtener favoritos");
            System.out.println("Opcion 6: insertar usuario");
            opcion = scan.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("actualizar un usuario");

                    try {
                        RefindCAD refindCAD = new RefindCAD();
                        Usuario usuario = new Usuario("asdasd", "Ruben", "Lara", "email@gmail.com", "asdasda asdasd ", "asdasd", 0);
                        refindCAD.actualizarUsuario(usuario);
                        System.out.println("ok");
                    } catch (ExcepcionRefind ex) {
                        System.out.println(ex.getMensajeUsuario());
                        System.out.println(ex.getMensajeAdmin());
                    }
                    break;
                case "2":
                    System.out.println("obtener un usuario");

                    try {
                        RefindCAD refindCAD = new RefindCAD();
                        //Usuario usuario = refindCAD.obtenerUsuario("asdasd");

                        //System.out.println(usuario);
                    } catch (ExcepcionRefind ex) {
                        System.out.println(ex.getMensajeUsuario());
                        System.out.println(ex.getMensajeAdmin());
                    }
                    break;
                case "3":
                    System.out.println("Insertar un favorito");

                    try {
                        RefindCAD refindCAD = new RefindCAD();
                        Usuario usuario = new Usuario("asdasd", "Ruben", "Lara", "email@gmail.com", "asdasda asdasd ", "asdasd", 0);
                        Categoria categoria = new Categoria(1, "asd", "asd", "asd");
                        Anuncio anuncio = new Anuncio(3, "asd", "qewqwe", categoria, usuario, "5664565", "564654");//Error al poner una categoria o anuncio no existente
                        refindCAD.insertarFavorito(usuario, anuncio);

                        System.out.println(usuario);
                    } catch (ExcepcionRefind ex) {
                        System.out.println(ex.getMensajeUsuario());
                        System.out.println(ex.getMensajeAdmin());
                    }
                    break;
                case "4":
                    System.out.println("Eliminar un favorito");

                    try {
                        RefindCAD refindCAD = new RefindCAD();
                        Usuario usuario = new Usuario("asdasd", "Ruben", "Lara", "email@gmail.com", "asdasda asdasd ", "asdasd", 0);
                        Categoria categoria = new Categoria(1, "asd", "asd", "asd");
                        Anuncio anuncio = new Anuncio(3, "asd", "qewqwe", categoria, usuario, "5664565", "564654");//Error al poner una categoria o anuncio no existente
                        refindCAD.eliminarFavorito(usuario, anuncio);

                        System.out.println(usuario);
                    } catch (ExcepcionRefind ex) {
                        System.out.println(ex.getMensajeUsuario());
                        System.out.println(ex.getMensajeAdmin());
                    }
                    break;
                case "5":
                    System.out.println("Obtener favoritos");
                    ArrayList<Anuncio> listaAnuncios = new ArrayList<>();
                    try {
                        RefindCAD refindCAD = new RefindCAD();
                        listaAnuncios = refindCAD.obtenerFavoritos();
                        System.out.println(listaAnuncios.get(0).getTitulo());
                    } catch (ExcepcionRefind ex) {
                        System.out.println(ex.getMensajeUsuario());
                        System.out.println(ex.getMensajeAdmin());
                    }
                    break;
                case "6":
                    System.out.println("insertar un usuario");

                    try {
                        RefindCAD refindCAD = new RefindCAD();
                        Usuario usuario = new Usuario("asdasd1", "Ruben", "Lara", "email@gmail.com", "asdasda asdasd ", "asdasd", 0);
                        refindCAD.insertarUsuario(usuario);
                        System.out.println("ok");
                    } catch (ExcepcionRefind ex) {
                        System.out.println(ex.getMensajeUsuario());
                        System.out.println(ex.getMensajeAdmin());
                    }
                    break;
            }
            opcion = "kk";
        } while (opcion.equals("kk"));
    }

}
