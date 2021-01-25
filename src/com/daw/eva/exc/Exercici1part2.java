package com.daw.eva.exc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eva
 */
public class Exercici1part2 {
    static void funcio1() {
        System.out.println("Funcio 1 ");
        funcio2();
        System.out.println("fi de f1");
    }

    private static void funcio2() {
        try {
            System.out.println("Funcio 2 ");
            funcio3();
        } catch (Exception e){
            System.out.println("capturat l'error a la funcio 2");
        }
        System.out.println("fi de f2");
    }

    private static void funcio3() {
        System.out.println("funcio 3 ");
        int[] v = {1,2,3};

        for (int i = 0; i <= v.length; i++) {
            System.out.println("v[" + i + "] = " + v[i]);
        }
        System.out.println("fi de f3");
    }    
     
    /*
    public static void main(String[] args) 
    {
        System.out.println("main");
	funcio1();
        System.out.println("fi de main");
    }*/

}
