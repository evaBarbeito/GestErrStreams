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
public class Punt implements Serializable {
    private int x;
    private int y;

    public Punt() { }

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }
   
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
