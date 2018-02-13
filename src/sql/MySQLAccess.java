package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JList;

import org.apache.poi.ss.usermodel.Cell;

import javax.swing.DefaultListModel;





public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	public void readDataBase() {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/exjobb?user=root&password=1234");
			
			statement = connect.createStatement();
			
		}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	
	public boolean NyKund(String NyKund, int kundnr)
	{
		try
		{			
			preparedStatement = connect.prepareStatement("insert into exjobb.kundlista values (?, ?)");
			preparedStatement.setInt(1, kundnr);
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
	
	
	public boolean Procent(int kundnr, int mo, int lo, int affo, int vinst)
	{
		try
		{			
			preparedStatement = connect.prepareStatement("insert into exjobb.prosentlista values (?,?,?,?,?)");
			preparedStatement.setInt(1, kundnr);
			preparedStatement.setInt(2, mo);
			preparedStatement.setInt(3, lo);
			preparedStatement.setInt(4, affo);
			preparedStatement.setInt(5, vinst);
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