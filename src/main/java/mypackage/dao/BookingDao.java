package mypackage.dao;

import java.util.List;

import mypackage.entities.Booking;
import mypackage.entities.User;

public interface BookingDao {
	
	void add(Booking booking) throws Exception;
	void delete(int bookingId) throws Exception;
	List<Booking> getByUser(User user);
}
