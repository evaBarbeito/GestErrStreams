/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.exc;

/**
 * 
 * @author eva
 *
 */
public class Exercici3 {
    private static int divisio(int a, int b) throws ArithmeticException {
        //"throws" llista els tipus d'excepcions que un mètode pot llançar.
        if (b == 0) {
            //"throw" per a llançar una excepció concreta. 
            //El fluxe d'execució es deté inmediatament després de la setència throw
            //i qualsevol sentència posterior no s'executa.
            throw new ArithmeticException();
        }
        //La linia del if no fa falta però l'enunciat de l'exercici ens
        //obliga a crear un objecte Exception i per això està.
        else {
            System.out.println("resultat de la divisió " + a + "/" + b + " = " + a/b);
            return a/b;
        }
        
    }    
    
    static void exercici3()
    {
        int res = 0;
        
        try {
            res = divisio(6, 1); 
            res = divisio(6, 2);
            res = divisio(6, 0); 
            res = divisio(6, 3); 
        } catch (ArithmeticException e) {
            System.out.println("El segon argument ha de ser diferent de 0");
        }
        
        System.out.println("Fi de l'exercici 3");
    }
    
}
