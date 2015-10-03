package com.digi.hibernate;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.util.HibernateUtil;

public class OneTwoMany {
	
	public static void main(String args[]){
		
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

//SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		insertintoDB(sessionfactory);
	}
	
	public static void insertintoDB(SessionFactory sessionfactory){
		
		
		
		Session session = sessionfactory.openSession();
		org.hibernate.Transaction tx= session.beginTransaction();
		Customer cust=new Customer();
		Customer cust1=new Customer();
		cust1.setCustName("Heidy");
		cust1.setOrderName("Bathroom");;
		cust.setCustName("Dev");
		cust.setOrderName("Garden");
		CustomerOrder custord=new CustomerOrder();
		CustomerOrder custord1=new CustomerOrder();
		custord.setOrderAmount(new BigDecimal(100));
		custord.setOrderDescription("Plantes and flowers");
		custord.setOrderDetailName("Plantes and Flowers");
		custord1.setOrderAmount(new BigDecimal(100));
		custord1.setOrderDescription("Bathroom Products");
		custord1.setOrderDetailName("Bathroom");
		
		custord.setCustomer(cust);
		System.out.println(cust);
		System.out.println(custord);
		session.delete(cust);
		session.delete(custord);
		tx.commit();
		
	}

}
