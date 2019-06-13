/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcjunio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VCV
 */
public class Conexion {
    private Connection cntn;
    public String cntnURL;
    
    public Connection getConnection(){
        return this.cntn;
    }
    
    public void abrirConexion(String bd, String servidor, String usuario, String pass){
        this.cntnURL = String.format("jdbc:mariadb://%s:3306/%s", servidor, bd);
        
        try{
            this.cntn = DriverManager.getConnection(cntnURL,usuario, pass);
            if(this.cntn != null){
                System.out.println("Conectado");
            }else{             
                System.out.println("No conectado");
            }       
        }catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getLocalizedMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println(" Código error: " + sqle.getErrorCode());  
        }
    }
    
    public void abrirConexionPS(String bd, String servidor, String usuario, String pass){
        this.cntnURL = 
                String.format("jdbc:mariadb://%s:3306/%s?useServerPrepStmts=true",servidor, bd);
        try {
            this.cntn = DriverManager.getConnection(cntnURL, usuario, pass);
        if(this.cntn != null){
                System.out.println("Conectado");
            }else{             
                System.out.println("No conectado");
            }       
        }catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getLocalizedMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println(" Código error: " + sqle.getErrorCode());  
        }
    }
    
    
    
    public void cerrarConexion(){
        try{
            this.cntn.close();
        }catch(SQLException sqle){
            System.out.println("Error al cerrar la conexión: " + sqle.getLocalizedMessage());
        }
    }
    
}
