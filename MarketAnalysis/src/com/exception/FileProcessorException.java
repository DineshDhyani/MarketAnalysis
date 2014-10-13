package com.exception;

public class FileProcessorException extends Exception {
	private static final long serialVersionUID = 1L;

	public FileProcessorException() {
		super();
	}
	
	public FileProcessorException(String message) {
		super(message);
	}

	public FileProcessorException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public FileProcessorException(Throwable cause) {
		super(cause);
	}

}
