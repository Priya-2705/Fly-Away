package mypackage.models;

import java.time.LocalDateTime;

public class FlightModel {
	
	private int airlineId;
	private int sourceId;
	private int destinationId;
	private LocalDateTime departureDateTime;
	private double ticketPrice;
	private int availableSeats;
	
	public FlightModel() {
	}

	public FlightModel(int airlineId, int sourceId, int destinationId, LocalDateTime departureDateTime,
			double ticketPrice, int availableSeats) {
		super();
		this.airlineId = airlineId;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		this.departureDateTime = departureDateTime;
		this.ticketPrice = ticketPrice;
		this.availableSeats = availableSeats;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
}
