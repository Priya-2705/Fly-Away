package mypackage.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage.entities.Admin;
import mypackage.entities.Airline;
import mypackage.entities.Booking;
import mypackage.entities.Flight;
import mypackage.entities.Place;
import mypackage.entities.User;

public class HibernateUtil {

	
	static SessionFactory sessionFactory = null;
	
	public static SessionFactory buildSessionFactory() {
		
		if(sessionFactory != null) {
			return sessionFactory;
		}
			
		// STEP 1: Create Configuration Object
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Flight.class)
				           .addAnnotatedClass(Airline.class).addAnnotatedClass(Booking.class).addAnnotatedClass(Place.class).addAnnotatedClass(Admin.class).addAnnotatedClass(User.class);
		sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
}