package com.kakaopay.api.common;

import java.io.Serializable;

public class Response implements Serializable {
	private String code;
	private String message;
	private Object data;

	public Response() {}
	public Response(Object data) {
		this.code = KPConstants.OK;
		this.message = KPConstants.SUCCEES;
		this.data = data;
	}
	public Response(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	
	
	
}
