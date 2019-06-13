/*
17. ¿Cuántos géneros distintos de películas hay?
 */
package t2sax;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author VCV
 */
public class T2SAX5 extends DefaultHandler{

    ArrayList<String> lstDiffAtribs=new ArrayList<>();
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("¿Cuántos géneros distintos de películas hay?");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String attGenero;
        int cuentaIguales=0;
        
        if(qName.equals("pelicula")){
            for(int i = 0;i<attributes.getLength();i++){
                if(attributes.getQName(i).equals("genero")){
                    attGenero=attributes.getValue(i);
                    for (String attGuardado : lstDiffAtribs) {
                        if(attGuardado.equals(attGenero)){
                            cuentaIguales++;
                        }
                    }
                    if(cuentaIguales==0){
                        lstDiffAtribs.add(attGenero);
                    }
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("filmoteca")){
            System.out.println("Hay "+lstDiffAtribs.size()+" atributos distintos, son:");
            for(String a:lstDiffAtribs){
                System.out.println(a);
            }
        }
    }
}
