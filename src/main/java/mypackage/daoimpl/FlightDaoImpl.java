package mypackage.daoimpl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import mypackage.dao.FlightDao;
import mypackage.entities.Flight;
import mypackage.util.HibernateUtil;

public class FlightDaoImpl implements FlightDao {

	@Override
	public void add(Flight flight) throws Exception {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(flight);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new Exception("Failed to add flight.", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(int flightId) throws Exception {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Flight flight = session.get(Flight.class, flightId);
			session.delete(flight);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new Exception("Failed to delete flight.", e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void update(Flight flight) throws Exception {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(flight);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new Exception("Failed to add flight.", e);
		} finally {
			session.close();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Flight getFlightById(int flightId) {

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Flight> query = session.createQuery("select f from mypackage.entities.Flight f where f.flightId = ?1");
		query.setParameter(1, flightId);
		Flight result = (Flight) query.uniqueResult();
		session.close();
		return result;
	}

	@Override
	public List<Flight> getFlightsBySearchCriteria(LocalDate dateOfTravel, int sourceId, int destinationId,
			int numberOfPersons) {

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Flight> query = session.createQuery("select f from mypackage.entities.Flight f where "
				+ "DATE(f.departureDateTime) = :dateOfTravel " + "and f.sourcePlace.placeId = :sourceId "
				+ "and f.destinationPlace.placeId = :destinationId " + "and f.availableSeats >= :numberOfPersons",
				Flight.class);
		query.setParameter("dateOfTravel", java.sql.Date.valueOf(dateOfTravel));
		query.setParameter("sourceId", sourceId);
		query.setParameter("destinationId", destinationId);
		query.setParameter("numberOfPersons", numberOfPersons);
		List<Flight> result = query.getResultList();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> getAll() {

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Flight> query = session.createQuery("select f from mypackage.entities.Flight f");
		List<Flight> result = query.list();
		;
		session.close();
		return result;
	}
}
