
package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;



@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO

{

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();

	}

	@Transactional
	public boolean save(Category category) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.saveOrUpdate(category);

			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception e) { // TODO Auto-generated catch block
								// e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Category category) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategoryByID(int id) {

		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id=" + id).uniqueResult();

	}

	public Category getCategoryByName(String name) {

		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name='" + name + "'")
				.list().get(0);

	}

}
