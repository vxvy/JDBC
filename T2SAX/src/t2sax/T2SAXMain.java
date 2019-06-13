/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2sax;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author VCV
 */
public class T2SAXMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
//            SAXHandler saxH=new SAXHandler();
            T2SAX1 saxH=new T2SAX1();
//            T2SAX2 saxH=new T2SAX2();
//            T2SAX3 saxH=new T2SAX3();
//            T2SAX4 saxH=new T2SAX4(1);
//            T2SAX5 saxH=new T2SAX5();
            SAXParseatorino saxPino=new SAXParseatorino(System.getProperty("user.home")+"/peliculas.xml", (DefaultHandler)saxH);
        
        } 
        catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } 
        catch (SAXException saxe) {
            saxe.printStackTrace();
        } 
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
    }
}
