package com.daw.eva.streams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Escriu un programa que crea un nou arxiu mitjançant la concatenació de
 * diversos arxius alhora. Per teclat ens demanarà una serie de fitxers i el nom
 * del nou fitxer. Cada arxiu d'origen ha d'existir (si no, escriviu un missatge
 * d'error i la sortida). L'últim nom de fitxer en la línia, newFile, és el nom
 * del fitxer a ser creat, i no ha d'existir. Crea el nou arxiu amb l'obertura
 * dels arxius d'origen d'un en un, en l'ordre, la lectura de cada arxiu byte
 * per byte i escriptura de cada byte per newFile. Tanqueu tots els arxius quan
 * ja no són necessàris.
 * 
 *
 */
public class Exercici1 {
	public static void main(String[] args) throws IOException {
//		Scanner scanner = new Scanner(System.in);
//		List<String> arxius = new ArrayList<String>();
//		String arxiu = scanner.next();
//		System.out.println(arxiu);
//		while (scanner.hasNext()) {
//			arxius.add(arxiu);
//			arxiu = scanner.next();
//		}
//		scanner.close();
		List<String> arxius = new ArrayList<String>();
		arxius.add("a.txt");
		arxius.add("b.txt");
		arxius.add("c.txt");
		OutputStream f = new FileOutputStream (new File("d.txt"),true);
		int x = 45098;
		f.write(x);;
		f.close();
		concatenarArxius(arxius);
	}

	private static void concatenarArxius(List<String> arxius) {
		
		try {
			File fileO = new File(arxius.get(arxius.size()-1));
			for (int i = 0; i < arxius.size()-1; i++) {
				FileInputStream fileInputStream= new FileInputStream(new File(arxius.get(i)));
				copiar (fileInputStream,fileO);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("arxiu no trobat");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Errors IO");
		}
	}

	private static void copiar(FileInputStream fileInputStream, File fileO) throws IOException {
		boolean append=true;
		byte buff[] = new byte[100];
		FileOutputStream fileOutputStream = new FileOutputStream(fileO ,append);
		try {
			int reads;
			while ((reads = fileInputStream.read(buff, 0, 100))>-1){
				fileOutputStream.write(buff,0,reads);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fileOutputStream.close();
			fileInputStream.close();

		}
	}
}
