package com.stackroute.springboot.rest.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "emp_details")
public class Employee {
	
	/*
	 * @NotNull -> validates the annotated property value must not be null
	 * @AssertTrue
	 * @AssertFalse
	 * @Min
	 * @Max
	 * @Size Strings, Collection, Map, Arrays
	 * @Email
	 * @Pattern
	 * 
	 * @NotEmpty (not null or empty)
	 * 	         string, collection ,map and array
	 * 
	 * @NotBlank
	 * 		      string--> null or whitespace
	 * 
	 * @Positive or @PositiveOrZero
	 * @Negative or @NegativeOrZero
	 * @Past or @PastOrPresent
	 * @Future or @FutureOrPresent
	 * @CreatedAt
	 * @ModifiedAt
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="emp_id")
	private int id;
	@Column(name ="emp_name")
	@NotBlank(message = "Name must not be empty")
	@Size(min = 5, max = 20 , message = "Name must be in between 5 to 20 characters")
	@Pattern(regexp =  "^[a-zA-Z]+$" , message = "name must contain only alphabets")
	private String name;
	
	@Column(name ="emp_email")
	@NotEmpty(message = "Email must not be empty")
	@Email(message = "invalid email")
	private String email;
	
	@Column(name ="emp_contactno")
	@NotBlank(message = "contact no must not be empty")
	@Size(min = 10, max = 10 , message =" contact no must be 10 characters")
	private String contactNo;
	
	@Column(name ="emp_age")
	private int age;
	
	@Column(name = "emp_join_date")
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	@Column(name = "emp_salary")
	@Positive(message = "Salary must be positive")
	private double salary;
	@Column(name = "emp_regular")
	@NotNull(message = "regular must be either true or false")
	@Type(type =  "org.hibernate.type.BooleanType")
	private Boolean regular;
	
	
	/*
	 * @OneToOne
	 * 
	 */
	/*
	 * @OneToOne (cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "address_id") private Address address;
	 
	 *public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	 */
	
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name ="emp_addresses", joinColumns = {
	 * 
	 * @JoinColumn(name ="emp_id", referencedColumnName = "emp_id") },
	 * inverseJoinColumns = {
	 * 
	 * @JoinColumn(name ="address_id", referencedColumnName = "address_id") })
	 */
	
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name ="emp_addresses", joinColumns = {
	 * 
	 * @JoinColumn(name ="emp_id", referencedColumnName = "emp_id") },
	 * inverseJoinColumns = {
	 * 
	 * @JoinColumn(name ="address_id", referencedColumnName = "address_id") })
	 * 
	 * private List<Address> addressList;
	 * 
	 * 
	 * 
	 * public List<Address> getAddressList() { return addressList; } public void
	 * setAddressList(List<Address> addressList) { this.addressList = addressList; }
	 */
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Boolean isRegular() {
		return regular;
	}
	public void setRegular(Boolean isRegular) {
		this.regular = isRegular;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo + "]";
	}
	
	

}
