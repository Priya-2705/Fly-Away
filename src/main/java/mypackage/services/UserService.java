package mypackage.services;

import mypackage.entities.User;
import mypackage.models.UserLoginModel;
import mypackage.models.UserModel;

public interface UserService {
	
	void register(UserModel userModel);
	User getUser(UserLoginModel userLoginModel);
}
