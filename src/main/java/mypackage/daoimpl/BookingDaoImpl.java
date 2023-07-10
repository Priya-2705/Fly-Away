package mypackage.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import mypackage.dao.BookingDao;
import mypackage.entities.Booking;
import mypackage.entities.User;
import mypackage.util.HibernateUtil;

public class BookingDaoImpl implements BookingDao{

	@Override
	public void add(Booking booking) throws Exception {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(booking);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
            }
            throw new Exception("Failed to add booking.", e);
        } finally {
            session.close();
        }	
	}

	@Override
	public void delete(int bookingId) throws Exception {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Booking booking = session.get(Booking.class, bookingId);
			session.delete(booking);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
            }
            throw new Exception("Failed to delete booking.", e);
        } finally {
            session.close();
        }	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getByUser(User user) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Booking> query = session.createQuery("SELECT b FROM mypackage.entities.Booking b WHERE b.user = :user");
        query.setParameter("user", user);
        List<Booking> bookings = query.list();
        session.close();
        return bookings;
	}
}
