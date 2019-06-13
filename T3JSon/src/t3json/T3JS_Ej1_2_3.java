/*
1.-
Crea un método usando Open Weather Map  que 
dada una localidad nos 
devuelva un JsonObject 
con los datos devueltos de las predicciones meteorológicas.

2.
Crea un método usando Open 
Weather Map  que dada una longitud y latitud nos devuelva un JsonObject 
con los datos devueltos de las predicciones meteorológicas.

3.
Crea un método usando Open Weather Map  que dada una longitud y latitud y un cantidad X nos devuelva 
las  X predicciones met
eorológicas de las localidades cercanas a esas coordenadas

https://stackoverflow.com/questions/16251415/not-able-to-convert-json-value-into-json-object
 */
package t3json;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 *
 * @author VCV
 */
public class T3JS_Ej1_2_3 {
    
    public T3JS_Ej1_2_3(){}
    
    //Ej1
    public JsonObject prediccionMeteoCiudad(String ciudad){
        JSonConstructorDeArbol jsCda=new JSonConstructorDeArbol();
        
        JsonValue jv=jsCda.montaDesde("http://api.openweathermap.org/data/2.5/weather?q="+ciudad+",es&lang=es&APPID=8f8dccaf02657071004202f05c1fdce0");
        JsonObject jobj=(JsonObject)jv;
        return jobj;
    }
    
    //Ej2
    public JsonObject prediccionMeteoCoords(double longitud, double latitud){
        JSonConstructorDeArbol jsCda = new JSonConstructorDeArbol();
        
        JsonValue jv=jsCda.montaDesde("http://api.openweathermap.org/data/2.5/weather?lat="+latitud+"&lon="+longitud+"&APPID=8f8dccaf02657071004202f05c1fdce0");
        JsonObject jobj=(JsonObject)jv;
        
        return jobj;
    }
    
    //Ej3
    public JsonObject numPrediccionesMeteoCoords(double latitud, double longitud,int numCiudades){
        JSonConstructorDeArbol jsCda = new JSonConstructorDeArbol();
        JsonValue jv=jsCda.montaDesde("http://api.openweathermap.org/data/2.5/find?lat="+latitud+"&lon="+longitud+"&cnt="+numCiudades+"&APPID=8f8dccaf02657071004202f05c1fdce0");
        
        JsonObject jobj = (JsonObject)jv;
        return jobj;
    }
}