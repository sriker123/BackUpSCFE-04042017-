package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();

	}

	public User getUser(int id) {
		return (User) getSession().get(User.class, id);
	}

	public boolean save(User user) {

		try {

			getSession().save(user);

			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try {
			getSession().update(user);

			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validate(String name, String password) {

		String hql = "from User where name='" + name + "'and password='" + password + "'";
		if (getSession().createQuery(hql).uniqueResult() == null) {
			return false;
		}
		return true;
	}

	public User getUserbyName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// db Operation

		String hql = "from User where name='" + name + "'";
		User user = (User) session.createQuery(hql).uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return user;
	}

}
