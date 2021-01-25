package com.daw.eva.exc;

public class NegativeNotAllowedException extends Exception {
	@Override
	   public String toString() {
	       return ("Negative amount is not allowed!");
	   }

}
