/*
7.Crea dos métodos: 
 Dado el título de una película le añada, si no existe, un atributo pasado como parámetro.
 Dado el título de una película y un atributo, si existe lo elimine
 */
package t2xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author VCV
 */
public class T2XML7 {
    
    Document docXML;
    public T2XML7(Document docXML){
        this.docXML=docXML;
    }
    
    public void anyadeAtributoAPeli(String tituloPeli,String nuevoAtributo) throws NullPointerException{
        Node nPeli=buscaPelis(tituloPeli);
        NamedNodeMap nnmAtributos;
        boolean coincideAtributo=false;
        
//        Comprueba en qué película estamos
//        System.out.println(nPeli.getChildNodes().item(1).getFirstChild().getNodeValue());

        if(nPeli.hasAttributes()){
            nnmAtributos=nPeli.getAttributes();
            for(int i = 0; i < nnmAtributos.getLength();i++){
                if(nnmAtributos.item(i).getNodeName().equals(nuevoAtributo)){
                    System.err.println("Ya existe el atributo "+nuevoAtributo);
                    coincideAtributo=true;
                }
            }
        }
        //Si no existen coincidencias inserta atributo
        if(!coincideAtributo){
            ((Element)nPeli).setAttribute(nuevoAtributo, "contenidoAtributo");
                    System.err.println("En teoría se ha creado "+nuevoAtributo);
        }
        
    }
    public void quitaAtributoAPeli(String tituloPeli,String nuevoAtributo) throws NullPointerException{
        
        Node nPeli=buscaPelis(tituloPeli);
        
        NamedNodeMap nnmAtributos;
        boolean coincideAtributo=false;
        
        if(nPeli.hasAttributes()){
            nnmAtributos=nPeli.getAttributes();
            for(int i = 0; i < nnmAtributos.getLength();i++){
                if(nnmAtributos.item(i).getNodeName().equals(nuevoAtributo)){
                    System.err.println("Sí existe el atributo "+nuevoAtributo);
                    coincideAtributo=true;
                }
            }
        }
        //Si no existen coincidencias inserta atributo
        if(coincideAtributo){
            ((Element)nPeli).removeAttribute(nuevoAtributo);
            System.err.println("En teoría se borró el atributo "+nuevoAtributo);
        }
        
    }
    
    public Node buscaPelis(String tituloPeli) throws NullPointerException{
        NodeList listPelis, listElementosPeli;
        Node peliEncontrada;
        NamedNodeMap nnmAtributos;
        boolean coincideAtributo=false;
        
        listPelis=this.docXML.getElementsByTagName("pelicula");
        
        for(int i=0;i<listPelis.getLength();i++){
            if(listPelis.item(i).hasChildNodes()){
                listElementosPeli=listPelis.item(i).getChildNodes();
                for(int j=0; j<listElementosPeli.getLength();j++){
                    if(listElementosPeli.item(j).hasChildNodes() &&
                            listElementosPeli.item(j).getFirstChild().getNodeValue().equals(tituloPeli)){

//                        System.err.println(listElementosPeli.item(j).getFirstChild().getNodeValue());
//                        Comprueba que el título sea el dado

                        return listPelis.item(i);

//                      Lo mismo que el método de más arriba...
//
//                        peliEncontrada=listPelis.item(i);
//                        
//                        if(peliEncontrada.hasAttributes()){
//                            nnmAtributos=peliEncontrada.getAttributes();
//                            for(int k = 0; k < nnmAtributos.getLength();k++){
//                                if(nnmAtributos.item(k).getNodeName().equals("gener")){
//                                    coincideAtributo=true;
//                                    System.err.println("Se ejecutó");
//                                }
//                            }
//                        }
//
//                        if(!coincideAtributo){
//                            ((Element)peliEncontrada).setAttribute("palomitas", "contenidoAtributo");
//                            System.err.println("Se ejecutó addAttri");
//
//                        }
                        
                        
                    }
                }
            }
        }
        
        return null;
    }
}
