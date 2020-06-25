package com.stackroute.springboot.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Address already exists with this id")
public class AddressAlreadyExistsException extends Exception {

}
