package mypackage.serviceimpl;

import mypackage.models.AdminLoginModel;
import mypackage.models.AdminModel;
import mypackage.dao.AdminDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.entities.Admin;
import mypackage.services.AdminService;

public class AdminServiceImpl implements AdminService{

	private AdminDao adminDao = new AdminDaoImpl();
	@Override
	public void register(AdminModel adminModel) {
		
		Admin admin = new Admin();
		admin.setaUsername(adminModel.getAusername());
		admin.setaPassword(adminModel.getApassword());
		adminDao.insert(admin);
		
	}

	@Override
	public Admin getAdmin(AdminLoginModel adminLoginModel) {
		
		return adminDao.getAdmin(adminLoginModel.getaUsername(), adminLoginModel.getaPassword());
	}
	
}
