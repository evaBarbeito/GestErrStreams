package com.daw.eva.streams;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class Exemple4 {
	public static void main(String[] args) throws IOException {
		String arxiuLectura = "exemple1.txt";
		String arxiuEscriptura = "copiaExemple1.txt";

		// Per llegir bytes
		InputStream fInputStream = null;
		OutputStream fOutputStream = null;

		// Per llegir caràcters
		Reader fReader = null;
		Writer fWriter = null;

		// Per llegir linies
		BufferedReader bufferR = null;
		PrintWriter bufferW = null;

		try {

			fInputStream = new FileInputStream(arxiuLectura);
			fOutputStream = new FileOutputStream(arxiuEscriptura);

			fReader = new FileReader(arxiuLectura);
			fWriter = new FileWriter(arxiuEscriptura);

			bufferR = new BufferedReader(new FileReader(arxiuLectura));
			bufferW = new PrintWriter(new FileWriter(arxiuEscriptura));

			llegirByteAbyte(fInputStream, fOutputStream);
			llegirPerBlocs(fInputStream, fOutputStream);
			llegirDeCop(fInputStream, fOutputStream);

			llegirPerBlocOrientatCaracter(fReader, fWriter);
			
			llegirLinies(bufferR, bufferW);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fInputStream != null)
				fInputStream.close();
			if (fOutputStream != null)
				fOutputStream.close();
			if (fReader != null)
				fReader.close();
			if (fWriter != null)
				fWriter.close();
			if (bufferR != null)
				bufferR.close();
			if (bufferW != null)
				bufferW.close();

		}
	}

	private static void llegirLinies(BufferedReader inputStream, PrintWriter outputStream) {

		String l;
		try {
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
				System.out.println(l);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void llegirPerBlocOrientatCaracter(Reader fInput, Writer foutput) {
		try {
			char[] dades = new char[100];
			int llegits = 0;
			while (-1 < (llegits = fInput.read(dades)))
				foutput.write(dades, 0, llegits);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void llegirDeCop(InputStream fInput, OutputStream foutput) {
		try {
			byte data[] = new byte[fInput.available()];
			fInput.read(data, 0, fInput.available());
			foutput.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void llegirPerBlocs(InputStream in, OutputStream out) {
		try {
			byte[] dades = new byte[100];
			int llegits = 0;
			while (-1 != (llegits = in.read(dades)))
				out.write(dades, 0, llegits);
			out.close();
	//		in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void llegirByteAbyte(InputStream fInput, OutputStream foutput) {
		int llegit;
		try {
			while ((llegit = fInput.read()) > -1) {
				foutput.write(llegit);
			}
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}
}
