/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3json;

import java.io.File;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.JsonValue;

/**
 *
 * @author VCV
 */
public class T3JSOUPMain {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        T3JS_Ej1_2_3 ejer1_2_3=new T3JS_Ej1_2_3();
       
        JsonObject jv1=ejer1_2_3.prediccionMeteoCiudad("Cangas");
        System.out.println(jv1);
        JsonObject jv2=ejer1_2_3.prediccionMeteoCoords(0, 0);
        System.out.println(jv2);
        JsonObject jv3=ejer1_2_3.numPrediccionesMeteoCoords(42.4338555, -8.6743651, 5);
        System.out.println(jv3);
        
        T3JS_Ej5_6_7_8_9 ejer5_6_7_8 = new T3JS_Ej5_6_7_8_9(1);

        System.out.println(ejer5_6_7_8.buscaIdCiudad());
        System.out.println(ejer5_6_7_8.buscaNombreCiudad());
        System.out.println(ejer5_6_7_8.buscaCoordenadasCiudad());
        System.out.println(ejer5_6_7_8.buscaDatosPrecipitacionesCiudad());
        
        T3JS_Ej5_6_7_8_9 ejer9 = new T3JS_Ej5_6_7_8_9(5);

        System.out.println(ejer9.buscaDatosPrecipitacionesCiudadesCercanas());
        
        T3JS_Ej13 ejer13 = new T3JS_Ej13();
        ejer13.volcarEnMemoria();
        
        T3JS_Ej14_15_17 ejer14_15_17 = new T3JS_Ej14_15_17();
        ejer14_15_17.encuentraEventos("Pontevedra", 50, 5);

    }    
}
