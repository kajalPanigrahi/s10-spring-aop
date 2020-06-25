package com.stackroute.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springboot.rest.entity.Address;
import com.stackroute.springboot.rest.exception.AddressAlreadyExistsException;
import com.stackroute.springboot.rest.exception.AddressNotFoundException;
import com.stackroute.springboot.rest.repository.AddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address saveAddress(Address address) throws AddressAlreadyExistsException {
		Address createdAddress = null;
		Optional<Address> optional = addressRepository.findById(address.getId());
		
		
		if(optional.isPresent()) {
			throw new AddressAlreadyExistsException();
		}
		else {
			createdAddress = addressRepository.save(address);
		}
		
		return createdAddress;
	}

	@Override
	public Address getAddressById(int id) throws AddressNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updatedAddress(Address employee) throws AddressNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAdderss(int id) throws AddressNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
