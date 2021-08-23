package com.OneToOne;

import org.hibernate.Session;

import com.OneToOne.DataTransfer.ForeignKey.Account;
import com.OneToOne.DataTransfer.ForeignKey.Employee;

public class ForeignKey {
	
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		Account account = new Account();
		account.setAccountNumber("123-345-65454");
		
		//Add new Employee object
		Employee emp = new Employee();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");
		
		//Save Account
		session.saveOrUpdate(account);
		//Save Employee
		emp.setAccount(account);
		session.saveOrUpdate(emp);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
