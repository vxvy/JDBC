/*
Crea un método que muestre los títulos de las películas
 */
package t2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class T2XML2MAin {
    public static void main(String[]args){
        CrearArbol arbolPelis=new CrearArbol();
        
        Document pelisXML=arbolPelis.crearArbol("C:\\Users\\VCV\\Desktop\\XMLFiles\\peliculas.xml");
        
        T2XML2 ejercicio = new T2XML2();
        ejercicio.ejer2(pelisXML);
        
//        NodeList theTitles=pelisXML.getElementsByTagName("titulo");
//        Node title;
//        
//        for(int i=0;i<theTitles.getLength();i++){
//            title=theTitles.item(i);
//            if(title.getNodeType()==Node.ELEMENT_NODE){
//                    System.out.println(title.getNodeName()+": "+title.getFirstChild().getNodeValue());
//            }
//        }
    }
}
