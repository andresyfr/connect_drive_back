package com.andresyfr.connect.drive.services.exceptions;

public class AccessDeniedExceptionView extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AccessDeniedExceptionView(String message) {
		super(message);
	}

}
