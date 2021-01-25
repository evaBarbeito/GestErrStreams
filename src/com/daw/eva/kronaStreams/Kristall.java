package com.daw.eva.kronaStreams;

import Pantalles.MenuConstructorPantalla;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;


/**
 *
 * @author eva
 */
public class Kristall {
    /*
    SISTEMA DE NAVEGACIÓ BASAT EN WAYPOINTS.
    ES DONEN D'ALTA DIVERSOS WAYPOINTS DE L'ESPAI (ORBITA MARCIANA, PUNT LAGRANGE TERRA-LLUNA, PHOBOS, SATURN, LLUNA,...).
    ES PODEN MEMORITZAR DIVERSES RUTES AFEGINT DIVERSOS WAYPOINTS A CADA RUTA.
    
    */
    
    public static void bloquejarPantalla() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nToca 'C' per a continuar ");
        while (in.hasNext()) {
            if ("C".equalsIgnoreCase(in.next())) break;
        }
    }
    
    
    public static void menuKristall() { //throws IOException  {
        String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");
        passarMultiplesParametres objPassarMultiplesParametres = null;
        boolean exitCreacioRandomAccesFile = false;
        
        
        do {
            menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append("Kristall ");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator")); 
            
            menu.append("1. Comparar 2 fitxers");
            menu.append(System.getProperty("line.separator"));
            menu.append("2. Nº de línies i caràcters d'una llista d'arxius (I)");
            menu.append(System.getProperty("line.separator"));
            menu.append("3. Nº de línies i caràcters d'una llista d'arxius (II)");
            menu.append(System.getProperty("line.separator"));
            menu.append("4. Nº de repetecions de caràcters en un fitxer");
            menu.append(System.getProperty("line.separator"));
            menu.append("5. Links d'una URL a un fitxer");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("10. Mostrar contingut d'un directori");
            menu.append(System.getProperty("line.separator"));
            menu.append("11. Fer copia seguretat d'un directori (còpia automàtica)");
            menu.append(System.getProperty("line.separator"));
            menu.append("12. Fer copia seguretat d'un directori (còpia manual)");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            
            menu.append("20. FileUtils (I)");
            menu.append(System.getProperty("line.separator"));
            menu.append("21. FileUtils (II)");
            menu.append(System.getProperty("line.separator"));
            menu.append("22. FileUtils (III)");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("30. Guardar les naus amb RandomAccesFile");
            menu.append(System.getProperty("line.separator"));
            menu.append("31. Recuperar les naus amb RandomAccesFile");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("50. Tornar al menú pare (PNS-24 Puma)");
            menu.append(System.getProperty("line.separator"));
            
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();
            
            
            switch (opcio) {
                case "1":
                	Fitxers.menu1();
                    bloquejarPantalla();
                    break;
                case "2":
                	Fitxers.menu2();
                    bloquejarPantalla();
                    break;
                case "3":
                	Fitxers.menu3();
                    bloquejarPantalla();
                    break;
                case "4":
                	Fitxers.menu4();
                    bloquejarPantalla();
                    break;
                case "5":
                	Fitxers.menu5();
                    bloquejarPantalla();
                    break;
                case "10":
                	Fitxers.menu10();
                    bloquejarPantalla();
                    break;
                case "11":
                	Fitxers.menu11();
                    bloquejarPantalla();
                    break;
                case "12":
                	Fitxers.menu12();
                    bloquejarPantalla();
                    break;                    
                case "20":
                	objPassarMultiplesParametres = Fitxers.menu20();
                    bloquejarPantalla();
                    break;
                case "21":
                	objPassarMultiplesParametres = Fitxers.menu21(objPassarMultiplesParametres);
                    bloquejarPantalla();
                    break;
                case "22":
                	Fitxers.menu22(objPassarMultiplesParametres);
                    bloquejarPantalla();
                    break;
                case "30":
					try {
						Fitxers.menu30();
						exitCreacioRandomAccesFile = true;
					} catch (IOException e) {
						System.out.println("ERROR: hi ha hagut algun error al gravar i/o tancar el fitxer.");
						exitCreacioRandomAccesFile = false;
						
						e.printStackTrace();
					}
					
                    bloquejarPantalla();
                    break;
                case "31":
                	if (exitCreacioRandomAccesFile) {
                		try {
							Fitxers.menu31();
						} catch (IOException e) {
							System.out.println("ERROR: hi ha hagut algun error al llegir i/o tancar el fitxer.");
							e.printStackTrace();
						}
                	} else {
                		System.out.println("ALERTA: No s'ha pogut executar amb éxit el menú 30 i per tant no es pot executar el menú 31.");
                	}
                	
                    bloquejarPantalla();
                    break;
                case "50":
                    break; 
                default:
                    System.out.println("COMANDA NO RECONEGUDA");
            }   
        } while (!opcio.equals("50"));
    }
    
}
