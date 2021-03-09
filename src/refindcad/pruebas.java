/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refindcad;

import Controlador.RefindCAD;
import POJOS.ExcepcionRefind;
import POJOS.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            System.out.println("Opcion 1: insertar usuario");
            System.out.println("Opcion 2: mostrar un usuario");
            opcion = scan.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Insertar un usuario");

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
                    System.out.println("Insertar un usuario");

                    try {
                        RefindCAD refindCAD = new RefindCAD();
                        Usuario usuario = refindCAD.obtenerUsuario("asdasd");

                        System.out.println(usuario);
                    } catch (ExcepcionRefind ex) {
                        System.out.println(ex.getMensajeUsuario());
                        System.out.println(ex.getMensajeAdmin());
                    }
                    break;

            }
        } while (opcion.equals("kk"));
    }

}
