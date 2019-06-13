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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
9.
Mediante DatabaseMetaData (y métodos similares)
queremos obtener cierta información de la base de datos 
y de las tablas que contiene la base de datos:

    a.Obtén los siguientes datos de la base de datos: 
    Nombre del driver, 
    versión del driver, 
    url de conexión, 
    usuario con el que estamos conectados a la base de datos, 
    el nombre del SGBD, 
    versión del SGBD
    y las palabras reservadas que tienen el SGBD.

    b.Obtén todas las bases de datos
    (Catalogs) del SGBD.
    
    c.Para todas las tablas de la base datos ADD
    obtén: el nombre de las tabla y el tipo de tabla.

    d.Repite el ejercicio anterior pero 
    sólo mostrando las vistas.

    e.Combina en uno solo los ejercicios b y c.

    f.Obtén todos los procedimientos almacenados de la base de datos ADD.

    g.Mediante getColumns obtén de las tablas de la base de datos ADD que comiencen por 'a' los siguientes datos: 
    posición de la columna, 
    base de datos, 
    tabla, 
    nombre de la columna, 
    nombre del tipo de dato de la  columna,  
    tamaño  de  la  columna  y  si  permite  nulos.  
    Indica  también  si  has  encontrado  alguna  tabla con un campo autoincrementado.

    h.Mediante las funciones getPrimaryKeys y getExportedKeys 
    obtén todas las claves primarias y foráneas de las base de datos ADD.
 */
public class T4Ejer_9 {
    
    Conexion conection = new Conexion();
    
//    a.Obtén los siguientes datos de la base de datos: 
//    Nombre del driver, 
//    versión del driver, 
//    url de conexión, 
//    usuario con el que estamos conectados a la base de datos, 
//    el nombre del SGBD, 
//    versión del SGBD
//    y las palabras reservadas que tienen el SGBD.
    
