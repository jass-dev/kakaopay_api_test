package com.kakaopay.api.exceptions;

public class GeneralException extends Exception {
	
	private static final long serialVersionUID = -3192459715895284111L;
	private String message;
	private String errCode;
	
	public GeneralException() {
		super();
	}
	
	public GeneralException(String message) {
		super(message);
		this.message = message;
	}
	
	public GeneralException(String errCode, String message) {
		super(message);
		this.errCode = errCode;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	


}
