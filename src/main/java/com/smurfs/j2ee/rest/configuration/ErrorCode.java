package com.smurfs.j2ee.rest.configuration;

public enum ErrorCode {
	INVALID_DATA(403, "Invalid data"), MALFORMED_JSON_INPUT(402,
			"Malformed JSON input provided"), NO_CONTENT_PROVIDED(401, "No content provided");

	private final int code;
	private final String message;

	private ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}
