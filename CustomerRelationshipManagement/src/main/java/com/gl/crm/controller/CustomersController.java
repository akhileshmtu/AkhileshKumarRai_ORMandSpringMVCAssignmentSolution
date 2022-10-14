package com.gl.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.crm.model.Customer;
import com.gl.crm.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	// /customers/list
	// @RequestMapping("/customers/list")
	// Option 2 - for declaring request mapping

	public String handleListCustomers(Model theModel) {

		List<Customer> customers = customerService.listAll();

//		  System.out.println("List of Customers");
//		  
//		  for(int i=0;i<customers.size();i++) { Customer c = customers.get(i);
//		  System.out.println(c.getId()); }
//		 

		theModel.addAttribute("customers", customers);

		return "customers-lister";
	}
}
