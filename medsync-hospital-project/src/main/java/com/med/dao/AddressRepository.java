package com.med.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.med.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}