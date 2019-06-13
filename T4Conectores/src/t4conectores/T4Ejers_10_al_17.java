/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4conectores;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.StampedLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VCV
 */
public class T4Ejers_10_al_17 {

/*
    10.
        Queremos obtener los siguientes datos de las columnas devueltas por la consulta 
        "select *, nombre as non from alumnos": 
    Nombre de la columna, 
    alias de la columna, 
    nombre del tipo de dato usado en la columna, 
    si es autoincrementado 
    y si permite nulos.
    
    16.
        Realiza un método que permita 
    buscar una cadena de texto en cualquier columna de tipo char o varchar de cualquier tabla de una base datos dada. 
    Debe indicar la base de datos, tabla y columna donde se encontró la coincidencia y el texto completo del campo
*/
    
    Conexion connection = new Conexion();
    
    public void ejer10(){
        try{
            this.connection.abrirConexion("add", "localhost", "root", "isR00t");
            String query = "select *, nombre as non from alumnos";
            Statement stmt = this.connection.getConexion().createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            System.out.println("Nombre de la columna / alias de la columna / nombre del tipo de dato usado en la columna / si es autoincrementado / permite nulos");
            
            for(int i = 1; i<=rsmd.getColumnCount();i++){
                System.out.println(rsmd.getColumnName(i)
                        + " | "+rsmd.getColumnLabel(i)
                        + " | "+rsmd.getColumnTypeName(i)
                        + " | Autoincrement: "+rsmd.isAutoIncrement(i) 
                        + " | Nullable: "+rsmd.isNullable(i));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejers_10_al_17.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(T4Ejers_10_al_17.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    16.
        Realiza un método que permita 
    buscar una cadena de texto en cualquier columna de tipo char o varchar de cualquier tabla de una base datos dada. 
    Debe indicar la base de datos, tabla y columna donde se encontró la coincidencia y el texto completo del campo
    */
    
    public void ejer16(){
        DatabaseMetaData dbmt=null;
        try{
            this.connection.abrirConexion("add", "localhost", "root", "isR00t");
            dbmt = this.connection.getConexion().getMetaData();
            ResultSet rsCatalogs = dbmt.getCatalogs();
            Statement stmt = this.connection.getConexion().createStatement();
            
            while(rsCatalogs.next()){
                ResultSet rsTablas = dbmt.getTables(rsCatalogs.getString(1), "%", null, null);
                System.out.println("--------------------COMIENZA BDD "+rsCatalogs.getString(1)+"----------------------------");
                
                while(rsTablas.next()){
                    ResultSet rsCols = dbmt.getColumns(rsCatalogs.getString(1), null, rsTablas.getString(3), null);
                    System.out.println("--------------------COMIENZA TABLA "+rsTablas.getString(3)+"----------------------------");
                    
                    while(rsCols.next()){
                        System.out.println("--------------------COMIENZA COLUMNA "+rsCols.getString(4)+"----------------------------");
                        if(rsCols.getInt(5) == java.sql.Types.CHAR || rsCols.getInt(5) == java.sql.Types.VARCHAR){
                            
                            String query = "SELECT "+rsCols.getString(4)+" FROM "+rsCatalogs.getString(1)+"."+rsTablas.getString(3)+";";
                            ResultSet rsQuery = stmt.executeQuery(query);
                            
                            while(rsQuery.next()){
                                System.out.println("Base de datos: "+rsCatalogs.getString(1)
                                        +"\nNombre de Tabla: "+rsTablas.getString(3)
                                        +"\nNombre de la Columna: "+rsCols.getString(4)
                                        +"\nTipo de variable: "+rsCols.getString(6)
                                        +"\n"+query
                                        +"\nContenido: "+rsQuery.getString(rsCols.getString(4))
                                );        
                                System.out.println("--------------------FIN Registro----------------------------");
                            }
                        }
                        System.out.println("--------------------FIN COLUMNA "+rsCols.getString(4)+"----------------------------");
                    }
                    System.out.println("--------------------FIN TABLA "+rsTablas.getString(3)+"----------------------------");
                }
                System.out.println("--------------------FIN BASE DE DATOS "+rsCatalogs.getString(1)+"----------------------------");
            }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejers_10_al_17.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(T4Ejers_10_al_17.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
