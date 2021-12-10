package com.xoriant.main;

import java.util.Scanner;

import com.xoriant.dao.EcartDaoImpl;
import com.xoriant.model.Brand;
import com.xoriant.model.Category;
import com.xoriant.model.Product;
import com.xoriant.util.Ecartutil;

public class Main {

	void showMainMenu() {
		String str="yes";
			do{
		System.out.println("==========================================");
		System.out.println("============ Welcome To Ecart ============");
		System.out.println("==========================================");
		System.out.println(" 1) Add New Brand ");
		System.out.println(" 2) Add New Category");
		System.out.println(" 3) Add New Product");
		System.out.println(" 4) Update Brand");
		System.out.println(" 5) List of All Brands");
		System.out.println(" 6) List of All Categories");
		System.out.println(" 7) List Of All Products");
		System.out.println(" 8) Delete Product");
		System.out.println(" 9) Delete Brand");
		System.out.println(" 10)List Of All Product Based On Their Brand Name");
		System.out.println(" 11)List of All Product Based on Their Category Name");
		System.out.println(" 12)Delete Category ");
		
		
		EcartDaoImpl el=new EcartDaoImpl();
		Ecartutil eu=new Ecartutil();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice");
		int num=sc.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("========= Add New Brand =======");
			eu.addNewBrand();
			break;
			
		case 2:
			System.out.println("========== Add New Category =======");
			eu.addNewCategory();
			break;
		case 3:
			System.out.println("========== Add New Product==========");
			eu.addNewProduct();
			break;
		case 4:
			System.out.println("========== Update Brand ==========");
			Brand brand1=new Brand();
			System.out.println("Enter Brand Id");
			int brandId1=sc.nextInt();
			System.out.println("Enter Brand Name");
			String brandName=sc.next();
			brand1.setBrandId(brandId1);
			brand1.setBrandName(brandName);
			el.updateBrand(brand1);
			break;
		case 5:
			System.out.println("=========== List Of ALL Brand ==========");
			el.fetchAllBrand().forEach(System.out::println);
			break;
		case 6: 
			System.out.println("========== List of All Categories======= ");
			el.fetchAllCategories().forEach(System.out::println);
			break;
		case 7:
			System.out.println("=========== List of All Products=======");
             el.fetchAllProduct().forEach(System.out::println);
             break;
		case 8:
			System.out.println("============ Delete Product By Id=========");
			Product p=new Product();
			System.out.println("Enter Product ID");
			int productId=sc.nextInt();
			p.setProductId(productId);
			el.deleteProduct(productId);
			break;
			
		case 9:
			System.out.println("===== Delete Brand =======");
			Brand brand=new Brand();
			System.out.println("Enter Brand Id::");
			int brandId=sc.nextInt();
			brand.setBrandId(brandId);
			el.deleteBrand(brandId);
			break;
		case 10:
			System.out.println("===== List Of All Product Based On Their Brand Name=====");
			Brand brand2=new Brand();
			System.out.println("Enter Brand Name::");
		    String brandName2=sc.next();
		    brand2.setBrandName(brandName2);
			el.listOfAllProductsByUsingBrand(brandName2).forEach(System.out::println);
			break;
		case 11:
			System.out.println("===== List Of All Product Based on Their Category =====");
			Category category=new Category();
			System.out.println("Enter Category Name::");
			String categoryName=sc.next();
			category.setCategoryName(categoryName);
			el.fetchAllProductBasedOnTheirCategoryName(categoryName).forEach(System.out::println);
			break;
		case 12:
			System.out.println("====== Delete Category =======");
			Category category1=new Category();
			System.out.println("Enter Category Id::");
			int categoryId=sc.nextInt();
			
			category1.setCategoryId(categoryId);
			el.deleteCategory(categoryId);
			break;
		}
		System.out.println("Do you want to continue?? 1)yes 2)no");
		str=sc.next();
	}while(str.equals("yes"));
}
}
