package com.stackroute.springboot.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.springboot.rest.entity.Employee;
import com.stackroute.springboot.rest.exception.EmployeeAlreadyExistsException;
import com.stackroute.springboot.rest.service.IEmployeeService;

@RestController
@RequestMapping("api/v1/employee")
//http://localhost:8083/api/v1/employee/employees
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	private ResponseEntity responseEntity;	
	
	/*
	 * {
	 * "id":1,
	 * "name":
	 * }
	 * */
	@PostMapping("/employees")
	public ResponseEntity<?> saveEmployee( @RequestBody Employee employee) throws EmployeeAlreadyExistsException{
		
		
		try {
			Employee createdEmployee = employeeService.saveEmployee(employee);			
			responseEntity = new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
		} catch (EmployeeAlreadyExistsException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Some internal Error Occured..", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return responseEntity;
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees(){
		return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
	}
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad Input")
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String,String> errorsMap = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errorsMap.put(fieldName, errorMessage);
		});
		
		return errorsMap;
	}

}
