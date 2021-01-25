/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.kronaStreams;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author eva
 */
public class Naus_Dades implements Comparable<Naus_Dades>{
    String nom;
    String tipus;
    char model[] = new char [50];
    LocalDateTime dataConstruccio;
    String descripcio;
    

    public Naus_Dades(String nom, String tipus, char[] model, LocalDateTime dataConstruccio, String descripcio) {
        this.nom = nom;
        this.tipus = tipus;
        this.model = model;
        this.dataConstruccio = dataConstruccio;
        this.descripcio = descripcio;
    }
    

    public String getNom() {
        return nom;
    }

    public String getTipus() {
        return tipus;
    }

    public char[] getModel() {
        return model;
    }

    public LocalDateTime getDataConstruccio() {
        return dataConstruccio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setModel(char[] model) {
        this.model = model;
    }

    public void setDataConstruccio(LocalDateTime dataConstruccio) {
        this.dataConstruccio = dataConstruccio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = dataConstruccio.format(formatter);

        return nom + ": " + tipus + " del model " + model + " construit el " + formatDateTime + ". Descripció: " + descripcio;
    }

/*DE L'ALUMNE 
	@Override
    public String toString() {
        return getNom() +": "+ tipus + " del model " + getModel() + " construit el " + calendarToString(getDataConstruccio()) + ". Descripció: " + getDescripcio();
    }

    public String calendarToString(Calendar c){
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date1 = sdf.format(date);

        return date1;
    }
*/
    
    
    //Emmagetzarem els objectes Naus_Dades en un HashSet. Un HashSet és com un array on els
    //objectes es guarden en una posició (calaix) concreta en funció del cálcul del hashcode.
    //Farem que totes les naus del mateix "tipus" es guardin en el mateix calaix i a llavors
    //per a diferenciar-les (dins del calaix) es farà servir el equals().
    //Quan insertem una nova nau (métode add()), es farà el insert si no hi ha cap nau amb
    //el mateix nom + tipus + model. Si existis una nau amb el mateix nom + tipus + model 
    //a llavors no es faria res (ni un update).
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.tipus);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Naus_Dades other = (Naus_Dades) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.tipus, other.tipus)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        return true;
    }

    //És lo que es fa servir quan s'executa un sort() per a comparar les naus.
    @Override
    public int compareTo(Naus_Dades o) {
        return this.getNom().compareToIgnoreCase(o.getNom());
    }
    
           
    
}
