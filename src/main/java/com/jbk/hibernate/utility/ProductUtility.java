package com.jbk.hibernate.utility;

import java.util.Scanner;

import com.jbk.hibernate.entity.Product;

public class ProductUtility {

	public static Product prepareProduct(Scanner scanner)
	{
		
		System.out.println("Enter product ID");
		long productId=scanner.nextLong();
		
		System.out.println("Enter product name");
		String productName=scanner.next();
		
		System.out.println("Enter supplier ID");
		long SupplierId=scanner.nextLong();
		
		System.out.println("Enter category ID");
		long CategoryId=scanner.nextLong();
		
		System.out.println("Enter product Quantity");
		int productQuantity=scanner.nextInt();
		
		System.out.println("Enter product price");
		double productprice=scanner.nextDouble();
		
		Product product =new Product(productId, productName, SupplierId, CategoryId, productQuantity, productprice);
		return product;
		
		
	
		
	
		
	}
}
