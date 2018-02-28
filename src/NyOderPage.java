import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql.MySQLAccess;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class NyOderPage extends JFrame 
{
	
	private JPanel contentPane;
	private JFrame frame;
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
	private JTextField textDate;
	private JTextField textTotalAmount;
	private JTextField textOverTime;
	private JTextField textProcent;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textShipmentCost;
	private JTextField textField_20;
	
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
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Kundens namn");
		lblName.setBounds(10, 11, 100, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(319, 8, 80, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKundensNumer = new JLabel("Kundens Numer");
		lblKundensNumer.setBounds(229, 11, 80, 14);
		contentPane.add(lblKundensNumer);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1187, 8, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(1141, 11, 46, 14);
		contentPane.add(lblDatum);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 39, 95, 20);
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
		textField_8.setBounds(995, 8, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnImport = new JButton("Import");
		btnImport.setBounds(995, 38, 89, 23);
		contentPane.add(btnImport);
		
		JButton btnPrint = new JButton("Skriv ut");
		btnPrint.setBounds(1171, 625, 89, 23);
		contentPane.add(btnPrint);
		
		textDate = new JTextField();
		textDate.setBounds(1174, 507, 86, 20);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		JLabel lblDatum_1 = new JLabel("Datum");
		lblDatum_1.setBounds(1087, 510, 46, 14);
		contentPane.add(lblDatum_1);
		
		JLabel lblTotalaSumman = new JLabel("Totala summan");
		lblTotalaSumman.setBounds(1087, 476, 100, 14);
		contentPane.add(lblTotalaSumman);
		
		textTotalAmount = new JTextField();
		textTotalAmount.setBounds(1174, 476, 86, 20);
		contentPane.add(textTotalAmount);
		textTotalAmount.setColumns(10);
		
		JLabel lblvertidsTilgg = new JLabel("\u00D6vertids till\u00E4gg");
		lblvertidsTilgg.setBounds(774, 476, 100, 14);
		contentPane.add(lblvertidsTilgg);
		
		textOverTime = new JTextField();
		textOverTime.setBounds(774, 491, 46, 20);
		contentPane.add(textOverTime);
		textOverTime.setColumns(10);
		
		textProcent = new JTextField();
		textProcent.setBounds(820, 491, 46, 20);
		contentPane.add(textProcent);
		textProcent.setColumns(10);
		
		JLabel lblTid = new JLabel("Tid");
		lblTid.setBounds(757, 494, 20, 14);
		contentPane.add(lblTid);
		
		JLabel label = new JLabel("%");
		label.setBounds(866, 494, 20, 14);
		contentPane.add(label);
		
		JLabel lblMatrial = new JLabel("Matrial");
		lblMatrial.setBounds(186, 476, 46, 14);
		contentPane.add(lblMatrial);
		
		textField_13 = new JTextField();
		textField_13.setBounds(99, 8, 120, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		JList list = new JList();
		list.setBounds(55, 493, 86, 122);
		contentPane.add(list);
		
		textField_14 = new JTextField();
		textField_14.setBounds(186, 626, 86, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblSumma = new JLabel("Summa");
		lblSumma.setBounds(141, 629, 46, 14);
		contentPane.add(lblSumma);
		
		textField_15 = new JTextField();
		textField_15.setBounds(55, 626, 86, 20);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblSumma_1 = new JLabel("Summa");
		lblSumma_1.setBounds(10, 629, 46, 14);
		contentPane.add(lblSumma_1);
		
		JButton btnSave = new JButton("Spara");
		btnSave.setBounds(1171, 595, 89, 23);
		contentPane.add(btnSave);
		
		JList list_2 = new JList();
		list_2.setBounds(186, 493, 86, 122);
		contentPane.add(list_2);
		
		JCheckBox chckbxMoms = new JCheckBox("Moms");
		chckbxMoms.setBounds(1021, 472, 60, 23);
		contentPane.add(chckbxMoms);
		
		JLabel lblNewLabel = new JLabel("Maskin kostnad");
		lblNewLabel.setBounds(55, 476, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSumma_2 = new JLabel("Summa");
		lblSumma_2.setBounds(272, 629, 46, 14);
		contentPane.add(lblSumma_2);
		
		textField_16 = new JTextField();
		textField_16.setBounds(317, 626, 86, 20);
		contentPane.add(textField_16);
		textField_16.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setBounds(317, 493, 86, 122);
		contentPane.add(list_1);
		
		JLabel lblEraKostnader = new JLabel("Era Kostnader");
		lblEraKostnader.setBounds(317, 476, 86, 14);
		contentPane.add(lblEraKostnader);
		
		JList list_3 = new JList();
		list_3.setBounds(448, 493, 40, 122);
		contentPane.add(list_3);
		
		textField_17 = new JTextField();
		textField_17.setBounds(448, 626, 40, 20);
		contentPane.add(textField_17);
		textField_17.setColumns(10);
		
		JLabel lblSumma_3 = new JLabel("Summa");
		lblSumma_3.setBounds(403, 629, 46, 14);
		contentPane.add(lblSumma_3);
		
		JLabel lblNewLabel_1 = new JLabel("St\u00E4ll tid");
		lblNewLabel_1.setBounds(448, 476, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSumma_4 = new JLabel("Summa");
		lblSumma_4.setBounds(488, 629, 46, 14);
		contentPane.add(lblSumma_4);
		
		textField_18 = new JTextField();
		textField_18.setBounds(532, 626, 40, 20);
		contentPane.add(textField_18);
		textField_18.setColumns(10);
		
		JList list_4 = new JList();
		list_4.setBounds(533, 493, 40, 122);
		contentPane.add(list_4);
		
		JLabel lblMaskinTid = new JLabel("Maskin tid");
		lblMaskinTid.setBounds(532, 476, 60, 14);
		contentPane.add(lblMaskinTid);
		
		JLabel lblTotalaTid = new JLabel("Totala tid");
		lblTotalaTid.setBounds(572, 629, 56, 14);
		contentPane.add(lblTotalaTid);
		
		JLabel lblFrakt = new JLabel("Frakt kostnad");
		lblFrakt.setBounds(668, 476, 80, 14);
		contentPane.add(lblFrakt);
		
		textShipmentCost = new JTextField();
		textShipmentCost.setBounds(668, 491, 86, 20);
		contentPane.add(textShipmentCost);
		textShipmentCost.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Summa");
		lblNewLabel_2.setBounds(623, 494, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNummer = new JLabel("Nummer");
		lblNummer.setBounds(10, 85, 50, 14);
		contentPane.add(lblNummer);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(60, 82, 55, 20);
		contentPane.add(comboBox);
		
		JLabel lblMaskin = new JLabel("Maskin");
		lblMaskin.setBounds(124, 85, 46, 14);
		contentPane.add(lblMaskin);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(180, 82, 120, 20);
		contentPane.add(comboBox_1);
		
		JPanel panelMaskin = new JPanel();
		panelMaskin.setBounds(10, 127, 784, 65);
		contentPane.add(panelMaskin);
		panelMaskin.setLayout(new GridLayout(1, 0, 0, 0));
		
		JList list_10 = new JList();
		panelMaskin.add(list_10);
		
		JList list_9 = new JList();
		panelMaskin.add(list_9);
		
		JList list_8 = new JList();
		panelMaskin.add(list_8);
		
		JList list_7 = new JList();
		panelMaskin.add(list_7);
		
		JList list_6 = new JList();
		panelMaskin.add(list_6);
		
		JList list_5 = new JList();
		panelMaskin.add(list_5);
		
		JButton btnLggtill = new JButton("L\u00E4ggtill");
		btnLggtill.setBounds(314, 81, 89, 23);
		contentPane.add(btnLggtill);
		
		JLabel lblNummer_1 = new JLabel("Nummer");
		lblNummer_1.setBounds(10, 110, 50, 14);
		contentPane.add(lblNummer_1);
		
		JLabel lblMaskin_1 = new JLabel("Maskin");
		lblMaskin_1.setBounds(141, 110, 46, 14);
		contentPane.add(lblMaskin_1);
		
		JLabel lblPris = new JLabel("Pris");
		lblPris.setBounds(272, 113, 46, 14);
		contentPane.add(lblPris);
		
		JLabel lblStlTid = new JLabel("St\u00E4l tid");
		lblStlTid.setBounds(403, 110, 46, 14);
		contentPane.add(lblStlTid);
		
		JLabel lblTid_1 = new JLabel("Tid");
		lblTid_1.setBounds(532, 110, 46, 14);
		contentPane.add(lblTid_1);
		
		JLabel lblPrisOprationStycket = new JLabel("Pris Opration Stycket");
		lblPrisOprationStycket.setBounds(668, 110, 130, 14);
		contentPane.add(lblPrisOprationStycket);
		
		JLabel lblNewLabel_3 = new JLabel("Mattrial");
		lblNewLabel_3.setBounds(10, 203, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnLggtill_1 = new JButton("L\u00E4ggtill");
		btnLggtill_1.setBounds(66, 199, 89, 23);
		contentPane.add(btnLggtill_1);
		
		JPanel panelMattrial = new JPanel();
		panelMattrial.setBounds(10, 248, 784, 65);
		contentPane.add(panelMattrial);
		panelMattrial.setLayout(new GridLayout(1, 0, 0, 0));
		
		JList list_17 = new JList();
		panelMattrial.add(list_17);
		
		JList list_11 = new JList();
		panelMattrial.add(list_11);
		
		JList list_12 = new JList();
		panelMattrial.add(list_12);
		
		JList list_13 = new JList();
		panelMattrial.add(list_13);
		
		JList list_14 = new JList();
		panelMattrial.add(list_14);
		
		JList list_15 = new JList();
		panelMattrial.add(list_15);
		
		JList list_16 = new JList();
		panelMattrial.add(list_16);
		
		JLabel lblMatrial_1 = new JLabel("Matrial");
		lblMatrial_1.setBounds(10, 228, 46, 14);
		contentPane.add(lblMatrial_1);
		
		JLabel lblPrisMatrigalenhet = new JLabel("Pris / matrigalenhet");
		lblPrisMatrigalenhet.setBounds(124, 228, 100, 14);
		contentPane.add(lblPrisMatrigalenhet);
		
		JLabel lblMngd = new JLabel("M\u00E4ngd");
		lblMngd.setBounds(234, 228, 46, 14);
		contentPane.add(lblMngd);
		
		JLabel lblMo_1 = new JLabel("MO");
		lblMo_1.setBounds(348, 228, 46, 14);
		contentPane.add(lblMo_1);
		
		JLabel lblVinst_1 = new JLabel("Vinst");
		lblVinst_1.setBounds(572, 228, 46, 14);
		contentPane.add(lblVinst_1);
		
		JLabel lblNewLabel_4 = new JLabel("Affo");
		lblNewLabel_4.setBounds(460, 228, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblPris_1 = new JLabel("Pris");
		lblPris_1.setBounds(680, 228, 46, 14);
		contentPane.add(lblPris_1);
		
		JButton btnOverTimeShipmentCost = new JButton("L\u00E4ggtill");
		btnOverTimeShipmentCost.setBounds(668, 517, 89, 23);
		contentPane.add(btnOverTimeShipmentCost);
		
		JButton btnAddOverTime = new JButton("L\u00E4ggtill");
		btnAddOverTime.setBounds(775, 517, 89, 23);
		contentPane.add(btnAddOverTime);
		
		textField_20 = new JTextField();
		textField_20.setBounds(623, 628, 86, 20);
		contentPane.add(textField_20);
		textField_20.setColumns(10);
		
		JPanel panelKostnader = new JPanel();
		panelKostnader.setBounds(10, 374, 784, 65);
		contentPane.add(panelKostnader);
		panelKostnader.setLayout(new GridLayout(1, 0, 0, 0));
		
		JList list_18 = new JList();
		panelKostnader.add(list_18);
		
		JList list_19 = new JList();
		panelKostnader.add(list_19);
		
		JList list_20 = new JList();
		panelKostnader.add(list_20);
		
		JList list_21 = new JList();
		panelKostnader.add(list_21);
		
		JList list_22 = new JList();
		panelKostnader.add(list_22);
		
		JLabel lblNewLabel_5 = new JLabel("Era kostnader");
		lblNewLabel_5.setBounds(10, 324, 80, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblPris_2 = new JLabel("Kostnad");
		lblPris_2.setBounds(10, 349, 46, 14);
		contentPane.add(lblPris_2);
		
		JButton btnLggtill_3 = new JButton("L\u00E4ggtill");
		btnLggtill_3.setBounds(98, 320, 89, 23);
		contentPane.add(btnLggtill_3);
		
		JLabel lblLo_1 = new JLabel("LO");
		lblLo_1.setBounds(162, 354, 46, 14);
		contentPane.add(lblLo_1);
		
		JLabel lblAffo_1 = new JLabel("Affo");
		lblAffo_1.setBounds(323, 354, 46, 14);
		contentPane.add(lblAffo_1);
		
		JLabel lblVinst_2 = new JLabel("Vinst");
		lblVinst_2.setBounds(476, 354, 46, 14);
		contentPane.add(lblVinst_2);
		
		JLabel lblPris_3 = new JLabel("Pris");
		lblPris_3.setBounds(636, 354, 46, 14);
		contentPane.add(lblPris_3);

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
