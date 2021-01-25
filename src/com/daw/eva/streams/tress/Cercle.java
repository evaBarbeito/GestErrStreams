/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.streams.tress;

import java.io.Serializable;

/**
 *
 * @author gmartinez
 */
public class Cercle implements Serializable {
    private Punt centre;
    private int radi;
   
    public Cercle() { }
   
    public Cercle(Punt centre, int radi) {
        this.centre = centre;
        this.radi = radi;
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
    
}
