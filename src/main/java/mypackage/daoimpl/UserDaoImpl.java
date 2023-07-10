package mypackage.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import mypackage.dao.UserDao;
import mypackage.entities.User;
import mypackage.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	
	@Override
	public void insert(User user) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
	            tx.rollback();
	        }
			e.printStackTrace();
		} finally {
			session.close();
		}		
	}
	
	@Override
	public void update(User user) {
	    SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.beginTransaction();
	        session.update(user);
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String uUsername, String uPassword) {
			
		SessionFactory sessionFactory = null;
	    Session session = null;
	    Query<User> query = null;
	    User user = null;
	    try {
	        sessionFactory = HibernateUtil.buildSessionFactory();
	        session = sessionFactory.openSession();
	        query = session.createQuery("select u from mypackage.entities.User u where u.uUsername = :username and u.uPassword = :password");
	        query.setParameter("username", uUsername);
	        query.setParameter("password", uPassword);
	        user = query.uniqueResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return user;
	}
	
	
}
