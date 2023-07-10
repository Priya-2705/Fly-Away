package mypackage.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import mypackage.dao.PlaceDao;
import mypackage.entities.Place;
import mypackage.util.HibernateUtil;

public class PlaceDaoImpl implements PlaceDao {

	@Override
	public void add(Place place) throws Exception {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(place);
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
	public void delete(int placeId) throws Exception {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// Check if there are any flights associated with the place
	        Query<Long> countQuery = session.createQuery("select count(*) from mypackage.entities.Flight f where f.sourcePlace.placeId = :placeId or f.destinationPlace.placeId = :placeId", Long.class);
	        countQuery.setParameter("placeId", placeId);
	        long flightCount = countQuery.uniqueResult();

	        if (flightCount > 0) {
	            throw new Exception("Cannot delete the place as there are associated flights.");
	        }
	        
	        // Delete the place
			Place place = session.get(Place.class, placeId);
			session.delete(place);
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

	@SuppressWarnings("unchecked")
	@Override
	public Place getPlaceById(int placeId) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Place> query = session.createQuery("select p from mypackage.entities.Place p where p.placeId = ?1");
		query.setParameter(1, placeId);
		Place result = (Place) query.uniqueResult();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Place getPlaceByName(String placeName) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Place> query = session.createQuery("select p from mypackage.entities.Place p where p.placeName = ?1");
		query.setParameter(1, placeName);
		Place result = (Place) query.uniqueResult();
		session.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Place> getAll() {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Place> query = session.createQuery("select p from mypackage.entities.Place p");
		List<Place> result = query.list();
		session.close();
		return result;
	}
}
