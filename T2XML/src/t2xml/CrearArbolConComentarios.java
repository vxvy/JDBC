/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author VCV
 */
public class CrearArbolConComentarios {
    
    public Document crearArbol(String ruta){
        Document documenterino=null;
        
        try{
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(false);
            
            DocumentBuilder db=dbf.newDocumentBuilder();
            documenterino=db.parse(ruta);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return documenterino;
    }
}
