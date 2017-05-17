package com.parakh.parakh.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.parakh.parakh.dao.DAO;
import com.parakh.parakh.exception.UserException;
import com.parakh.parakh.pojo.Customer;
import com.parakh.parakh.pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			commit();
			close();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	// check username only user

	public User checkUserUnique(String username) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();
			commit();
			close();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	// check username unique for customer

	public Customer checkCustomerUnique(String username) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Customer where username = :username");
			q.setString("username", username);
			Customer customer = (Customer) q.uniqueResult();
			commit();
			close();
			return customer;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	
	
	
	//get customer username and password
	public Customer getCustomer(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Customer where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			Customer customer = (Customer) q.uniqueResult();
			commit();
			close();
			return customer;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get customer " + username, e);
		}
	}
	
	public User get(int userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where personId= :personId");
			q.setInteger("personId", userId);		
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}

	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			User user = new User(u.getUserName(), u.getPassword());

			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setEmail(u.getEmail());
			user.setPhoneNumber(u.getPhoneNumber());
			user.setStatus("user");
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	//register customer
	public Customer registerCustomer(Customer c)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			Customer customer = new Customer(c.getUserName(), c.getPassword());

			customer.setFirstName(c.getFirstName());
			customer.setLastName(c.getLastName());
			customer.setEmail(c.getEmail());
			customer.setPhoneNumber(c.getPhoneNumber());
			customer.setStatus("customer");
			getSession().save(customer);
			commit();
			return customer;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUserName(), e);
		}
	}
	
	public Customer getCustomer(String personId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Customer where personId= :personId");
			q.setString("personId", personId);		
			Customer customer = (Customer) q.uniqueResult();
			commit();
			return customer;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + personId, e);
		}
	}
}
