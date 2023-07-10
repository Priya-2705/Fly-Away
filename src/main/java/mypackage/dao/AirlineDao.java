package mypackage.dao;

import java.util.List;

import mypackage.entities.Airline;

public interface AirlineDao {
	
	void add(Airline airline) throws Exception;
	void delete(int airlineId) throws Exception;
	Airline getAirlineById(int airlineId);
	Airline getAirlineByName(String airlineName);
	List<Airline> getAll();
}
