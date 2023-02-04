package com.jbk.hibernate.service;

import java.util.List;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;

public class ProductService {
	ProductDao productDao=new ProductDao();
	
	public boolean saveProduct(Product product) {
		
		return productDao.saveProduct(product);
		
		}
	
	public Product getProductById(long productId)
	{
		return productDao.getProductById(productId);
		
	}
	public boolean deleteProductById(long productId) {
		
		return productDao.deleteProductById(productId);
	}
	
	public boolean updateProduct(Product product)
	{
	return productDao.updateProduct(product);	
		
	}
	public List<Product> getAllProducts(){
		
		return productDao.getAllProducts();
	}
	
	public List<Product> getAllProductsByNameDesc(){
		
		return productDao.getAllProductsByNameDesc();
	}
	
	public List<Product> getAllProductsByNameAsc(){
		
		return productDao.getAllProductsByNameAsc();
	}
	
	public List<Product> getNProducts(int n){
		
		return productDao.getNProducts(n);
	}
	
public List<Product> getPaiging(int number1,int number2){
		
		return productDao.getPaiging(number1, number2);
	}

public void RestrictionsExamples()
{
	productDao.RestrictionsExamples();
	}

}
