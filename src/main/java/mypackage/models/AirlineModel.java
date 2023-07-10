package mypackage.models;

public class AirlineModel {
	
	private String airlineName;
	
	public AirlineModel() {
	}

	public AirlineModel(String airlineName) {
		super();
		this.airlineName = airlineName;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
}
