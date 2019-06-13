/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcjunio;

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
public class JDBCEjers_6_7_ProcedAlmacenados {
    
    Conexion cntn = new Conexion();
    
     public ResultSet queryExecutionerPS(String query){
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                stmt=this.cntn.getConnection().prepareStatement(query);
                
            }
        
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
        }
        
        
        return rs;
    }
    
//    a)Dado un país devuelva el número de naves totales que tenga.
     
     public int numDeportistasPorDeportePS(String deporte){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT nombre FROM deportistas WHERE deporte = ?;";
        int numDeportistasPorDeporte = 0;
        
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                ps=this.cntn.getConnection().prepareStatement(query);
                ps.setString(1, deporte);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    numDeportistasPorDeporte++;
                }
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCEjers_6_7_ProcedAlmacenados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         return numDeportistasPorDeporte;
     }
     
//    b)Dado un país devuelva el número de naves que tiene en cada estado.

     public int numDeportistasDeporteGeneroPS(String deporte, String genero){
        int numDerpoDeporteGenero = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT nombre FROM deportistas "
                + "WHERE deporte = ? AND genero = ?;";
        
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                ps=this.cntn.getConnection().prepareStatement(query);
                ps.setString(1, deporte);
                ps.setString(2, genero);
                rs = ps.executeQuery();
                while(rs.next()){
                    numDerpoDeporteGenero++;
                }
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCEjers_6_7_ProcedAlmacenados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
         return numDerpoDeporteGenero;
     }

//    c)¿Qué naves no tienen un estado asignado?
     
     public void numDeporSinDeportePS(String deporte){
        String query = "SELECT nombre, deporte FROM deportistas WHERE ? IS NULL;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                ps=this.cntn.getConnection().prepareStatement(query);
                ps.setString(1, deporte);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    System.out.println(
                            rs.getRow()+" Nombre: "+rs.getNString("nombre")
                                    +" Deporte: "+rs.getNString("deporte"));
                }
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCEjers_6_7_ProcedAlmacenados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
     }
     
//    d)La segunda y tercera con un volumen de carga mayor.
     
     public void segundoYTercerDeporteMasPracticadoPS(){
        String query = "SELECT deporte, COUNT(deporte) AS 'cuenta' FROM deportistas "
                + "GROUP BY deporte "
                + "ORDER BY cuenta DESC "
                + "LIMIT 1,2";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                ps=this.cntn.getConnection().prepareStatement(query);
                rs=ps.executeQuery();
            }
        
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn.getConnection()!=null){
                this.cntn.cerrarConexion();
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCEjers_6_7_ProcedAlmacenados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
     }
     
     //7.Ejecuta el procedimiento almacenado países
     
     
}
