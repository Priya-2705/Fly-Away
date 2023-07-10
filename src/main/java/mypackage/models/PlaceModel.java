package mypackage.models;

public class PlaceModel {
	
	private String placeName;
	
	public PlaceModel() {
	}

	public PlaceModel(String placeName) {
		super();
		this.placeName = placeName;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
}
