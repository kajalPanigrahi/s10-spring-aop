package com.stackroute.springboot.rest.service;

import java.util.List;

import com.stackroute.springboot.rest.entity.Employee;
import com.stackroute.springboot.rest.exception.EmployeeAlreadyExistsException;
import com.stackroute.springboot.rest.exception.EmployeeNotFoundException;

public interface IEmployeeService {
	
	public Employee saveEmployee(Employee employee) throws EmployeeAlreadyExistsException;
	public Employee getEmployeeByid(int id) throws EmployeeNotFoundException;
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
	public boolean deleteEmployee(int id) throws EmployeeNotFoundException;

}
