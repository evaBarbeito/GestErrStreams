package com.daw.eva.streams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Crear un programa que llegeixi un arxiu de text i crei dos arxius: un que
 * contigui una llista de totes les paraules de l'arxiu ordenada alfabèticament
 * i un altre amb un registre de les repeticions de cada paraula ordenat per
 * repeticions.
 * 
 *
 */
public class Exercici6 {
	public static void main(String[] args) throws IOException {
		Map<String, Integer> registreParaules = new HashMap<String, Integer>();
		Set<String> paraulesDiferents = new TreeSet<String>();

		
		BufferedReader br = null;
		BufferedReader buffer = null;
		try {
			
			// String arxiu = llegirParametreEntrada();
			 String arxiu = "a.txt";
			 FileReader reader = new FileReader(new File(arxiu));
			buffer = new BufferedReader(reader);
			String line;
			String paraules[];
			while ((line = buffer.readLine()) != null) {
				paraules = line.split(" ");
				for (String paraula : paraules) {
					if (!paraula.equals("")) {
						if (paraulesDiferents.add(paraula)) {
							registreParaules.put(paraula, new Integer(1));
						} else {
							registreParaules.put(paraula,
									registreParaules.get(paraula) + 1);
						}
					}
				}
			}
			escriuParaulesDiferents(paraulesDiferents);
			escriuRegistreParaules(registreParaules);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			buffer.close();
		}
	}

	private static String llegirParametreEntrada() {
		System.out.println("Posa nom fitxer");
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String line;
		 String arxiu="";
		 try {
			arxiu= br.readLine();
				       
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arxiu;
	}

	private static void escriuRegistreParaules(Map<String, Integer> registre) throws IOException {
		FileWriter fwriter = null;
		try {
			 fwriter = new FileWriter(
					new File("registreParaules.txt"));
			Set<String> values = registre.keySet();
			for (String paraula : values) {
				fwriter.write(paraula + ": " + registre.get(paraula).toString()
						+ " vegades\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			fwriter.close();
		}
	}

	private static void escriuParaulesDiferents(Set<String> paraulesDiferents) throws IOException {
		FileWriter fwriter=null;
		try {
			fwriter = new FileWriter(new File("paraulesDif.txt"));
			for (String paraula : paraulesDiferents) {
				fwriter.write(paraula + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			fwriter.close();
		}

	}
}
