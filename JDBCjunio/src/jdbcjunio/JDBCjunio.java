/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcjunio;

/**
 *
 * @author VCV
 */
public class JDBCjunio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JDBCEjers_1_4 ejers = new JDBCEjers_1_4();
        
        //Ej1 consulta tabla - valor
//        ejers.obtenerTuplasConValor("deporte", "Taekwondo");
//        ejers.obtenerTuplasConValor("deporte", "Baloncesto");
        
        //Ej4 Inserta
//        ejers.insertaDato();
        
        //Ej3 Modifica
//        ejers.updatePorId(115);
                
        //Ej2 Elimina
//        ejers.borraPorId(115);
        
        JDBCEjers_8_9 ejers89 = new JDBCEjers_8_9();
        ejers89.ejer8D();
        
    }
    
}
