package com.daw.eva.kronaStreams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import Varies.Data;



public class Fitxers {
	
	/*
	Escriu un programa que compari dos arxius de text línia per línia. 
	S'ha de llegir una línia de cada arxiu i comparar-les. Si aquestes no coincideixen, s'ha de mostrar  el número de línia que
	falla i les dues línies que són diferents. El programa processarà totes les línies de l'arxiu. 
	Pots ficar el nom dels 2 arxius a pelo en el programa.

	Fes servir els Readers / Writers (apartat 1.3. dels apunts) per a llegir i escriure en fitxer.

	Farem que tot el tema d’exepcions es faci dins del mètode menu1().
	 */
	public static void menu1() {
		BufferedReader bufferReader1 = null;
        BufferedReader bufferReader2 = null;
		String pathname1 = "a.txt";
        String pathname2 = "b.txt";
        int numLiniesDiferents;
        String linia1;
        String linia2;
        int i;
        
        
        try {
            bufferReader1 = new BufferedReader(new FileReader(new File(pathname1)));
            bufferReader2 = new BufferedReader(new FileReader(new File(pathname2)));
            // Necessitem fer un BufferReader per a poder executar readLine().
            // Si volguessim executar read(), que llegeix caràcter a caràcter, no necessitem el BufferReader ja que
            // FileReader ja té el mètode read().
            
            numLiniesDiferents = 0;
            linia1 = bufferReader1.readLine();
            linia2 = bufferReader2.readLine();
            i = 1;
            while (linia1 != null && linia2 != null) {
            	if (!linia1.equals(linia2)) {
            		System.out.println("Falla la línia "+ i);
                    System.out.println("Linia de " + pathname1 + ": " + linia1);
                    System.out.println("Linia de " + pathname2 + ": " + linia2);
                    
                    numLiniesDiferents++;
            	}
            	
                linia1 = bufferReader1.readLine();
                linia2 = bufferReader2.readLine();
                i++;
            }
            
            if (linia1 != null) {
            	while (linia1 != null) {
            		System.out.println("Falla la línia" + i);
                    System.out.println("Linia de " + pathname1 + ": " + linia1);
                    System.out.println("Linia de " + pathname2 + ": NULL");
                	
                    numLiniesDiferents++;
                    linia1 = bufferReader1.readLine();
                    i++;
            	}
            } else {
            	if (linia2 != null) {
                	while (linia2 != null) {
                		System.out.println("Falla la línia" + i);
                        System.out.println("Linia de " + pathname1 + ": NULL");
                        System.out.println("Linia de " + pathname2 + ": " + linia2);
                    	
                        numLiniesDiferents++;
                        linia2 = bufferReader2.readLine();
                        i++;
                	}
            	}
            }
            
            System.out.println("Número de línies diferents: " + numLiniesDiferents);
            System.out.println("FI DE LA COMPARACIÓ.");
        
        } catch (FileNotFoundException e) {
        	// Excepció provocada pel "new FileReader(arxiu)" .
			System.out.println("Excepció provocada pel \"new FileReader()\".");
			e.printStackTrace();
		} catch (IOException e) {
			// Excepció provocada pel "bufferReaderX.readLine()" .
			System.out.println("Excepció provocada pel \"buffer.readLine()\".");
			e.printStackTrace();
		} finally {
            try {
				bufferReader1.close();
				bufferReader2.close();
				//Closes the stream and releases (allibera) any system resources associated with it.
			} catch (IOException e) {
				// Excepció provocada pel "bufferReaderX.close()" . 
				System.out.println("Excepció provocada pel \"buffer.close()\".");
				e.printStackTrace();
			}
        }
	}
	
	
	/*
	Donada una llista d'arxius, compta el número de línies i el número de caràcters de cada arxiu.
	Fica la lista d'arxius a processar en un ArrayList i accedeix als seus noms recorrent la llista.
	El programa ha de  mostrar per cada arxiu el nom, el número de línies i el número de caràcters. 
	Pots ficar el nom dels 2 arxius a pelo en el programa.

	Si es produeix un error quan s'intenti llegir un d'aquests arxius s'ha d'imprimir un missatge d'error per aquest arxiu, però
	es continuarà processant la resta d'arxius.

	Fes servir els Readers / Writers (apartat 1.3. dels apunts) per a llegir i escriure en fitxer.

	Fes servir el constructor FileReader(File file).

	Farem que tot el tema d’exepcions es faci dins del mètode menu2().
	 */
	public static void menu2() {
		List<String> arxius = new ArrayList<String>();
		FileReader fileReader;
		int numLinies;
        int numCaracters;
        BufferedReader bufferReader = null;
        String linia;
		
		
        arxius.add("a.txt");
        arxius.add("b.txt");

        for (String arxiu : arxius) {
            File f = new File(arxiu);
            
            numLinies = 0;
            numCaracters = 0;

            try {
                fileReader = new FileReader(f);
                bufferReader = new BufferedReader(fileReader);
                
                while ((linia = bufferReader.readLine()) != null) {
                    numCaracters = numCaracters + linia.length();
                    numLinies++;
                }
                
            } catch (Exception e) {
            	// Excepció provocada pel "new FileReader(arxiu)" . En realitat provoca una "FileNotFoundException".
            	// Excepció provocada pel "bufferReader.readLine()" . En realitat provoca una "IOException".
                System.out.println("L'arxiu " + f.getName() + " ha generat un error.");
                System.out.println(e.toString());
            } finally {
            	 try {
					bufferReader.close();
				} catch (IOException e) {
					// Excepció provocada pel "bufferReader.close()" . 
					System.out.println("Excepció provocada pel \"buffer.close()\".");
					e.printStackTrace();
				}
            }
            
            System.out.println("L'arxiu " + f.getName() + " té " + numLinies + " linies i " + numCaracters + " caracters.");
        }
	}
	
	
	/*
	Donada una llista d'arxius, compta el número de línies i el número de caràcters de cada arxiu.
	Fica la lista d'arxius a processar en un ArrayList i accedeix als seus noms recorrent la llista.
	El programa ha de  mostrar per cada arxiu el nom, el número de línies i el número de caràcters. 

	Si es produeix un error quan s'intenti llegir un d'aquests arxius s'ha d'imprimir un missatge d'error i s'ha d'aturar l'execució 
	del programa sense processar la resta d'arxius.

	Fes servir els Readers / Writers (apartat 1.3. dels apunts) per a llegir i escriure en fitxer.

	Fes servir el constructor FileReader(String fileName).

	Farem que tot el tema d’exepcions es faci dins del mètode menu3(). Captura les excepcions per separat, és a dir, no facis servir
	un catch (Exception e){} que les capturi totes.
	 */
	public static void menu3() {
		List<String> arxius = new ArrayList<String>();
		FileReader fileReader;
		BufferedReader bufferReader = null;
		int numLinies;
        int numCaracters;
        String linia;
		
		
        arxius.add("a.txt");
        arxius.add("b.txt");

        try {
	        for (String arxiu : arxius) {
	            numLinies = 0;
	            numCaracters = 0;
	            
				fileReader = new FileReader(arxiu);
				bufferReader = new BufferedReader(fileReader);

                while ((linia = bufferReader.readLine()) != null) {
                    numCaracters = numCaracters + linia.length();
                    numLinies++;
                }
				
	            System.out.println("L'arxiu " + arxiu + " té " + numLinies + " linies i " + numCaracters + " caracters.");
	        }
        }  catch (FileNotFoundException e) {
			// Excepció provocada pel "new FileReader(arxiu)" .
			System.out.println("Excepció provocada pel \"new FileReader(arxiu)\".");
			e.printStackTrace();
		} catch (IOException e) {
			// Excepció provocada pel "bufferReader.readLine()" .
			System.out.println("Excepció provocada pel \"buffer.readLine()\".");
			e.printStackTrace();
		} finally {
			try {
				bufferReader.close();
				// Closes the stream and releases (allibera) any system resources associated with it.
			} catch (IOException e) {
				// Excepció provocada pel "bufferReader.close()" . 
				System.out.println("Excepció provocada pel \"buffer.close()\".");
				e.printStackTrace();
			}
		}
	}
	
        
       
	
	/*
	Crear un programa que llegeixi un fitxer de text i per a cada caràcter llegit guardarem les seves repeticions.  
	Fes servir un mapa ordenat alfabèticament per guardar els caràcters llegits i les seves repeticions.

	Després guardarem en un fitxer de sortida el resultat de manera que contingui: caracter, repeticions i percentatge. 
	El codi que grabi el resultat en el fitxer ha d'estar en un mètode anomenat escriureResultatsAlArxiu() el qual ha de
	propagar les possibles excepcions que pugui tenir.

	Fes servir els Readers / Writers (apartat 1.3. dels apunts) per a llegir i escriure en fitxer.
	 */
	public static void menu4() {
		TreeMap<Character, Integer> mapaOrdenat = new TreeMap<Character, Integer>();
		String arxiu = "a.txt";
        FileReader fileReader = null;
        int llegit;
        int totalCaractersLLegits;
        FileWriter fileWriter = null;
        
        
        try {
            fileReader = new FileReader(new File(arxiu));
            // Si volem executar read(), que llegeix caràcter a caràcter, no necessitem el BufferReader ja que
            // FileReader ja té el mètode read().
            // Per a executar readLine() si que necessitem el BufferReader.
            // FileReader.read() retornarà -1 si arriba al final del fitxer.
            // Si fem "(char) numCaracterLLegit", a llavors ens converteix a char el nº llegit (el nº equival a un caràcter).

            llegit = -1;
            totalCaractersLLegits = 0;
            while ((llegit = fileReader.read()) > 0) {
                if (mapaOrdenat.containsKey((char) llegit)) {
                    mapaOrdenat.put((char) llegit, mapaOrdenat.get((char) llegit) + 1);
                } else {
                    mapaOrdenat.put((char) llegit, 1);
                }
                
                totalCaractersLLegits++;
            }
            
            escriureResultatsAlArxiu(mapaOrdenat, totalCaractersLLegits);
        
        } catch (FileNotFoundException e) {
        	// Excepció provocada pel "new FileReader()" .
			e.printStackTrace();
		} catch (IOException e) {
			// Excepció provocada pel "freader.read()" i pel mètode escriureResultatsArxiu() .
			e.printStackTrace();
		} finally {
            try {
				fileReader.close();
			} catch (IOException e) {
				// Excepció provocada pel "buffer.close()" . 
				e.printStackTrace();
			}
        }
	}
	
	
	private static void escriureResultatsAlArxiu(TreeMap<Character, Integer> mapaOrdenat, int totalCaractersLLegits) throws IOException {
        FileWriter fileWriter = null;

        
        try {
    		fileWriter = new FileWriter(new File("menu4_resultat.txt"));
            
            for (Entry<Character, Integer> dada : mapaOrdenat.entrySet()) {
            	fileWriter.write("Caràcter: " + dada.getKey() + 
                		", repeticions: " + dada.getValue() + 
                		", percentatge: " + dada.getValue() * 100 / totalCaractersLLegits + "% \n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }
	
	

	/*
	Crear un programa que donada una URL, agafi tots els links que contingui i els guardi en un fitxer de text. 

	Per a llegir una URL:
		URL url = new URL("https://www.ditl.org/");
		URLConnection conn = url.openConnection();
		bufferReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	Fes servir els Readers / Writers (apartat 1.3. dels apunts) per a llegir i escriure en fitxer. Fes servir un FileWriter i
	un PrintWriter per escriure en el fitxer (evidentment això farà que totes les línies estiguin duplicades).

	Feu servir les classes Pattern i Matcher per a buscar patrons. 
	Mirar https://www.w3schools.com/java/java_regex.asp
	 */
	public static void menu5() {
		String link = "http://www.escoladeltreball.org/ca";
		BufferedReader bufferReader = null;
		boolean append = false;
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        
        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            
            bufferReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            fileWriter = new FileWriter("menu5_links.txt", append);
            printWriter = new PrintWriter(fileWriter, true);		// Amb el true esborra el buffer de sortida.

            // Mirar https://www.w3schools.com/java/java_regex.asp
            // Pattern Class - Defines a pattern (to be used in a search)
            // Matcher Class - Used to search for the pattern
            Pattern p = Pattern.compile("(<a href=\")([^\"]+)(\")");	

            String line = "";
            while ((line = bufferReader.readLine()) != null) {
                Matcher matcher = p.matcher(line);
                while (matcher.find()) {
                    fileWriter.write(matcher.group(2) + "\n");		// 1a forma de escriure en el fitxer.
                    printWriter.println(matcher.group(2));	// 2a forma de escriure en el fitxer.
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
        		bufferReader.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	
        	printWriter.close();
        }
	}
	
	
	
	/*
	Crear un programa que donat un directori ens mostri tots els fitxers i directoris que té per sota. 

	Crideu a un mètode mostrarFitxersIDirectoris(File directori, List<String> llistaContingutDirectori) {} que serà
	el que fiqui en un ArrayList el nom dels arxius i directoris que trobi. 
	A més a més aquest mètode haurà de ser recursiu pel cas que dins un directori trobi un directori.

	Fes servir la classe File (apartat 1.4.2. dels apunts).
	 */
	public static void menu10() {
		String nomDirectori = "directori";
		File directori;
		List<String> llistaContingutDirectori = new ArrayList<String>();

        directori = new File(nomDirectori);
        
        mostrarFitxersIDirectoris(directori, llistaContingutDirectori);
        
        System.out.println("Contingut del directori:");
        for (String dada : llistaContingutDirectori) {
        	System.out.println(dada);	
        }
	}
	
	
	private static void mostrarFitxersIDirectoris(File directori, List<String> llistaContingutDirectori) {
        String pathDirectoriActual;
        String[] contingutDirectoriActual;
        
        
        pathDirectoriActual = directori.getPath();
        
        contingutDirectoriActual = directori.list();
        
        for (int i = 0; i < contingutDirectoriActual.length; i++) {
            File f = new File(pathDirectoriActual + "/" + contingutDirectoriActual[i]);
            
            if (f.isDirectory()) {
                mostrarFitxersIDirectoris(f, llistaContingutDirectori);
            }
            
            llistaContingutDirectori.add(contingutDirectoriActual[i]);
        }
    }
	
	

	
	
	
	/*
	Escriu un programa que realitza còpies de seguretat de tots els arxius d'un directori mitjançant la creació d'un nou subdirectori (dins del propi
	directori) anomenat backUp0 i copiant tots els arxius del directori actual al mateix. Els noms dels arxius de les còpies són els mateixos que en el
	directori actual. Només fer còpia de seguretat dels arxius, NO dels directoris.
	Si backUp0 ja existeix, la còpia de seguretat s'ha de fer en backUp1, i si aquest existeix doncs en backUp2 i així successivament. 

	Dins del mètode menu11() crida al mètode trobarNumBackupMesAlt() el qual retornarà el número de backUp més gran que s'ha fet servir fins ara.
	
	Després crida al mètode copiarTotsArxius() per a copiar els arxius al subdirectori del backUp creat.
	Si un arxiu no es pot llegir (veure canRead() de la classe File), cal mostrar un missatge d'advertència, no copiar-lo i continuar copiant
	la resta d'arxius.
	Copia els arxius fent servir FileUtils.copyFileToDirectory() .
	
	Utilitzeu els mètodes:
	- listFiles() de la classe File per obtenir una llista d'arxius i directoris.
	- isDirectory() o isFile() per determinar quins elements de la llista són arxius o directoris.
	- mkdir() per crear el nou directori.
	
	Feu servir la classe File (apartat 1.4.2. dels apunts) i FileUtils 
	 
	Si escrivim FileUtils ja ens demana de fer un import de la classe  org.apache.commons.io.FileUtils
	VEURE QUE PODEM FER AMB EL PLUGIN:
	Per a veure lo que aquest plugin pot fer escriurem FileUtils. i ens sortirà una llista dels atributs i mètodes que té.	 
	 */
	public static void menu11() {
		String nomDirectoriBackup="backUp";
        String pathOrigen = "directori";
        File [] arrayDeFilesDelOrigen;
        int numBackup;
        File backupFile;
        String pathDesti;
        

        arrayDeFilesDelOrigen = new File(pathOrigen).listFiles();
        
        numBackup = trobarNumBackupMesAlt(arrayDeFilesDelOrigen);
        numBackup = numBackup + 1;
        backupFile = new File (pathOrigen + "/" + nomDirectoriBackup + numBackup);
        backupFile.mkdir();
        pathDesti = pathOrigen + "/" + nomDirectoriBackup + numBackup;
        
        copiarTotsArxiusAutomaticament(backupFile, arrayDeFilesDelOrigen);
        
        System.out.println("FI");
	}
	
	
	private static int trobarNumBackupMesAlt(File[] filesDelDirectori) {
        int numBackupMesGran;
        String nomArxiu;
        String numBackUpTrobat;
        
        
        numBackupMesGran = 0;
        for (File f : filesDelDirectori) {
            if (f.isDirectory()){
                nomArxiu = f.getName();
                
                if (nomArxiu.matches(".*backUp[0-9]+")){
                    numBackUpTrobat = nomArxiu.substring(6, nomArxiu.length());
                    
                    if(numBackupMesGran < Integer.parseInt(numBackUpTrobat)){
                        numBackupMesGran = Integer.parseInt(numBackUpTrobat);
                    }
                }
            }
        }
        
        return numBackupMesGran;
    }
	
	
	private static void copiarTotsArxiusAutomaticament(File backupFile, File[] arrayDeFilesDelOrigen ) {
        for (File fOrigen : arrayDeFilesDelOrigen) {
            if (fOrigen.isFile()){
            	if (fOrigen.canRead()){
            		try {
						FileUtils.copyFileToDirectory(fOrigen, backupFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
            	} else {
            		System.out.println("L'arxiu "+ fOrigen +" no s'ha pogut copiar ja que no té permisos de lectura.");
            	}
            }
        }
    }
	
	
	
	/*
	Escriu un programa que realitza còpies de seguretat de tots els arxius d'un directori mitjançant la creació d'un nou subdirectori (dins del propi
	directori) anomenat backUp0 i copiant tots els arxius del directori actual al mateix. Els noms dels arxius de les còpies són els mateixos que en el
	directori actual. Només fer còpia de seguretat dels arxius, NO dels directoris.
	Si backUp0 ja existeix, la còpia de seguretat s'ha de fer en backUp1, i si aquest existeix doncs en backUp2 i així successivament. 
	
	Dins del mètode menu11() crida al mètode trobarNumBackupMesAlt() el qual retornarà el número de backUp més gran que s'ha fet servir fins ara.
	
	Després crida al mètode copiarTotsArxiusManualment() per a copiar els arxius al subdirectori del backUp creat.
	Si un arxiu no es pot llegir (veure canRead() de la classe File), cal mostrar un missatge d'advertència, no copiar-lo i continuar copiant la resta
	d'arxius.
	La manera de copiar l'arxiu serà creant un arxiu amb el mateix nom dins del directori de backUp i després copiar el contingut de l'arxiu origen
	sobre el de destí (el del directori de backUp). Per a copiar el contingut  de l'arxiu origen sobre el de destí crida al mètode copiarContingutFitxer() .
	
	En el mètode copiarContingutFitxer() per tal de garantir el funcionament correcte en la còpia del contingut per qualsevol tipus d'arxiu, realitza
	la lectura i escriptura amb fluxos orientats a byte (classes FileInputStream i FileOutputStream). 
	
	Utilitzeu els mètodes:
	- listFiles() de la classe File per obtenir una llista d'arxius i directoris.
	- isDirectory() o isFile() per determinar quins elements de la llista són arxius o directoris.
	- mkdir() per crear el nou directori.
	- fileInputStream.read() i fileOutputStream.write() .
	
	Feu servir la classe File (apartat 1.4.2. dels apunts).
	 */
	public static void menu12() {
		String nomDirectoriBackup="backUp";
        String pathOrigen = "directori";
        File [] arrayDeFilesDelOrigen;
        int numBackup;
        File backupFile;
        String pathDesti;
        

        arrayDeFilesDelOrigen = new File(pathOrigen).listFiles();
        
        numBackup = trobarNumBackupMesAlt(arrayDeFilesDelOrigen);
        numBackup = numBackup + 1;
        backupFile = new File (pathOrigen + "/" + nomDirectoriBackup + numBackup);
        backupFile.mkdir();
        pathDesti = pathOrigen + "/" + nomDirectoriBackup + numBackup;
        
        copiarTotsArxiusManualment(pathDesti, arrayDeFilesDelOrigen);
        
        System.out.println("FI");
	}
	
	
	private static void copiarTotsArxiusManualment(String pathDesti, File[] arrayDeFilesDelOrigen ) {
        for (File fOrigen : arrayDeFilesDelOrigen) {
            if (fOrigen.isFile()){
            	File fDesti = new File (pathDesti + "/" + fOrigen.getName());
            	
            	if (fOrigen.canRead()){
            		try {
						fDesti.createNewFile();
						copiarContingutFitxer(fOrigen, fDesti);
					} catch (IOException e) {
						// Aquí agafa les exepcions dels fileInputStream i fileOutputStream que hi ha en copiarContingutFitxer().
						e.printStackTrace();
					}
            	} else {
            		System.out.println("L'arxiu "+ fOrigen +" no s'ha pogut copiar ja que no té permisos de lectura.");
            	}
            }
        }
    }
	
	
	private static void copiarContingutFitxer(File fOrigen, File fDesti) throws IOException {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
        boolean append = true;
        int numCaractersLLegits;
        byte buff[] = new byte[100];
        
        
        fileInputStream = new FileInputStream(fOrigen);
        fileOutputStream = new FileOutputStream(fDesti, append);
        
        try {
            while ((numCaractersLLegits = fileInputStream.read(buff, 0, 100))>-1){
                fileOutputStream.write(buff,0,numCaractersLLegits);
            }
        } catch (IOException e) {
        	// Aquí agafa l'exepció de fileInputStream.read() .
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
            fileInputStream.close();
        }
    }
	
	
	
	//20. FileUtils (I)
	public static passarMultiplesParametres menu20() {
		String path = null;
		File directoriArrel = null;
		File directoriOrigen = null;
		List<File> llistaFitxers = null;
		passarMultiplesParametres objPassarMultiplesParametres;
		
		
		try {
			//APARTAT 1: Crea el directori "directoriExercici10" i dins el directori "origen" (forceMkdir).
	        path = "directoriMenu20/";
	        directoriArrel = new File(path);
			FileUtils.forceMkdir(directoriArrel);
	        directoriOrigen = new File(path + "origen");
	        FileUtils.forceMkdir(directoriOrigen);
	        System.out.println("APARTAT 1: Creats els directoris " + directoriArrel.getPath() + " i " + directoriOrigen.getPath());
	        System.out.println();
	
	        
	        //APARTAT 2: Crea amb un bucle 5 fitxers anomenats "fitxer1.txt" - "fitxer5.txt" (createNewFile).
	        String nomFitxer;
	        boolean fitxerCreat = false;
	        ArrayList<String> totsNomsFitxers = new ArrayList<String>();
	        for(int i = 1; i < 6; i++){
	            nomFitxer = path + "fitxer" + i + ".txt";
	            totsNomsFitxers.add(nomFitxer);
	            File fitxerTmp = new File(nomFitxer);
	            fitxerCreat = fitxerTmp.createNewFile();
	            System.out.println("APARTAT 2: S'ha creat el fitxer " + nomFitxer + "? " + fitxerCreat);
	        }
	        System.out.println();
	        
	        
	        //APARTAT 3: Afegeix unes linies de text en els fitxers (les linies de text seràn els noms
	        //dels fitxers) (listFiles)(writeLines).
	        String[] extensionsFitxers = {"txt", "java","xml"};
	        llistaFitxers = (List<File>)FileUtils.listFiles(directoriArrel, extensionsFitxers, true);
	
	        for (File fitxer: llistaFitxers){
	            FileUtils.writeLines(fitxer, "UTF-8", totsNomsFitxers, null, true);
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        System.out.println("APARTAT 3: ARA ES HORA DE MIRAR SI S'HA AFEGIT EL CONTINGUT ALS FITXERS QUE ENCARA ES TROBEN EN " + path);
        
        objPassarMultiplesParametres = new passarMultiplesParametres(llistaFitxers, directoriOrigen, path, directoriArrel);
        
        return objPassarMultiplesParametres;
	}
	
	
	
	//21. FileUtils (II)
	public static passarMultiplesParametres menu21(passarMultiplesParametres objPassarMultiplesParametres) {
		try {
			//APARTAT 4: Mou els 5 fitxers a dins del directori "origen" (moveFileToDirectory).
	        Iterator<File> it = objPassarMultiplesParametres.getLlistaFitxers().iterator();
	        while (it.hasNext()){
	            FileUtils.moveFileToDirectory(it.next(), objPassarMultiplesParametres.getDirectoriOrigen(), true);
	        }
	        System.out.println("APARTAT 4: S'HAN MOGUT ELS 5 FITXERS A " + objPassarMultiplesParametres.getDirectoriOrigen().getPath()); 
	        System.out.println();
	        
	        /*ESBORRAR D'AQUESTA MANERA NO VA.
	        for (File fitxer: llistaFitxers){
	            FileUtils.moveFileToDirectory(fitxer, directoriOrigen, true);
	        }*/
	        
	        
	        //APARTAT 5: Pregunta si el directori conté algún fitxer amb nom "fitxer3.txt" 
	        //(getFile)(directoryContains).
	        File fitxer3txt = FileUtils.getFile(objPassarMultiplesParametres.getDirectoriOrigen(), "fitxer3.txt");
	        System.out.println("APARTAT 5: Està fitxer3.txt?: " + FileUtils.directoryContains(objPassarMultiplesParametres.getDirectoriOrigen(), fitxer3txt));
	        System.out.println();
	        
	        
	        //APARTAT 6: Esborra el fitxer "fitxer3.txt" i torna a executar l'apartat 5 (forceDelete).
	        FileUtils.forceDelete(fitxer3txt);
	        System.out.println("APARTAT 6: Està fitxer3.txt?: " + FileUtils.directoryContains(objPassarMultiplesParametres.getDirectoriOrigen(), fitxer3txt));
	        System.out.println();
	        
	        
	        //APARTAT 7: Comproba si el fitxer "fitxer1.txt" és mes vell que "Fitxer5.txt" (isFileOlder).
	        File fitxer1txt = FileUtils.getFile(objPassarMultiplesParametres.getDirectoriOrigen(), "fitxer1.txt");
	        File fitxer5txt = FileUtils.getFile(objPassarMultiplesParametres.getDirectoriOrigen(), "fitxer5.txt");
	        System.out.println("APARTAT 7:");
	        System.out.println("Data (long Date) última modificació de fitxer1.txt: " + fitxer1txt.lastModified());
	        System.out.println("Data (LocalDateTime) última modificació de fitxer1.txt: " + Data.imprimirLongTime(fitxer1txt.lastModified()));
	        System.out.println("Data (long Date) última modificació de fitxer5.txt: " + fitxer5txt.lastModified());
	        System.out.println("Data (LocalDateTime) última modificació de fitxer5.txt: " + Data.imprimirLongTime(fitxer5txt.lastModified()));
	        System.out.println("Fitxer1.txt és meś vell que fitxer5.txt?: " + FileUtils.isFileOlder(fitxer1txt, fitxer5txt));
	        System.out.println();
	        
	        
	        //APARTAT 8: Copia, machacant el contingut anterior, la linia "linia sobreescrita" en el
	        //fitxer "fitxer1.txt" (writeStringToFile)
	        FileUtils.writeStringToFile(fitxer1txt, "linia sobreescrita", "UTF-8", false);
	        System.out.println("APARTAT 8: CANVIAT EL CONTINGUT DEL FITXER fitxer1.txt");
	        System.out.println();
	        
	        
	        //APARTAT 9: Comproba si el fitxer "fitxer1.txt" és mes nou que "fitxer5.txt"
	        System.out.println("APARTAT 9:");
	        System.out.println("Data (long Date) última modificació de fitxer1.txt: " + fitxer1txt.lastModified());
	        System.out.println("Data (Calendar) última modificació de fitxer1.txt: " + Data.imprimirLongTime(fitxer1txt.lastModified()));
	        System.out.println("Data (long Date) última modificació de fitxer5.txt: " + fitxer5txt.lastModified());
	        System.out.println("Data (Calendar) última modificació de fitxer5.txt: " + Data.imprimirLongTime(fitxer5txt.lastModified()));
	        System.out.println("Fitxer1.txt és meś nou que fitxer5.txt?: " + FileUtils.isFileNewer(fitxer1txt, fitxer5txt));
	        System.out.println();
	        
	        
	        //APARTAT 10: Fes un touch sobre el fitxer "fitxer5.txt" i comproba si el fitxer "fitxer1.txt"
	        //és mes nou que "fitxer5.txt" (touch).
	        //bloquejarPantalla();
	        FileUtils.touch(fitxer5txt);
	        System.out.println("APARTAT 10");
	        System.out.println("Data (long Date) última modificació de fitxer1.txt: " + fitxer1txt.lastModified());
	        System.out.println("Data (Calendar) última modificació de fitxer1.txt: " + Data.imprimirLongTime(fitxer1txt.lastModified()));
	        System.out.println("Data (long Date) última modificació de fitxer5.txt: " + fitxer5txt.lastModified());
	        System.out.println("Data (Calendar) última modificació de fitxer5.txt: " + Data.imprimirLongTime(fitxer5txt.lastModified()));
	        System.out.println("Fitxer1.txt és meś nou que fitxer5.txt?: " + FileUtils.isFileNewer(fitxer1txt, fitxer5txt));            
	        System.out.println();
        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objPassarMultiplesParametres;
	}

	
	
	//22. FileUtils (III)
	public static void menu22(passarMultiplesParametres objPassarMultiplesParametres) {
		try {
			//APARTAT 11: Mou el el directori "origen" al directori "desti" i si no existeix
	        //previament "desti" donçs que es crei automàticament (moveDirectoryToDirectory).
	        File directoriDesti = new File(objPassarMultiplesParametres.getPath() + "desti");
	        FileUtils.moveDirectoryToDirectory(objPassarMultiplesParametres.getDirectoriOrigen(), directoriDesti, true);
	        System.out.println("APARTAT 11: S'HA MOGUT EL DIRECTORI " + objPassarMultiplesParametres.getDirectoriOrigen().getPath() + " A DINS DEL DIRECTORI " + directoriDesti.getPath());
	        System.out.println();
	        
	        
	        //APARTAT 12: Calcula el tamany del directori "desti" (sizeOfDirectoryAsBigInteger)
	        System.out.println("APARTAT 12: EL TAMANY DEL DIRECTORI desti ES: " + FileUtils.sizeOfDirectoryAsBigInteger(directoriDesti));
	        System.out.println("SUMEU EL TAMANY DELS 5 FITXERS QUE HI HA DINS DEL DIRECTORI desti I VEUREU QUE"
	        		+ "\n SUMEN 438 BYTES SEMPRE I QUAN NOMÉS EXECUTEU ELS MENÚS 20 I 21 UNA VEGADA.");
	        System.out.println();
	      
	        
	        //APARTAT 13: Fer servir el iterador de FileUtils per a recorre el directori "directoriExercici10"
	        //i treure per pantalla el seu contingut indicant si son fitxers o directoris (iterateFilesAndDirs).
	        System.out.println("APARTAT 13:");
	        Iterator it2 = FileUtils.iterateFilesAndDirs(objPassarMultiplesParametres.getDirectoriArrel(), new WildcardFileFilter("*.txt"), new WildcardFileFilter("*"));
	        while (it2.hasNext()){
	            File fileTmp = (File)it2.next();
	            System.out.println("    NOM DEL FILE TROBAT: " + ((File) fileTmp).getName());
	            System.out.println("    PATH DEL FILE TROBAT: " + ((File) fileTmp).getPath());
	            System.out.println("    ES UN FITXER?: " + ((File) fileTmp).isFile());
	            System.out.println("    ES UN DIRECTORI?: " + ((File) fileTmp).isDirectory());
	            System.out.println();
	        }
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	//30. Guardar les naus amb RandomAccesFile
	public static void menu30() throws IOException {
        LocalDateTime today;
        ArrayList<Naus_Dades> arrayListDeNaus = new ArrayList<Naus_Dades>();
        File fitxer = new File("Naus_Dades.dat");
        RandomAccessFile fitxerEmmagatzematge = null;
        int longString;
        StringBuffer stringBuffer = null;
       
        
        today = LocalDateTime.now();

        // Per a passar de String --> char[]: es fa servir .toCharArray() sobre el string.
        arrayListDeNaus.add(new Naus_Dades("Agamemnon", "destructor", "Omega".toCharArray(), today, "Enviat a la flota de Babylon 5"));
        arrayListDeNaus.add(new Naus_Dades("Achilles", "destructor", "Omega".toCharArray(), today, "Enviat a la flota de Babylon 5"));
        arrayListDeNaus.add(new Naus_Dades("Cortez", "explorador", "Explorer".toCharArray(), today, "Enviat a l'espai profund"));
        
		try {
			fitxerEmmagatzematge = new RandomAccessFile(fitxer, "rw");
			
			// RandomAccessFile no sap escriure i llegir objectes, ni String, ni LocalDateTime,...
	        for(Naus_Dades nauTmp : arrayListDeNaus){
	            // Gravem el nom (String nom).
	            longString = nauTmp.getNom().length();
	            fitxerEmmagatzematge.writeInt(longString);
	            fitxerEmmagatzematge.writeChars(nauTmp.getNom());
	            System.out.println("longString = " + longString + ", nauTmp.getNom() = " + nauTmp.getNom());
	            System.out.println();
	            
	            // Gravem el tipus (String tipus).
	            longString = nauTmp.getTipus().length();
	            fitxerEmmagatzematge.writeInt(longString);
	            fitxerEmmagatzematge.writeChars(nauTmp.getTipus());                
	            System.out.println("longString = " + longString + ", nauTmp.getTipus() = " + nauTmp.getTipus());
	            System.out.println();
	            
	            // Gravem el model (char model[50]).
	            // Per a passar de char[] --> String: String.valueOf(X) on X és de tipus char[].
	            stringBuffer = new StringBuffer(String.valueOf(nauTmp.getModel()));
	            stringBuffer.setLength(50);
	            fitxerEmmagatzematge.writeChars(stringBuffer.toString());
	            System.out.println("stringBuffer.length() = " + stringBuffer.length() + ", StringBuffer(String.valueOf(nauTmp.getModel())) = " + stringBuffer);
	            System.out.println();
	            
	            // Gravem la dataConstruccio (LocalDateTime dataConstruccio).
	            // ALERTA: la LocalDateTime ocupa 23 caràcters en Java 8 i 26 en Java 11.
	            // Potser la millor solució per a gravar el contingut d'una LocalDateTime sería calcular la quantitat de caràcters que
	            // té (dataAGravar.length()) i gravar el número en el fitxer (amb writeInt()) i després gravar el valor de la LocalDateTime.
	            //System.out.println(nauTmp.getDataConstruccio().toString());
	            fitxerEmmagatzematge.writeChars(String.valueOf(nauTmp.getDataConstruccio().toString()));
	            System.out.println("nauTmp.getDataConstruccio() = " + nauTmp.getDataConstruccio());
	            System.out.println("String.valueOf(nauTmp.getDataConstruccio().toString().length) = " + String.valueOf(nauTmp.getDataConstruccio().toString().length()));
	            System.out.println("String.valueOf(nauTmp.getDataConstruccio().toString()) = " + String.valueOf(nauTmp.getDataConstruccio().toString()));
	            System.out.println();
	            
	            // Gravem la descripció (String descripcio).
	            longString = nauTmp.getDescripcio().length();
	            fitxerEmmagatzematge.writeInt(longString);
	            fitxerEmmagatzematge.writeChars(nauTmp.getDescripcio()); 
	            System.out.println("longString = " + longString + ", nauTmp.getNom() = " + nauTmp.getDescripcio());
	            System.out.println();
	            
	            System.out.println("Gravada la nau " + nauTmp.getNom());
	            System.out.println("----------------");
	        }
	        
	        System.out.println();
	        System.out.println("S'han gravat totes les naus amb èxit.");
		} finally {
			fitxerEmmagatzematge.close();
			System.out.println("Fitxer tancat amb èxit.");
		}
	}
	
	
	
	//31. Recuperar les naus amb RandomAccesFile
	public static void menu31() throws IOException {
		File fitxer = new File("Naus_Dades.dat");
        RandomAccessFile fitxerEmmagatzematge = null;
        String stringTmp;
        int longString;
        
        
		fitxerEmmagatzematge = new RandomAccessFile(fitxer, "r");
		
		while (fitxerEmmagatzematge.getFilePointer() != fitxerEmmagatzematge.length()) {
        	System.out.println("----------------");
        	
            // LLegim el nom (String nom).
        	stringTmp = "";
            longString = fitxerEmmagatzematge.readInt();
            System.out.println("Nom.length(): " + longString);
            for(int i = 0; i< longString; i++) {
                //System.out.println("Nom: " + fitxerEmmagatzematge.readChar());
            	stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
            }
            System.out.println("Nom: " + stringTmp);
            
            // LLegim el tipus (String tipus).
            stringTmp = "";
            longString = fitxerEmmagatzematge.readInt();
            System.out.println("tipus.length(): " + longString);
            for(int i = 0; i< longString; i++) {
                //System.out.println("Tipus: " + fitxerEmmagatzematge.readChar());
            	stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
            }
            System.out.println("Tipus: " + stringTmp);
            
            // LLegim el model (char model[50]).    
            stringTmp = "";
            for(int i = 0; i< 50; i++) {
                //System.out.println("Model: " + fitxerEmmagatzematge.readChar());
                stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
            }
            System.out.println("Model: " + stringTmp);
            
            // LLegim la dataConstruccio (LocalDateTime dataConstruccio).
            // ALERTA: la LocalDateTime ocupa 23 caràcters en Java 8 i 26 en Java 11.
            // Potser la millor solució per a gravar el contingut d'una LocalDateTime sería calcular la quantitat de caràcters que
            // té (dataAGravar.length()) i gravar el número en el fitxer (amb writeInt()) i després gravar el valor de la LocalDateTime.
            stringTmp = "";
            for(int i = 0; i< 26; i++) {		// Si s'executés amb Java 8 hauriem de posar 23 en comptes de 26.
                //System.out.println("Data construcció: " + fitxerEmmagatzematge.readChar());
                stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
            }
            System.out.println("Data construcció: " + Data.imprimirData(LocalDateTime.parse(stringTmp)));
            
            // LLegim la descripció (String descripcio).
            stringTmp = "";
            longString = fitxerEmmagatzematge.readInt();
            System.out.println("descripcio.length(): " + longString);
            for(int i = 0; i< longString; i++) {
                //System.out.println("Descripció: " + fitxerEmmagatzematge.readChar());
            	stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
            }
            System.out.println("Descripció: " + stringTmp);
        }
		
		fitxerEmmagatzematge.close();
		
		System.out.println();
    	System.out.println("Fitxer llegit i tancat amb èxit.");
	}
	
	
	
	
	
	
	
	
}
