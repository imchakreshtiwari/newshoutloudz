package com.one.Shout.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItamWsException extends RuntimeException {

	private static final long serialVersionUID = -8887641618465003112L;

	protected Throwable rootCause;
	protected String code;
	protected String message;
	
	public ItamWsException(String message) {
		super();
		this.message = message;
	}

	public ItamWsException(Throwable rootCause) {
		super(rootCause);
		this.rootCause = rootCause;
	}

	public ItamWsException(String code, String message) {
		super(message);
		this.code=code;
		this.message=message;
	}
	
	public ItamWsException(String message, Throwable rootCause) {
		super(message, rootCause);
		this.message=message;
		this.rootCause = rootCause;
	}
	
	public ItamWsException(String code, String message, Throwable rootCause) {
		super(message, rootCause);
		this.code=code;
		this.message=message;
		this.rootCause = rootCause;
	}

	
	
}
