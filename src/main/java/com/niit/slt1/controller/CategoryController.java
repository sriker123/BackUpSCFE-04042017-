package com.niit.slt1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {
	// Category.jsp - addcategory, delete category, show categorylist, update
	// categorylist, edit category list

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@RequestMapping("/getAllCategories")
	public ModelAndView getAllCategories()
	{
		List<Category> categories = categoryDAO.list(); 
		return new ModelAndView("Category","categoryList",categories);
	}
	// method1 to add category
	@RequestMapping(value = "/manage_category_create")
	public ModelAndView getcreateCategoryForm() {
		System.out.println("get createCategoryForm called*****************");
		ModelAndView mv = new ModelAndView("createCategoryForm");

		mv.addObject("createCategoryObj", category);

		return mv;
	}

	// Step#2 to add category
	@RequestMapping(value = "/manage_category_create", method = RequestMethod.POST)
	public ModelAndView createCategory(@ModelAttribute(value = "createCategoryObj") Category category) {
		System.out.println("create category called*****************");
		/*
		 * category.setId(id); category.setName(name);
		 * category.setDescription(description);
		 */
		ModelAndView mv = new ModelAndView("AdminHome");
		if (categoryDAO.save(category)) {
			mv.addObject("message", "Successfully created the category");
			List<Category> categoryList = categoryDAO.list();
			mv.addObject("categoryList", categoryList);
			mv.addObject("category", category);

		} else {
			mv.addObject("message", "Not able to create Category.Please contact Administrator");

		}
		mv.addObject("isUserClickedCategories", "true");
		return mv;

	}

	@RequestMapping(value = "/manage_category_delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable(value = "id") int id, Model model) {
		System.out.println("delete Category called****");

		//ModelAndView mv = new ModelAndView("AdminHome");
		Category category = (Category) categoryDAO.getCategoryByID(id);
		categoryDAO.delete(category);
			

		model.addAttribute("categoryList", categoryDAO.list());
		//mv.addObject("isUserClickedCategories", "true");
		return "redirect:/getAllCategories";
		// return "forward:/manage_categories";
	}

	// edit Category
	// when clicked on edit the data should be retrieved in the categorformedit
	// , i.e GET the data
	@RequestMapping(value = "/manage_category_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getCategory(@PathVariable("id") int id) {
		System.out.println("edit method called");

		Category category = categoryDAO.getCategoryByID(id);
		// can also use this keyword
		// Category category = this.categoryDAp.getCategoryById(id);
		// return new
		// ModelAndView("CategoryEditForm","editCategoryObj",category);
		ModelAndView mv = new ModelAndView("CategoryEditForm");
		mv.addObject("editCategoryObj", category);
		return mv;

	}

	// Method 2
	// When clicked on edit category button in categoryFormEdit page it should
	// edit and update

	/*@RequestMapping(value = "/manage_category_edit/{id}", method = RequestMethod.POST)
	public ModelAndView editcategory(@ModelAttribute(value = "editCategoryObj") Category category)

	{
		System.out.println("edit category");

		ModelAndView mv = new ModelAndView("AdminHome");

		if (categoryDAO.update(category)) {
			mv.addObject("message", "edited");
			List<Category> categoryList = categoryDAO.list();
			mv.addObject("categoryList", categoryList);
			mv.addObject("category", category);
		} else {
			mv.addObject("message", "not edited");
		}
		return mv;

	}*/
	@RequestMapping(value = "/manage_category_edit", method = RequestMethod.POST)
	public ModelAndView editCategory(@ModelAttribute(value = "editCategoryObj") Category category, Model model) {
		System.out.println("edit category called****");

		this.categoryDAO.update(category);
		ModelAndView mv = new ModelAndView("AdminHome");
		model.addAttribute("categoryList", categoryDAO.list());
		mv.addObject("isUserClickedCategories", "true");
		return mv;

	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
