/*
14. Crea un "manejador" que produzca una salida similar a:
Comienzo a leer
<filmoteca>
    <pelicula>
        <titulo>Dune</titulo>
        <director>
            <nombre>David</nombre>
            <apellido>Lynch</apellido>
        </director>
    </pelicula>
    <pelicula>
        <titulo>El Señor de los Anillos</titulo>
        <director>
            <nombre>Peter</nombre>
            <apellido>Jackson</apellido>
        </director>
    </pelicula>
    ...

http://www.cs.sjsu.edu/~pearce/modules/lectures/web/jax/SAX.htm
 */
package t2sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author VCV
 */
public class T2SAX2 extends DefaultHandler{
    
    boolean childHasText=false;
    int profundidad=0;
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Crea un \"manejador\" que produzca una salida similar a...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        profundidad++;
        for(int i=0;i<profundidad;i++){
            System.out.print("\t");
        }
        System.out.print("<"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {  
        String texto=new String(ch, start, length).trim();
        if(texto.length()==0){
            childHasText=false;
//            System.out.println(texto.length());
            System.out.println();
        }else{
            childHasText=true;
            System.out.print(texto);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(!childHasText){
            for(int i=0;i<profundidad;i++){
                System.out.print("\t");
            }
        }
        System.out.print("</"+qName+">");
        profundidad--;
    }
    
}