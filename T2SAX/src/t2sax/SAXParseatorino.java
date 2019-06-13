/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2sax;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author VCV
 */
public class SAXParseatorino {
    public SAXParseatorino(String xml, DefaultHandler handler) throws ParserConfigurationException, SAXException, IOException {
        try{
//            SAXHandler handler = new SAXHandler();
            SAXParserFactory saxPF = SAXParserFactory.newInstance();
            SAXParser saxP = saxPF.newSAXParser();
            saxP.parse(new File(xml), handler);
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        catch(SAXException saxe){
            saxe.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
