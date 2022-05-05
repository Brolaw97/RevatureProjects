package service;

import model.ErsUsers;

public interface UserService {

	public ErsUsers selectUserByCredentials(String username, String password);
}
