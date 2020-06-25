package com.stackroute.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.springboot.rest.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
