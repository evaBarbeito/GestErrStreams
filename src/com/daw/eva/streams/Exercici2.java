package com.daw.eva.streams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercici2 {
	public static void main(String[] args) {
		String bigFileRuta = "a.txt";
		File bigFile = new File(bigFileRuta);
		int chunkSize = 100;
		String baseName = "tros";
		try {
			truncar(bigFile, chunkSize, baseName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void truncar(File bigFile, int chunkSize, String baseName) throws IOException {
		byte b[] = new byte [chunkSize];
		FileInputStream fileInputStream=null;
		FileOutputStream fileOutputStream=null;
		
		try {
			fileInputStream = new FileInputStream(bigFile);
			int i=0;
			while (fileInputStream.read(b, 0, chunkSize)>0){
				fileOutputStream = new FileOutputStream(baseName+i+".txt");
				fileOutputStream.write(b);
				i++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
			
		} finally {
			fileInputStream.close();
			fileOutputStream.close();
		}
	}
}
