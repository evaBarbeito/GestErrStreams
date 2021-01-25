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
public class Exercici5 {
    private int edat;

    
    public Exercici5(int edat) {
        this.edat = edat;
    }

    public int getEdat() {
        return edat;
    }

    

    public void setEdat(int edat) throws Exercici5ValidarEdatException{
        //"throws" llista els tipus d'excepcions que un mètode pot llançar.
        try {
            System.out.println("setEdat(" + edat + "): try inici");
            if (edat <= 0) {
                //"throw" per a llançar una excepció concreta.
                //El fluxe d'execució es deté inmediatament després de la setència throw
                //i qualsevol sentència posterior no s'executa.
                System.out.println("setEdat(" + edat + "): try: edat <= 0");
                throw new Exercici5ValidarEdatException(edat);
                //System.out.println("setEdat: try: 2 edat <= 0");  //Aquesta linia no arriba a executar-se mai perquè es llança el throw.
            }    
            if (edat > 100) {
                System.out.println("setEdat(" + edat + "): try: edat > 100");
                throw new Exercici5ValidarEdatException(edat);
                //System.out.println("setEdat: try: 2 edat <= 0");  //Aquesta linia no arriba a executar-se mai perquè es llança el throw.
            }    
            
            this.edat = edat;
            System.out.println("setEdat(" + this.getEdat() + "): try fi");
        } catch (Exercici5ValidarEdatException e) { 
            System.out.println("setEdat(): catch inici"); 
       }
            
         //   Pots fer throws new Exception només, passar-ho, propagar-ho, o fer a més del throws, el try-catch dins el mètode, per tractar-ho aquí també, primer ...
            // mínim, un d'ells.
        
        System.out.println("setEdat(" + edat + "): fi: edat introduida = " + edat);
    }
}
