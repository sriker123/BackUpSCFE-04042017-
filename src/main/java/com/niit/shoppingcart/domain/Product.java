package com.niit.shoppingcart.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "product")
@Component
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * GenerationType.TABLE.That way, jpa uses a sequence table for id assigment
	 * and you may never need to generate sequence or auto-increment values or
	 * triggers that lowers portability. Also note that in java int type is
	 * initiated with 0 default, so you may get rid of that also.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotEmpty(message = "name is required")
	private String name;

	@Min(value = 100, message = "must be greate or equal to 100")
	private float price;

	@Column(name = "description")
	@NotEmpty(message = "desc is required")
	private String description;

	@Transient
	private MultipartFile image;

	public Product() {

	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	// getter+setters

}
