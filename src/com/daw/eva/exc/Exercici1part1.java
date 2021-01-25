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
public class Exercici1part1 {
    static void exercici1Apartats1i2() {
        int[] v = {1,2,3};


        //INICI: APARTATS 1.1 i 1.2
//        try {
//        	for (int i = 0; i <= v.length; i++) {		//Això provoca una ArrayIndexOutOfBoundsException perque long=3 però indexs=[0,2].
//                System.out.println(v[i]);
//                //A partir d'aquí no es mostra res perque s'ha produir un error i s'avorta el flux habitual
//                //d'execució i automàticament s'ha llenaçat una Exception.
//            }
//		} finally {
//			//1.3
//			// TODO: handle finally clause
//			 System.out.println("Final del programa 1");    
//		}
        
        
        
//        for (int i = 0; i <= v.length; i++) {		//Això provoca una ArrayIndexOutOfBoundsException perque long=3 però indexs=[0,2].
//            System.out.println(v[i]);
//            //A partir d'aquí no es mostra res perque s'ha produir un error i s'avorta el flux habitual
//            //d'execució i automàticament s'ha llenaçat una Exception.
//        }
//        System.out.println("Final del programa 1");    
	//FINAL: APARTATS 1.1 i 1.2
        
        

        //INICI: APARTAT 1.3.
        //Ficant el codi subceptible d'error en un bloc try-catch.
        //En try fiquem el codi que volem executar i susceptible d'error i en catch el tractament
        //que volem que s'executi si es produeix un error dins del try.
        //FINAL: APARTAT 1.3.
        
        
        //INICI: APARTATS 1.4, 1.5 i 1.7
	//Apartat 1.4: el missatge "Final del programa" no es veu perque donat un error
        //en el bloc del catch, s'atura l'execució i salta al bloc catch on s'executa lo
        //que allà hi ha. Tot el codi que està fora del catch ja no s'executarà.
        try {
            for (int i = 0; i <= v.length; i++) {
                System.out.println(v[i]);
            }
        } catch (Exception e){
            System.out.println("Codi del catch:");
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("e.getCause() = " + e.getCause());
            System.out.print("e.printStackTrace() = " );
            e.printStackTrace();
            System.out.println("e.toString() = " + e.toString());
            System.out.println("Fi de codi del catch.");
        } finally{
            System.out.println("Codi del finally");
        }
        System.out.println("Final del programa 2");
        //FINAL: APARTATS 1.4, 1.5 i 1.7
        
        System.out.println("-----------------------------------");
        System.out.println("---------------1.6 ---------------");
        System.out.println("-----------------------------------");
        //INICI: APARTAT 1.6
        String cadenaTmp = "tonto quien me lea";
        char caracterTmp;
        
        try {
            for (int i = 0; i < v.length; i++) {
                    System.out.println(v[i]);
            }

            caracterTmp = cadenaTmp.charAt(100);	//Això provoca una StringIndexOutOfBoundsException. 
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Codi del catch ArrayIndexOutOfBoundsException");
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("e.getCause() = " + e.getCause());
            System.out.print("e.printStackTrace() = " );
            e.printStackTrace();
            System.out.println("e.toString() = " + e.toString());
        } 
            catch (StringIndexOutOfBoundsException e){
            System.out.println("Codi del catch StringIndexOutOfBoundsException");
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("e.getCause() = " + e.getCause());
            System.out.print("e.printStackTrace() = " );
            e.printStackTrace();
            System.out.println("e.toString() = " + e.toString());
        }
        
        //Exception e sempre a l última posició
            catch (Exception e)  {
        	System.out.println(e.getMessage());
        } finally {
        
            System.out.println("Codi del finally");
        }
        
        System.out.println("Final del programa 3");
        //FINAL: APARTAT 1.6
        
    }    
}
