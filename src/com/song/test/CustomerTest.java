package com.song.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.song.hbm.MySessionFactoty;
import com.song.hbm.model.Customer;
import com.song.hbm.model.Order;

public class CustomerTest {
//	hibernate 状态
//	1：持久状态 session.get()/session.load()---------------------------session.save()获取持久对象
//	2：临时状态 Customer c=new Customer()   ---------------------------创建临时对象
//	3:游离状态 o.setCustomer(null) 此时的c如果没有别的对象对其引用，那么c就为游离状态  ----session.setCustomer(null) 从持久对象转换为游离对象
//	4：删除状态 session.delete(c)           ---------------------------session.delete(c) 从游离对象转化为删除对象
	@Test
	public void addCustomer(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
//		session.setFlushMode(FlushMode.NEVER);
//		for(int i=0;i<100000;i++){
//			Customer c=new Customer();
//			c.setName(i+"张无忌");
//			c.setAge(18+i);
//			c.setDes("少年英雄"+i);
//			session.save(c);
//			System.out.println("================="+i);
//			if(i%1000==0){
//				session.flush();
//				session.clear();
//			}
//		}
//		session.flush();
//		-----------------------------
//		Customer c=new Customer();
//		c.setName("张xx");
//		c.setDes("哈哈哈");
//		Address homeAddress=new Address();
//		homeAddress.setCity("北京");
//		
//		c.setHomeAddress(homeAddress);
//		session.save(c);
		
		Customer c=new Customer();
		c.setName("张翠山");
		
		Order o=new Order();
		o.setOrderNum("0001");
		
		c.getOrders().add(o);
		
		session.save(c);
		tx.commit();
		session.close();
//		tx.rollback();
		 
	}
	@Test
	public void updateCustomer(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
		Customer c = (Customer) session.load(Customer.class,2);
		c.setName("abcccc");
		System.out.println(c.getHomeAddress().getCity());
		
		session.update(c);
		tx.commit();
		session.close();
	}
	@Test
	public void getCustomer(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery(" from Customer ");
		List<Customer> list = query.list();
		System.out.println("总条目："+list.size());
		for(Customer c:list){
			System.out.println(c.getTotal());
			if(c.getHomeAddress()!=null){
				String city = c.getHomeAddress().getCity();
				System.out.println("===="+city);
			}
		}
		tx.commit();
		 
		boolean wasCommitted = tx.wasCommitted();
		System.out.println("事物是否提交？="+wasCommitted);
		session.close();
	}

//	@Test
//	public void delCustomer(){
//		Session session = MySessionFactoty.getSession();
//		Transaction tx = session.beginTransaction();
//		Customer c=new Customer();
//		c.setId(1);
//		session.delete(c);
//		tx.commit();
//		session.close();
//	}
}
	