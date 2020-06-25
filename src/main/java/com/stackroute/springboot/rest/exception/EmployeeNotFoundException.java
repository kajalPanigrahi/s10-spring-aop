package com.stackroute.springboot.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Emplyoee doesnot exists with this ID")
public class EmployeeNotFoundException extends Exception {

}
