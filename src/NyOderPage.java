import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql.MySQLAccess;

import javax.swing.DefaultListModel;
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
import java.awt.TextField;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class NyOderPage extends JFrame 
{
	
	private JPanel contentPane;
	private JFrame frame;
	
	
	String startWalue = "0";
	String startAmount = "1";
	String startMo = "10";
	String startLo = "25";
	String startAffo = "20";
	String startVinst = "25";
	
	JPanel panelMaskin;
	JPanel panelMattrial;
	JPanel panelKostnader;
	
	JList listMchineNumber;
	JList listMachineMachine;
	JList listMachinePrice;
	JList listMachinePrepareTime;
	JList listMachineTime;
	JList listMachinePris;
	
	JList listMaterialMaterial;
	JList listMaterialPrisMaterialUnit;
	JList listMatirialAmount;
	JList listMaterialMo;
	JList listMaterialAffo;
	JList listMaterialVinst;
	JList listMaterialPris;
	
	DefaultListModel<String> MaterialMaterial = new DefaultListModel<String>();
	DefaultListModel<String> MaterialPrisMaterialUnit = new DefaultListModel<String>();
	DefaultListModel<String> MatirialAmount = new DefaultListModel<String>();
	DefaultListModel<String> MaterialMo = new DefaultListModel<String>();
	DefaultListModel<String> MaterialAffo = new DefaultListModel<String>();
	DefaultListModel<String> MaterialVinst = new DefaultListModel<String>();
	DefaultListModel<String> MaterialPris = new DefaultListModel<String>();
	
	JList listYourThing;
	JList listYourPrepareTime;
	JList listYourUnit;
	JList listYourLo;
	JList listYourAffo;
	JList listYourProfit;
	JList listYourPris;
	
	JList listCollectedMachineCost;
	JList listCollectedMaterialCost;
	JList listYourCollectedCost;
	JList listCollectedPrepareTime;		
	JList listCollectedMachineTime;
	
	JComboBox comboBoxMachine;
	JComboBox comboBoxNummber;
	
	
	
	private static JTextField textFieldDatum;
	private JTextField textProduce;
	private JTextField textAmount;
	private JTextField textVinst;
	private JTextField textAffo;
	private JTextField textLo;
	private JTextField textMo;
	private JTextField textImport;
	private static JTextField textDate;
	private JTextField textTotalAmount;
	private JTextField textOverTime;
	private JTextField textOverProcent;
	private JTextField textCostemerName;
	private JTextField textTotalMaterialCost;
	private JTextField textTotalMachineCost;
	private JTextField textYourTotalCost;
	private JTextField textTotalPrepareTime;
	private JTextField textTotalMachineTime;
	private JTextField textShippingCost;
	private JTextField textTotalTime;
	private JTextField textFieldUnitAmaunt;
	
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
		
		panelMaskin = new JPanel();
		panelMaskin.setBounds(10, 127, 784, 65);
		contentPane.add(panelMaskin);
		panelMaskin.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelMattrial = new JPanel();
		panelMattrial.setBounds(10, 248, 784, 65);
		contentPane.add(panelMattrial);
		panelMattrial.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelKostnader = new JPanel();
		panelKostnader.setBounds(10, 374, 784, 65);
		contentPane.add(panelKostnader);
		panelKostnader.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelMachineLists();
		panelMatrialLists();
		panelKostnader();
		otherLists();
		buttons();
		textfelds();
		label();
		comboboxes();
		
	}
	
	private void panelMachineLists() 
	{
		listMchineNumber = new JList();
		panelMaskin.add(listMchineNumber);
		
		listMachineMachine = new JList();
		panelMaskin.add(listMachineMachine);
		
		listMachinePrice = new JList();
		panelMaskin.add(listMachinePrice);
		
		listMachinePrepareTime = new JList();
		panelMaskin.add(listMachinePrepareTime);
		
		listMachineTime = new JList();
		panelMaskin.add(listMachineTime);
		
		listMachinePris = new JList();
		panelMaskin.add(listMachinePris);
	}

	private void panelMatrialLists()
	{
		listMaterialMaterial = new JList();
		listMaterialMaterial.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listMaterialMaterial.getSelectedIndex() == -1)
				{
			        //inget h�nder
				}
				else
				{
					SelectMatrialMatrial();
				}	
			}
		});
		panelMattrial.add(listMaterialMaterial);
		
		listMaterialPrisMaterialUnit = new JList();
		listMaterialMaterial.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listMaterialMaterial.getSelectedIndex() == -1)
				{
			        //inget h�nder
				}
				else
				{
					SelectMatirialAmount();
				}	
			}
		});
		panelMattrial.add(listMaterialPrisMaterialUnit);
		
		listMatirialAmount = new JList();
		listMaterialMaterial.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listMaterialMaterial.getSelectedIndex() == -1)
				{
			        //inget h�nder
				}
				else
				{
					SelectMaterialPrisMaterialUnit();
				}	
			}
		});
		panelMattrial.add(listMatirialAmount);
		
		listMaterialMo = new JList();
		listMaterialMaterial.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listMaterialMaterial.getSelectedIndex() == -1)
				{
			        //inget h�nder
				}
				else
				{
					SelectMaterialMo();
				}	
			}
		});
		panelMattrial.add(listMaterialMo);
		
		listMaterialAffo = new JList();
		listMaterialMaterial.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listMaterialMaterial.getSelectedIndex() == -1)
				{
			        //inget h�nder
				}
				else
				{
					SelectMaterialAffo();
				}	
			}
		});
		panelMattrial.add(listMaterialAffo);
		
		listMaterialVinst = new JList();
		listMaterialMaterial.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listMaterialMaterial.getSelectedIndex() == -1)
				{
			        //inget h�nder
				}
				else
				{
					SelectMaterialVinst();
				}	
			}
		});
		panelMattrial.add(listMaterialVinst);
		
		listMaterialPris = new JList();
		listMaterialMaterial.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listMaterialMaterial.getSelectedIndex() == -1)
				{
			        //inget h�nder
				}
				else
				{
					SelectMaterialPris();
				}	
			}
		});
		panelMattrial.add(listMaterialPris);
	}
	
	private void panelKostnader()
	{
		listYourThing = new JList();
		panelKostnader.add(listYourThing);
		
		JList listYourPrepareTime = new JList();
		panelKostnader.add(listYourPrepareTime);
		
		JList listYourUnit = new JList();
		panelKostnader.add(listYourUnit);
		
		JList listYourLo = new JList();
		panelKostnader.add(listYourLo);
		
		JList listYourAffo = new JList();
		panelKostnader.add(listYourAffo);
		
		JList listYourProfit = new JList();
		panelKostnader.add(listYourProfit);
		
		JList listYourPris = new JList();
		panelKostnader.add(listYourPris);
	}

	private void otherLists() 
	{
		listCollectedMachineCost = new JList();
		listCollectedMachineCost.setBounds(55, 493, 86, 122);
		contentPane.add(listCollectedMachineCost);
		
		listCollectedMaterialCost = new JList();
		listCollectedMaterialCost.setBounds(186, 493, 86, 122);
		contentPane.add(listCollectedMaterialCost);
		
		listYourCollectedCost = new JList();
		listYourCollectedCost.setBounds(317, 493, 86, 122);
		contentPane.add(listYourCollectedCost);
		
		listCollectedPrepareTime = new JList();
		listCollectedPrepareTime.setBounds(448, 493, 40, 122);
		contentPane.add(listCollectedPrepareTime);
			
		listCollectedMachineTime = new JList();
		listCollectedMachineTime.setBounds(533, 493, 40, 122);
		contentPane.add(listCollectedMachineTime);
	}
	
	private void buttons() 
	{
		JButton btnImport = new JButton("Import");
		btnImport.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				setDate();
				setStartProcentWalue();
				setStarWalue();
			}
		});
		btnImport.setBounds(995, 38, 89, 23);
		contentPane.add(btnImport);
		
		JButton btnPrint = new JButton("Skriv ut");
		btnPrint.setBounds(1171, 625, 89, 23);
		contentPane.add(btnPrint);
		
		JButton btnSave = new JButton("Spara");
		btnSave.setBounds(1171, 595, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnAddMachine = new JButton("L\u00E4ggtill");
		btnAddMachine.setBounds(335, 81, 89, 23);
		contentPane.add(btnAddMachine);
		
		JButton btnAddMaterel = new JButton("L\u00E4ggtill");
		btnAddMaterel.addMouseListener(new MouseAdapter() 
		{
			
			int listItem = 0;
			public void mouseClicked(MouseEvent e)
			{
				listItem++;
				AddMaterial(listItem);
			}
		});
		btnAddMaterel.setBounds(66, 199, 89, 23);
		contentPane.add(btnAddMaterel);

		JButton btnAddShippingCost = new JButton("L\u00E4ggtill");
		btnAddShippingCost.setBounds(668, 517, 89, 23);
		contentPane.add(btnAddShippingCost);
		
		JButton btnAddOverTime = new JButton("L\u00E4ggtill");
		btnAddOverTime.setBounds(775, 517, 89, 23);
		contentPane.add(btnAddOverTime);
		
		JButton btnAddToYourCost = new JButton("L\u00E4ggtill");
		btnAddToYourCost.setBounds(98, 320, 89, 23);
		contentPane.add(btnAddToYourCost);
	}

	private void label() 
	{
		JLabel lblYourLo = new JLabel("LO");
		lblYourLo.setBounds(348, 354, 46, 14);
		contentPane.add(lblYourLo);
		
		JLabel lblAffo_1 = new JLabel("Affo");
		lblAffo_1.setBounds(460, 354, 46, 14);
		contentPane.add(lblAffo_1);
		
		JLabel lblYourProfit = new JLabel("Vinst");
		lblYourProfit.setBounds(572, 354, 46, 14);
		contentPane.add(lblYourProfit);
		
		JLabel lblYourPris = new JLabel("Pris stycket");
		lblYourPris.setBounds(680, 354, 68, 14);
		contentPane.add(lblYourPris);
		
		JLabel lblStPris = new JLabel("St pris ");
		lblStPris.setBounds(234, 354, 46, 14);
		contentPane.add(lblStPris);
		
		JLabel lblInkptTjnst = new JLabel("Ink\u00F6pt tj\u00E4nst");
		lblInkptTjnst.setBounds(10, 354, 80, 14);
		contentPane.add(lblInkptTjnst);
		
		JLabel lblUnitAmaunt = new JLabel("Syck summan ex moms");
		lblUnitAmaunt.setBounds(1020, 451, 150, 14);
		contentPane.add(lblUnitAmaunt);
		
		JLabel lblNewYourCost = new JLabel("Era kostnader");
		lblNewYourCost.setBounds(10, 324, 80, 14);
		contentPane.add(lblNewYourCost);
		
		JLabel lblYourPrepareCost = new JLabel("St\u00E4lkostnad");
		lblYourPrepareCost.setBounds(124, 354, 70, 14);
		contentPane.add(lblYourPrepareCost);
		
		JLabel lblMaterialMaterial = new JLabel("Matrial");
		lblMaterialMaterial.setBounds(10, 228, 46, 14);
		contentPane.add(lblMaterialMaterial);
		
		JLabel lblPrisMatrigalenhet = new JLabel("Pris / matrigalenhet");
		lblPrisMatrigalenhet.setBounds(99, 228, 120, 14);
		contentPane.add(lblPrisMatrigalenhet);
		
		JLabel lblMaterialAmuont = new JLabel("M\u00E4ngd");
		lblMaterialAmuont.setBounds(234, 228, 46, 14);
		contentPane.add(lblMaterialAmuont);
		
		JLabel lblMaterialMo = new JLabel("MO");
		lblMaterialMo.setBounds(348, 228, 46, 14);
		contentPane.add(lblMaterialMo);
		
		JLabel lblMaterialVinst = new JLabel("Vinst");
		lblMaterialVinst.setBounds(572, 228, 46, 14);
		contentPane.add(lblMaterialVinst);
		
		JLabel lblMaterialAffo = new JLabel("Affo");
		lblMaterialAffo.setBounds(460, 228, 46, 14);
		contentPane.add(lblMaterialAffo);
		
		JLabel lblMaterialPrisUnit = new JLabel("Pris stycket");
		lblMaterialPrisUnit.setBounds(680, 228, 68, 14);
		contentPane.add(lblMaterialPrisUnit);
		
		JLabel lblMachineNumber = new JLabel("Nummer");
		lblMachineNumber.setBounds(10, 110, 50, 14);
		contentPane.add(lblMachineNumber);
		
		JLabel lblMachineMachine = new JLabel("Maskin");
		lblMachineMachine.setBounds(141, 110, 46, 14);
		contentPane.add(lblMachineMachine);
		
		JLabel lblMachinePris = new JLabel("Pris");
		lblMachinePris.setBounds(272, 113, 46, 14);
		contentPane.add(lblMachinePris);
		
		JLabel lblMachinePrepareTime = new JLabel("St\u00E4l tid");
		lblMachinePrepareTime.setBounds(403, 110, 46, 14);
		contentPane.add(lblMachinePrepareTime);
		
		JLabel lblMachineTime1 = new JLabel("Tid");
		lblMachineTime1.setBounds(532, 110, 46, 14);
		contentPane.add(lblMachineTime1);
		
		JLabel lblMachinPris = new JLabel("Pris Opration Stycket");
		lblMachinPris.setBounds(668, 110, 130, 14);
		contentPane.add(lblMachinPris);
		
		JLabel lblMachineMaterial = new JLabel("Matrial");
		lblMachineMaterial.setBounds(10, 203, 46, 14);
		contentPane.add(lblMachineMaterial);
		
		JLabel lblCollectedMachineTime = new JLabel("Maskin tid");
		lblCollectedMachineTime.setBounds(532, 476, 60, 14);
		contentPane.add(lblCollectedMachineTime);
		
		JLabel lblTotalTid = new JLabel("Totala tid");
		lblTotalTid.setBounds(572, 629, 56, 14);
		contentPane.add(lblTotalTid);
		
		JLabel lblShipping = new JLabel("Frakt kostnad");
		lblShipping.setBounds(668, 476, 80, 14);
		contentPane.add(lblShipping);
		
		JLabel lblShippingAmuount = new JLabel("Summa");
		lblShippingAmuount.setBounds(623, 494, 46, 14);
		contentPane.add(lblShippingAmuount);
		
		JLabel lblNumber = new JLabel("Nummer");
		lblNumber.setBounds(10, 85, 50, 14);
		contentPane.add(lblNumber);
		
		JLabel lblSelectMaskin = new JLabel("V\u00E4llj Maskin");
		lblSelectMaskin.setBounds(124, 85, 70, 14);
		contentPane.add(lblSelectMaskin);

		JLabel lblTotalPrepareTime = new JLabel("Summa");
		lblTotalPrepareTime.setBounds(403, 629, 46, 14);
		contentPane.add(lblTotalPrepareTime);
		
		JLabel lblCollectedPrepareTime = new JLabel("Maskin st\u00E4ll tid");
		lblCollectedPrepareTime.setBounds(425, 476, 86, 14);
		contentPane.add(lblCollectedPrepareTime);
		
		JLabel lblTotalMachineTime = new JLabel("Summa");
		lblTotalMachineTime.setBounds(488, 629, 46, 14);
		contentPane.add(lblTotalMachineTime);
		
		JLabel lblCollectedMachineCost = new JLabel("Maskin kostnad");
		lblCollectedMachineCost.setBounds(55, 476, 100, 14);
		contentPane.add(lblCollectedMachineCost);
		
		JLabel lblYourTotoalCost = new JLabel("Summa");
		lblYourTotoalCost.setBounds(272, 629, 46, 14);
		contentPane.add(lblYourTotoalCost);
		
		JLabel lblYourCollectedCost = new JLabel("Era Kostnader");
		lblYourCollectedCost.setBounds(317, 476, 86, 14);
		contentPane.add(lblYourCollectedCost);
		JLabel lblTid = new JLabel("Tid");
		lblTid.setBounds(757, 494, 20, 14);
		contentPane.add(lblTid);
		
		JLabel labelProcent = new JLabel("%");
		labelProcent.setBounds(866, 494, 20, 14);
		contentPane.add(labelProcent);
		
		JLabel lblCollectedMatrialCoste = new JLabel("Matrial kostnad");
		lblCollectedMatrialCoste.setBounds(186, 476, 90, 14);
		contentPane.add(lblCollectedMatrialCoste);
		
		JLabel lblSumma = new JLabel("Summa");
		lblSumma.setBounds(141, 629, 46, 14);
		contentPane.add(lblSumma);
		
		JLabel lblTotalMachineCost = new JLabel("Summa");
		lblTotalMachineCost.setBounds(10, 629, 46, 14);
		contentPane.add(lblTotalMachineCost);
		
		JLabel lblMo = new JLabel("MO");
		lblMo.setBounds(436, 42, 30, 14);
		contentPane.add(lblMo);

		JLabel lblDatum_1 = new JLabel("Datum");
		lblDatum_1.setBounds(1118, 510, 46, 14);
		contentPane.add(lblDatum_1);
		
		JLabel lblTotalAmount = new JLabel("Totala summan ex moms");
		lblTotalAmount.setBounds(1020, 479, 150, 14);
		contentPane.add(lblTotalAmount);
		
		JLabel lblOverTime = new JLabel("\u00D6vertids till\u00E4gg");
		lblOverTime.setBounds(774, 476, 100, 14);
		contentPane.add(lblOverTime);
		
		JLabel lblLo = new JLabel("LO");
		lblLo.setBounds(542, 42, 30, 14);
		contentPane.add(lblLo);
		
		JLabel lblAffo = new JLabel("Affo");
		lblAffo.setBounds(639, 42, 30, 14);
		contentPane.add(lblAffo);
		
		JLabel lblCostemerName = new JLabel("Kundens namn");
		lblCostemerName.setBounds(10, 11, 100, 14);
		contentPane.add(lblCostemerName);

		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(1131, 11, 46, 14);
		contentPane.add(lblDatum);
		
		JLabel lblProduce = new JLabel("Vad ska Tillverkas");
		lblProduce.setBounds(10, 42, 120, 14);
		contentPane.add(lblProduce);
		
		JLabel lblAmount = new JLabel("Antal");
		lblAmount.setBounds(229, 42, 46, 14);
		contentPane.add(lblAmount);
		
		JLabel lblVinst = new JLabel("Vinst");
		lblVinst.setBounds(732, 42, 30, 14);
		contentPane.add(lblVinst);
	}

	private void textfelds() 
	{
		textFieldDatum = new JTextField();
		textFieldDatum.setBounds(1177, 8, 86, 20);
		contentPane.add(textFieldDatum);
		textFieldDatum.setColumns(10);
		
		textProduce = new JTextField();
		textProduce.setBounds(124, 39, 95, 20);
		contentPane.add(textProduce);
		textProduce.setColumns(10);
		
		textAmount = new JTextField();
		textAmount.setBounds(264, 39, 86, 20);
		contentPane.add(textAmount);
		textAmount.setColumns(10);
		
		textVinst = new JTextField();
		textVinst.setBounds(764, 39, 30, 20);
		contentPane.add(textVinst);
		textVinst.setColumns(10);
		
		textAffo = new JTextField();
		textAffo.setBounds(668, 39, 30, 20);
		contentPane.add(textAffo);
		textAffo.setColumns(10);
		
		textLo = new JTextField();
		textLo.setBounds(572, 39, 30, 20);
		contentPane.add(textLo);
		textLo.setColumns(10);
		
		textMo = new JTextField();
		textMo.setBounds(476, 39, 30, 20);
		contentPane.add(textMo);
		textMo.setColumns(10);
		
		textImport = new JTextField();
		textImport.setBounds(995, 8, 86, 20);
		contentPane.add(textImport);
		textImport.setColumns(10);
		
		textDate = new JTextField();
		textDate.setBounds(1174, 507, 86, 20);
		contentPane.add(textDate);
		textDate.setColumns(10);		
		
		textTotalAmount = new JTextField();
		textTotalAmount.setBounds(1174, 476, 86, 20);
		contentPane.add(textTotalAmount);
		textTotalAmount.setColumns(10);
	
		textOverTime = new JTextField();
		textOverTime.setBounds(774, 491, 46, 20);
		contentPane.add(textOverTime);
		textOverTime.setColumns(10);
		
		textOverProcent = new JTextField();
		textOverProcent.setBounds(820, 491, 46, 20);
		contentPane.add(textOverProcent);
		textOverProcent.setColumns(10);
		
		textCostemerName = new JTextField();
		textCostemerName.setBounds(99, 8, 120, 20);
		contentPane.add(textCostemerName);
		textCostemerName.setColumns(10);
		
		textTotalMaterialCost = new JTextField();
		textTotalMaterialCost.setBounds(186, 626, 86, 20);
		contentPane.add(textTotalMaterialCost);
		textTotalMaterialCost.setColumns(10);
		
		textTotalMachineCost = new JTextField();
		textTotalMachineCost.setBounds(55, 626, 86, 20);
		contentPane.add(textTotalMachineCost);
		textTotalMachineCost.setColumns(10);
		
		textYourTotalCost = new JTextField();
		textYourTotalCost.setBounds(317, 626, 86, 20);
		contentPane.add(textYourTotalCost);
		textYourTotalCost.setColumns(10);
		
		textTotalPrepareTime = new JTextField();
		textTotalPrepareTime.setBounds(448, 626, 40, 20);
		contentPane.add(textTotalPrepareTime);
		textTotalPrepareTime.setColumns(10);
		
		textTotalMachineTime = new JTextField();
		textTotalMachineTime.setBounds(532, 626, 40, 20);
		contentPane.add(textTotalMachineTime);
		textTotalMachineTime.setColumns(10);
		
		textShippingCost = new JTextField();
		textShippingCost.setBounds(668, 491, 86, 20);
		contentPane.add(textShippingCost);
		textShippingCost.setColumns(10);
		
		textFieldUnitAmaunt = new JTextField();
		textFieldUnitAmaunt.setColumns(10);
		textFieldUnitAmaunt.setBounds(1174, 448, 86, 20);
		contentPane.add(textFieldUnitAmaunt);
		
		textTotalTime = new JTextField();
		textTotalTime.setBounds(623, 628, 86, 20);
		contentPane.add(textTotalTime);
		textTotalTime.setColumns(10);
	}
	
	private void comboboxes() 
	{
		comboBoxMachine = new JComboBox();
		comboBoxMachine.setBounds(204, 82, 120, 20);
		comboBoxMachine.setSelectedItem(null);
		comboBoxMachine.setEditable(true);
		contentPane.add(comboBoxMachine);
		
		comboBoxNummber = new JComboBox();
		comboBoxNummber.setBounds(60, 82, 55, 20);
		comboBoxNummber.setSelectedItem(null);
		comboBoxNummber.setEditable(true);
		contentPane.add(comboBoxNummber);
		
		JButton btnDeliteMaterial = new JButton("Ta Bort");
		btnDeliteMaterial.setBounds(165, 199, 89, 23);
		contentPane.add(btnDeliteMaterial);
		
		JButton btnDeliteYourCost = new JButton("Ta Bort");
		btnDeliteYourCost.setBounds(203, 320, 89, 23);
		contentPane.add(btnDeliteYourCost);
	}

	private static void setDate() 
	{
		Date dNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat ("dd.MM.yyyy");
		textDate.setText(sdf.format(dNow));
		textFieldDatum.setText(sdf.format(dNow));
		
	 }
	
	private void setStartProcentWalue()
	{
		textMo.setText(startMo);
		textLo.setText(startLo);
		textAffo.setText(startAffo);
		textVinst.setText(startVinst);
	}

	private void setStarWalue()
	{
		textAmount.setText(startAmount);
		textTotalMachineCost.setText(startWalue);
		textTotalMaterialCost.setText(startWalue);
		textYourTotalCost.setText(startWalue);
		textTotalPrepareTime.setText(startWalue);
		textTotalMachineTime.setText(startWalue);
		textTotalTime.setText(startWalue);
		textShippingCost.setText(startWalue);
		textOverTime.setText(startWalue);
		textOverProcent.setText(startWalue);
		textTotalAmount.setText(startWalue);
		textFieldUnitAmaunt.setText(startWalue);
	}
	
	private void AddMaterial( int listItem)
	{
		MaterialMaterial.addElement("Matrial"+listItem);
		MaterialPrisMaterialUnit.addElement(startWalue);
		MatirialAmount.addElement(startWalue);
		MaterialMo.addElement(startMo);
		MaterialAffo.addElement(startAffo);
		MaterialVinst.addElement(startVinst);
		MaterialPris.addElement(startWalue);
		
		
		listMaterialMaterial.setModel(MaterialMaterial);	
		listMaterialPrisMaterialUnit.setModel(MaterialPrisMaterialUnit);
		listMatirialAmount.setModel(MatirialAmount);
		listMaterialMo.setModel(MaterialMo);
		listMaterialAffo.setModel(MaterialAffo);
		listMaterialVinst.setModel(MaterialVinst);
		listMaterialPris.setModel(MaterialPris);
	}

	
	
	
	private void SelectMatrialMatrial()
	{
		listMatirialAmount.setSelectedIndex(listMaterialMaterial.getSelectedIndex());
    	listMaterialPrisMaterialUnit.setSelectedIndex(listMaterialMaterial.getSelectedIndex());	
    	listMaterialMo.setSelectedIndex(listMaterialMaterial.getSelectedIndex());	
    	listMaterialAffo.setSelectedIndex(listMaterialMaterial.getSelectedIndex());
    	listMaterialVinst.setSelectedIndex(listMaterialMaterial.getSelectedIndex());
    	listMaterialPris.setSelectedIndex(listMaterialMaterial.getSelectedIndex());		
	}
	
	private void SelectMatirialAmount()
	{
		listMaterialMaterial.setSelectedIndex(listMatirialAmount.getSelectedIndex());
    	listMaterialPrisMaterialUnit.setSelectedIndex(listMatirialAmount.getSelectedIndex());	
    	listMaterialMo.setSelectedIndex(listMatirialAmount.getSelectedIndex());	
    	listMaterialAffo.setSelectedIndex(listMatirialAmount.getSelectedIndex());
    	listMaterialVinst.setSelectedIndex(listMatirialAmount.getSelectedIndex());
    	listMaterialPris.setSelectedIndex(listMatirialAmount.getSelectedIndex());	  	
	}
	
	private void SelectMaterialPrisMaterialUnit()
	{
		
		listMaterialMaterial.setSelectedIndex(listMaterialPrisMaterialUnit.getSelectedIndex());
		listMatirialAmount.setSelectedIndex(listMaterialPrisMaterialUnit.getSelectedIndex());	
    	listMaterialMo.setSelectedIndex(listMaterialPrisMaterialUnit.getSelectedIndex());	
    	listMaterialAffo.setSelectedIndex(listMaterialPrisMaterialUnit.getSelectedIndex());
    	listMaterialVinst.setSelectedIndex(listMaterialPrisMaterialUnit.getSelectedIndex());
    	listMaterialPris.setSelectedIndex(listMaterialPrisMaterialUnit.getSelectedIndex());	  	
	}
	
	private void SelectMaterialMo()
	{
		listMaterialMaterial.setSelectedIndex(listMaterialMo.getSelectedIndex());
		listMatirialAmount.setSelectedIndex(listMaterialMo.getSelectedIndex());	
		listMaterialPrisMaterialUnit.setSelectedIndex(listMaterialMo.getSelectedIndex());	
    	listMaterialAffo.setSelectedIndex(listMaterialMo.getSelectedIndex());
    	listMaterialVinst.setSelectedIndex(listMaterialMo.getSelectedIndex());
    	listMaterialPris.setSelectedIndex(listMaterialMo.getSelectedIndex());	  	
	}
	
	private void SelectMaterialAffo()
	{
		listMaterialMaterial.setSelectedIndex(listMaterialAffo.getSelectedIndex());
		listMatirialAmount.setSelectedIndex(listMaterialAffo.getSelectedIndex());	
		listMaterialPrisMaterialUnit.setSelectedIndex(listMaterialAffo.getSelectedIndex());	
    	listMaterialMo.setSelectedIndex(listMaterialAffo.getSelectedIndex());
    	listMaterialVinst.setSelectedIndex(listMaterialAffo.getSelectedIndex());
    	listMaterialPris.setSelectedIndex(listMaterialAffo.getSelectedIndex());	  	
	}
	
	private void SelectMaterialVinst()
	{
		listMaterialMaterial.setSelectedIndex(listMaterialVinst.getSelectedIndex());
		listMatirialAmount.setSelectedIndex(listMaterialVinst.getSelectedIndex());	
		listMaterialPrisMaterialUnit.setSelectedIndex(listMaterialVinst.getSelectedIndex());	
    	listMaterialMo.setSelectedIndex(listMaterialVinst.getSelectedIndex());
    	listMaterialAffo.setSelectedIndex(listMaterialVinst.getSelectedIndex());
    	listMaterialPris.setSelectedIndex(listMaterialVinst.getSelectedIndex());	  	
	}
	
	private void SelectMaterialPris()
	{
		listMaterialMaterial.setSelectedIndex(listMaterialPris.getSelectedIndex());
		listMatirialAmount.setSelectedIndex(listMaterialPris.getSelectedIndex());	
		listMaterialPrisMaterialUnit.setSelectedIndex(listMaterialPris.getSelectedIndex());	
    	listMaterialMo.setSelectedIndex(listMaterialPris.getSelectedIndex());
    	listMaterialAffo.setSelectedIndex(listMaterialPris.getSelectedIndex());
    	listMaterialVinst.setSelectedIndex(listMaterialPris.getSelectedIndex());	  	
	}
	
	
	
	
	
	
	

}
