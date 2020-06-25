package com.stackroute.springboot.rest.service;

import java.util.List;

import com.stackroute.springboot.rest.entity.Address;
import com.stackroute.springboot.rest.exception.AddressAlreadyExistsException;
import com.stackroute.springboot.rest.exception.AddressNotFoundException;

public interface IAddressService {
	
	public Address saveAddress(Address employee) throws AddressAlreadyExistsException;

	public Address getAddressById(int id) throws AddressNotFoundException;
	public List<Address> getAllAddresses();
	public Address updatedAddress(Address employee) throws AddressNotFoundException;
	public boolean deleteAdderss(int id) throws AddressNotFoundException;


}
