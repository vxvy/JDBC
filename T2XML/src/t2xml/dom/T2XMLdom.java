package t2xml.dom;

import org.w3c.dom.Document;
import t2xml.CrearArbol;

/**
 *
 * @author VCV
 */
public class T2XMLdom {
    public static void main(String[]args){
        CrearArbol caXML=new CrearArbol();
        Document docXML=caXML.crearArbol(System.getProperty("user.home")+"/peliculas.xml");
        Document docXML2=caXML.crearArbol(System.getProperty("user.home")+"/newPeliculas.xml");
        
//        T2XML5 ejer5=new T2XML5();
//        ejer5.masDeNDirectores(docXML,1);

//        T2XML6 ejer6=new T2XML6();
//        ejer6.buscaCuentaGenerosDistintos(docXML);

//        T2XML7 ejer7=new T2XML7(docXML);
//        try{
//            ejer7.anyadeAtributoAPeli("Matrix", "aaaaaatributo");
//            ejer7.quitaAtributoAPeli("Matrix", "aaaaaatributo");
//        }
//        catch(NullPointerException npe){
//            System.err.println("No existe ninguna película con ese nombre.");
//        }
        
        T2XML8 ejer8=new T2XML8(docXML2);
        ejer8.anyadePelicula("Depredador", "John", "Tiernan", "accion", 1987, "en");
    }
}
