/*
14.
Crea un método que 
dado un una localidad, una cantidad de kilómetros y una cantidad X,
nos devuelva los X eventos cercanos a esa localidad en el radio especificado.

15.
Crea dos métodos que para que cada evento anterior muestre la información detallada 
de cada lugar en el que se desarrolle y
la información detallada del evento.

17. 
¿Cuál es el tiempo actual de cada ciudad en donde se desarrollen los eventos encontrados?
 */


package t3json;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 *
 * @author VCV
 */
public class T3JS_Ej14_15_17 {

    JSonConstructorDeArbol cda = new JSonConstructorDeArbol();
    JsonArray jarr;
    
    public T3JS_Ej14_15_17(){}
    
    //Ej14
    public void encuentraEventos(String localidad, int kiloRadio, int numEventos){
        JsonValue jv = cda.montaDesde("http://api.eventful.com/json/events/search?q=music&l="+localidad+"&units=km&within="+kiloRadio+"&page_size="+numEventos+"&app_key=c2tPtVFTrSk8xnQS");
        JsonObject jobj = (JsonObject)jv;
//        System.out.println(jobj);
        this.jarr = jobj.getJsonObject("events").getJsonArray("event");
        for(int i = 0 ; i < numEventos; i++){
            JsonObject eventoActual = jarr.getJsonObject(i);
            System.out.println("Evento número: "+(i+1)+" de "+numEventos+" :: "+eventoActual.getString("title")+" en "+eventoActual.getString("city_name")+", cerca de "+localidad);
            this.infoEvento(eventoActual);
            this.infoCiudadEvento(eventoActual);
            
            double longitud=Double.parseDouble(eventoActual.getString("longitude"));
            double latitud=Double.parseDouble(eventoActual.getString("latitude"));
            this.infoMeteoCiudadEvento(longitud, latitud);
            System.out.println("----------------------------------------");
        }
    }
    
    //Ej15.a Info del evento
    public void infoEvento(JsonObject eventoActual){
        System.out.println("Información evento:\n"
                +"\tDirección: "+eventoActual.getString("venue_name")+"\n"
                +"\tDescripción del evento: "+eventoActual.getString("description", "no hay descripción")+"\n"
                +"\tId del evento: "+eventoActual.getString("id")+"\n"
                +"\tHora de inicio: "+eventoActual.getString("start_time")+"\n"
                +"\tWeb del evento: "+eventoActual.getString("url")+"\n"
        );
    }
    
    //Ej15.b Info de ciudad evento
    public void infoCiudadEvento(JsonObject eventoActual){
        System.out.println("Información ciudad evento:\n"
                +"\tCiudad: "+eventoActual.getString("city_name")+"\n"
                +"\tPaís: "+eventoActual.getString("country_name")+"("+eventoActual.getString("country_abbr")+")\n"
                +"\tLatitud: "+Double.parseDouble(eventoActual.getString("latitude"))+"\n"
                +"\tLongitud: "+Double.parseDouble(eventoActual.getString("longitude"))+"\n"
        );
    }
    
    //Ej17 Info meteo ciudad
    public void infoMeteoCiudadEvento(double longitud, double latitud){
        T3JS_Ej1_2_3 ej3=new T3JS_Ej1_2_3();
        JsonObject jobTiempoCiudad=ej3.prediccionMeteoCoords(longitud, latitud);
        JsonObject jobMeteoCiudad=jobTiempoCiudad.getJsonArray("weather").getJsonObject(0);
        System.out.println("Información meteorológica:\n"+
                "\tTiempo: "+jobMeteoCiudad.getString("main")+" - "+jobMeteoCiudad.getString("description")+"\n"
                +"\tCielo: "+jobTiempoCiudad.getJsonObject("clouds").getInt("all")+"% nublado"
                );
        
        
    }
}
