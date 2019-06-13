/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3json;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author VCV
 */
public class JSonConstructorDeArbol {
    
    public JsonValue montaDesde(String stringURL){
        JsonReader jr=null;
        JsonValue jv=null;
  
        
        try{
            if(stringURL.toLowerCase().startsWith("http://")){
                URL url=new URL(stringURL);
                InputStream is=url.openStream();
                jr=Json.createReader(is); 
            }
            else if(stringURL.toLowerCase().startsWith("https://")){
                //C:\Program Files\Java\jdk1.8.0_77\bin>
                //keytool.exe -import -v -file C:\Users\VCV\Desktop\opentdbcom.crt -keystoreC:\Users\VCV\Desktop\opentdbcom.crt.jks -storepass drowssap
                System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\VCV\\Desktop\\opentdbcom.crt.jks");
                
                URL url=new URL(stringURL);
                HttpsURLConnection httpsURL = (HttpsURLConnection)url.openConnection();
                InputStream is=url.openStream();
                jr=Json.createReader(is);
           }else{
                jr=Json.createReader(new FileReader(stringURL));
            }
            jv=jr.read();
        }catch(IOException e){
            System.out.println("Error procesando documento Json: \n"+e.getLocalizedMessage());
        }finally{
            if(jr!=null){
                jr.close();
            }
        }
        return jv;
    }
}