package com.OneToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.OneToMany.DataTransfer.ForeignKey.Account;
import com.OneToMany.DataTransfer.ForeignKey.Employee;

public class FK_Associates {
	
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		Account account1 = new Account();
		account1.setAccountNumber("Account detail 1");
		
		Account account2 = new Account();
		account2.setAccountNumber("Account detail 2");
		
		Account account3 = new Account();
		account3.setAccountNumber("Account detail 3");
		
		//Add new Employee object
		Employee firstEmployee = new Employee();
		firstEmployee.setEmail("demo-user-first@mail.com");
		firstEmployee.setFirstName("demo-one");
		firstEmployee.setLastName("user-one");
		
		Employee secondEmployee = new Employee();
		secondEmployee.setEmail("demo-user-second@mail.com");
		secondEmployee.setFirstName("demo-two");
		secondEmployee.setLastName("user-two");
		
		Set<Account> accountsOfFirstEmployee = new HashSet<Account>();
		accountsOfFirstEmployee.add(account1);
		accountsOfFirstEmployee.add(account2);
		
		Set<Account> accountsOfSecondEmployee = new HashSet<Account>();
		accountsOfSecondEmployee.add(account3);
		
		firstEmployee.setAccounts(accountsOfFirstEmployee);
		secondEmployee.setAccounts(accountsOfSecondEmployee);
		//Save Employee
		session.save(firstEmployee);
		session.save(secondEmployee);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
