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
public class T2XML4 {

    public int contador = 0;

    public T2XML4() {

    }

    public void ejer4(Document xmlDoc, int prof) {

        Node nodoActual;
        NodeList contenidoNodoActual;
        NamedNodeMap nnmActual;

        nodoActual = xmlDoc.getFirstChild();

        metodoRecursivo(nodoActual, prof);

    }

    public void metodoRecursivo(Node nodoActual, int prof) {
        NodeList contenidoNodoActual;
        for (int j = 0; j < prof; j++) {
            System.out.print("    ");
        }
        System.out.println(nodoActual.getNodeType() + " " + nodoActual.getNodeName());
        if (nodoActual.hasChildNodes()) {
            prof++;
            contenidoNodoActual = nodoActual.getChildNodes();
            for (int i = 0; i < contenidoNodoActual.getLength(); i++) {

                metodoRecursivo(contenidoNodoActual.item(i), prof);
            }
        }
    }

    public void metodoRecursivo2(Node nodoActual, int pron) {
        NodeList contenidoNodoActual;

        if (nodoActual.hasChildNodes()) {
            System.out.println(nodoActual.getNodeType() + " " + nodoActual.getNodeName());
            pron++;
            contenidoNodoActual = nodoActual.getChildNodes();
            for (int i = 0; i < contenidoNodoActual.getLength(); i++) {
                nodoActual = contenidoNodoActual.item(i);
                if (nodoActual.getNodeType() != 1) {
                    for (int j = 0; j < pron; j++) {
                        System.out.print("    ");
                    }
                    System.out.println(nodoActual.getNodeType() + " " + nodoActual.getNodeName());
                }
                metodoRecursivo(nodoActual, pron);
            }
        }
    }
}
