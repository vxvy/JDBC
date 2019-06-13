/*
5. Crea un método que nos devuelva el id de una ciudad en Open Weather Map.

6. Crea un método que nos devuelva el nombre de una ciudad en Open Weather Map.

7. Crea un método que nos devuelva las coordenadas de una ciudad en Open Weather Map.

8. Crea un método que nos devuelva: fecha, temperatura, humedad, probabilidad de cielo con nubes, 
velocidad del viento y pronóstico del tiempo

9. Crea un método que nos devuelva los datos anteriores para las X ciudades cercanas a una dada (incluyendo esta)
 */
package t3json;

import java.time.format.DateTimeFormatter;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 *
 * @author VCV
 */
public class T3JS_Ej5_6_7_8_9 {
    
    JSonConstructorDeArbol jsCda=new JSonConstructorDeArbol();
    JsonValue jv;
    JsonArray jarrList;
    JsonObject ciudadActual;
    
    public T3JS_Ej5_6_7_8_9(int numCiudades){
        this.jv=jsCda.montaDesde("http://api.openweathermap.org/data/2.5/find?lat=42.232819&lon=-8.72264&cnt="+numCiudades+"&APPID=8f8dccaf02657071004202f05c1fdce0");
        JsonObject jobj=(JsonObject)jv;
        this.jarrList = jobj.getJsonArray("list");
        this.ciudadActual=jarrList.getJsonObject(0);
    }
    
    public void setCiudadActual(int nCiudad){
        this.ciudadActual=jarrList.getJsonObject(nCiudad);
    }
    
    //Ej5
    public int buscaIdCiudad(){
        return ciudadActual.getInt("id");
    }
    //Ej6
    public String buscaNombreCiudad(){
        return ciudadActual.getString("name");
    }
    //Ej7
    public JsonObject buscaCoordenadasCiudad(){
        return ciudadActual.getJsonObject("coord");
    }
    //Ej8
    public String buscaDatosPrecipitacionesCiudad(){
        
        DatosPrecipitacionesCiudad dpc=new DatosPrecipitacionesCiudad();
        
        //Nombre 
        dpc.setpNombre(ciudadActual.getString("name"));
        
        //fecha
        dpc.setpFecha(ciudadActual.getInt("dt"));
        
        //predicción general
        JsonArray jarrWeather = ciudadActual.getJsonArray("weather");
        JsonObject jobWeather = jarrWeather.getJsonObject(0);
        dpc.setpPredMeteo(jobWeather);
        
        //temperatura
        JsonObject jobMain = ciudadActual.getJsonObject("main");
        dpc.setpTemperatura(jobMain.getInt("temp"));
        
        //humedad
        dpc.setpHumedad(jobMain.getInt("humidity"));
        
        //nubes%
        JsonObject jobClouds = ciudadActual.getJsonObject("clouds");
        dpc.setpNubes(jobClouds.getInt("all"));
                
        //vel viento
        JsonObject jobWind = ciudadActual.getJsonObject("wind");
        dpc.setpVelViento(jobWind.getInt("speed"));
        
        return dpc.toString();
    }
    //Ej9
    public String buscaDatosPrecipitacionesCiudadesCercanas(){
        String ciudades="";
        int n = this.jarrList.size();
        for(int i = 0; i<n;i++){
            this.setCiudadActual(i);
            ciudades+=buscaDatosPrecipitacionesCiudad()+"\n";
        }
        return ciudades;
    }
}