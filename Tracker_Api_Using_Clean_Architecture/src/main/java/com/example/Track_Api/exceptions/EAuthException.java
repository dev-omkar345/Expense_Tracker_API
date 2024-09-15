package com.example.Track_Api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EAuthException extends Exception {

	public EAuthException(String message)
	{
		super(message);
	}
}
