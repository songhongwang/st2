package com.song.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactoty {
	private static SessionFactory sessionFactory;
	static{
		Configuration config=new Configuration();
		config.configure("com/song/hbm/hibernate.cfg.xml"); 
		sessionFactory = config.buildSessionFactory();
	}
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
