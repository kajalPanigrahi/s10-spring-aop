package com.stackroute.springboot.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Emplyoee already exists with this ID")
public class EmployeeAlreadyExistsException extends Exception {

}
