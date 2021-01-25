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
public class exemplesApartat1punt4ExempleMain {
    // Per usar la nova classe
    public static void prova4() throws exemplesApartat1punt4ExempleExceptionMeva {
        throw new exemplesApartat1punt4ExempleExceptionMeva("Ha passat una catàstrofe!!");
    }  


    public static void main(String[] args) {
        try {
            prova4();
        } catch (exemplesApartat1punt4ExempleExceptionMeva e) {
            // TODO Auto-generated catch block
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }    
}
