package com.song.test;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.song.hbm.MySessionFactoty;
import com.song.hbm.model.Customer;
import com.song.hbm.model.Order;

public class StrategyTest {

	@Test
	public void initData(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
		Customer c=new Customer();
		c.setName("hello kitty1");
		c.setAge(20+new Random().nextInt(10));
//		session.save(c);
		for(int i=0;i<10;i++){
			Order o=new Order();
			o.setOrderNum("1000"+i);
			o.setPrice(100+i);
			c.getOrders().add(o);
			o.setCustomer(c);
			session.save(o);
		}
		tx.commit();
		session.close();
	}
	@Test
	public void getLazyCustomer(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
		Customer c = (Customer) session.get(Customer.class, 1);
		if(!Hibernate.isInitialized(c)){
			System.out.println("Î´³õÊ¼»¯");
			System.out.println(c.getClass());
			Hibernate.initialize(c);
			System.out.println(c.getClass());
		} 
		session.flush();
		session.clear();
		System.out.println(c.getClass());
		
		c.setAge(123);
		
		tx.commit();
		session.close();
	
	}
	@Test
	public void getJoinCustomer(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
//		Criteria criteria = session.createCriteria(Customer.class);
		
//		Customer c = (Customer) session.get(Customer.class, 1);
//		c.setAge(123);
//		Order o=new Order();
//		o.setOrderNum("YYYY2");
//		o.setCustomer(c);
//		
//		c.getOrders().add(o);
		
		Order o=new Order();
		o.setOrderNum("aaa");
		
		session.save(o);
		
		tx.commit();
		session.close();
	}
	@Test
	public void getCriteriaCustomer(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
//		Criteria criteria = session.createCriteria(Order.class);
//		criteria.add(Restrictions.gt("price", Double.parseDouble("100")));
//		criteria.addOrder(org.hibernate.criterion.Order.asc("id"));
//		List<Order> list = criteria.list();
//		for(Order o:list){
//			System.out.println(o.getOrderNum());
//		}
		
		Query query = session.createQuery("from Customer where id=:id");
		query.setString("id", "1");
		List<Customer> list = query.list();
		for(Customer c:list){
			System.out.println(c.getName());
		}
		
		tx.commit();
		session.close();
	}
}
