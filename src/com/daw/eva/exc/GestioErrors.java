/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.exc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author eva
 */
public class GestioErrors {

    /**
     * @param args the command line arguments
     * @throws CustomException 
     */
    public static void main(String[] args) throws CustomException {
//        Exercici1part1.exercici1Apartats1i2();
//        Exercici1part2.funcio1();
//        Exercici2.exercici2();
//        Exercici3.exercici3();
         
    	
    	
     //   System.out.println("----INICI----");
        
        /*
        
        Exercici4 persona = new Exercici4(6);
        //try {
            System.out.println("----------------");
            System.out.println("persona.setEdat(5):");
            persona.setEdat(5);
            System.out.println("----------------");
            System.out.println("persona.setEdat(-3):");
            persona.setEdat(-3);
            System.out.println("----------------");
            System.out.println("persona.setEdat(115):");
            persona.setEdat(115);
            System.out.println("----------------");
            System.out.println("persona.setEdat(27):");
            persona.setEdat(27);
            System.out.println("----FINAL----");
        //} catch (IllegalArgumentException("IllegalArgumentException")) {
        //        
        //}
        
      */
     	
            
        
//        System.out.println("----INICI----");
//        Exercici5 persona = new Exercici5(6);
//        try {
//            System.out.println("----------------");
//            System.out.println("persona.setEdat(5):");
//            persona.setEdat(5);
//            System.out.println("----------------");
//            System.out.println("persona.setEdat(-3):");
//            persona.setEdat(-3);
//            System.out.println("----------------");
//            System.out.println("persona.setEdat(115):");
//            persona.setEdat(115);
//            System.out.println("----------------");
//            System.out.println("persona.setEdat(27):");
//            persona.setEdat(27);
//            System.out.println("----FINAL----");
//        }
//        catch (Exercici5ValidarEdatException ex) {
//        	//necessita ser declarat, al menys, el catch, pot estar buït
//        	//es pot propagar per a logar els errors
//            Logger.getLogger(GestioErrors.class.getName()).log(Level.SEVERE, null, ex);
//       }
   //    finally { 
    	   
    	   
       int a=10, b=0;
       int[] c= new int[2];
       
       try {
    	   c[3]=1;
    	   //c[0]=1;
    	   //el de sota no s'executarà mai, si volem que s'executi, cal posar-ho en un try-catch anidat
           System.out.println(a/b);
           
           try {
        	   System.out.println(a/b);     // aquí entraria si l'assignació al array fos correcta....
		   } catch (Exception e) {
			// TODO: handle exception
			   System.out.println(e);
		   }
           
         //catch ordenat de més a menys específic
           //aquestes són runtime, no estem obligats a tractar-les
       } catch (ArithmeticException e) {
    	   System.out.println(e);    	   
       } catch (ArrayIndexOutOfBoundsException e) {
    	   System.out.println(e);    	   
       }
        
       BufferedReader reader=null;
       try {
		FileReader fr= new FileReader("balance.txt");
		
		reader = new BufferedReader(fr);
		System.out.println(reader.readLine());
		
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
		//	e2.printStackTrace();
			throw new CustomException(100, "File balance.txt not found" );   //code per a debuggar, per exemple, podem propagar varios errors
			//per a validar dades entrada usuari....
			//throw propaga, i atura el fluxe d'execució , 
			
			//les unchecked exception, extenen de runtime exception, null pointers, arrayindexoutofbounds, veure a gg java 8 exception, no es tracten, doncs son problemes estructurals de codi.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//reader.readLine....
			e.printStackTrace();
		} finally {
			if (reader!=null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				System.out.println("Completat lectura fitxer");
		}
        
       
       //Exercicis 0 i 0.1
       System.out.println("----Entra un id d'usuari----");
       Scanner sc1 = new Scanner(System.in);
  	   int user_id=sc1.nextInt();

	  	   try{
	  	       if (user_id!=1234){
	  	           throw new InvalidUserIdException();
	  	       }
	
	  	   }catch (Exception e){
	  	       System.out.println(e);
	  	   }
	  	   
	  //alternatiu a llegir per consola	   , té més memoria el buffer, permet asíncron, és només lectura, no parseig com Scanner
	  InputStreamReader i=new InputStreamReader(System.in);
	  BufferedReader d=new BufferedReader(i);
	  System.out.println("----Entra algo, exemple de InputStreamReader i BufferedReader ---");
		  String sentence;
		try {
			sentence = d.readLine();  //linies de caràcters.
			 System.out.println(sentence);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	 
	  //PrintWriter, per volcar System.out
	    InputStreamReader ii=new InputStreamReader(System.in);
		BufferedReader dd=new BufferedReader(ii);
		PrintWriter p=new PrintWriter(System.out, true);
		
		
		
		System.out.println("----Entra algo, exemple de InputStreamReader i BufferedReader i PrintWriter ---");
			String sentence2;
			try {
				sentence2 = dd.readLine();
				 //System.out.println(sentence2);
				p.println(sentence2);
				 
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
	  
	  	   
	  	  int current_balancee = 1000;
	  	  System.out.println("----Entra un quantitat positiva per a fer un ingrès al teu compte----");
	  	  Scanner sc2 = new Scanner(System.in);
	  	  int deposit_amountt=sc2.nextInt();

		  	try{
		  	   if(deposit_amountt<0){
		  	       throw new NegativeNotAllowedException();
		  	   }else{
		  	       current_balancee+=deposit_amountt;
		  	       System.out.println("Updated balance is: "+current_balancee);
		
		  	   }
		  	}catch (Exception e){
		  	   System.out.println(e);
		  	}
    //  }
        
        Scanner sc;
      
	    try {
		sc = new Scanner(new File("balance.txt"));
		int current_balance = sc.nextInt();
		System.out.println(current_balance);	
			 
		
		 
		 //create a new scanner for system input i.e to accept user input
		 Scanner sc3 = new Scanner(System.in);
		 System.out.println("Enter amount to be deposited");
		 int deposit_amount = sc3.nextInt();

		 current_balance+=deposit_amount;

		 System.out.println("Updated balance is: "+current_balance);
		   //writing or updating new balance to the file
		   FileOutputStream f = new FileOutputStream("balance.txt");
		   int bal = current_balance;
		   String s = Integer.toString(bal);
		   byte b1[] = s.getBytes();
		   try {
				f.write(b1);
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			//e1.printStackTrace();
		}
		
    }
    
}
