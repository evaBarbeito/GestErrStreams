package com.daw.eva.gui;

public class Empleat extends Persona implements Comparable<Empleat>{
    int codiEmpleat;
    String carrec;
    int jornadaLaboral;
    String estudis;
    int salari;
    double telefon;
	
	
    public Empleat(int codiEmpleat, String carrec, int jornada_laboral, int salari, 
            String nom, String cognom1, String cognom2, String dni) {
        super(nom, cognom1, cognom2, dni);
        this.codiEmpleat = codiEmpleat;
        this.carrec = carrec;
        this.jornadaLaboral = jornada_laboral;
        this.salari = salari;
    }
    
    public int getCodiEmpleat() {
        return codiEmpleat;
    }
    
    public void setCodiEmpleat(int codi_empleat) {
        this.codiEmpleat = codi_empleat;
    }
    
    public String getCarrec() {
        return carrec;
    }
    
    public void setCarrec(String carrec) {
        this.carrec = carrec;
    }
    
    public int getJornadaLaboral() {
        return jornadaLaboral;
    }
    
    public void setJornadaLaboral(int jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }
    
    public String getEstudis() {
        return estudis;
    }
    
    public void setEstudis(String estudis) {
        this.estudis = estudis;
    }
    
    public int getSalari() {
        return salari;
    }
    
    public void setSalari(int salari) {
        this.salari = salari;
    }
    
    public double getTelefon() {
        return telefon;
    }
    
    public void setTelefon(double telefon) {
        this.telefon = telefon;
    }
    
    @Override
    public int compareTo(Empleat o) {
        return o.salari - this.salari;
    }
}
