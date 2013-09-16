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
//	hibernate ״̬
//	1���־�״̬ session.get()/session.load()---------------------------session.save()��ȡ�־ö���
//	2����ʱ״̬ Customer c=new Customer()   ---------------------------������ʱ����
//	3:����״̬ o.setCustomer(null) ��ʱ��c���û�б�Ķ���������ã���ôc��Ϊ����״̬  ----session.setCustomer(null) �ӳ־ö���ת��Ϊ�������
//	4��ɾ��״̬ session.delete(c)           ---------------------------session.delete(c) ���������ת��Ϊɾ������
	@Test
	public void addCustomer(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
//		session.setFlushMode(FlushMode.NEVER);
//		for(int i=0;i<100000;i++){
//			Customer c=new Customer();
//			c.setName(i+"���޼�");
//			c.setAge(18+i);
//			c.setDes("����Ӣ��"+i);
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
//		c.setName("��xx");
//		c.setDes("������");
//		Address homeAddress=new Address();
//		homeAddress.setCity("����");
//		
//		c.setHomeAddress(homeAddress);
//		session.save(c);
		
		Customer c=new Customer();
		c.setName("�Ŵ�ɽ");
		
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
		System.out.println("����Ŀ��"+list.size());
		for(Customer c:list){
			System.out.println(c.getTotal());
			if(c.getHomeAddress()!=null){
				String city = c.getHomeAddress().getCity();
				System.out.println("===="+city);
			}
		}
		tx.commit();
		 
		boolean wasCommitted = tx.wasCommitted();
		System.out.println("�����Ƿ��ύ��="+wasCommitted);
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
	