    public void ejer9_a(){
    
        DatabaseMetaData dbmt =null;
        
        try {
            this.conection.abrirConexion("add", "localhost", "root", "isR00t");
            dbmt=this.conection.getConexion().getMetaData();
        
            System.out.println("El driver de conexión es: "+dbmt.getDriverName());
            System.out.println("La versión de este driver es: "+dbmt.getDriverVersion());
            System.out.println("La URL de conexión es: "+dbmt.getURL());
            System.out.println("El nombre del SGBD: "+dbmt.getDatabaseProductName());
            System.out.println("Las palabras reservadas por este SGBD son: ");
            for(String a : dbmt.getSQLKeywords().split(",")){
                System.out.println(a);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejer_9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(T4Ejer_9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//     b.Obtén todas las bases de datos (Catalogs) del SGBD.
    
    public void ejer9_b(){
        DatabaseMetaData dbmt = null;
        try{
            this.conection.abrirConexion("add", "localhost", "root", "isR00t");
            dbmt = this.conection.getConexion().getMetaData();
            
            ResultSet rs = dbmt.getCatalogs();
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
//    c.Para todas las tablas de la base datos ADD
//    obtén: el nombre de las tablas y el tipo de tabla.

    public void ejer9_c(){
        DatabaseMetaData dbmt = null;
        try {
            this.conection.abrirConexion("add", "localhost", "root", "isR00t");
            dbmt = this.conection.getConexion().getMetaData();
            
            ResultSet rs = dbmt.getTables(null, null, "%", null);
            
            //Imprime nombre de las tablas de la base de datos seleccionada(add) y su tipo
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4));
            }
        } 
        catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();            
        }
    }
    
//    d.Repite el ejercicio anterior pero 
//    sólo mostrando las vistas.
    
    public void ejer9_d(){
        DatabaseMetaData dbmt = null;
        try {
            this.conection.abrirConexion("add", "localhost", "root", "isR00t");
            dbmt = this.conection.getConexion().getMetaData();
            
            ResultSet rs = dbmt.getTables(null, null, "%", new String[] {"VIEW"});
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4));
            }
        } 
        catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();            
        }
    }
    
    //e.Combina en uno solo los ejercicios b y c.
    
    public void ejer9_e(){
        DatabaseMetaData dbmt = null;
        try {
            this.conection.abrirConexion("add", "localhost", "root", "isR00t");
            dbmt = this.conection.getConexion().getMetaData();
            
            ResultSet rs1 = dbmt.getCatalogs();
            while(rs1.next()){
                ResultSet rs2 = dbmt.getTables(rs1.getString(1), null, "%", null);
                while(rs2.next()){
                    System.out.println(rs2.getString(1)+"\t"+rs2.getString(3)+"\t"+rs2.getString(4));
                }
            }
                        
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejer_9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //f.Obtén todos los procedimientos almacenados de la base de datos ADD.

    public void ejer9_f(){
        DatabaseMetaData dbmt = null;
        try{
            this.conection.abrirConexion("add", "localhost", "root", "isR00t");
            dbmt = this.conection.getConexion().getMetaData();
            
            ResultSet rs = dbmt.getProcedures(null, "%", "%");
            while(rs.next()){
                System.out.println(rs.getString(3));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejer_9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(T4Ejer_9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //g.Mediante getColumns obtén de las tablas de la base de datos ADD que comiencen por 'a' los siguientes datos: 
    //posición de la columna, base de datos, tabla, nombre de la columna, nombre del tipo de dato de la  columna,  tamaño  de  la  columna  y  si  permite  nulos.  
    //Indica  también  si  has  encontrado  alguna  tabla con un campo autoincrementado.

    
    public void ejer9_g(){
        DatabaseMetaData dbmt = null;
        try{
            this.conection.abrirConexion("add", "localhost", "root", "isR00t");
            dbmt = this.conection.getConexion().getMetaData();
            
            ResultSet rsCols = dbmt.getColumns("add", null, "a%", null);
            while(rsCols.next()){
                    System.out.println(
                          "Posición de la columna: " +rsCols.getInt(17)
                                                                //ORDINAL_POSITION
                        + "\nBase de datos: " +rsCols.getString(1) 
                                                                //TABLE_CAT ------------->1
                        + "\nTabla: "+rsCols.getString(3)
                                                                //TABLE_NAME ------------>3
                        + "\nNombre de la columna: "+rsCols.getString(4)
                                                                //COLUMN_NAME ----------->4
                        + "\nNombre del tipo de dato de la columna: "+rsCols.getString(6)
                                                                //TYPE_NAME ------------->6
                        + "\nTamaño de la columna: "+rsCols.getInt(7)
                                                                //COLUMN_SIZE ----------->7
                        + "\nPermite nulos: " +rsCols.getString(18)
                                                                //IS_NULLABLE ----------->18
                        + "\n-----------------------------------"
                    );
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejer_9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(T4Ejer_9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //h.Mediante las funciones getPrimaryKeys y getExportedKeys 
    //obtén todas las claves primarias y foráneas de las base de datos ADD.
    
    public void ejer9_h(){
        DatabaseMetaData dbmt = null;
        try{
            this.conection.abrirConexion("add", "localhost", "root", "isR00t");
            dbmt = this.conection.getConexion().getMetaData();
            
//            ResultSet rsPKs = dbmt.getPrimaryKeys("add", "%", "%");
            ResultSet rsTables = dbmt.getTables("add", null, null, null);
            
            while(rsTables.next()){
                ResultSet rsKs = dbmt.getImportedKeys("add", null, rsTables.getString(3));
                while(rsKs.next()){
                    System.out.println("Nombre de la PK: "+rsKs.getString(4)
                                     + "\nTabla de la que es PK: "+rsKs.getString(3)
                                     + "\nEs FK? "+ (rsKs.getString(8) == null ? "NO" : "SÍ"
                                             + "\nTabla en la que es FK: "+ rsKs.getString(7))
                                     + "\n------------------------------------------"
                    );
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejer_9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(T4Ejer_9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}