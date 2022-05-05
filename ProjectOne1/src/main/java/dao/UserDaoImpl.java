package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ErsUsers;
/**
 * All of the background logic that deals with the user.
 * Just a log in method/ creates a user object.
 * 
 * @author brody
 *
 */
public class UserDaoImpl implements UserDao {

		public ErsUsers selectUserByCredentials(String username, String password){
		ErsUsers currentUser = null;
		try (Connection connect = ConnectionFactory.getConnection()) {
			ResultSet rs = null;
			PreparedStatement ps = null;

			String sql = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password =?";

			ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				currentUser = new ErsUsers(rs.getString("ers_username"), rs.getString("ers_password"), /* Next Line */
						rs.getInt("ers_user_id"), rs.getInt("user_role_id"));
				
				//System.out.println(currentUser.toString());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (currentUser != null) {
			return currentUser;
		}

		return null;

	}

}
