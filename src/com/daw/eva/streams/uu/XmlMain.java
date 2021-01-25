/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.streams.uu;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author eva
 */
public class XmlMain {
    public static void main(String[] args) throws FileNotFoundException {
        Punt p1 = new Punt(1,2);
        Cercle c11 = new Cercle("c11", p1, 10);
        Cercle c12 = new Cercle("c12", p1, 20);
        Cercle c13 = new Cercle("c13", p1, 30);
        Punt p2 = new Punt(3,4);
        Cercle c21 = new Cercle("c21", p2, 40);
       
        // Serialització
        XMLEncoder e;
        e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("fitxerAmbDadesXML.xml")));
        e.writeObject(c11);
        e.writeObject(c12);
        e.writeObject(c13);
        e.writeObject(c21);
        e.close();
        
        // Recuperació
        Cercle cxml;
        XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("fitxerAmbDadesXML.xml")));
        System.out.println("Dades dels cercles:");
        try {
            while ((cxml = (Cercle) d.readObject()) != null){
                System.out.println("Nom: " + cxml.getNom() + ", radi: " + cxml.getRadi() + ", centre: " + cxml.getDadesCentre()); 
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //Així controlem que hem arribat al final del fitxer perquè el "d.readObject() != null" no va, ja que, ha intentat llegir un objecte quan no n'hi havia cap i per tant ja no arriba
            //ni a comparar-lo amb NULL.
            System.out.println("¡¡¡ArrayIndexOutOfBoundsException!!!: no hi ha més elements al fitxer per a llegir.");
        } finally {
            d.close();
            System.out.println("Tanquem el fitxer.");
        }
        
        System.out.println("Fi del programa.");

    }
}
