package com.musc.kanban.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceConflictException extends RuntimeException {

	public ResourceConflictException(String field, Object fieldValue) {
		super(String.format("%s '%s' already in use", field, fieldValue));
	}
}
