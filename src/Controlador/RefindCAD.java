/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import POJOS.ExcepcionRefind;
import POJOS.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alvaro Ortiz Pedroso
 */
public class RefindCAD {

    private Connection conexion;

    public RefindCAD() throws ExcepcionRefind {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ExcepcionRefind e = new ExcepcionRefind();
            e.setMensajeUsuario("Error general del sistema. Consulte con su administrador");
            e.setMensajeAdmin("Error con el driver de mySql");
            throw e;
        }
    }

    private void conectar() throws ExcepcionRefind {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/refind?user=root&password=");
        } catch (SQLException ex) {
            ExcepcionRefind e = new ExcepcionRefind();
            e.setMensajeUsuario("Error general del sistema. Consulte con su administrador");
            e.setMensajeAdmin("Error en la conexion a la base de datos de refind");
            throw e;
        }
    }

    /**
     * 
     * 
     * 
     * Ademas el identificador de usuario no puede aparecer duplicado ya que es gestionbado por fireBase
     * @param usuario
     * @return
     * @throws ExcepcionRefind 
     */
    public int insertarUsuario(Usuario usuario) throws ExcepcionRefind {
        int registrosAfectados = 0;
        String dml = "INSERT INTO usuario (usuario_firebase, nombre, apellido, email, biografia, foto) values (?,?,?,?,?,?)";
        conectar();
        try {
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setString(1, usuario.getUsuarioFirebase());
            sentenciaPreparada.setString(2, usuario.getNombre());
            sentenciaPreparada.setString(3, usuario.getApellido());
            sentenciaPreparada.setString(4, usuario.getEmail());
            sentenciaPreparada.setString(5, usuario.getBiografia());
            sentenciaPreparada.setString(6, usuario.getFoto());//
            //sentenciaPreparada.setObject(6, usuario.getCreador(), Types.INTEGER);
            registrosAfectados = sentenciaPreparada.executeUpdate();
            sentenciaPreparada.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionRefind e = new ExcepcionRefind();

            String[] palabraClave = {"null"};
            String error = "";
            for (int i = 0; i < palabraClave.length; i++) {
                if (ex.getMessage().contains(palabraClave[i])) {
                    error = palabraClave[i];
                    break;
                }
            }
            switch (error) {
                case "null":
                    e.setMensajeUsuario("Es necesario rellenar todos los campos");
                    break;
                default:
                    e.setMensajeUsuario("Error general del sistema. Consulte con su administrador");
            }
            e.setMensajeAdmin(ex.getMessage());
            throw e;
        }
        return registrosAfectados;
    }
    
    public void actualizarUsuario(){
        
    }
    public void obtenerUsuario(){
        
    }
    public void insertarFavorito(){
        
    }
    public void eliminarFavorito(){
        
    }
    
    public void obtenerFavorito(){
        
    }
    
    
    public void obtenerFavoritos(){
        
    }
    
    public void insertarComentario(){
        
    }
    
    public void obtenerComentarios(){
        
    }
    
    public void obtenerAnuncio(){
        
    }
    public void obtenerAnuncios(){
        
    }
    public void obtenerCategoria(){
        
    }
    
    
}
