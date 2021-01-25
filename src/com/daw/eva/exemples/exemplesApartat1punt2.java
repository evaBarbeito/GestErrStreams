package com.daw.eva.exemples;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eva
 */

public class exemplesApartat1punt2 {
    
    /*
    public static void prova() {
        System.out.println("Estic dins de prova().");
        throw new NullPointerException("LLançada la NullPointerException desde prova().");
        //Per a llançar l'excepció NullPointerException a saco fem servir el throw.
        //NullPointerException hereda de RunTimeException (verue apartat 1.3 dels apunts) i 
        //per tant es propaga automàticament, no és obligatori realitzar cap acció.
    }   

    public static void main(String[] args) {
        try {
            prova();
            System.out.println("No s'executa mai.");
        } catch (Exception e) {
            System.out.println("Catch: Error = " + e.getMessage());
        }
    }    
    */
    
    /*
    public static void prova1() throws Exception {
        System.out.println("Estic dins de prova1()");
        throw new NullPointerException("LLançada la NullPointerException desde prova().");
        //El "throws Exception" serveix per advertir als altres mètodes que criden a prova1() de les 
        //excepcions que aquest pot produir i que per tant ells han de gestionar.
    }   

    public static void main(String[] args) {
        //int opcio = Integer.parseInt(args[0]);
        int opcio = Integer.parseInt("234");

        //prova1();    // Error, s'ha de ficar dins un try-catch

        try {
            prova1();
            System.out.println("No s'executa mai");
        } catch (Exception e) {
            System.out.println("Catch: Error = " + e.getMessage());
        }
    }
    */
    
    
    
    public static void metodeAmbClausulaThrows (String nomFitxer) throws FileNotFoundException, IOException
    {
        //FileOutputStream f = new FileOutputStream (nomFitxer);
        System.out.println ("El metodeAmbClausulaThrows s'ha inicialitzat.");
        FileInputStream f = new FileInputStream (nomFitxer);
        f.close();
        System.out.println ("El metodeAmbClausulaThrows ha finalitzat.");
    } 

    public static void main(String[] args) {
        //if (args.length!=1) {
        //    System.out.print("La crida del programa ha d’indicar un paràmetre: ") ;
        //    System.out.println("nomArxiu amb el corresponent camí de directoris .");
        //    System.exit(1);
        //}
        
        //Excepcio08 exc = new Excepcio08();
        try {
            //exc.metodeAmbClausulaThrows(args[0]);
            metodeAmbClausulaThrows("asdf286poiu.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Capturada l’excepció FileNotFoundException: ");
            System.out.println("e = " + e);
        } catch (IOException e) {
            System.out.println("Capturada l’excepció IOException: ");
            System.out.println("e = " + e);
        }
        
        System.out.println("El programa ha finalitzat.");
    }
    
    
}

