/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.streams.tress;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author gmartinez
 */
public class SerializableMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Punt p = new Punt(2,4);
        Cercle c1 = new Cercle(p, 10);
        Cercle c2 = new Cercle(p, 12);
        File f = new File("fitxerAmbDadesSerialitzades.bin");
       
        // Serialització (emmagatzema un cadena de text seguida de 2 objectes Cercle).
        ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(f));
        fileOut.writeObject("Hola que tal");
        fileOut.writeObject(c1);
        fileOut.writeObject(c2);
        fileOut.close();
       
        // Recuperació (1r recupera la cadena de text i després els 2 objectes Cercle).
        ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(f));
        System.out.println("Dades llegides del fitxer serialitzat (1r recuperarà la cadena de text i després els 2 objectes Cercle):");
        System.out.println((String) fileIn.readObject());
               
        try {
            while (true) {
                Cercle aux = (Cercle) fileIn.readObject();
                System.out.println("Cercle radi " + aux.getRadi());
            }
        } catch (EOFException e) {
            fileIn.close();
        } catch (Exception e) {
            if (fileIn != null) fileIn.close();
            System.out.println("Error");
        }
    }
    
}
