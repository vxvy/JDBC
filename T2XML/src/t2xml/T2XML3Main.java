/*
Crea un método 
que muestre todas las películas junto con el nombre y apellido de su/sus directores 
además del género al que pertenece.
 */
package t2xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author VCV
 */
public class T2XML3Main {
    public static void main(String[]args){
        
        CrearArbol arbolXML=new CrearArbol();
        
        Document xmlDocument=arbolXML.crearArbol("C:\\Users\\VCV\\Desktop\\XMLFiles\\peliculas.xml");
        
        T2XML3 ejercicio = new T2XML3();
        ejercicio.ejer3(xmlDocument);
    }
}
