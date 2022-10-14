package com.gl.crm.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.crm.model.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> listAll() {

		Transaction transaction = session.beginTransaction();

		List<Customer> customers = session.createQuery("from customer_entity").list();

		transaction.commit();
		return customers;

	}

	@Transactional
	public void save(Customer customer) {

		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(customer);

		transaction.commit();

	}

	@Transactional
	public Customer findById(int id) {

		Customer customer = new Customer();

		Transaction transaction = session.beginTransaction();
		customer = session.get(Customer.class, id);
		transaction.commit();

		return customer;
	}

	@Transactional
	public void deleteById(int id) {

		Transaction transaction = session.beginTransaction();

		Customer customer = session.get(Customer.class, id);

		session.delete(customer);

		transaction.commit();

	}
}
