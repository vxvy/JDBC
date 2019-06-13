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
public class T2XML4Main {
    public static void main(String[]args){
        CrearArbolConComentarios ca=new CrearArbolConComentarios();
        
        Document xmlDoc=ca.crearArbol("C:\\Users\\VCV\\Desktop\\XMLFiles\\peliculas.xml");
        
        T2XML4 ejercicio=new T2XML4();
        ejercicio.ejer4(xmlDoc,0);
    }
}
