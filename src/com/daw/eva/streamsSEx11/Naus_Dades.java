package com.daw.eva.streamsSEx11;

import java.time.LocalDateTime;

public class Naus_Dades {
	String nom;
    String tipus;
    char model[] = new char [50];
    LocalDateTime dataConstruccio;
    String descripcio;
    
    
    
    public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getTipus() {
		return tipus;
	}



	public void setTipus(String tipus) {
		this.tipus = tipus;
	}



	public char[] getModel() {
		return model;
	}



	public void setModel(char[] model) {
		this.model = model;
	}



	public LocalDateTime getDataConstruccio() {
		return dataConstruccio;
	}



	public void setDataConstruccio(LocalDateTime dataConstruccio) {
		this.dataConstruccio = dataConstruccio;
	}



	public String getDescripcio() {
		return descripcio;
	}



	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}



	public Naus_Dades(String nom, String tipus, char[] model, LocalDateTime dataConstruccio, String descripcio) {
        this.nom = nom;
        this.tipus = tipus;
        this.model = model;
        this.dataConstruccio = dataConstruccio;
        this.descripcio = descripcio;
    }
    
}
