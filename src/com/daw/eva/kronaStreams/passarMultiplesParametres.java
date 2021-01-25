package com.daw.eva.kronaStreams;

import java.io.File;
import java.util.List;

public class passarMultiplesParametres {
	private List<File> llistaFitxers;
	private File directoriOrigen;
	private File directoriArrel;
	private String path;
	
	
	public List<File> getLlistaFitxers() {
		return llistaFitxers;
	}

	public void setLlistaFitxers(List<File> llistaFitxers) {
		this.llistaFitxers = llistaFitxers;
	}

	public File getDirectoriOrigen() {
		return directoriOrigen;
	}

	public void setDirectoriOrigen(File directoriOrigen) {
		this.directoriOrigen = directoriOrigen;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public File getDirectoriArrel() {
		return directoriArrel;
	}

	public void setDirectoriArrel(File directoriArrel) {
		this.directoriArrel = directoriArrel;
	}

	
	public passarMultiplesParametres(List<File> llistaFitxers, File directoriOrigen, String path, File directoriArrel) {
		this.llistaFitxers = llistaFitxers;
		this.directoriOrigen = directoriOrigen;
		this.path = path;
		this.directoriArrel = directoriArrel;
	}
	
}
