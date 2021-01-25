package com.daw.eva.streams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exemple3 {
	public static void main(String[] args) {
		File fileOriginal = new File("exemple1.txt");
		File fileDesti = new File("desti.txt");
		try {
			copiar(fileOriginal, fileDesti);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copiar(File fileOriginal, File fileDesti) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(fileOriginal);
			out = new FileOutputStream(fileDesti);
			int x;
			while ( (x=in.read())>-1){
				out.write(x);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			in.close();
			out.close();
		}
	}
} 
