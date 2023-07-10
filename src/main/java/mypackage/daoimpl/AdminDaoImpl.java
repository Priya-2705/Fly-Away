package mypackage.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import mypackage.dao.AdminDao;
import mypackage.entities.Admin;
import mypackage.util.HibernateUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void insert(Admin admin) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(admin);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Admin admin) {

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(admin);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Admin getAdmin(String aUsername, String aPassword) {
		
		SessionFactory sessionFactory = null;
	    Session session = null;
	    Query<Admin> query = null;
	    Admin admin = null;
	    try {
	        sessionFactory = HibernateUtil.buildSessionFactory();
	        session = sessionFactory.openSession();
	        query = session.createQuery("select a from mypackage.entities.Admin a where a.aUsername = :username and a.aPassword = :password");
	        query.setParameter("username", aUsername);
	        query.setParameter("password", aPassword);
	        admin = query.uniqueResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return admin;
	}
}
