/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcjunio;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VCV
 */
public class JDBCEjers_8_9 {
    
    Conexion cntn = new Conexion();
    
//    https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html
    //8.Muestra los siguientes metadatos de la base de datos actual:
    
    public ArrayList<Object> getMetadata(){
        
        ArrayList<Object> dbmtCatalogsStmt = new ArrayList<>();
        DatabaseMetaData dbmt = null;
        ResultSet rsCatalogs = null;
        Statement stmt = null;
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection() != null){
                dbmt = this.cntn.getConnection().getMetaData();
                rsCatalogs = dbmt.getCatalogs();
                stmt = this.cntn.getConnection().createStatement();
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
        }
        dbmtCatalogsStmt.add(dbmt);
        dbmtCatalogsStmt.add(rsCatalogs);
        dbmtCatalogsStmt.add(stmt);
        
        return dbmtCatalogsStmt;
    }
    
//    a)Bases de datos disponibles.

    public void ejer8A(){
        ArrayList<Object> dbmtCatalogsStmt = this.getMetadata();
        
        DatabaseMetaData dbmt = null;
        ResultSet rsCatalogs = null;
        Statement stmt = null;
        
        for(int i = 0; i < dbmtCatalogsStmt.size();i++){
            Object aux = dbmtCatalogsStmt.get(i);
            if(aux instanceof DatabaseMetaData){
                dbmt = ((DatabaseMetaData)aux);
            }else if(aux instanceof ResultSet){
                rsCatalogs = ((ResultSet)aux);
            }else{
                stmt = ((Statement)aux);
            }
        }
        
        try{
            System.out.println("Bases de datos");
            while(rsCatalogs.next()){
                System.out.println(rsCatalogs.getString(1));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
    
//    b)Nombre de la tabla y tipo dentro de una base de datos concreta.
    
    public void ejer8B(){
        DatabaseMetaData dbmt = null;
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection() != null){
                dbmt = this.cntn.getConnection().getMetaData();
    //            Statement stmt = this.cntn.getConnection().createStatement();
                ResultSet rsCatalogs = dbmt.getCatalogs();

                while(rsCatalogs.next()){
                    System.out.println("Base de datos: "+rsCatalogs.getString(1));
                    ResultSet rsTabla = 
                            dbmt.getTables(rsCatalogs.getString(1), null, null, null);
                    while(rsTabla.next()){
                        System.out.println("Tabla: "+rsTabla.getString(3));
                    }
                    System.out.println("Fín de la base de datos");
                }
            }
        } catch (SQLException sqle) {
            Logger.getLogger(JDBCEjers_8_9.class.getName()).log(Level.SEVERE, null, sqle);
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
        }
    }
    
//    c)Nombre de las columnas de la tabla naves, tipo de dato y si permite nulos.
    
    public void ejer8C(){
        DatabaseMetaData dbmt = null;
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection() != null){
                dbmt = this.cntn.getConnection().getMetaData();
                Statement stmt = this.cntn.getConnection().createStatement();
                ResultSet rsCatalogs = dbmt.getCatalogs();
                
                while(rsCatalogs.next()){
                    System.out.println("Base de datos: "+rsCatalogs.getString(1));
                    ResultSet rsTabla =
                        dbmt.getTables(rsCatalogs.getString(1), null, null, null);
                    while(rsTabla.next()){
                        if(rsTabla.getString(3).equals("deportistas")){
                            System.out.println("Tabla: "+rsTabla.getString(3));
                            ResultSet rsCols = 
                                dbmt.getColumns(rsCatalogs.getString(1), null, null, null);
                            while(rsCols.next()){
                                System.out.println(
                                        "Columnas de "+rsCols.getString(3)
                                        +"\nNombre de la columna: "+ rsCols.getString(4) 
                                        +"\nTipo de dato "+ rsCols.getString(6)
                                        +"\nEs nullable? "+ (rsCols.getInt(11) == 1? "Sí":"No")
                                        );
                            }
                        }
                    }
                    System.out.println("Fín de la base de datos");
                }
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
        }
    }
    
