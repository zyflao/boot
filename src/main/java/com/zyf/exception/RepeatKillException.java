package com.zyf.exception;

public class RepeatKillException extends RuntimeException {

	public RepeatKillException(String message) {
		super(message);
	}

	public RepeatKillException(String msg, Throwable cause) {

		super(msg, cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
