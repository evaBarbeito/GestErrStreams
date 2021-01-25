package com.daw.eva.exc;

public class InvalidUserIdException extends Exception {
	@Override
	   public String toString() {
	       return ("Invalid user id entered");
	   }
}

