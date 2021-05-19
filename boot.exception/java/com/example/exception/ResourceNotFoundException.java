package com.example.exception;

public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID = 1882648923663542068L;



	public ResourceNotFoundException() {
        super();
    }

 

    public ResourceNotFoundException(final String message) {
        super(message);
    }

}
