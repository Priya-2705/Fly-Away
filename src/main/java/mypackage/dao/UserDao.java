package mypackage.dao;

import mypackage.entities.User;

public interface UserDao {
	
	void insert(User user);
	void update(User user);
	User getUser(String uUsername, String uPassword);
}
