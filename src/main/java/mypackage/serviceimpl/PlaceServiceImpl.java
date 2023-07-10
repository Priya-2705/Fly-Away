package mypackage.serviceimpl;

import mypackage.dao.AdminDao;
import mypackage.dao.PlaceDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.daoimpl.PlaceDaoImpl;
import mypackage.entities.Admin;
import mypackage.entities.Place;
import mypackage.models.PlaceModel;
import mypackage.services.PlaceService;

public class PlaceServiceImpl implements PlaceService{

	private PlaceDao placeDao = new PlaceDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();
	
	@Override
	public void addPlace(Admin admin, PlaceModel placeModel) {
		
		try {
		Admin adm = adminDao.getAdmin(admin.getaUsername(), admin.getaPassword());

		Place place = new Place();
		place.setPlaceName(placeModel.getPlaceName());
		place.setAdmin(admin);
		
		adm.addPlace(place);
		placeDao.add(place);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
