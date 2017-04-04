package com.niit.slt1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

//this admin controller is created top control over the links that are in AdminHome 
@Controller
public class AdminController {

	//define 3 methods 
	@Autowired
	Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	
	
	@RequestMapping("/manage_categories")
	public ModelAndView manageCategories()
	{
		System.out.println("manageCategories");
		ModelAndView mv = new ModelAndView("/AdminHome");
		mv.addObject("isUserClickedCategories", "true");
	
		List<Category> categoryList= categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		mv.addObject("category", category);
		return mv;

	}

	@RequestMapping("/manage_products")
	public ModelAndView manageProducts() {
		System.out.println("manageProducts");
		ModelAndView mv = new ModelAndView("/AdminHome");
		mv.addObject("isUserClickedProducts", "true");
		List<Product> productList = productDAO.list();
		mv.addObject("productList",productList);
		mv.addObject("product",product);
		return mv;
	}

	@RequestMapping("/manage_suppliers")
	public ModelAndView manageSuppliers() {
		System.out.println("manageSupplier");
		ModelAndView mv = new ModelAndView("/AdminHome");
		mv.addObject("isUserClickedSuppliers", "true");
		
		List<Supplier> supplierList=supplierDAO.list();
		mv.addObject("supplierList",supplierList);
		mv.addObject("supplier",supplier);
		return mv;

	}
}
