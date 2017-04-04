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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;
	
	@RequestMapping("/getAllSuppliers")
	public ModelAndView getAllSuppliers()
	{
		List<Supplier> suppliers = supplierDAO.list();
		return new ModelAndView("Supplier", "supplierList",suppliers);
	}

	// add Supplier
	// method 1 for add Supplier
	@RequestMapping("/manage_supplier_create")
	public ModelAndView getSupplierForm() {
		System.out.println("get createSupplierForm called*****************");
		ModelAndView mv = new ModelAndView("createSupplierForm");
		mv.addObject("createSupplierObj", supplier);
		return mv;

	}

	// add Product
	// method 2 for add Product
	@RequestMapping(value = "/manage_supplier_create", method = RequestMethod.POST)
	public ModelAndView createSupplier(@ModelAttribute(value = "createProductObj") Supplier supplier) {
		System.out.println("create Supplier called****");
		ModelAndView mv = new ModelAndView("AdminHome");
		if (supplierDAO.save(supplier)) {
			mv.addObject("message", "Successfully created the Supplier");
			List<Supplier> supplierList = supplierDAO.list();
			mv.addObject("supplierList", supplierList);

		} else {
			mv.addObject("message", "Not able to create Product.Please contact Administrator");

		}
		return mv;

	}

	// delete a supplier
	@RequestMapping(value = "/manage_supplier_delete/{id}", method = RequestMethod.GET)
	public String deleteSupplier(@PathVariable(value = "id") int id, Model model) {
		System.out.println("deleteSupplier called****");

		//ModelAndView mv = new ModelAndView("AdminHome");
		Supplier supplier = (Supplier) supplierDAO.getSupplierByID(id);
		supplierDAO.delete(supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		return "redirect:/getAllSuppliers";

	}

	// edit Supplier
	// method 1 for edit Supplier
	@RequestMapping(value = "/manage_supplier_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditSupplierForm(@PathVariable(value = "id") int id) {
		System.out.println("getEditSupplierForm called******");

		Supplier supplier = (Supplier) this.supplierDAO.getSupplierByID(id);
		return new ModelAndView("editSupplierForm", "editSupplierObj", supplier);
	}

	// edit Supplier
	// method 2 for edit Supplier
	@RequestMapping(value = "/manage_supplier_edit", method = RequestMethod.POST)
	public ModelAndView editSupplier(@ModelAttribute(value = "editProductObj") Supplier supplier, Model model) {
		System.out.println("editSupplier  called****");

		this.supplierDAO.update(supplier);
		ModelAndView mv = new ModelAndView("AdminHome");
		model.addAttribute("supplierList", supplierDAO.list());
		return mv;

	}

}
