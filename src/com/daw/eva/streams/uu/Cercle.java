/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.streams.uu;

/**
 *
 * @author gmartinez
 */
public class Cercle {
    private String nom;
    private Punt centre;
    private int radi;
   
    public Cercle() { }
   
    public Cercle(String nom, Punt centre, int radi) {
        this.nom = nom;
        this.centre = centre;
        this.radi = radi;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Punt getCentre() {
        return centre;
    }

    public void setCentre(Punt centre) {
        this.centre = centre;
    }

    public int getRadi() {
        return radi;
    }

    public void setRadi(int radi) {
        this.radi = radi;
    } 
    
    
    public String getDadesCentre() {
        return ("x = " + Integer.toString(this.centre.getX()) + ", y = " + Integer.toString(this.centre.getY()));
    }

}
