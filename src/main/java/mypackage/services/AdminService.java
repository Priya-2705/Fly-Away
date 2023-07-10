package mypackage.services;

import mypackage.entities.Admin;
import mypackage.models.AdminLoginModel;
import mypackage.models.AdminModel;

public interface AdminService {
	
	void register(AdminModel adminModel);
	Admin getAdmin(AdminLoginModel adminLoginModel);
}
