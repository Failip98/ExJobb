package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JList;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	public void readDataBase() throws Exception {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/exjobb?user=root&password=");
			
			statement = connect.createStatement();
		
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	
	}
	
	public boolean NyKund(String NyKund, String NyNR)
	{
		try
		{			
			preparedStatement = connect.prepareStatement("insert into exjobb.kundlista values (?, ?)");
			preparedStatement.setString(1, NyNR);
			preparedStatement.setString(2, NyKund);
			preparedStatement.executeUpdate();
			
		}
		catch (SQLException e)
		{
			if (e.getErrorCode() == 1062)
			{
				return true;
			}
			return false;
		}
		
		return true;
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