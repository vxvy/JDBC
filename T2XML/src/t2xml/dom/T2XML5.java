/*
Crea un método que muestre las películas que tienen más n directores. 
Siendo n un parámetro que se la pasa la método
 */
package t2xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author VCV
 */
public class T2XML5 {
    public void masDeNDirectores(Document docXML, int n){
        
        NodeList listaPelis, listaContenidoPeli, listaContenidoEnElementosPeli;
        Node nPelicula, nItemContenidoPeli, nElementoPeli;
        int contDirectores=0;
        String tituloPeli="";
        boolean imprime=true;
        
        listaPelis = docXML.getElementsByTagName("pelicula");
        
        //Itera de película en película
        for(int i = 0;i < listaPelis.getLength();i++){
            nPelicula=listaPelis.item(i);
            if(nPelicula.hasChildNodes()){
                listaContenidoPeli=nPelicula.getChildNodes();
                
                //Itera dentro de cada película
                for(int j = 0;j<listaContenidoPeli.getLength();j++){
                    nItemContenidoPeli=listaContenidoPeli.item(j);
                    if(nItemContenidoPeli.getNodeName().equals("director")){
                        contDirectores++;
                    }
                }
                if(contDirectores>n){
                    //Imprimir contenido de contenidoPeli después de iterar el contenido de la película
                    for(int j = 0;j<listaContenidoPeli.getLength();j++){
                        nElementoPeli=listaContenidoPeli.item(j);
                        if(!nElementoPeli.getNodeName().equals("#text")){
                            System.out.println(nElementoPeli.getNodeName()+": ");
                        }
                        listaContenidoEnElementosPeli=nElementoPeli.getChildNodes();
                        for(int k=0;k<listaContenidoEnElementosPeli.getLength();k++){

                            if(listaContenidoEnElementosPeli.item(k).getNodeType()==Node.ELEMENT_NODE){
                                //Aquí imprime el contenido de "director"
                                System.out.println(
                                        "\t"+listaContenidoEnElementosPeli.item(k).getNodeName()+": "
                                        +"\t"+listaContenidoEnElementosPeli.item(k).getFirstChild().getNodeValue());
                            }else if(listaContenidoEnElementosPeli.item(k).getParentNode().getNodeName().equals("titulo")){
                                    //Aquí imprime el título
                                System.out.println("\t"+listaContenidoEnElementosPeli.item(k).getNodeValue());
                            }
                        }
                    }
                    System.out.println("------------------------------------");
                }  
                //Termina de iterar el contenido de la película, 
                //reinicia el contador de directores
                contDirectores = 0;
            }
        }
    }
}
