package com.xoriant.util;

import java.util.Scanner;

import com.xoriant.dao.EcartDaoImpl;
import com.xoriant.model.Brand;
import com.xoriant.model.Category;
import com.xoriant.model.Product;

public class Ecartutil {

	public void addNewBrand() {
		Scanner sc=new Scanner(System.in);
		Brand brand=new Brand();
		System.out.println("Enter Brand Name");
		String brandName=sc.next();
		brand.setBrandName(brandName);
		
		EcartDaoImpl el=new EcartDaoImpl();
		el.addNewBrand(brand);
	}
	
	public void addNewCategory() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Category Name::");
		String categoryName=sc.next();
		
		Category category=new Category();
		
		category.setCategoryName(categoryName);
		
		EcartDaoImpl el=new EcartDaoImpl();
		el.addNewCategory(category);
	}
	
	
	public void addNewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product Name");
		String productName=sc.next();
		System.out.println("Enter Product Price");
		double productPrice=sc.nextDouble();
		System.out.println("Enter Brand Id");
		int brandId=sc.nextInt();
		System.out.println("Enter Category Id");
		int categoryId=sc.nextInt();
		
		Product product=new Product();
		Brand brand=new Brand();
		Category category=new Category();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		brand.setBrandId(brandId);
		category.setCategoryId(categoryId);
		
		product.setBrand(brand);
		product.setCategory(category);
		
		EcartDaoImpl el=new EcartDaoImpl();
		el.addNewProduct(product);
	}
	
	
	public void updateBrand() {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENter Brand ID::");
		int brandId=sc.nextInt();
		System.out.println("ENter The Brand Name");
		String brandName=sc.next();
		
		Brand brand=new Brand();
		brand.setBrandId(brandId);
		brand.setBrandName(brandName);
		EcartDaoImpl el=new EcartDaoImpl();
		el.updateBrand(brand);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
