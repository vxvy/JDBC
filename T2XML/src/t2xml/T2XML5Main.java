/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2xml;

import org.w3c.dom.Document;

/**
 *
 * @author VCV
 */
public class T2XML5Main {
    public static void main (String[]args){
      
        CrearArbol caXML=new CrearArbol();
        Document docXML=caXML.crearArbol("C:\\Users\\VCV\\Desktop\\XMLFiles\\peliculas.xml");
        
        T2XML5 ejercicio=new T2XML5();
        ejercicio.ejer5(1, docXML);
    }
}