//    d)Campo que es clave primaria de tabla notas.
    
    public void ejer8D(){
        DatabaseMetaData dbmt = null;
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                dbmt= this.cntn.getConnection().getMetaData();
                ResultSet rsCatalogs= dbmt.getCatalogs();
                
                while(rsCatalogs.next()){
                    System.out.println("Database: "+rsCatalogs.getString(1));
                    ResultSet rsTables = dbmt.getTables(rsCatalogs.getString(1), null, null, null);
                    
                    while(rsTables.next()){
                        System.out.println("Table: "+rsTables.getString(3));
                        if(rsTables.getString(3).equals("deportistas")){
                            ResultSet rsPK = 
                                    dbmt.getPrimaryKeys(rsCatalogs.getString(1), null, rsTables.getString(3));
                            
                            while(rsPK.next()){
                                System.out.println(rsPK.getString(4));
                            }
                        }
                    }
                }
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
        }
    }
    
    
    //9.Muestra los siguientes metadatos de la consulta 
    //  que muestre todos los datos de la tabla salas.

    public void ejer9(){
        DatabaseMetaData dbmd = null;
        this.cntn.abrirConexion("examen", "localhost", "root", "");
        try{
            if(this.cntn.getConnection()!=null){
                dbmd = cntn.getConnection().getMetaData();
                ResultSet rs = dbmd.getCatalogs();
                
                while(rs.next()){
                    if(rs.getString(1).equals("examenes")){
                        ResultSet rsTablas = dbmd.getTables(rs.getString(1), null, null, null);
                        while(rsTablas.next()){
                            if(rsTablas.getString(3).equals("salas")){
                                ResultSet rsCols = dbmd.getColumns(rs.getString(1), null, rsTablas.getString(3), null);
                                while(rsCols.next()){
                                    System.out.println(
                                            "Database: "+rs.getString(1)
                                            +"\n Tabla: "+rsTablas.getString(3)
                                            +"\n Columna: "+rsCols.getString(4)
                                    );
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCEjers_8_9.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            if(cntn.getConnection()!=null){
                cntn.cerrarConexion();
            }
        }
    }

//    a)Nombre de las columnas que devuelve 
    //así como el alias de estos (en caso de existir).
    
    public void ejer9a(){
        DatabaseMetaData dbmd = null;
        this.cntn.abrirConexion("examen", "localhost", "root", "");
        try{
            if(this.cntn.getConnection()!=null){
                dbmd = cntn.getConnection().getMetaData();
                ResultSet rs = dbmd.getCatalogs();
                while(rs.next()){
                    ResultSet rsTabla = dbmd.getTables(rs.getString(1), null, null, null);
                    while(rsTabla.next()){
                        ResultSet rsColu = dbmd.getColumns(rs.getString(1), null, rsTabla.getString(3), null);
                        int cont = 1;
                        while(rsColu.next()){
                            System.out.println(
                                    "Database: "+rs.getString(1)
                                +"\n Tabla: "+rsTabla.getString(3)
                                +"\n Nombre: "+ rsColu.getString(4)
                                +"\n Alias: '"+rsColu.getMetaData().getColumnName(cont)+"'"
                            );
                            cont++;
                        }
                    }
                }
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
        }
    }

//    b)Nombre del tipo de dato de la columna

    public void ejer9b(){
        DatabaseMetaData dbmd = null;
        this.cntn.abrirConexion("examen", "localhost", "root", "");
        try{
            if(this.cntn.getConnection()!=null){
                dbmd = cntn.getConnection().getMetaData();
                ResultSet rs=dbmd.getCatalogs();
                
                while(rs.next()){
                    ResultSet rsTabla = dbmd.getTables(rs.getString(1), null, null, null);
                    while(rsTabla.next()){
                        ResultSet rsCol = dbmd.getColumns(rs.getString(1), null, rsTabla.getString(3), null);
                        while(rsCol.next()){
                            System.out.println(
                                    "Database: "+rs.getString(1)
                                +"\n Tabla: "+rsTabla.getString(3)
                                +"\n Nombre: "+ rsCol.getString(4)
                                +"\n Alias: '"+rsCol.getString(6)
                            );
                        }
                    }
                }
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
        }
    }
}