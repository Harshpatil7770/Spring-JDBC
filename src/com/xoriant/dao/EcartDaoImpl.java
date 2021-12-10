package com.xoriant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.xoriant.config.DBconfig;
import com.xoriant.model.Brand;
import com.xoriant.model.Category;
import com.xoriant.model.Product;


public class EcartDaoImpl {

	public void  addNewBrand(Brand brand) {
		try {
			Connection con=DBconfig.getConnection();
			String sql="insert into brands values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,brand.getBrandId());
			ps.setString(2,brand.getBrandName());
			int result=ps.executeUpdate();
			if(result!=0) {
				System.out.println("New Brand Added ID:: "+brand.getBrandId()+" Name:: "+brand.getBrandName());
			}else {
				System.out.println("Record Not Saved..........");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
	}
	
	public void addNewCategory(Category category) {
		try {
			Connection con=DBconfig.getConnection();
			String sql="insert into categories values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,category.getCategoryId());
			ps.setString(2,category.getCategoryName());
			
			int result=ps.executeUpdate();
			if(result!=0) {
				System.out.println("New Category Added ID:: "+category.getCategoryId()+" CategoryName:: "+category.getCategoryName());
			}else {
				System.out.println("Record not saved ........");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
		
	}

	public void addNewProduct(Product product) {
        try {
	Connection con=DBconfig.getConnection();
	String sql="insert into products values(?,?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1,product.getProductId());
	ps.setString(2, product.getProductName());
	ps.setDouble(3,product.getProductPrice());
	ps.setInt(4,product.getBrand().getBrandId());
	ps.setInt(5,product.getCategory().getCategoryId() );
	
	int result=ps.executeUpdate();
	if(result!=0) {
		System.out.println("New Product Added Id:: "+product.getProductId()+"Product Name:: "+product.getProductName());
	}else {
		System.out.println("Record Not Saved .........");
	}
          }catch(Exception e) {
        	e.printStackTrace();  
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
		
	}
	
	public void  updateBrand(Brand brand1) {
		try {
			Connection con=DBconfig.getConnection();
			String sql="update brands set brand_name=? where brand_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,brand1.getBrandId());
			ps.setString(2,brand1.getBrandName());
			
			int result=ps.executeUpdate();
			if(result!=0) {
				System.out.println("Update Brand Succesfully ID:: "+brand1.getBrandId()+"Brand Name:: "+brand1.getBrandName());
			}else {
				System.out.println("Record not Saved............");
			}
		}catch(Exception e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
	
	}
	
	public List<Brand> fetchAllBrand(){
		List<Brand> list=new ArrayList<Brand>();
		try {
			Connection con=DBconfig.getConnection();
			Statement st=con.createStatement();
			String sql="select * from brands";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Brand brand=new Brand();
				brand.setBrandId(rs.getInt(1));
				brand.setBrandName(rs.getString(2));
				
				list.add(brand);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
		return list;
	}
	
	public List<Category> fetchAllCategories(){
		List<Category> list=new ArrayList<Category>();
		try {
			Connection con=DBconfig.getConnection();
			Statement st=con.createStatement();
			String sql="select * from categories";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Category category=new Category();
				
				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				list.add(category);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
		return list;
	}
	
	
	public List<Product> fetchAllProduct(){
		 List<Product> list=new ArrayList<Product>();
		 try {
			 Connection con=DBconfig.getConnection();
			 Statement st=con.createStatement();
			 String sql="select * from products p inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id";
			 ResultSet rs=st.executeQuery(sql);
			 while(rs.next()) {
				
				 Product product=new Product();
				 Brand brand=new Brand();
				 Category category=new Category();
				 
				 product.setProductId(rs.getInt(1));
				 product.setProductName(rs.getString(2));
				 product.setProductPrice(rs.getDouble(3));
				 brand.setBrandId(rs.getInt(4));
				 brand.setBrandName(rs.getString(5));
				 category.setCategoryId(rs.getInt(6));
				 category.setCategoryName(rs.getString(7));
				 
				 product.setBrand(brand);
				 product.setCategory(category);
				 
				 list.add(product);
			 }
		 }catch(Exception e) {
			e.printStackTrace(); 
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
		 return list;
	}
	
	public void deleteProduct(int productId) {
		try {
			Connection con=DBconfig.getConnection();
			String sql="delete from products where product_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, productId);
			int rs=ps.executeUpdate();
			System.out.println(rs);
		}catch(Exception e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
	}

	public void deleteBrand(int brandId) {
	try {
		Connection con=DBconfig.getConnection();
		String sql="delete from brands where brand_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, brandId);
		int rs=ps.executeUpdate();
		if(rs!=0) {
			System.out.println("Delete Brand Succesfully");
		}else {
			System.out.println("Please enter correct Brand Id");
		}
	}catch(Exception e) {
		e.printStackTrace();
	} /*
		 * finally { DBconfig.closeConnection(); }
		 */
		
	}

	public List<Product> listOfAllProductsByUsingBrand(String brandName2) {
		 List<Product> list=new ArrayList<Product>();
		try {
			Connection con=DBconfig.getConnection();
			String sql="select * from products p inner join brands b on p.brand_id=b.brand_id where b.brand_name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,brandName2);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()) {
		    	Product product=new Product();
		    	Brand brand=new Brand();
		    	product.setProductId(rs.getInt(1));
		    	product.setProductName(rs.getString(2));
		    	product.setProductPrice(rs.getDouble(3));
		    	brand.setBrandId(rs.getInt(4));
		    	brand.setBrandName(rs.getString(5));
		    	
		    	product.setBrand(brand);
		    	list.add(product);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
		return list;
	}

	public List<Category> fetchAllProductBasedOnTheirCategoryName(String categoryName) {
		List<Category> list=new ArrayList<Category>();
		try {
			Connection con=DBconfig.getConnection();
			String sql="select * from products p inner join categories c on p.category_id=c.category_id where c.category_name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,categoryName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product product=new Product();
				Category category=new Category();
				
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getDouble(3));
				category.setCategoryId(rs.getInt(4));
				category.setCategoryName(rs.getString(5));
				
				product.setCategory(category);
				
				list.add(category);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
		return list;
	}

	public void deleteCategory(int categoryId) {
		try {
			Connection con=DBconfig.getConnection();
			String sql="delete from categories where category_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			int rs=ps.executeUpdate();
			if(rs!=0) {
				System.out.println("====== Delete Category Succesfully ======");
			}else {
				System.out.println("====== Records Not Found ========");
			}
		}catch(Exception e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
		
	}
	
	
}
