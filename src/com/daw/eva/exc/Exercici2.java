/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.exc;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author eva
 */
public class Exercici2 {
    private static void obrirFitxer() throws IOException 
    {
        //En throws l'opció FileNotFoundException no fa falta perque està dins
        //de la IOException.
        //FileOutputStream pot generar 2 errors: FileNotFoundException i 
        //SecurityException. SecurityException està dins de RuntimeException
        //i per això no fa falta ficar-la en el throws. Les RuntimeException i 
        //tot lo que hi ha a dins no s'ha de ficar en el throws.
        FileOutputStream f = new FileOutputStream ("../docs/test.txt");
        f.close();
    }
    
    
    static void exercici2()
    {
        try {
                obrirFitxer();
        } catch (IOException e) {
            System.out.println("Codi del catch:");
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("e.getCause() = " + e.getCause());
            System.out.print("e.printStackTrace() = " );
            e.printStackTrace();
            System.out.println();
            System.out.println("e.toString() = " + e.toString());
            System.out.println("Fi de codi del catch.");
	}        
    }
}
