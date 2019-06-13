/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author VCV
 */
public class T2XML2 {
    public void ejer2(Document pelisXML){
        
        NodeList theTitles=pelisXML.getElementsByTagName("titulo");
        Node title;
        
        for(int i=0;i<theTitles.getLength();i++){
            title=theTitles.item(i);
//            if(title.getNodeType()==Node.ELEMENT_NODE){
                    System.out.println(title.getNodeName()+": "+title.getFirstChild().getNodeValue());
//            }
        }
    }
}
