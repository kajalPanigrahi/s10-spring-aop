package com.stackroute.springboot.rest.test.repository;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.springboot.rest.entity.Employee;
import com.stackroute.springboot.rest.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmployeeRepositoryTest {

	// JpaRepository
	// application.properties

	@Autowired
	private EmployeeRepository employeeRepository;

	private Employee employee;

	@Before
	public void setup() {
		employee = new Employee();
		employee.setId(1);
		employee.setName("Emptest");
		employee.setEmail("emp1test@gmail.com");
		employee.setContactNo("1111111111");
		employee.setAge(32);
		employee.setJoinDate(new Date());
		employee.setRegular(true);
		employee.setSalary(345345.345);
	}
	
	@After
	public void tearDown() {
		employee = null;
		employeeRepository.deleteAll();
	}
	
	@Test
	public void testSaveEmployeeSuccess() {
		employeeRepository.save(employee);		
	   Employee createdEmployee = employeeRepository.findById(1).get();
	   Assert.assertEquals(employee.getName(), createdEmployee.getName());
	   
	   employeeRepository.delete(employee);
	}

}
