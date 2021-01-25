package com.daw.eva.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex3serieRANDOM {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File fichero = new File("Departamentos.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");

		int Departamento[] = {10, 15, 20, 25, 30, 35, 40, 45, 50};
		String Nombre[] = {"INFORM�TICA","MARK�TING","CONTABILIDAD","VENTAS", "COMPRAS","PERSONAL", "RECURSOS", "ADMINISTRACI�N", "ECONOM�A"};
		String Localidad[] = {"MADRID", "SEVILLA", "LE�N", "TOLEDO", "GUADALAJARA","CUENCA","OVIEDO", "BILBAO","VALENCIA"};
		
		StringBuffer buffer = null;
		StringBuffer buffer2 = null;
		int n=Nombre.length;
		
		for (int i=0; i<n; i++) {
			file.writeInt(i+1);
			
			file.writeInt(Departamento[i]);

			buffer = new StringBuffer(Nombre[i]);
			buffer.setLength(15);
			file.writeChars(buffer.toString());
			
			buffer2 = new StringBuffer(Localidad[i]);
			buffer2.setLength(15);
			file.writeChars(buffer2.toString());
		}

		file.close();
		
		
		file = new RandomAccessFile(fichero, "r");
		
        int id, dep, pos = 0;
        char nom[] = new char [15];
        char loc[] = new char [15];
        char aux, aux2;

        file.seek(pos);
        for (;;) {
            //file.seek(pos);       // Ara no fa falta perqu� hem camuglat la l�nia pos = pos + 68;

            id = file.readInt();

            dep = file.readInt();

            for(int i = 0; i<nom.length; i++) {
                aux = file.readChar();
                nom[i] = aux;
            }

            for (int i = 0; i<loc.length; i++) {
                aux2 = file.readChar();
                loc[i] = aux2;
            }

            String nomS = new String(nom);
            String locS = new String(loc);

            System.out.println(nomS.length() + ", " +  locS.length());
            //no hi quep en una sola línia
            System.out.println("ID: " + id + ", Departamento: " + dep + ", Nombre: " + nomS ) ; // +  ", Localidad: " + locS + ".");
            System.out.println("Localidad: "+ locS );
            System.out.println("ID: " + id + ", Departamento: " + dep + ", Nombre: " + nomS.trim() + ", Localidad: " + locS.trim() + ".");
            System.out.println();

            //pos = pos+68;         // Per a saltar des de el principi del fitxer al seg�ent bloc per� no fa falta perqu� despr�s de 
                                    // l'�ltim file.readChar(), per agafar la localitat, el punter ja apunta al seg�ent bloc.

            if (file.getFilePointer()==file.length()) {
                break;
            }
        }

        file.close();
	}

}
