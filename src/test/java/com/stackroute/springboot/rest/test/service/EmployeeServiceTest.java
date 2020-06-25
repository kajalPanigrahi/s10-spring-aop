package com.stackroute.springboot.rest.test.service;

import java.util.Date;
import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.springboot.rest.entity.Employee;
import com.stackroute.springboot.rest.exception.EmployeeAlreadyExistsException;
import com.stackroute.springboot.rest.repository.EmployeeRepository;
import com.stackroute.springboot.rest.service.EmployeeServiceImpl;


@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
	
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	private Employee employee;
	private Optional<Employee> optional;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		   employee = new Employee();
		   employee.setId(1);
		   employee.setName("emp1testname");
		   employee.setEmail("emp1test@gmail.com");
		   employee.setContactNo("1111");
		   employee.setAge(32);
		   employee.setJoinDate(new Date());
		   employee.setRegular(true);
		   employee.setSalary(345345.345);
		   
		   optional = Optional.of(employee);
		
	}
	
	@After
	public void tearDown() {
		employee = null;
		optional = null;
	}
	
	@Test
	public void testSaveEmployeeSuccess() throws EmployeeAlreadyExistsException {
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
	     Employee createdEmployee = employeeService.saveEmployee(employee);
	     Assert.assertEquals(employee.getName(), createdEmployee.getName());
		
		
	}

}
