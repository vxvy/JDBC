/*
6. ¿Cuántos géneros diferentes de películas hay?¿Cuáles son?
 */
package t2xml.dom;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author VCV
 */
public class T2XML6 {
    public void buscaCuentaGenerosDistintos(Document docXML){
        NodeList listaPelis;
        Node nPeli;
        NamedNodeMap nnmAtribs;
        
        listaPelis=docXML.getElementsByTagName("pelicula");
        String []arrAtributos = new String[listaPelis.getLength()];
        
        for(int i=0;i<listaPelis.getLength();i++){
            nPeli=listaPelis.item(i);
            if(nPeli.hasAttributes()){
                nnmAtribs=nPeli.getAttributes();
                for(int j=0;j<nnmAtribs.getLength();j++){
                    if(nnmAtribs.item(j).getNodeName().equals("genero")){
                        arrAtributos[i]=nnmAtribs.item(j).getFirstChild().getNodeValue();
//                        System.out.println(arrAtributos[i]);
                    }
                }
            }
        }

        ArrayList<String> arrLstAtributosDistintos = new ArrayList<>();
        int cuentaIguales=0;
        for(int i=0;i<arrAtributos.length;i++){
            for(int j=0;j<arrAtributos.length;j++){
                if(arrAtributos[i].equals(arrAtributos[j])){
                    cuentaIguales++;
                }
            }
            if(cuentaIguales==1){
                arrLstAtributosDistintos.add(arrAtributos[i]);
            }
            cuentaIguales=0;
        }
        
        System.out.println("Hay "+arrLstAtributosDistintos.size()+" atributos distintos.\nSon: ");
        
        for(int i = 0; i<arrLstAtributosDistintos.size();i++){
            System.out.println(arrLstAtributosDistintos.get(i));
        }
        
    }
}
