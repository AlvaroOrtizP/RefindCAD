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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

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
     * ------------- METODOS USUARIO
     */
    /**
     *
     *
     *
     * Ademas el identificador de usuario no puede aparecer duplicado ya que es
     * gestionbado por fireBase
     *
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

    public int actualizarUsuario(Usuario usuario) throws ExcepcionRefind {
        int registrosAfectados = 0;
        String dml = "UPDATE usuario SET nombre=?,apellido=?,email=?,biografia=? WHERE usuario_firebase=?";
        conectar();
        try {
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setString(1, usuario.getNombre());
            sentenciaPreparada.setString(2, usuario.getApellido());
            sentenciaPreparada.setString(3, usuario.getEmail());
            sentenciaPreparada.setString(4, usuario.getBiografia());
            sentenciaPreparada.setString(5, usuario.getUsuarioFirebase());
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

    public void actualizarFotoUsuario() {

    }

    public int actualizarCreador(Usuario usuario) throws ExcepcionRefind {
        int registrosAfectados = 0;
        String dml = "UPDATE usuario SET creador=? WHERE usuario_firebase=?";
        conectar();
        try {
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);

            sentenciaPreparada.setObject(1, usuario.getCreador(), Types.INTEGER);
            sentenciaPreparada.setString(2, usuario.getUsuarioFirebase());

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

    public Usuario obtenerUsuario(String usuarioFirebase) throws ExcepcionRefind {
        conectar();
        Usuario usuario = new Usuario();
        String sql = "select * from usuario where usuario_firebase = '" + usuarioFirebase + "'";

        try {
            conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet res = sentencia.executeQuery(sql);
            while (res.next()) {
                usuario.setUsuarioFirebase(usuarioFirebase);
                usuario.setNombre(res.getString("nombre"));
                usuario.setApellido(res.getString("apellido"));
                usuario.setBiografia(res.getString("biografia"));
                usuario.setEmail(res.getString("email"));
                usuario.setCreador(res.getInt("creador"));
                usuario.setFoto(res.getString("foto"));
            }
            res.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionRefind e = new ExcepcionRefind();
            e.setMensajeAdmin(ex.getMessage());
            e.setMensajeUsuario("Error general del sistema. Consulte con el administrador");
        }
        return usuario;
    }

    /**
     *
     */
    public void insertarFavorito() {

    }

    public void eliminarFavorito() {

    }

    public void obtenerFavorito() {

    }

    public void obtenerFavoritos() {

    }

    public void insertarComentario() {

    }

    public void obtenerComentarios() {

    }

    public void obtenerAnuncio() {

    }

    public void obtenerAnuncios() {

    }

    public void obtenerCategoria() {

    }

}
