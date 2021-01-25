/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.exc;

/**
 *
 * @author eva
 */
public class Exercici5ValidarEdatException extends Exception {

    Exercici5ValidarEdatException(int edat) {
        if (edat < 0) {
            System.out.println("Exercici5ValidarEdatException: l' edat " + edat + " no pot ser un nº negatiu");
        } 
        else {
            System.out.println("Exercici5ValidarEdatException: l' edat " + edat + " no pot ser un nº > 100");
        }
    }
}
