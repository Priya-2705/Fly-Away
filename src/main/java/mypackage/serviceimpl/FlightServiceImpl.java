package mypackage.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import mypackage.dao.AdminDao;
import mypackage.dao.AirlineDao;
import mypackage.dao.FlightDao;
import mypackage.dao.PlaceDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.daoimpl.AirlineDaoImpl;
import mypackage.daoimpl.FlightDaoImpl;
import mypackage.daoimpl.PlaceDaoImpl;
import mypackage.entities.Admin;
import mypackage.entities.Airline;
import mypackage.entities.Flight;
import mypackage.entities.Place;
import mypackage.models.FlightModel;
import mypackage.services.FlightService;

public class FlightServiceImpl implements FlightService {

	private FlightDao flightDao = new FlightDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();
	private AirlineDao airlineDao = new AirlineDaoImpl();
	private PlaceDao placeDao = new PlaceDaoImpl();

	@Override
	public void addFlight(Admin admin, FlightModel flightModel) {

		try {
			Admin adm = adminDao.getAdmin(admin.getaUsername(), admin.getaPassword());
			Airline airline = airlineDao.getAirlineById(flightModel.getAirlineId());
			Place source = placeDao.getPlaceById(flightModel.getSourceId());
			Place destination = placeDao.getPlaceById(flightModel.getDestinationId());
			
			Flight flight = new Flight();
			flight.setAirline(airline);
			flight.setSourcePlace(source);
			flight.setDestinationPlace(destination);
			flight.setDepartureDateTime(flightModel.getDepartureDateTime());
			flight.setTicketPrice(flightModel.getTicketPrice());
			flight.setAvailableSeats(flightModel.getAvailableSeats());
			flight.setAdmin(adm);

			adm.addFlight(flight);
			flightDao.add(flight);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Flight> getFlightsBySearchCriteria(LocalDate dateOfTravel, int sourceId, int destinationId,
			int numberOfPersons) {
		
			return flightDao.getFlightsBySearchCriteria(dateOfTravel, sourceId, destinationId, numberOfPersons);
	}
}
