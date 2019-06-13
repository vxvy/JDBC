/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

/**
 *
 * @author VCV
 */
public class CrearArbol {
    public Document crearArbol(String ruta){
        Document documenterino = null;
        try{
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true);
            
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            documenterino=db.parse(ruta);
            //NO OLVIDAR LA ASIGNACIÓN
        }
        catch(Exception e){
            System.err.println(e.getStackTrace());
        }
        
        return documenterino;
    }
}
