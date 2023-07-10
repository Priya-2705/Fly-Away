package mypackage.services;

import mypackage.entities.Admin;
import mypackage.models.AirlineModel;

public interface AirlineService {
	
	void addAirline(Admin admin, AirlineModel airlineModel);
}
