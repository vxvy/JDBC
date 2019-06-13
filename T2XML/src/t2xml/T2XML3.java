/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author VCV
 */
public class T2XML3 {
    public void ejer3(Document xmlDocument){
        
        NodeList listaPelis, listaElementosEnPelicula, listaDires,listaDatosDirectores;
        NamedNodeMap nnmAtributos;
        
        listaPelis=xmlDocument.getElementsByTagName("pelicula");
        
        for(int i=0;i<listaPelis.getLength();i++){
//            System.err.println(listaPelis.item(i).getNodeName());



            if(listaPelis.item(i).hasChildNodes()){
                listaElementosEnPelicula=listaPelis.item(i).getChildNodes();
                
                for(int j=0;j<listaElementosEnPelicula.getLength();j++){
//                    System.err.println("\t"+listaElementosEnPelicula.item(j));
                    
                    if(listaElementosEnPelicula.item(j).getNodeName().equals("titulo")){
                        System.out.println(listaElementosEnPelicula.item(j).getFirstChild().getNodeValue());
                    }
//Muestra los títulos

                    if(listaElementosEnPelicula.item(j).getNodeName().equals("director")){
                        listaDires=listaElementosEnPelicula.item(j).getChildNodes();
                        
//                        if (listaDires.item(k).getNodeName().equals("nombre")){
//                                  nombre=listaDires.item(k).getFirstChild().getNodeValue()+nombre;
//                            }
//                            if (listaDires.item(k).getNodeName().equals("apellido")){
//                               nombre+=listaDires.item(k).getFirstChild().getNodeValue();
//                            }
                        
                        for(int k=0;k<listaDires.getLength();k++){
//                            System.err.println("\t\t"+listaDires.item(k).getNodeName());
                            
                            if(listaDires.item(k).hasChildNodes()){
                                listaDatosDirectores=listaDires.item(k).getChildNodes();
                                
                                for(int m=0;m<listaDatosDirectores.getLength();m++){
                                    System.out.print("\t"+listaDatosDirectores.item(m).getNodeValue());
                                }
                            }
                            if(k%2==0){
                                System.out.println("");
                            }
                        }
                    }
//Pruebas de navegación + muestra datos de director
                }
            }
            
            if(listaPelis.item(i).hasAttributes()){
                nnmAtributos=listaPelis.item(i).getAttributes();
                
                for(int j=0; j<nnmAtributos.getLength();j++){
                    
                    if(nnmAtributos.item(j).getNodeName().equals("genero")){
                        System.out.println("\n\t"+nnmAtributos.item(j).getFirstChild().getNodeValue()+"\n"
                                + "-------------------------------------------------------------");
                    }
                }
            }
//Muestra los atributos
            
        }
        
    }
}
