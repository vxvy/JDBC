/*
Usando open trivia database: 
https://opentdb.com/api_config.php
genera 20 preguntas de informática de dificultad alta y 
muestra las preguntas y respuestas, marcando las correctas con un *
 */
package t3json;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 *
 * @author VCV
 */
public class T3JS_Ej13 {
    
    JsonArray jarr;
    
    public T3JS_Ej13(){
    
        JSonConstructorDeArbol cda = new JSonConstructorDeArbol();
//        JsonValue jv = cda.montaDesde(System.getProperty("user.home")+"/api.php.json");
        JsonValue jv = cda.montaDesde("https://opentdb.com/api.php?amount=20&category=18&difficulty=hard&type=multiple");
        JsonObject jobj = (JsonObject)jv;
        this.jarr = jobj.getJsonArray("results");
        
    }
    
    public void volcarEnMemoria(){
        
        for(int i = 0; i< this.jarr.size();i++){
            System.out.println("Pregunta: "+(i+1));
            JsonObject objetoActual=(JsonObject)jarr.get(i);
            System.out.println(objetoActual.getString("question"));
            
            JsonArray aux = objetoActual.getJsonArray("incorrect_answers");
            for(int j=0;j<aux.size();j++){
                System.out.println("\t  "+aux.get(j));
            }
            
            System.out.println("\t* \""+objetoActual.getString("correct_answer")+"\"\r\n");
        }
        
    }
    
}