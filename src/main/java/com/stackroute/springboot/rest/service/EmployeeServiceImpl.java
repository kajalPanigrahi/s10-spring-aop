package com.stackroute.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springboot.rest.entity.Employee;
import com.stackroute.springboot.rest.exception.EmployeeAlreadyExistsException;
import com.stackroute.springboot.rest.exception.EmployeeNotFoundException;
import com.stackroute.springboot.rest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeAlreadyExistsException {
		//if Employee already exists with this id
		Employee createdEmployee = null;
		Optional<Employee> optional = employeeRepository.findById(employee.getId());
		
		
		if(optional.isPresent()) {
			throw new EmployeeAlreadyExistsException();
		}
		else {
			createdEmployee = employeeRepository.save(employee);
		}
		
		return createdEmployee;
	}

	@Override
	public Employee getEmployeeByid(int id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmployee(int id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
