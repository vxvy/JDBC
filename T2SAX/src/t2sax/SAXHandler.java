/*
 ESTO ES Lo que usa el parser
 */
package t2sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author VCV
 */
public class SAXHandler extends DefaultHandler{
    
    @Override
    public void startDocument()throws SAXException{
        System.err.println("Start document");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("titulo")){
            System.err.println("un titulo");
        }
    }
}
