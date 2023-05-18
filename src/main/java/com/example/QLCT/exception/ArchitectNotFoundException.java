package com.example.QLCT.exception;

public class ArchitectNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArchitectNotFoundException(Integer id) {
		super("Could not found the architect with id " + id);
	}
}
