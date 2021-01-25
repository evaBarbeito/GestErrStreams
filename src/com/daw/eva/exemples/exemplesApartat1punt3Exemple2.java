/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.exemples;

/**
 *
 * @author gines
 */
public class exemplesApartat1punt3Exemple2 {
    public static void met02() {
        String t[]={"Hola","Adéu","Fins demà"};
        for (int i=0; i<=t.length; i++) {
            System.out.println("Posició " + i + " : " + t[i]);
        }
            
        System.out.println("El mètode met02 s’ha acabat.");
    }

    public static void met01() {
        System.out.println("Entrem en el mètode met01 i anem a executar met02");
        met02();
        System.out.println("Tornem a estar en met01 després de finalitzar met02");
    }

    public static void main(String args[]) {
        System.out.println("Iniciem el programa i anem a executar met01");
        met01();
        System.out.println("Tornem a estar en el main després de finalitzar met01");
    }
}
