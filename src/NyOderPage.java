import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql.MySQLAccess;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class NyOderPage extends JFrame 
{
	
	private JPanel contentPane;
	
	static MySQLAccess db = new MySQLAccess();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					NyOderPage frame = new NyOderPage();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public NyOderPage() 
	{
		initialize();
		try 
		{
			db.readDataBase();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
	}


	private void initialize() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 820, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Kundens namn");
		lblName.setBounds(10, 11, 100, 14);
		contentPane.add(lblName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(110, 8, 100, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(340, 8, 80, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKundensNumer = new JLabel("Kundens Numer");
		lblKundensNumer.setBounds(229, 11, 100, 14);
		contentPane.add(lblKundensNumer);
		
		textField_1 = new JTextField();
		textField_1.setBounds(708, 8, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(652, 11, 46, 14);
		contentPane.add(lblDatum);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 39, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblVadSkaTillverkas = new JLabel("Vad ska Tillverkas");
		lblVadSkaTillverkas.setBounds(10, 42, 120, 14);
		contentPane.add(lblVadSkaTillverkas);
		
		JLabel lblAntal = new JLabel("Antal");
		lblAntal.setBounds(229, 42, 46, 14);
		contentPane.add(lblAntal);
		
		textField_3 = new JTextField();
		textField_3.setBounds(283, 39, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(764, 39, 30, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblVinst = new JLabel("Vinst");
		lblVinst.setBounds(718, 42, 46, 14);
		contentPane.add(lblVinst);
		
		textField_5 = new JTextField();
		textField_5.setBounds(668, 39, 30, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblAffo = new JLabel("Affo");
		lblAffo.setBounds(628, 42, 30, 14);
		contentPane.add(lblAffo);
		
		textField_6 = new JTextField();
		textField_6.setBounds(572, 39, 30, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblLo = new JLabel("LO");
		lblLo.setBounds(532, 42, 30, 14);
		contentPane.add(lblLo);
		
		textField_7 = new JTextField();
		textField_7.setBounds(476, 39, 30, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblMo = new JLabel("MO");
		lblMo.setBounds(436, 42, 30, 14);
		contentPane.add(lblMo);
		
		textField_8 = new JTextField();
		textField_8.setBounds(532, 8, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnImport = new JButton("Import");
		btnImport.setBounds(433, 7, 89, 23);
		contentPane.add(btnImport);
		
		JButton btnSkrivUt = new JButton("Skriv ut");
		btnSkrivUt.setBounds(705, 527, 89, 23);
		contentPane.add(btnSkrivUt);
		
		textField_9 = new JTextField();
		textField_9.setBounds(708, 496, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblDatum_1 = new JLabel("Datum");
		lblDatum_1.setBounds(652, 499, 46, 14);
		contentPane.add(lblDatum_1);
		
		JLabel lblTotalaSumman = new JLabel("Totala summan");
		lblTotalaSumman.setBounds(628, 471, 120, 14);
		contentPane.add(lblTotalaSumman);
		
		textField_10 = new JTextField();
		textField_10.setBounds(708, 465, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JRadioButton rdbtnMoms = new JRadioButton("Moms");
		rdbtnMoms.setBounds(558, 467, 60, 23);
		contentPane.add(rdbtnMoms);
		
		JLabel lblvertidsTilgg = new JLabel("\u00D6vertids til\u00E4gg");
		lblvertidsTilgg.setBounds(436, 471, 120, 14);
		contentPane.add(lblvertidsTilgg);
		
		textField_11 = new JTextField();
		textField_11.setBounds(521, 496, 30, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(476, 496, 30, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblTid = new JLabel("Tid");
		lblTid.setBounds(436, 499, 30, 14);
		contentPane.add(lblTid);
		
		JLabel label = new JLabel("%");
		label.setBounds(556, 499, 46, 14);
		contentPane.add(label);

		buttons();
		textfelds();
		label();
	}

	private void buttons() {
		// TODO Auto-generated method stub
		
	}

	private void label() {
		// TODO Auto-generated method stub
		
	}

	private void textfelds() {
		// TODO Auto-generated method stub
		
	}
	

}
