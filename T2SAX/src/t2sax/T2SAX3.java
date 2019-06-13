/*
15. Crea un "manejador" que muestre todas las películas junto con el nombre y apellido 
de su/sus directores además del género al que pertenece
 */
package t2sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author VCV
 */
public class T2SAX3 extends DefaultHandler{

    boolean write=false;
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Crea un \"manejador\" que muestre todas las películas "
                + "junto con el nombre y apellido \n"
                + "de su/sus directores además del género al que pertenece");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(!qName.equals("filmoteca")&&!qName.equals("pelicula")){
            write=true;
            System.out.println(qName+": ");
        }else{
            if(qName.equals("pelicula")){
                for(int i = 0; i<attributes.getLength();i++){
                    if(attributes.getQName(i).equals("genero")){
                        System.out.println("---------------------------------");
                        System.out.println(attributes.getQName(i)+": "+attributes.getValue(i));
                    }
                }
            }
            write=false;
        }
   }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String texto=new String(ch,start,length).trim();
        if(write&&texto.length()>0){
            System.out.println("\t"+texto);
        }
    }
   
}
