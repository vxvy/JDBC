/*
Añade la siguiente película "Depredador" dirigida en 1987 por John Tiernan dentro del género acción. 
Esta en versión original. Almacena este árbol en un fichero XML.
 */
package t2xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author VCV
 */
public class T2XML8 {
    
    Document docXML;
    
    public T2XML8(Document docXML){
        this.docXML=docXML;
    }
    
    public void anyadePelicula(String elNombrePelicula, String elNombreDirector, String elApellidoDirector, String atriGeneroPeli, int atriAnyoPeli, String atriIdiomaPeli){
        
        Element nPeli=this.docXML.createElement("pelicula");
        nPeli.setAttribute("genero", atriGeneroPeli);
        nPeli.appendChild(this.docXML.createTextNode("\n"));
        
        Element nPeliNTitulo=this.docXML.createElement("titulo");
        Text textNTitulo=this.docXML.createTextNode(elNombrePelicula);
        nPeliNTitulo.appendChild(textNTitulo);
        nPeli.appendChild(nPeliNTitulo);
        nPeli.appendChild(this.docXML.createTextNode("\n"));
        
        Element nPeliNDirector=this.docXML.createElement("director");
        nPeliNDirector.appendChild(this.docXML.createTextNode("\n"));
    
        Element nPeliNDirectorNNombre=this.docXML.createElement("nombre");
        Text textNNombre=this.docXML.createTextNode(elNombreDirector);
        nPeliNDirectorNNombre.appendChild(textNNombre);
        nPeliNDirector.appendChild(nPeliNDirectorNNombre);
        nPeliNDirector.appendChild(this.docXML.createTextNode("\n"));
        
        Element nPeliNDirectorNApellido=this.docXML.createElement("apellido");
        Text textNApellido=this.docXML.createTextNode(elApellidoDirector);
        nPeliNDirectorNApellido.appendChild(textNApellido);
        nPeliNDirector.appendChild(nPeliNDirectorNApellido);
        nPeliNDirector.appendChild(this.docXML.createTextNode("\n"));
        
        nPeli.appendChild(nPeliNDirector);
    }
}
