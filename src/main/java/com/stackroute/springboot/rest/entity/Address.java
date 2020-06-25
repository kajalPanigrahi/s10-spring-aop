package com.stackroute.springboot.rest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "emp_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	@Column(name = "address_houseno")
	private String houseNo;
	@Column(name = "address_street")
	private String street;
	@Column(name = "address_city")
	private String city;
	@Column(name = "address_state")
	private String state;
	@Column(name = "address_zipcode")
	private int zipcode;
	
	/*
	 * @OneToOne(mappedBy = "address")
	 * 
	 * @JsonIgnore private Employee employee;
	 */
	
	
	/*
	 * @ManyToMany(mappedBy = "addressList")
	 * 
	 * @JsonIgnore private List<Employee> employeesList;
	 * 
	 * 
	 * 
	 * 
	 * public List<Employee> getEmployeesList() { return employeesList; } public
	 * void setEmployeesList(List<Employee> employeesList) { this.employeesList =
	 * employeesList; }
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	/*
	 * public Employee getEmployee() { return employee; } public void
	 * setEmployee(Employee employee) { this.employee = employee; }
	 */
	
	
	
	
	
	

}
