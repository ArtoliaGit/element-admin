package com.artolia.admin.common;

import com.google.gson.Gson;

public class Result {

	private String message;
	private Integer code;
	private Object data;
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
