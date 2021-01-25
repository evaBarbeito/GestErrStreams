package com.daw.eva.streamsSEx11;

import java.io.EOFException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ebarbeito
 */
public class Exercici11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero = new File("Naus_Dades.dat");
        ArrayList<Naus_Dades> arrayListDeNaus = new ArrayList<Naus_Dades>();
        LocalDateTime today;
        int longString;
        StringBuffer buffer = null;
        
       
        today = LocalDateTime.now();

        // Per a passar de String --> char[]: es fa servir .toCharArray() sobre el string.
        arrayListDeNaus.add(new Naus_Dades("Agamemnon", "destructor", "Omega".toCharArray(), today, "Enviat a la flota de Babylon 5"));
        arrayListDeNaus.add(new Naus_Dades("Achilles", "destructor", "Omega".toCharArray(), today, "Enviat a la flota de Babylon 5"));
        arrayListDeNaus.add(new Naus_Dades("Cortez", "explorador", "Explorer".toCharArray(), today, "Enviat a l'espai profund"));
        
        try {
            RandomAccessFile fitxerEmmagatzematge = new RandomAccessFile(fichero, "rw");
            
            // RandomAccessFile no sap escriure i llegir objectes, ni String, ni LocalDateTime,...
            for(Naus_Dades nauTmp : arrayListDeNaus){
            	
                System.out.println(nauTmp.getDataConstruccio().toString().length());
                
                // Gravem el nom (String nom).
                longString = nauTmp.getNom().length();
                fitxerEmmagatzematge.writeInt(longString);
                fitxerEmmagatzematge.writeChars(nauTmp.getNom());
                
                // Gravem el tipus (String tipus).
                longString = nauTmp.getTipus().length();
                fitxerEmmagatzematge.writeInt(longString);
                fitxerEmmagatzematge.writeChars(nauTmp.getTipus());                
                
                // Gravem el model (char model[50]).
                // Per a passar de char[] --> String: String.valueOf(X) on X és de tipus char[].
                buffer = new StringBuffer(String.valueOf(nauTmp.getModel()));
                buffer.setLength(50);
                fitxerEmmagatzematge.writeChars(buffer.toString());
                
                // Gravem la dataConstruccio (LocalDateTime dataConstruccio).
                longString = 26; //  a java 11, 23 a java8
               // fitxerEmmagatzematge.writeInt(longString);
                fitxerEmmagatzematge.writeChars(String.valueOf(nauTmp.getDataConstruccio().toString()));
                
                
                // Gravem la descripció (String descripcio).
                longString = nauTmp.getDescripcio().length();
                fitxerEmmagatzematge.writeInt(longString);
                fitxerEmmagatzematge.writeChars(nauTmp.getDescripcio()); 
                
                System.out.println("longString desc: " + longString + ", " + nauTmp.getDescripcio());
                
                
            }
            

            String stringTmp;
            fitxerEmmagatzematge.close();
            
            fitxerEmmagatzematge = new RandomAccessFile(fichero, "r");
            
            while (fitxerEmmagatzematge.getFilePointer() != fitxerEmmagatzematge.length()) {
            	System.out.println("----------------");
            	
	            // LLegim el nom (String nom).
            	stringTmp = "";
	            longString = fitxerEmmagatzematge.readInt();
	            System.out.println("Nom.length(): " + longString);
	            for(int i = 0; i< longString; i++) {
	                //System.out.println("Nom: " + fitxerEmmagatzematge.readChar());
	            	stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
	            }
	            System.out.println("Nom: " + stringTmp);
	            
	            // LLegim el tipus (String tipus).
	            stringTmp = "";
	            longString = fitxerEmmagatzematge.readInt();
	            System.out.println("tipus.length(): " + longString);
	            for(int i = 0; i< longString; i++) {
	                //System.out.println("Tipus: " + fitxerEmmagatzematge.readChar());
	            	stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
	            }
	            System.out.println("Tipus: " + stringTmp);
	            
	            // LLegim el model (char model[50]).    
	            stringTmp = "";
	            for(int i = 0; i< 50; i++) {
	                //System.out.println("Model: " + fitxerEmmagatzematge.readChar());
	                stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
	            }
	            System.out.println("Model: " + stringTmp);
	            
	            // LLegim la dataConstruccio (LocalDateTime dataConstruccio).
	            stringTmp = ""; //23 a java 8, i 26 a java 11
	            for(int i = 0; i< 26; i++) {
	                //System.out.println("Data construcció: " + fitxerEmmagatzematge.readChar());
	                stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
	            }
	            System.out.println("Data construcció: " + stringTmp);
	            
	            // LLegim la descripció (String descripcio).
	            stringTmp = "";
	            longString = fitxerEmmagatzematge.readInt();
	           // longString = fitxerEmmagatzematge.readInt();
	           // System.out.println("descripcio.length(): " + longString);
	            for(int i = 0; i< longString; i++) {
	                //System.out.println("Descripció: " + fitxerEmmagatzematge.readChar());
	            	stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
	            }
	            System.out.println("Descripció: " + stringTmp);
	            
	            if (fitxerEmmagatzematge.getFilePointer()==fitxerEmmagatzematge.length()) {
	                break;
	            }
	         
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exercici11.class.getName()).log(Level.SEVERE, null, ex);
        } catch ( EOFException ex ) {
        	System.out.println(ex.getMessage());
        	Logger.getLogger(Exercici11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {        
            Logger.getLogger(Exercici11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
