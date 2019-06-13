/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcjunio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author VCV
 */
public class JDBCEjers_5 {

    Conexion cntn = new Conexion();
    
//  5.Realiza las siguientes consultas:
    public ResultSet queryExecutioner(String query){
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            this.cntn.abrirConexion("ad_tema6", "localhost", "root", "");
            if(this.cntn.getConnection()!=null){
                stmt = this.cntn.getConnection().createStatement();
                rs = stmt.executeQuery(query);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            if(this.cntn != null){
                this.cntn.cerrarConexion();
            }
        }
        
        return rs;
    }

//    a)Dado un país devuelva el número de naves totales que tenga.

    
    public int numDeportistasPorDeporte(String deporte){
        String query = "SELECT nombre FROM deportistas WHERE deporte = '"+deporte+"';";
        ResultSet rs = this.queryExecutioner(query);
        int numDeportistasPorDeporte = 0;
        try{
            while(rs.next()){
                numDeportistasPorDeporte++;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return numDeportistasPorDeporte;
    }
//    b)Dado un país devuelva el número de naves que tiene en cada estado.
    
    public int numDeportistasDeporteGenero(String deporte, String genero){
        String query = "SELECT nombre FROM deportistas "
                + "WHERE deporte ='"+deporte+"' AND genero = '"+genero+"';";
        ResultSet rs = this.queryExecutioner(query);
        int numDerpoDeporteGenero = 0;
        try{            
            while(rs.next()){
                numDerpoDeporteGenero++;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return numDerpoDeporteGenero;
    }
    
//    c)¿Qué naves no tienen un estado asignado?
    public void numDeporSinDeporte(String deporte){
        String query = "SELECT nombre, deporte FROM deportistas WHERE "+deporte+" IS NULL;";
        ResultSet rs = this.queryExecutioner(query);
        try{
            while(rs.next()){
                System.out.println(rs.getRow()+" Nombre: "+rs.getNString("nombre")+" Deporte: "+rs.getNString("deporte"));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }    
    }
    
//    d)La segunda y tercera con un volumen de carga mayor*/
    public void segundoYTercerDeporteMasPracticado(){
        String query = "SELECT deporte, COUNT(deporte) AS 'cuenta' FROM deportistas "
                + "GROUP BY deporte "
                + "ORDER BY cuenta DESC "
                + "LIMIT 1,2";
        ResultSet rs = this.queryExecutioner(query);
        try{
            while(rs.next()){
                System.out.println(rs.getRow() + " Deporte: " +rs.getNString("deporte")+" Numero de jugadores: "+rs.getInt(2));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
