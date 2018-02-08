package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void readDataBase() throws Exception {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/world?user=exjobb&password=1234");
			
			statement = connect.createStatement();
		
			
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	
	}
	
	
	
	
	
	
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}
	
} 