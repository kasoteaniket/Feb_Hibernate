package com.jbk.hibernate.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jbk.hibernate.config.HibernateConfig;
import com.jbk.hibernate.entity.Product;

public class ProductDao {
	
	SessionFactory sessionFactory=HibernateConfig.getsessionFactory();
	public boolean saveProduct(Product product)
	
	{Session session=sessionFactory.openSession();
		try {
			
		Product dbProduct=getProductById(product.getProductId());
		Transaction transaction=session.beginTransaction();
		if(dbProduct==null)
		{
			
			session.save(product);
		
		
		    transaction.commit();
		    return true;
		}}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		session.close();
		
		}
		 return false;		
	}
	
	
	
	public Product getProductById(long productId)
	{
		Session session=sessionFactory.openSession();
		Product product=null;
		try{
	      product=session.get(Product.class, productId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		
		session.close();
		}
		
		return product;
		
	}
	public boolean deleteProductById(long productId) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Product dbproduct=null;
		boolean isDeleted=false;
		
		try{
			
			dbproduct=getProductById( productId);
			if(dbproduct!=null) {
				session.delete(dbproduct);
				transaction.commit();
			isDeleted= true;
		}}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
			
			session.close();
			
		}return isDeleted;	
		}
	
	public boolean updateProduct(Product product) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		boolean isUpdated=false;
		
		 try {
		Product dbProduct=getProductById(product.getProductId());
		if(dbProduct!=null)
		{
		session.update(product);	
		transaction.commit();
		isUpdated=true;
			
		}
		 }
		 catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		 finally {
			 session.close();
		 }
		return isUpdated;
			
	}
	public List<Product> getAllProducts()
	{
		Session session=sessionFactory.openSession();
		List<Product> list=null;
		
		try {
			Criteria criteria=session.createCriteria(Product.class);
			list=criteria.list();	
		}
		catch (Exception e) {
		e.printStackTrace();	// TODO: handle exception
		}
		finally {
			
			session.close();
			
		} return list;
	}
	
	public List<Product> getAllProductsByNameAsc(){
		Session session=sessionFactory.openSession();
		List<Product> list=null;
		try {
			Criteria criteria=session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productName"));
			list=criteria.list();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		finally {
			session.close();
		}
		return list;
			
	}
	public List<Product> getAllProductsByNameDesc(){
		Session session=sessionFactory.openSession();
		List<Product> list=null;
		try {
			Criteria criteria=session.createCriteria(Product.class);
			criteria.addOrder(Order.desc("productName"));
			list=criteria.list();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		finally {
			session.close();
		}
		return list;
		
		
		
	}
	public List<Product> getNProducts(int n)
	{Session session=sessionFactory.openSession();
	List<Product> list=null;
	try {
		Criteria criteria=session.createCriteria(Product.class);
		criteria.setMaxResults(n);
		list=criteria.list();
	}
	catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
	finally {
		session.close();
	}
	return list;
		
	}
	
	public List<Product> getPaiging(int number1,int number2){
		Session session=sessionFactory.openSession();
		List<Product> list=null;
		try {
			Criteria criteria=session.createCriteria(Product.class);
			criteria.setFirstResult(number1);
			criteria.setMaxResults(number2);
			list=criteria.list();
			
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		finally {
			session.close();
		}
		return list;
		
		
		
	}
	
	public void RestrictionsExamples() {
		
	Session session=sessionFactory.openSession();
	try {
		//equal...want product whose id=2
		Criteria criteria=session.createCriteria(Product.class);
		 criteria=criteria.add(Restrictions.eq("productQuantity", 2));
		List<Product> list= criteria.list();
		if(list!=null)
				System.out.println(list);
		else
			System.out.println("no product exist");
				
		//greatr 
	      list=criteria.add(Restrictions.gt("productPrice", 2.0)).list()	;
	      if(list!=null)
	      System.out.println(list);
	      else 
	    	  System.out.println("no product exist ");
	      
	      //and......Restrictions returns Criterion
	      list=criteria.add(Restrictions.and(Restrictions.eq("productQuantity", 2), Restrictions.gt("productPrice", 1000.0))).list();
	     
	      System.out.println(list);
	      
	      //like
	      list=criteria.add(Restrictions.like("productName", "%a%")).list();
	      if(list!=null)
	    	  System.out.println(list);
	      else 
	    	  System.out.println("product not exist");
	      
	      //in
	      list=criteria.add(Restrictions.in("productPrice", 1.0,2.0,3.0,4.0)).list();
	      if(list!=null)
	    	  System.out.println(list);
	      else
	    	  System.out.println("product not exist");
	      
	      
	      
		
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		
		session.close();
		
	}
		
		
	}
	
	
	}
	