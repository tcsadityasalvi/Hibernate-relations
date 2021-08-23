package com.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.ManyToMany.JoinTable.Reader;
import com.ManyToMany.JoinTable.Subscription;

public class joinTable {
	
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		//Add subscription
		Subscription subOne = new Subscription();
		subOne.setSubscriptionName("Entertainment");
		
		Subscription subTwo = new Subscription();
		subTwo.setSubscriptionName("Horror");
		
		Set<Subscription> subs = new HashSet<Subscription>();
		subs.add(subOne);
		subs.add(subTwo);
		
		//Add readers
		Reader readerOne = new Reader();
		readerOne.setEmail("demo-user1@mail.com");
		readerOne.setFirstName("demo");
		readerOne.setLastName("user");
		
		Reader readerTwo = new Reader();
		readerTwo.setEmail("demo-user2@mail.com");
		readerTwo.setFirstName("demo");
		readerTwo.setLastName("user");
		
		Set<Reader> readers = new HashSet<Reader>();
		readers.add(readerOne);
		readers.add(readerTwo);
		
		readerOne.setSubscriptions(subs);
		readerTwo.setSubscriptions(subs);

		session.save(readerOne);
		session.save(readerTwo);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
