package com.stackroute.springboot.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Address doesnot exists with this id")

public class AddressNotFoundException extends Exception {

}
