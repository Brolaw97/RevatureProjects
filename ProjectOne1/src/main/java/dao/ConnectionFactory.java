package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static { // for the connection
        try {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Static block has failed me");
        }
    }

	public static String url = "jdbc:postgresql://mydatabase.cdzgon3wur5c.us-east-1.rds.amazonaws.com:5432/projectone";
	public static String username = System.getenv("Training_DB_Username");
	public static String password = System.getenv("Training_DB_Password");
	
	
	
	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(url, username, password);

	}

	
	
}
