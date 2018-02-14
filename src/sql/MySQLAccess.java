package sql;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeCellEditor.DefaultTextField;
import javax.xml.soap.Text;

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
	
	public boolean nymaskin(int kundnr, int nr, String maskin, int pristime)
	{
		try
		{			
			preparedStatement = connect.prepareStatement("insert into exjobb.prislistamaskin values (?,?,?,?)");
			preparedStatement.setInt(1, kundnr);
			preparedStatement.setInt(2, nr);
			preparedStatement.setString(3, maskin);
			preparedStatement.setInt(4, pristime);
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

	public void Maskinlist(JList nr, JList maskin,JList pris, int kundnr)
	{
		try
		{
			resultSet = statement.executeQuery("select NR, Maskin,PrisTime from exjobb.prosentlista where ID=?");
			preparedStatement.setInt(1, kundnr);
			writeMaskinList(resultSet, nr,maskin,pris);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private void writeMaskinList(ResultSet resultSet, JList nr, JList maskin , JList pris) throws SQLException {
		DefaultListModel<String> listNRM = new DefaultListModel<String>();
		DefaultListModel<String> listMaskin = new DefaultListModel<String>();
		DefaultListModel<String> listPris = new DefaultListModel<String>();
		while (resultSet.next()) {
			
			String NR = resultSet.getString("NR");
			String Maskin = resultSet.getString("Maskin");
			String Pris = resultSet.getString("Pris");
			
			listNRM.addElement(NR); 
			listMaskin.addElement(Maskin);
			listPris.addElement(Pris);
			
		}
		nr.setModel(listNRM);
		maskin.setModel(listMaskin);
		pris.setModel(listPris);
		
	}
	
	public void getprosent(JTextField MO, JTextField LO, JTextField Affo,JTextField Vinst, int kundnr) 
	{
		try
		{
			resultSet = statement.executeQuery("select mo,lo,affo,vinst from exjobb.prosent where ID=? ");
			preparedStatement.setInt(1, kundnr);
			preparedStatement.executeUpdate();
			String mo = resultSet.getString("MO");
			MO.setText(mo);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
	}
	

	//private void writeProcent(ResultSet resultSet, JTextField MO, JTextField LO,JTextField Affo,JTextField Vinst) throws SQLException {
		/*
		while (resultSet.next()) {
			
			String mo = resultSet.getString("MO");
			String lo = resultSet.getString("LO");
			String affo = resultSet.getString("Affo");
			String vinst = resultSet.getString("Vinst");
			
			MO.setText(mo);
			LO.setText(lo);
			Affo.setText(affo);
			Vinst.setText(vinst);
			
		*/
	//}

	
	
	
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
	
