package com.song.test;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.song.hbm.MySessionFactoty;
import com.song.hbm.model.Customer;
import com.song.hbm.model.Order;

public class Many2One {

	@Test
	public void insert(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer c=new Customer();
		c.setName("ÕÅÈý·á2");
		
		
		Order o=new Order();
		o.setOrderNum("20002");
		
//		o.setCustomer(c);
		c.getOrders().add(o);
		
//		session.save(o);
		session.save(c);
		tx.commit();
		session.close();
	}
	@Test
	public void getCustomer(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
		Customer c = (Customer) session.get(Customer.class, 1);
		System.out.println(c.getOrders().size());
		Iterator<Order> iterator = c.getOrders().iterator();
		while(iterator.hasNext()){
			Order o = iterator.next();
			System.out.println(o.getOrderNum());
		}
		tx.commit();
		session.close();
	}
	@Test
	public void updateOrder(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = (Customer) session.load(Customer.class, 1);
		Order o = (Order) session.load(Order.class, 2);
		
//		o.setCustomer(c);
		tx.commit();
		session.close();
	}
	
	
	
}
