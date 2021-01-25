package com.daw.eva.gui;

import java.util.ArrayList;
import java.util.List;

public class ValidationEmpleatException extends Exception {
    static List<String> errors = new ArrayList<String>();
	
    public ValidationEmpleatException() {
    }

    public void addError(String error) {
        errors.add(error);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }
}
