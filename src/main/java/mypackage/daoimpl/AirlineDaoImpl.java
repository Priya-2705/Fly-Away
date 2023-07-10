package mypackage.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import mypackage.dao.AirlineDao;
import mypackage.entities.Airline;
import mypackage.util.HibernateUtil;

public class AirlineDaoImpl implements AirlineDao {

	@Override
	public void add(Airline airline) throws Exception {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(airline);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
		}
		throw new Exception("Failed to add airline.", e);
			} finally {
				session.close();
		}
	}

	@Override
	public void delete(int airlineId) throws Exception {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Airline airline = session.get(Airline.class, airlineId);
			session.delete(airline);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
		}
		throw new Exception("Failed to delete airline.", e);
			} finally {
				session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Airline getAirlineById(int airlineId) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Airline> query = session.createQuery("select a from mypackage.entities.Airline a where a.airlineId = ?1");
		query.setParameter(1, airlineId);
		Airline result = (Airline) query.uniqueResult();
		session.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Airline getAirlineByName(String airlineName) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Airline> query = session.createQuery("select a from mypackage.entities.Airline a where a.airlineName = ?1");
		query.setParameter(1, airlineName);
		Airline result = (Airline) query.uniqueResult();
		session.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Airline> getAll() {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Airline> query = session.createQuery("select a from mypackage.entities.Airline a");
		List<Airline> result = query.list();;
		session.close();
		return result; 
	}
}
