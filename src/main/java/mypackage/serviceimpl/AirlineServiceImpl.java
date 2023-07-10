package mypackage.serviceimpl;

import mypackage.dao.AdminDao;
import mypackage.dao.AirlineDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.daoimpl.AirlineDaoImpl;
import mypackage.entities.Admin;
import mypackage.entities.Airline;
import mypackage.models.AirlineModel;
import mypackage.services.AirlineService;

public class AirlineServiceImpl implements AirlineService{

	private AirlineDao airlineDao = new AirlineDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();
	
	@Override
	public void addAirline(Admin admin, AirlineModel airlineModel) {
		
		try {
		Admin adm = adminDao.getAdmin(admin.getaUsername(), admin.getaPassword());
		
		Airline airline = new Airline();
		airline.setAirlineName(airlineModel.getAirlineName());
		airline.setAdmin(admin);
		
		adm.addAirline(airline);
		airlineDao.add(airline);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
