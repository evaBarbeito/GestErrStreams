package com.daw.eva.exemples;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eva
 */


public class exemplesApartat1punt3Exemple1Arreglat {
    
    public static void prova0() {       // Error, cal marcar el mètode com a throws.
        //throw new Exception("PROVA0(): Texte de l’excepcio");
    }  
    
    public static void prova1() throws Exception {      // Ok. Exception hereta d’Exception.
        throw new Exception("PROVA1(): Texte de l’excepcio");
    }  

    public static void prova2() throws NullPointerException {   // Ok. NullPointerException hereta de RunTimeException.
        throw new NullPointerException("PROVA2(): Texte de l’excepcio");
    }  

    public static void prova3() {       // Ok. NullPointerException hereta de RunTimeException.
        throw new NullPointerException("PROVA3(): Texte de l’excepcio");
    }  

    public static void main(String[] args) {
        try {
            //Quan salta una excepció dins del try, s'atura l'execució del codi que hi ha 
            //per sota de la crida a l'execepció.
            
            //prova0();
            
            //prova1();
            
            //prova2();

            prova3();
            
            //Excepcions que hereten de Exception (però no de RunTimeException): No 
            //és automàtic, cal propagar-les o controlar-les.
            //L'ús d'aquests mètodes obliga a controlar l'excepció: 
            //    Opció 1. Usant try/catch 
            //    Opció 2. Marcant el propi mètode com a throws 
        } catch (Exception ex) {
            System.out.println("Main: Catch: Error = " + ex.getMessage());
            System.out.println();
        } 

        
    }
    
}
