package com.jbk.hibernate;

import java.util.List;
import java.util.Scanner;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;
import com.jbk.hibernate.service.ProductService;
import com.jbk.hibernate.utility.ProductUtility;

public class ProductController {
	
	public static void main(String[] args) {
	
		
	char ch;
	 Scanner scanner=new Scanner(System.in);
	ProductService productService=new ProductService();
	 
	
	do {
		
	
		System.out.println("press 1 to save product");
		
		System.out.println("press 2 to get product by ID");
		
		System.out.println("press 3 to delete product by ID");
		
		System.out.println("press 4 to update product");
		
		System.out.println("press 5 to see all product");
		
		System.out.println("press 6 to see all product in ascending order of name");
		
		System.out.println("press 7 to see all product in descending order of name");
		
		System.out.println("press 8 to see n product");
		
		System.out.println("press 9 to see  Paiging");
		
		System.out.println("press 10 to see Restriction examples");
		
		
		
		
		
	
		int choice=scanner.nextInt();
		
		switch(choice)
		{
		case 1:
			{Product product=ProductUtility.prepareProduct(scanner);
			boolean isAdded=productService.saveProduct(product);
			if(isAdded)
				System.out.println("saved...");
			else
				System.out.println("product already exist with id="+product.getProductId());
			
		     break;}
			
		case 2:
		{
			System.out.println("enter product id");
			long productId=scanner.nextLong();
			Product product=productService.getProductById(productId);
			if(product!=null)
			System.out.println(product);
			else
				System.out.println("product not exist with productId="+productId);
			
			break;
		}
		
		case 3:
			System.out.println("enter product Id");
			long productId=scanner.nextLong();
			boolean isDeleted=productService.deleteProductById(productId);
			if(isDeleted)
				System.out.println("product removed");
			else 
				System.out.println("product not exist wit productId "+productId);
			break;
			
		case 4:{
			Product product=ProductUtility.prepareProduct(scanner);
			boolean isUpdated=productService.updateProduct(product);
			if(isUpdated)
				System.out.println("Updated...");
			else
				System.out.println("product not exist with productid ="+product.getProductId());
		
		break;
		
		}
		
		case 5:
		{
			List<Product> list=productService.getAllProducts();
			
			if(list!=null) {
			for(Product product:list)
			{
				System.out.println(product);
				
			}}
			else
				System.out.println("no products exist");
			
			
			break;
		}
		
		case 6:
		{
			List<Product> list=productService.getAllProductsByNameAsc();
			if(list!=null)
				System.out.println(list);
			else
				System.out.println("no record found");
			
			
		break;	
		}

		case 7:
		{
			List<Product> list=productService.getAllProductsByNameDesc();
			if(list!=null)
				System.out.println(list);
			else
				System.out.println("no record found");
			
			
		break;	
		}
		case 8:{
			System.out.println("enter number of products you want to see");
			int number=scanner.nextInt();
			List<Product> list=productService.getNProducts(number);
			
			if(list!=null)
				System.out.println(list);
			else
				System.out.println("no record found");
			
			
		break;	
		}
		case 9:{
			System.out.println("enter numbers between which you see results");
			int number1=scanner.nextInt();
			int number2=scanner.nextInt();
			List<Product> list=productService.getPaiging(number1,number2);
			
			if(list!=null)
				System.out.println(list);
			else
				System.out.println("no record found");
			
		
		break;	
		}
		case 10:
		{
			productService.RestrictionsExamples();
				
		}
		}
		System.out.println("Do you want to continue(y/n)");	
		
		ch=scanner.next().charAt(0);
		
	}while(ch=='y' || ch=='Y');
		System.out.println("terminated");
	
	}
	
	
	
	
	}	
	
	
	


