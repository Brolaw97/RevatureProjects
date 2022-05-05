package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.ErsUsers;

public class UserServiceImpl implements UserService {

	UserDao myDao = new UserDaoImpl();
	@Override
	public ErsUsers selectUserByCredentials(String username, String password) {
		return myDao.selectUserByCredentials(username, password);
	}

}
