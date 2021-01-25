/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.exemples;

/**
 *
 * @author eva
 */
public class exemplesApartat1punt1 {
    /*
    public static void main(String[] args) {
        int opcio;
        
        try {
            opcio = Integer.parseInt(args[0]);   

            switch(opcio) {
                case 0: System.out.println("Has introduït 0");
                        break;
                case 1: System.out.println("Has introduït 1");
                        break;
                default: System.out.println("????");
            }
        } catch (Exception e) {
            System.out.println("Error en els paràmetres --> " + args[0]);
            System.out.println("Estem dins el bloc catch que ha capturat l’excepció.");
            System.out.print("Informació que dona el mètode getMessage(): ");
            System.out.println(e.getMessage());
            System.out.println("Informació que dona el mètode printtStackTrace(): ");
            e.printStackTrace();
            System.out.print("Informació donada pel mètode toString(): ");
            System.out.println(e.toString());
            //System.exit(0);
        } finally {
            System.out.println( "Finally: sempre s'executa, hagi o no un error" );
        }
        
        System.out.println("Final del programa");
    }
    */
    
    
    public static void main(String args[]) {
        String t[]={"Hola","Adéu","Fins demà"};
        
        try {
            System.out.println("Abans d’executar el for");
            for (int i=0; i<=t.length; i++) {
                System.out.println("Posició " + i + " : " + t[i]);
            }
            System.out.println("Després d’executar el for");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El programador és un... s’ha sortit de ls límits!");
        }
        
        System.out.println("Final del programa");
    }
    
    
    
    /*
    public static void main(String args[]) {
        String t[]={"Hola","Adéu","Fins demà"};
        
        try {
            System.out.println("Abans d’executar el for");
            for (int i=0; i<=t.length; i++) {
                System.out.println("Posició " + i + " : " + t[i]);
            }
            System.out.println("Després d’executar el for");
        } catch (StringIndexOutOfBoundsException e) {           //Aquest catch no captura l'error.
            System.out.println("El programador és un... s’ha sortit de ls límits!");
        } finally {
            System.out.println("Finally: sempre s'executa, hagi o no un error");
        }
        
        System.out.println("Final del programa");
    }
    */
    
    
}
