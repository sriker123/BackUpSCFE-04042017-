package com.niit.shoppingcart.dao.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;



@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public boolean save(Supplier supplier) {
		try {

			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(supplier);
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

	public boolean update(Supplier supplier) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.update(supplier);

			session.getTransaction().commit();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Supplier supplier) {
		try {

			getSession().delete(supplier);

			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier getSupplierByID(int id) {

		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where id=" + id).uniqueResult();
	}

	public Supplier getSupplierByName(String name) {

		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where name='" + name + "'")
				.uniqueResult();
	}

}
