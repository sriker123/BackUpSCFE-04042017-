package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;



@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private Session getSession() { return sessionFactory.getCurrentSession();
	 * }
	 */

	@SuppressWarnings("unchecked")
	public List<Product> list() {
		Session session = sessionFactory.openSession();
		return session.createQuery("from Product").list();
	}

	public boolean save(Product product) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(product);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.update(product);

			session.getTransaction().commit();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Product product) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Product getProductByID(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = (Product) session.createQuery("from Product where id=" + id).uniqueResult();
		session.getTransaction().commit();
		session.flush();
		session.close();
		return product;

	}

	public Product getProductByName(String name) {
		Session session = sessionFactory.openSession();
		return (Product) session.createQuery("from Product where name='" + name + "'").uniqueResult();

	}

}
