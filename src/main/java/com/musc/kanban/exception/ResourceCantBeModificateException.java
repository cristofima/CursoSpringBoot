package com.musc.kanban.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_REQUIRED)
public class ResourceCantBeModificateException extends RuntimeException {

	public ResourceCantBeModificateException(String message) {
		super(message);
	}
}
