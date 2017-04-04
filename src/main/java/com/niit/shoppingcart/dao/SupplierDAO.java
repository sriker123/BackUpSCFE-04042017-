package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Supplier;




public interface SupplierDAO {
	
	public List<Supplier> list();
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	
	public Supplier getSupplierByID(int id);

	public Supplier getSupplierByName(String name);

}
