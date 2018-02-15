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
	
	public boolean nytjanst(int kundnr, int nr, String tjanst, int pristime) 
	{
		try
		{	
			preparedStatement = connect.prepareStatement("insert into exjobb.prislistakonsult values (?,?,?,?)");
			preparedStatement.setInt(1, kundnr);
			preparedStatement.setInt(2, nr);
			preparedStatement.setString(3, tjanst);
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
			preparedStatement = connect.prepareStatement("select NR, Maskin,PrisTime from exjobb.prislistamaskin where ID=?");
			preparedStatement.setInt(1, kundnr);
			ResultSet resultSet = preparedStatement.executeQuery();
			writeMaskinList(resultSet, nr,maskin,pris);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void Tjanstlista(JList nr, JList tjanst,JList pristime, int kundnr)
	{
		try
		{
			preparedStatement = connect.prepareStatement("select NR, Tjänst,PrisTime from exjobb.prislistakonsult where ID=?");
			preparedStatement.setInt(1, kundnr);
			ResultSet resultSet = preparedStatement.executeQuery();
			writeTjanstList(resultSet, nr,tjanst,pristime);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void writeMaskinList(ResultSet resultSet, JList nr, JList maskin , JList pris) throws SQLException {
		DefaultListModel<String> listNRM = new DefaultListModel<String>();
		DefaultListModel<String> listMaskin = new DefaultListModel<String>();
		DefaultListModel<String> listPris = new DefaultListModel<String>();
		while (resultSet.next()) {
			
			String NR = resultSet.getString("NR");
			String Maskin = resultSet.getString("Maskin");
			String PrisTime = resultSet.getString("PrisTime");
			
			listNRM.addElement(NR); 
			listMaskin.addElement(Maskin);
			listPris.addElement(PrisTime);
			
		}
		nr.setModel(listNRM);
		maskin.setModel(listMaskin);
		pris.setModel(listPris);
		
	}
	
	private void writeTjanstList(ResultSet resultSet, JList nr, JList tjanst, JList pristime)throws SQLException {
		DefaultListModel<String> listNRT = new DefaultListModel<String>();
		DefaultListModel<String> listTjanst = new DefaultListModel<String>();
		DefaultListModel<String> listPrisTid = new DefaultListModel<String>();
		while (resultSet.next()) {
			
			String NR = resultSet.getString("NR");
			String Tjänst = resultSet.getString("Tjänst");
			String PrisTime = resultSet.getString("PrisTime");
			
			listNRT.addElement(NR); 
			listTjanst.addElement(Tjänst);
			listPrisTid.addElement(PrisTime);
			
		}
		nr.setModel(listNRT);
		tjanst.setModel(listTjanst);
		pristime.setModel(listPrisTid);

	}
	
	public void getprosent(JTextField MO, JTextField LO, JTextField Affo,JTextField Vinst, int kundnr) 
	{
		try
		{
			preparedStatement = connect.prepareStatement("select mo,lo,affo,vinst from exjobb.prosentlista where ID=? ");
			preparedStatement.setInt(1, kundnr);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				String mo = resultSet.getString("MO");
				String lo = resultSet.getString("LO");
				String affo = resultSet.getString("Affo");
				String vinst = resultSet.getString("Vinst"); 
				
				MO.setText(mo);
				LO.setText(lo);
				Affo.setText(affo);
				Vinst.setText(vinst);
				
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
	}
	

	
	
	
	private void close() 
	{
		try 
		{
			if (resultSet != null) 
			{
				resultSet.close();
			}

			if (statement != null) 
			{
				statement.close();
			}

			if (connect != null)
			{
				connect.close();
			}
		} catch (Exception e) 
		{
		}
	}

	
	}
	
