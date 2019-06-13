/*
6. Realizar un método que consulte que el nombre de un alumno contenga cierto patrón 
y que la altura sea mayor que un valor. 
Realízalo con y sin sentencias preparadas, 
pasando los valores de los criterios como parámetros.

7.Ejecuta los métodos anteriores, calculando el tiempo de ejecución, 
dentro de un bucle: 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000 veces. 
¿Qué conclusión extraes?

8.Quememos crear un método que pasándole cuatro parámetros 
(tabla, nombre de campo, tipo de dato, propiedades) 
nos permita añadir una columna a una tabla

 */
package t4conectores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VCV
 */
public class T4Ejers_6_7_8 {
    
    
    Conexion conection = new Conexion();

    //Ejer 6
    public void consultaPatronNombreAlumno(String patron, int alturaMin, boolean isPS){
        
        PreparedStatement ps = null;
        Statement stmt = null;
        try{
            ResultSet rs = null;
            if(isPS){
                conection.abrirConexionPS("add","localhost","root","isR00t");
                String query = "SELECT nombre, altura FROM alumnos WHERE nombre LIKE ? AND altura > ?;";
                ps = conection.getConexion().prepareStatement(query);
                ps.setString(1, patron);
                ps.setInt(2, alturaMin);
                rs = ps.executeQuery();
            }else{
                conection.abrirConexion("add","localhost","root","isR00t");
                String query = "SELECT nombre, altura FROM alumnos WHERE nombre LIKE "+patron+" AND altura > "+alturaMin+";";
                stmt = conection.getConexion().prepareStatement(query);
                rs = stmt.executeQuery(query);
            }
            while(rs.next()){
                System.out.println(rs.getRow() + " " + rs.getString("nombre"));
            }
            
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conection.cerrarConexion();
        }
    }
    
    //Ejer 7 
    //Sentencias preparadas
    public void testVelocidadPS1(int numeroVecesRepeticion){
        for(int i = 0;i<numeroVecesRepeticion;i++){
            this.consultaPatronNombreAlumno("A%", 170, true);
        }
    }
    
    //Sentencias regulares
    public void testVelocidadRS1(int numeroVecesRepeticion){
        for(int i = 0;i<numeroVecesRepeticion;i++){
            this.consultaPatronNombreAlumno("\"A%\"", 170, false);
        }
    }
    
    //Ejer 6 (para Ejer 7) remodelado para no abrir redundantemente la conexión 
    public void consultaPatronNombreAlumnoEj7(String patron, int alturaMin, boolean isPS){
        
        PreparedStatement ps = null;
        Statement stmt = null;
        try{
            ResultSet rs = null;
            if(isPS){
                String query = "SELECT nombre, altura FROM alumnos WHERE nombre LIKE ? AND altura > ?;";
                ps = conection.getConexion().prepareStatement(query);
                ps.setString(1, patron);
                ps.setInt(2, alturaMin);
                rs = ps.executeQuery();
            }else{
                String query = "SELECT nombre, altura FROM alumnos WHERE nombre LIKE "+patron+" AND altura > "+alturaMin+";";
                stmt = conection.getConexion().prepareStatement(query);
                rs = stmt.executeQuery(query);
            }
            while(rs.next()){
                System.out.println(rs.getRow() + " " + rs.getString("nombre"));
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Sentencias preparadas versión sin abrir la conexión y cerrarla cada vez
    public void testVelocidadPS2(int numeroVecesRepeticion){
        try {
            conection.abrirConexionPS("add","localhost","root","isR00t");
            for(int i = 0;i<numeroVecesRepeticion;i++){
                this.consultaPatronNombreAlumnoEj7("A%", 170, true);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conection.cerrarConexion();
        }
    }
    
    //Sentencias regulares versión sin abrir la conexión y cerrarla cada vez
    public void testVelocidadRS2(int numeroVecesRepeticion){
        try {
            conection.abrirConexion("add","localhost","root","isR00t");
            for(int i = 0;i<numeroVecesRepeticion;i++){
                this.consultaPatronNombreAlumnoEj7("\"A%\"", 170, false);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conection.cerrarConexion();
        }
    }
    
    //Ejer 8
    public void anyadeColumnaATabla(String tabla, String nombreDeCampo, String tipoDeDato, String propiedades){      
        
        Statement stmt = null;
        try{
            String query = "ALTER TABLE "+tabla+" ADD "+nombreDeCampo+" "+tipoDeDato+" "+propiedades;
            conection.abrirConexion("add","localhost","root","isR00t");
            stmt = conection.getConexion().createStatement();
            int tablasAlteradas = stmt.executeUpdate(query);
            System.out.println("Tablas alteradas : "+tabla);
        }catch(SQLException sqle){
            sqle.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(T4Ejers_6_7_8.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conection.cerrarConexion();
        }
    }
    
}