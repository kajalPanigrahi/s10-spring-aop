package com.stackroute.springboot.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.springboot.rest.entity.Address;
import com.stackroute.springboot.rest.entity.Employee;
import com.stackroute.springboot.rest.exception.AddressAlreadyExistsException;
import com.stackroute.springboot.rest.exception.EmployeeAlreadyExistsException;
import com.stackroute.springboot.rest.service.IAddressService;

@RestController
@RequestMapping("api/v1/address")
public class AddressController {
	
	@Autowired
	private IAddressService addressService;
	
	private ResponseEntity responseEntity;
	
	@PostMapping("/addresses")
	public ResponseEntity<?> saveAddress(@Valid @RequestBody Address address) throws AddressAlreadyExistsException{
		try {
			Address createdAddress = addressService.saveAddress(address);			
			
			responseEntity = new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
		} catch (AddressAlreadyExistsException e) {
			throw e;
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>("Some internal Error Occured..", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return responseEntity;
	}

}
