package com.niit.shoppingcart.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "category")
@Component
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	@NotEmpty(message = "name is mandatory")
	private String name;
	
	
	@NotEmpty(message = "desc is mandatory")
	private String description;

	public Category() {

	}

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;

	// getters+ setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}



	
}
