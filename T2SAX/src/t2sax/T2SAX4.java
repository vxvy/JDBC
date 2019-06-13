/*
16. Crea un "manejador" que muestre las películas que tienen n o más directores. 
Siendo n un parámetro que se le pasa la método
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
public class T2SAX4 extends DefaultHandler{

    int nDirectores;
    int cuentaDir;
    String tituPeli;
    boolean write=false;
    public ArrayList<String> lstPelisMasDeN;
    
    
    public T2SAX4(int nDirectores){
        this.nDirectores=nDirectores;
        this.lstPelisMasDeN=new ArrayList<>();
    }
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Crea un \"manejador\" que muestre "
                + "las películas que tienen n o más directores.\n"
                + "Siendo n un parámetro que se la pasa la método.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if(qName.equals("director")){
            cuentaDir++;
        }else if(qName.equals("titulo")){
            write=true;
        }
        
        
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String texto=new String(ch,start,length);
        if(write){
            this.tituPeli=texto;
        }
        write=false;
    }
    
    

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        if(qName.equals("pelicula")){
            if(cuentaDir>nDirectores){
                guardaTitulo(tituPeli);
            }
            cuentaDir=0;
        }else if(qName.equals("filmoteca")){
//            System.err.println("FÍN");
            System.out.println("Las siguientes películas tienen más de "+nDirectores+" directores.");
            for(int i=0;i<lstPelisMasDeN.size();i++){
                System.out.println(lstPelisMasDeN.get(i));
            }
        }
    }

    public void guardaTitulo(String peliConMasDeNDirectores){
        lstPelisMasDeN.add(peliConMasDeNDirectores);
    }
}


