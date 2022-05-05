package dao;

import model.ErsUsers;

public interface UserDao {

	public ErsUsers selectUserByCredentials(String username, String password);
}
