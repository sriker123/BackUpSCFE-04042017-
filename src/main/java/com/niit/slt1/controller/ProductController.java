package com.niit.slt1.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@SuppressWarnings("unused")
	@Autowired
	private Category category;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;

	@SuppressWarnings("unused")
	@Autowired
	private Supplier supplier;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@RequestMapping("/getAllProducts")
	public ModelAndView getAllCategories() {
		List<Product> products = productDAO.list();
		return new ModelAndView("Product", "productList", products);
	}

	// add Product
	// method 1 for add Product
	@RequestMapping("/manage_product_create")
	public ModelAndView createProductForm() {
		System.out.println("createProductForm called***********");
		ModelAndView mv = new ModelAndView("createProductForm");// there is a
																// jsp file
																// created just
																// to create the
																// product by
																// the admin
		mv.addObject("createProductObj", product);
		mv.addObject("productList", this.productDAO.list());
		mv.addObject("category", new Category());
		mv.addObject("categoryList", this.categoryDAO.list());
		mv.addObject("supplier", new Supplier());
		mv.addObject("supplierList", this.supplierDAO.list());

		return mv;
	}

	// add Product
	// method 2 for add Product
	
	@RequestMapping(value = "/manage_product_create", method = RequestMethod.POST)
	public ModelAndView createProduct(@Valid @ModelAttribute(value = "createProductObj") Product product,
			MultipartFile file, Model model, BindingResult result) {
		System.out.println("createProduct called****");
		ModelAndView mv = new ModelAndView("AdminHome");
		/*
		 * if (productDAO.save(product)) { mv.addObject("message",
		 * "Successfully created the product"); List<Product> productList =
		 * productDAO.list(); mv.addObject("productList", productList);
		 * mv.addObject("product", product);
		 * 
		 * } else { mv.addObject("message",
		 * "Not able to create Product.Please contact Administrator");
		 * 
		 * }
		 */
		// mv.addObject("isUserClickedProducts", "true");
		if (result.hasErrors()) {
			return new ModelAndView("createProductForm");
		}
		Category category = categoryDAO.getCategoryByName(product.getCategory().getName());
		System.out.println(category.getId() + ":" + category.getName() + ":" + category.getDescription());

		Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getName());
		System.out.println(supplier.getId() + ":" + supplier.getName() + ":" + supplier.getAddress());

		product.setCategory(category);
		product.setSupplier(supplier);
		// Image
		MultipartFile prodImage = product.getImage();
		System.out.println(prodImage);
		if (!prodImage.isEmpty()) {

			// store this Image
			Path paths = Paths.get("C:/Users/lenovo/workspace2/SCFE1/src/main/webapp/WEB-INF/resources/images/"
					+ product.getId() + ".png");
			try {
				prodImage.transferTo(new File(paths.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		productDAO.save(product);
		mv.addObject("isUserClickedProducts", "true");
		mv.addObject("productList", productDAO.list());

		return mv;

	}

	// delete Product
	@RequestMapping(value = "/manage_product_delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(value = "id") int id, Model model) {
		System.out.println("deleteProduct called****");
		// ModelAndView mv = new ModelAndView("AdminHome");
		Product product = (Product) productDAO.getProductByID(id);
		productDAO.delete(product);
		Path paths = Paths
				.get("C:/Users/lenovo/workspace2/SCFE1/src/main/webapp/WEB-INF/resources/images/" + id + ".png");

		if (Files.exists(paths)) {
			try {

				Files.delete(paths);

			} catch (IOException e) {
			}
		}
		model.addAttribute("productList", productDAO.list());

		return "redirect:/getAllProducts";

	}

	// edit Product
	// method 1 for edit Product
	@RequestMapping(value = "/manage_product_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditProductForm(@PathVariable(value = "id") int id) {
		System.out.println("getEditProductForm called******");

		Product product = (Product) this.productDAO.getProductByID(id);
		ModelAndView mv = new ModelAndView("editProductForm");
		// return new ModelAndView("editProductForm", "editProductObj",
		// product);
		mv.addObject("categoryList", this.categoryDAO.list());
		mv.addObject("supplierList", this.supplierDAO.list());
		mv.addObject("editProductObj", "product");
		mv.addObject("product", product);
		return mv;
	}

	// edit Product
	// method 2 for edit Product
	@RequestMapping(value = "/manage_product_edit", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute(value = "editProductObj") Product product, Model model) {
		System.out.println("editProduct  called****");

		// this.productDAO.Update(product);
		ModelAndView mv = new ModelAndView("AdminHome");
		if (productDAO.update(product)) {
			mv.addObject("message", "Updated Succesfully");
			List<Product> productList = productDAO.list();
			mv.addObject("productList", productList);
			mv.addObject("product", product);
		}
		System.out.println("Updted successfully............");
		model.addAttribute("productList", productDAO.list());
		return mv;

	}
}
