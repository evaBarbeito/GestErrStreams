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
public class exemplesApartat1punt3Exemple3Arreglat {
    
    public static void primer() {
        try {
            segon();
        } catch (Exception e) {
            System.out.println("Excepció capturada en primer().");
        }
        
    }
   
    public static void segon() {
        throw new NullPointerException();
    }

    public static void main(String[] args) {
        try {
            primer();
        } catch (Exception e) {
            System.out.println("Excepció capturada en el main().");
        }
        
        System.out.println("Final del programa");
        //No fa falta capturar l'exepció en el main() perquè ja ha estat capturada en primer().
        //Si primer() no capturés l'excepció, si que l'hauria de capturar el main().
    }
    
}
