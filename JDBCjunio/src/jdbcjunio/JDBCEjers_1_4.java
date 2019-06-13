/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcjunio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VCV
 */
public class JDBCEjers_1_4 {
    
    public Conexion cntn = new Conexion();
    
    /*1.Crea un método que pasándole un nombre de campo y un valor 
    nos devuelva todas las filas que contengan ese valor. 
    Hay que tener en cuenta y tratar de forma correcta 
    los campos enformato texto y los campos numéricos.*/
    public void obtenerTuplasConValor(String nombreColumna, String valorCampo){
        String query = "SELECT * FROM deportistas WHERE "+nombreColumna+" = '"+valorCampo+"';";
        Statement stmt = null;
                
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                stmt = this.cntn.getConnection().createStatement(); 
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    System.out.println(
                            rs.getRow() + " - "+
                                    "Nombre de columna: " + nombreColumna + 
                                    "\r\nNombre del deportista: " + rs.getNString("nombre")+
                                    "\r\nDeporte: " +rs.getNString(nombreColumna) 
                    );
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
    
    /*2.Borre filas de la tabla un función de su id.  
    Deberá devolver el número de filas borradas*/
    public int borraPorId(int idBorrar){
        int filasBorradas = 0;
        String query = "DELETE FROM deportistas WHERE id="+idBorrar;
        Statement stmt = null;
        
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection() != null){
                stmt = this.cntn.getConnection().createStatement();
                filasBorradas = stmt.executeUpdate(query);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection() != null){
                this.cntn.cerrarConexion();
            }
        }
//        return "Se han borrado "+filasBorradas+" filas con el id "+idBorrar+".";
        return filasBorradas;
    }
    
    /* 3.Nos permita actualizar filas de una tabla en función de su id. 
       Deberá devolver el número de filas actualizadas*/
    public int updatePorId(int id){
        int filasActualizadas = 0;
        String query = "UPDATE deportistas"
                     + "SET nombre = Juanito Martinez"
                     + "WHEN id = "+id+";";
        Statement stmt = null;
        
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                stmt = this.cntn.getConnection().createStatement();
                filasActualizadas = stmt.executeUpdate(query);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection() != null){
                this.cntn.cerrarConexion();
            }
        }
        
        return filasActualizadas;
    }
    
    /*4.Inserte una fila en la tabla. 
    El campo id debe insertarse de forma automática.*/
    public void insertaDato(){
        String query = "INSERT INTO deportistas(id, nombre, activo, genero, deporte) "
                     + "VALUES(default, 'pinwino', 1, 'masculino', 'ski')";
        Statement stmt = null;
        
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                stmt = this.cntn.getConnection().createStatement();
                int inserted = stmt.executeUpdate(query);
                if(inserted>0){
                    System.out.println("Fila insertada");
                }else{
                    System.out.println("Falló la inserción");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCEjers_1_4.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
        }
    }
}
