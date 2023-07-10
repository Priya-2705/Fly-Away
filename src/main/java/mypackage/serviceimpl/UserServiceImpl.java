package mypackage.serviceimpl;

import mypackage.dao.UserDao;
import mypackage.daoimpl.UserDaoImpl;
import mypackage.entities.User;
import mypackage.models.UserLoginModel;
import mypackage.models.UserModel;
import mypackage.services.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();
	@Override
	public void register(UserModel userModel) {
		
		User user = new User();
		user.setuUsername(userModel.getuUsername());
		user.setuPassword(userModel.getuPassword());
		userDao.insert(user);		
	}

	@Override
	public User getUser(UserLoginModel userLoginModel) {
		
		return userDao.getUser(userLoginModel.getuUsername(), userLoginModel.getuPassword());
	}

}
