package com.daw.eva.exemples;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gmartinez
 */
public class exemplesApartat1punt3Exemple3 {
    
    public static void primer() {
        segon();
    }
   
    public static void segon() {
        throw new NullPointerException();
    }

    public static void main(String[] args) {
        primer();
        System.out.println("Final del programa");
    }
    
}
