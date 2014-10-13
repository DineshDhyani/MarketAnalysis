package com.exception;

public class CsvFileException extends Exception {
	private static final long serialVersionUID = 1L;

	public CsvFileException() {
		super();
	}
	
	public CsvFileException(String message) {
		super(message);
	}

	public CsvFileException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public CsvFileException(Throwable cause) {
		super(cause);
	}

}
