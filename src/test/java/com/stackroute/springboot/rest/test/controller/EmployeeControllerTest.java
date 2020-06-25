package com.stackroute.springboot.rest.test.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.springboot.rest.controller.EmployeeController;
import com.stackroute.springboot.rest.entity.Employee;
import com.stackroute.springboot.rest.exception.EmployeeAlreadyExistsException;
import com.stackroute.springboot.rest.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	
	// Request
   @Autowired
   private	MockMvc mockMvc;
   
   @MockBean
   private EmployeeServiceImpl employeeService;
   
   private Employee employee;
   
   @Before
   public void setup() {
	   
	   employee = new Employee();
	   employee.setId(1);
	   employee.setName("emp1testname");
	   employee.setEmail("emp1test@gmail.com");
	   employee.setContactNo("1111");
	   employee.setAge(32);
	   employee.setJoinDate(new Date());
	   employee.setRegular(true);
	   employee.setSalary(345345.345);
	   
   }
   
   @After
   public void tearDown() {
	   employee = null;
   }
   
   @Test
   public void testSaveEmployeeSuccess() throws Exception {
	   /*
	    *  /api/v1/employee/employees
	    */
	   /*
	    * {id:1,name:}
	    */
	   
	   Mockito.when(employeeService.saveEmployee(employee)).thenReturn(employee);	   
	   
	                          
	   mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/employee/employees").
               contentType(MediaType.APPLICATION_JSON).
               content(asJSON(employee))).andExpect(status().isCreated());
   }
   
   
   @Test
   public void testSaveEmployeeFailure() throws Exception {
	   Mockito.when(employeeService.saveEmployee(Mockito.any())).thenThrow(EmployeeAlreadyExistsException.class);
	   
	   mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/employee/employees").
               contentType(MediaType.APPLICATION_JSON).
               content(asJSON(employee))).andExpect(status().isConflict());
	   
	   
		 
   }
   
   public static String asJSON(Object obj) {
	   try {
		String empObjString = new ObjectMapper().writeValueAsString(obj);
		return empObjString;
	} catch (Exception e) {
		throw new RuntimeException();
	}
   }
   
   
  
	

}
