package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErsUsers {

	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int roleId;
	
	public ErsUsers(String username, String password, int userId, int roleId) {
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.roleId = roleId;
	}
	public ErsUsers(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
}
