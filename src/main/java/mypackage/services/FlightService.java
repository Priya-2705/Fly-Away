package mypackage.services;

import java.time.LocalDate;
import java.util.List;

import mypackage.entities.Admin;
import mypackage.entities.Flight;
import mypackage.models.FlightModel;

public interface FlightService {
	
	void addFlight(Admin admin, FlightModel flightModel);
	List<Flight> getFlightsBySearchCriteria(LocalDate dateOfTravel, int sourceId, int destinationId, int numberOfPersons);
}
