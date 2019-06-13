/*
1. Un método que permita consultar alumnos que contengan una cadena de caracteres en su nombre. 
Además deberá visualizar el número de resultados obtenidos

2. Dar de alta alumnos y asignaturas

3. Dar de baja alumnos y asignaturas.

4. Modificar alumnos y asignaturas.

5. Realiza las siguientes consultas:
     Nombres de las aulas con alumnos
     Nombre  de  los  alumnos, de  las  asignaturas y notas de aquellos alumnos que han aprobado alguna asignatura.
     Nombre de las asignaturas sin alumnos.

 */
package t4conectores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VCV
 */
public class T4Ejers_1_2_3_4_5 {
    
    
    //Ejer1
    public int consultaNombre(){
    
        String query = "SELECT nombre FROM alumnos WHERE nombre IS NOT NULL;";
        Conexion conectionerino = new Conexion();
        Statement stmt=null;
        int contadorDeResultados=0;
        try{
            conectionerino.abrirConexion("add", "localhost", "root", "isR00t");
            stmt=conectionerino.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
//            contadorDeResultados = 0;
            while(rs.next()){
                contadorDeResultados++;
            }
            
            /*Codigo repetido en el finally*/
//            if(stmt != null){
//                try {
//                    stmt.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            conectionerino.cerrarConexion();
            /******************************/
            
            return contadorDeResultados;
        }catch(SQLException sqle){
            sqle.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conectionerino.cerrarConexion();
        }
        return contadorDeResultados;
    }
     
    //Ejer 2
    public void darDeAltaAlumnosYAsignaturas(String aluAsig, boolean esAlumno){
        String query;
        if(esAlumno){
            //es alumno
            query = "INSERT INTO "+aluAsig+"(codigo, nombre, apellidos, altura)"
                    + "VALUES (default, 'alu', 'relleno', 1.6);";
        }else{
            //es asignatura
            query = "INSERT INTO "+aluAsig+"(COD,Nombre)"
                    + "VALUES(79,'Bases de patoss');";
        }
        
        Conexion cntn = new Conexion();
        Statement stmt=null;
        try{
            cntn.abrirConexion("add", "localhost", "root", "isR00t");
            stmt = cntn.getConexion().createStatement();
            int filasAfectadas=stmt.executeUpdate(query);
            
            System.out.println("Número de filas afectadas "+filasAfectadas);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cntn.cerrarConexion();
        }
    }
    
    //Tanto en dar de baja como en modificar uso el >8 y >9 
    //para eliminar los registros creados en el primer ejercicio, 
    //que siempre serán mayores que la cantidad original de alumnos y asignaturas
    
    //Ejer3
    public void darDeBajaAlumnosYAsignaturas(String aluAsig, boolean esAlumno){
        String query;
        if(esAlumno){
            query = "DELETE FROM "+aluAsig+" WHERE codigo>9;";
        }else{
            query = "DELETE FROM "+aluAsig+" WHERE COD>8;";
        }
        
        Conexion cntn = new Conexion();
        Statement stmt=null;
        try{
            cntn.abrirConexion("add", "localhost", "root", "isR00t");
            stmt = cntn.getConexion().createStatement();
            int filasAfectadas=stmt.executeUpdate(query);
            
            System.out.println("Número de filas afectadas "+filasAfectadas);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cntn.cerrarConexion();
        }
    }
    
    //Ejer4
    public void modificarAlumnosYAsignaturas(String aluAsig, boolean esAlumno){
        String query;
        if(esAlumno){
            query = "UPDATE "+aluAsig+
                    " SET nombre='Juancho'"+
                    " WHERE codigo>9;";
        }else{
            query = "UPDATE "+aluAsig+
                    " SET Nombre='Base de Datos'"+ 
                    " WHERE COD>8;";
        }
        Conexion cntn = new Conexion();
        Statement stmt=null;
        try{
            cntn.abrirConexion("add", "localhost", "root", "isR00t");
            stmt = cntn.getConexion().createStatement();
            int filasAfectadas=stmt.executeUpdate(query);
            
            System.out.println("Número de filas afectadas "+filasAfectadas);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cntn.cerrarConexion();
        }
    }
    
    //Ejer5
    public void consultarNombresVarios(int opcion){
        String query="";
        switch(opcion){
            case 1:
                query="SELECT nombreAula"
                        + " FROM aulas"
                        + " WHERE numero=ANY(SELECT aula FROM alumnos) "
                        + " AND nombreAula IS NOT NULL;";
                break;
            case 2:
                query="SELECT alumnos.nombre AS 'Nombre alumno', asignaturas.NOMBRE AS 'Nombre asignatura', notas.nota FROM alumnos "
                        + "LEFT JOIN notas ON (alumnos.codigo = notas.alumno) "
                        + "LEFT JOIN asignaturas ON (asignaturas.COD = notas.asignatura) "
                        + "WHERE notas.alumno IS NOT NULL;";
                break;
            case 3:
                query="SELECT NOMBRE AS 'Nombre asignatura sin alumnos' "
                        + "FROM asignaturas "
                        + "WHERE NOMBRE NOT IN("
                        +       "SELECT DISTINCT asignaturas.NOMBRE "
                        +       "FROM asignaturas "
                        +       "INNER JOIN notas ON (asignaturas.COD = notas.asignatura)"
                        + ");";
                break;
            default:
                query="";
                System.out.println("No existe esa opción");
                break;
        }
        
        if(!query.equals("")){
            Conexion cntn = new Conexion();
            Statement stmt=null;
            try{
                cntn.abrirConexion("add", "localhost", "root", "isR00t");
                stmt = cntn.getConexion().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                switch(opcion){
                    case 1:
                        System.out.println("Nombres de las aulas con alumnos.");
                        while(rs.next()){
                            System.out.println(rs.getRow() + " " + rs.getString("nombreAula"));
                        }
                        break;
                    case 2:
                        System.out.println("Nombre de los alumnos, de las asignaturas y notas de aquellos alumnos que han aprobado alguna asignatura");
                        while(rs.next()){
                            System.out.println(rs.getRow() + " " + rs.getString("Nombre alumno")+ " " +rs.getString("Nombre asignatura") + " " + rs.getString("nota"));
                        }
                        break;
                    case 3:
                        System.out.println("Nombre asignatura sin alumnos:");
                        while(rs.next()){
                            System.out.println(rs.getRow() + " " + rs.getString("Nombre asignatura sin alumnos"));
                        }
                        break;
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                if(stmt != null){
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(T4Ejers_1_2_3_4_5.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                cntn.cerrarConexion();
            }
        }
        
    }
    
}
