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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

	public class MySQLAccess 
	{
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;

	public void readDataBase()
	{
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
			preparedStatement = connect.prepareStatement("insert into exjobb.kundlista values (?,?)");
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
	
	public boolean NewMaskin(int kundnr, int nr, String maskin, int pristime)
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
	
	public boolean NewKonsult(int kundnr, int nr, String tjanst, int pristime) 
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
		
	public void MaskinList(JList nr, JList maskin,JList pris, int kundnr)
	{
		try
		{
			preparedStatement = connect.prepareStatement("select NR, Maskin,PrisTime from exjobb.prislistamaskin where ID=?");
			preparedStatement.setInt(1, kundnr);
			ResultSet resultSet = preparedStatement.executeQuery();
			WriteMaskinList(resultSet, nr,maskin,pris);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void KonsultLista(JList nr, JList tjanst,JList pristime, int kundnr)
	{
		try
		{
			preparedStatement = connect.prepareStatement("select NR, Tjänst,PrisTime from exjobb.prislistakonsult where ID=?");
			preparedStatement.setInt(1, kundnr);
			ResultSet resultSet = preparedStatement.executeQuery();
			WriteKonsultList(resultSet, nr,tjanst,pristime);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void WriteMaskinList(ResultSet resultSet, JList nr, JList maskin , JList pris) throws SQLException {
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
	
	public void WriteKonsultList(ResultSet resultSet, JList nr, JList tjanst, JList pristime)throws SQLException {
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
	
	public void GetProsent(JTextField MO, JTextField LO, JTextField Affo,JTextField Vinst, int kundnr) 
	{
		try
		{
			preparedStatement = connect.prepareStatement("select mo,lo,affo,vinst from exjobb.prosentlista where ID=? ");
			preparedStatement.setInt(1, kundnr);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) 
			{
				
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
	
	public void ChangeMaskin(int kundnr, String maskin, int pris, int nr)
	{
		try
		{
			preparedStatement = connect.prepareStatement("Update exjobb.prislistamaskin SET Maskin = ?, PrisTime = ? WHERE ID= ? and NR = ?");
			preparedStatement.setInt(3, kundnr);
			preparedStatement.setString(1, maskin);
			preparedStatement.setInt(2, pris);
			preparedStatement.setInt(4, nr);
			preparedStatement.executeUpdate();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void ChangeKonsult(int kundnr, String tjenst, int pris, int nr) 
	{
		try
		{
			preparedStatement = connect.prepareStatement("Update exjobb.prislistakonsult SET Tjänst = ?, PrisTime = ? WHERE ID= ? and NR = ?");
			preparedStatement.setInt(3, kundnr);
			preparedStatement.setString(1, tjenst);
			preparedStatement.setInt(2, pris);
			preparedStatement.setInt(4, nr);
			preparedStatement.executeUpdate();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void ChangeProcent(int kundnr, int mo, int lo, int affo, int vinst)
	{
		try
		{
			preparedStatement = connect.prepareStatement("Update exjobb.prosentlista SET MO = ?, LO = ?, Affo = ?, Vinst = ? WHERE ID= ?");
			preparedStatement.setInt(5, kundnr);
			preparedStatement.setInt(1, mo);
			preparedStatement.setInt(2, lo);
			preparedStatement.setInt(3, affo);
			preparedStatement.setInt(4, vinst);
			preparedStatement.executeUpdate();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void DeliteMaskin(int kundnr, String nr)
	{
		try
		{
			preparedStatement = connect.prepareStatement("delete from exjobb.prislistamaskin where ID= ? and NR =?");
			preparedStatement.setInt(1, kundnr);
			preparedStatement.setString(2, nr);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void DeliteKonsult(int kundnr, String nr)
	{
		try
		{
			preparedStatement = connect.prepareStatement("delete from exjobb.prislistakonsult where ID= ? and NR =?");
			preparedStatement.setInt(1, kundnr);
			preparedStatement.setString(2, nr);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void RetriveKund(JComboBox<String> comboBoxForetag, int kundnr ) 
	{
		try
		{
			preparedStatement = connect.prepareStatement("select Kundnamn from exjobb.kundlista where ID = ?");
			preparedStatement.setInt(1, kundnr);
			ResultSet resultSet = preparedStatement.executeQuery();
			Test(resultSet, comboBoxForetag);	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void RetriveKundejnr(JComboBox<String> comboBoxForetag) {
		try
		{
			resultSet = statement.executeQuery("select Kundnamn from exjobb.kundlista");
			Test(resultSet, comboBoxForetag);
				
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void Test(ResultSet resultSet,JComboBox<String> comboBoxForetag) throws SQLException
	{
		DefaultComboBoxModel<String> Combox = new DefaultComboBoxModel<String>();
		while (resultSet.next())
		{	
			String Företag = resultSet.getString("Kundnamn");
			Combox.addElement(Företag); 	
		}
		comboBoxForetag.setModel(Combox);
	}
	
	public void RetriveKundNr(String kund, JTextField ID) 
	{
		try
		{
			preparedStatement = connect.prepareStatement("select ID from exjobb.kundlista where Kundnamn= ?");
			preparedStatement.setString(1, kund);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) 
			{
				String id = resultSet.getString("ID");	
				ID.setText(id);
			}		
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void DeliteKund(String kund, int kundnr) 
	{
		try
		{
			preparedStatement = connect.prepareStatement("delete from exjobb.kundlista where (ID= ? and Kundnamn =?)");
			preparedStatement.setInt(1, kundnr);
			preparedStatement.setString(2, kund);
			preparedStatement.executeUpdate();
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
	
