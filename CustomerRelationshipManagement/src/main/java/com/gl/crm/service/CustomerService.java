package com.gl.crm.service;

import java.util.List;

import com.gl.crm.model.Customer;

public interface CustomerService {

	List<Customer> listAll();

	Customer findById(int theid);

	void save(Customer thecustomer);

	void deleteById(int theId);
}
