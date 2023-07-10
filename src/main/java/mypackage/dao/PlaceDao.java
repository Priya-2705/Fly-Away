package mypackage.dao;

import java.util.List;

import mypackage.entities.Place;

public interface PlaceDao {
	
	void add(Place place) throws Exception;
	void delete(int placeId) throws Exception;
	Place getPlaceById(int placeId);
	Place getPlaceByName(String placeName);
	List<Place> getAll();
}
