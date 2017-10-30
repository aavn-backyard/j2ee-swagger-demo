package com.smurfs.j2ee.rest.configuration;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

public class ErrorMessage implements Serializable{
	private static final long serialVersionUID = 5612636220329772000L;
	private String createdTime;
	private String code;
	private String message;
	private String detail;
	private static final String FORMAT_TIME = "dd.MM.yyyy HH:mm:ss";

	public ErrorMessage() {
	}

	public ErrorMessage(String code, String message) {
		this.code = code;
		this.message = message;
		this.createdTime = (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).format(new Date(System.currentTimeMillis()));
	}

	public ErrorMessage(String code, String message, String detail) {
		this.code = code;
		this.message = message;
		this.detail = detail;
		this.createdTime = (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).format(new Date(System.currentTimeMillis()));
	}

	public ErrorMessage(String detail) {
		this.detail = detail;
		this.createdTime = (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).format(new Date(System.currentTimeMillis()));
	}

	public static ErrorMessage fromCode(ErrorCode code) {
		return new ErrorMessage(code.getCode() + "", code.getMessage());
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String toJson() {
		return (new Gson()).toJson(this);
	}
}
