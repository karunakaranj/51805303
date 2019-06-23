package com.hcl.oxbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.oxbank.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

//	@Query("select count(*) from ox_customer cust where cust.name = :name", native=true)
	@Query(value = "SELECT count(*) FROM ox_customer cust WHERE cust.name = 1", nativeQuery = true)
	public int findByName(String name);
}
