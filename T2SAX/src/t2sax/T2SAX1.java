/*
13. Crea un método que lea el fichero peliculas.xml.
 */
package t2sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author VCV
 */
public class T2SAX1 extends DefaultHandler{

    boolean elemTexto=false;
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Crea un método que lea el fichero peliculas.xml");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "titulo":
                System.out.print("Título: ");
                this.elemTexto=true;
                break;
            case "nombre":
                System.out.print("Nombre: ");
                this.elemTexto=true;
                break;
            case "apellido":
                System.out.print("Apellidos: ");
                this.elemTexto=true;
                break;
            default:
                this.elemTexto=false;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(this.elemTexto){
            String texto=new String(ch, start, length);
            System.out.println(texto);
            this.elemTexto=false;
        }
    }

//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if(qName.equals("filmoteca")){
//            System.err.println("FIN");
//        }
//    }
    
    
}
