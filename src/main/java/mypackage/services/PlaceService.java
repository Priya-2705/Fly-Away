package mypackage.services;

import mypackage.entities.Admin;
import mypackage.models.PlaceModel;

public interface PlaceService {
	
	void addPlace(Admin admin, PlaceModel placeModel);
}
