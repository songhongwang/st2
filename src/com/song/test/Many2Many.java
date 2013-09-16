package com.song.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.song.hbm.MySessionFactoty;
import com.song.hbm.model.Course;
import com.song.hbm.model.Student;

public class Many2Many {
	
	@Test
	public void addStudent(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
		Student s=new Student();
		s.setName("–°ÀŒ");
		
		Course c=new Course();
		c.setName("”ÔŒƒ");
		Course c2=new Course();
		c2.setName("”¢”Ô");
		
		s.getCourses().add(c);
		s.getCourses().add(c2);

		c.getStus().add(s);
		c2.getStus().add(s);
		
		
		
		session.save(s);
		
		tx.commit();
		session.close();
	}
	@Test
	public void delStudent(){
		Session session = MySessionFactoty.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Student");
		List<Student> student_list = query.list();
		for(Student s:student_list){
			session.delete(s);
			s=null;
		}
		Query createSQLQuery = session.createQuery("from Course");
		List<Course> list = createSQLQuery.list();
		for(Course c:list){
			session.delete(c);
			c=null;
		}
		tx.commit();
		session.close();
	}
}
