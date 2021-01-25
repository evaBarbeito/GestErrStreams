package com.daw.eva.exemples;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eva
 */
public class exemplesApartat1punt4ExempleExceptionMeva extends Exception {
    public exemplesApartat1punt4ExempleExceptionMeva(String message) {
        super(message);
    }

    public String getLocalizedMessage() {
        String error = super.getMessage();
        error += "\nMissatge personalitzat:";
        return error;
    }
}