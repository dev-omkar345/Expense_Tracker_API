package com.example.Track_Api.exceptions;

public class ApiReqException extends RuntimeException {
	
	public ApiReqException(String msg)
	{
		super(msg);
	}

	public ApiReqException(String msg, Throwable cause) 
	{
		super(msg, cause);
	}
}
