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
public class Exercici4 {
   private int edat;

    
    public Exercici4(int edat) {
        this.edat = edat;
    }

    public int getEdat() {
        return edat;
    }


    public void setEdat(int edat) throws IllegalArgumentException{
        //"throws" llista els tipus d'excepcions que un mètode pot llançar.

        System.out.println("setEdat(" + edat + "): entrem en setEdat()");
        if (edat <= 0) {
            //"throw" per a llançar una excepció concreta.
            //El fluxe d'execució es deté inmediatament després de la setència throw
            //i qualsevol sentència posterior no s'executa.
            System.out.println("setEdat(" + edat + "): try: edat <= 0");
            throw new IllegalArgumentException("LLANÇAT(edat = " + edat + ") IllegalArgumentException per edat <= 0");
            //System.out.println("setEdat: try: 2 edat <= 0");  //Aquesta linia no arriba a executar-se mai perquè es llança el throw.
        }    
        if (edat > 100) {
            System.out.println("setEdat(" + edat + "): try: edat > 100");
            throw new IllegalArgumentException("LLANÇAT(edat = " + edat + ") IllegalArgumentException per edat > 100");
            //System.out.println("setEdat: try: 2 edat <= 0");  //Aquesta linia no arriba a executar-se mai perquè es llança el throw.
        }    

        this.edat = edat;
        System.out.println("setEdat(" + this.getEdat() + "): fi: edat introduida = " + edat);
    }
     
}
