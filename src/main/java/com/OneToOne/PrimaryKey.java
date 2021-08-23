package com.OneToOne;

import org.hibernate.Session;

import com.OneToOne.DataTransfer.PrimaryKey.Account;
import com.OneToOne.DataTransfer.PrimaryKey.Employee;

public class PrimaryKey {
	
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
		
		emp.setAccount(account);
		account.setEmployee(emp);
		
		session.save(emp);
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
