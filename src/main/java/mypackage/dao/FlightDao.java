package mypackage.dao;

import java.time.LocalDate;
import java.util.List;

import mypackage.entities.Flight;

public interface FlightDao {
	
	void add(Flight flight) throws Exception;
	void delete(int flightId) throws Exception;
	void update(Flight flight) throws Exception;
	Flight getFlightById(int flightId);
	List<Flight> getAll();
	List<Flight> getFlightsBySearchCriteria(LocalDate dateOfTravel, int sourceId, int destinationId,
			int numberOfPersons);
}
