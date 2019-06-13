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
public class T2XML5 {
    public void ejer5(int numDirectores, Document docXML){
        
        Node nodoFilmoteca;
        
        nodoFilmoteca=docXML.getFirstChild();
        
        metodoRecursivo2(nodoFilmoteca);
    }
        
    public void metodoRecursivo2(Node nodoActual){
        if(nodoActual.hasChildNodes()){
            
            NodeList nuevaList=nodoActual.getChildNodes();  
            for(int i=0; i < nuevaList.getLength(); i++){
                metodoRecursivo2(nuevaList.item(i));
            }
        }
    }
}
        
    
    
        
//        String nombreDire="";
//        int cuenta=0;
        
//        for(int i=0;i<contenidoNodoActual.getLength();i++){
//            nodoActual=contenidoNodoActual.item(i);
//            System.out.println(nodoActual.getNodeName());
//
//            System.out.println(nodoActual.getChildNodes().item(1).getFirstChild().getNodeValue());
//            
//            if(nombreDire.equals(nodoActual.getChildNodes().item(1).getNodeValue())){
//                cuenta++;
//                if(cuenta>=numDirectores){
//                    /*Mostrar película*/
//                    System.err.println("acaca"+cuenta);
//                }
//            }else{
//                nombreDire=nodoActual.getChildNodes().item(1).getFirstChild().getNodeValue();
//                cuenta=0;
//            }
//
//        }
    

