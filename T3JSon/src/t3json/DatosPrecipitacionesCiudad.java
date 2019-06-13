/*
fecha, temperatura, humedad, probabilidad de cielo con nubes, 
velocidad del viento y pronóstico del tiempo
 */
package t3json;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.json.JsonObject;

/**
 *
 * @author VCV
 */
public class DatosPrecipitacionesCiudad {
    public String pNombre, pFecha, pPredMeteo;
    public int pTemperatura, pHumedad, pNubes, pVelViento;
    
    public DatosPrecipitacionesCiudad(){
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }
    
    public void setpFecha(long tiempoUnix) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.pFecha = Instant.ofEpochSecond(tiempoUnix).atZone(ZoneId.of("GMT+1")).format(parser);
    }

    public void setpPredMeteo(JsonObject pPredMeteo) {
        this.pPredMeteo = pPredMeteo.toString();
    }

    public void setpTemperatura(int pTemperatura) {
        this.pTemperatura = pTemperatura;
    }

    public void setpHumedad(int pHumedad) {
        this.pHumedad = pHumedad;
    }

    public void setpNubes(int pNubes) {
        this.pNubes = pNubes;
    }

    public void setpVelViento(int pVelViento) {
        this.pVelViento = pVelViento;
    }
    @Override
    public String toString(){
        return pNombre+"||"+pFecha+"||"+pPredMeteo+"||"+pTemperatura+"||"+pHumedad+"||"+pVelViento;
    }
}