package mypackage.dao;

import mypackage.entities.Admin;

public interface AdminDao {
	
	void insert(Admin admin);
	void update(Admin admin);
	Admin getAdmin(String aUsername, String aPassword);
}
