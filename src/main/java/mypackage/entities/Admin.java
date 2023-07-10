package mypackage.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String aUsername;
	private String aPassword;
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
	private Set<Place> places = new HashSet<>();
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
	private Set<Airline> airlines = new HashSet<>();
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
	private Set<Flight> flights = new HashSet<>();
	
	// Helper Methods
	public void addPlace(Place place) {
	    this.places.add(place);
	}
	
	public void addAirline(Airline airline) {
		this.airlines.add(airline);
	}
	
	public void addFlight(Flight flight) {
		this.flights.add(flight);
	}

	// Getters and Setters
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getaUsername() {
		return aUsername;
	}

	public void setaUsername(String aUsername) {
		this.aUsername = aUsername;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

	public Set<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(Set<Airline> airlines) {
		this.airlines = airlines;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
}
