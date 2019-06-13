/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author VCV
 */
public class Conexion {

    private Connection theConnection;
    public String url;
    
    public Connection getConexion() {
        return theConnection;
    }

    public void definirConexion(){
        //página 6
        
    }
    
    public void abrirConexion(String bd, String servidor, String usuario, String password) throws ClassNotFoundException {
        try {
//            Class.forName("org.mariadb.jdbc.Driver");
            this.url = String.format("jdbc:mariadb://%s:3306/%s", servidor, bd);
            this.theConnection = DriverManager.getConnection(url, usuario, password);
// Establecemos la conexión con la BD 
            if (this.theConnection != null) {
                System.out.println("Conectado a la base de datos " + bd + " en " + servidor);
            } else {
                System.out.println("NO se ha conectado a la base de datos " + bd + " en " + servidor);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getLocalizedMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println(" Código error: " + e.getErrorCode());
        }
    }
    

    public void abrirConexionPS(String bd, String servidor, String usuario, String password) throws ClassNotFoundException {
        try {
//            Class.forName("org.mariadb.jdbc.Driver");
            this.url = String.format("jdbc:mariadb://%s:3306/%s?useServerPrepStmts=true", servidor, bd);
            this.theConnection = DriverManager.getConnection(url, usuario, password);
// Establecemos la conexión con la BD 
            if (this.theConnection != null) {
                System.out.println("Conectado a la base de datos " + bd + " en " + servidor);
            } else {
                System.out.println("NO se ha conectado a la base de datos " + bd + " en " + servidor);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getLocalizedMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println(" Código error: " + e.getErrorCode());
        }
    }
    
    public void cerrarConexion() {
        try {
            this.theConnection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getLocalizedMessage());
        }
    }

}
