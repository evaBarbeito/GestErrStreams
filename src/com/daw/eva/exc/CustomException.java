package com.daw.eva.exc;

public class CustomException extends Exception {

	public CustomException(int i, String string) {
		// TODO Auto-generated constructor stub
		super("Error code:"+i+ ", " + string);
	}

}
