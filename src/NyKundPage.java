import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql.MySQLAccess;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.DefaultListModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.ClosedFileSystemException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class NyKundPage extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldMO;
	private JTextField textFieldLO;
	private JTextField textFieldAffo;
	private JTextField textFieldVinst;
	private JTextField textKundNr;

	JPanel MaskinPanel;
	JPanel TjänstPanel;
	
	JList listNRM;
	JList listMaskin;
	JList listPris;
	JList listNRT;
	JList listKonsult;
	JList listPrisTid;
	
	JComboBox comboBoxForetag;
	
	static MySQLAccess db = new MySQLAccess();
	public JTextField textExcel;
	private JTextField textMaskinKonsultNr;
	private JTextField textMaskinKonsult;
	private JTextField textPrisTime;
	
	int listselecter = 1;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try 
				{
					NyKundPage frame = new NyKundPage();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public NyKundPage() 
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
		
		JPanel MaskinPanel = new JPanel();
		MaskinPanel.setBounds(10, 124, 249, 306);
		contentPane.add(MaskinPanel);
		MaskinPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel KonsultPanel = new JPanel();
		KonsultPanel.setBounds(269, 124, 249, 306);
		contentPane.add(KonsultPanel);
		KonsultPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		comboBox();
		textfelds();
		label();
		buttons(MaskinPanel,KonsultPanel);
		MaskinPanelLists(MaskinPanel);
		KonsultPanelLists(KonsultPanel);
		
		
	}
	
	private void label()
	{
		JLabel lblMO = new JLabel("MO");
		lblMO.setBounds(652, 14, 46, 14);
		contentPane.add(lblMO);
		
		JLabel lblLO = new JLabel("LO");
		lblLO.setBounds(652, 45, 46, 14);
		contentPane.add(lblLO);
		
		JLabel lblAffo = new JLabel("Affo");
		lblAffo.setBounds(652, 76, 46, 14);
		contentPane.add(lblAffo);
		
		JLabel lblVinst = new JLabel("Vinst");
		lblVinst.setBounds(652, 107, 46, 14);
		contentPane.add(lblVinst);
		
		JLabel lblNRM = new JLabel("Nummer");
		lblNRM.setBounds(24, 99, 50, 14);
		contentPane.add(lblNRM);
		
		JLabel lblMaskin = new JLabel("Maskin");
		lblMaskin.setBounds(104, 99, 46, 14);
		contentPane.add(lblMaskin);
		
		JLabel lblPris = new JLabel("Pris / Time");
		lblPris.setBounds(184, 99, 75, 14);
		contentPane.add(lblPris);
		
		JLabel lblNRK = new JLabel("Nummer");
		lblNRK.setBounds(282, 99, 50, 14);
		contentPane.add(lblNRK);
		
		JLabel lblKonsult = new JLabel("Konsult");
		lblKonsult.setBounds(364, 99, 46, 14);
		contentPane.add(lblKonsult);
		
		JLabel lblPrisTid = new JLabel("Pris / Time");
		lblPrisTid.setBounds(432, 99, 75, 14);
		contentPane.add(lblPrisTid);
		
		JLabel lblKundNamn = new JLabel("Kund Namn");
		lblKundNamn.setBounds(10, 14, 75, 14);
		contentPane.add(lblKundNamn);
		
		JLabel lblKundNr = new JLabel("Kund Nr");
		lblKundNr.setBounds(10, 45, 60, 14);
		contentPane.add(lblKundNr);	
		
		JLabel lbllegtillNr = new JLabel("Nummer");
		lbllegtillNr.setBounds(528, 138, 50, 14);
		contentPane.add(lbllegtillNr);
		
		JLabel lbllegtillMaskintjenst = new JLabel("Maskin/Konsult");
		lbllegtillMaskintjenst.setBounds(528, 169, 100, 14);
		contentPane.add(lbllegtillMaskintjenst);
		
		JLabel lbllagtillpris = new JLabel("Pris/Time");
		lbllagtillpris.setBounds(528, 200, 100, 14);
		contentPane.add(lbllagtillpris);
	}
	
	private void textfelds()
	{
		
		textKundNr = new JTextField();
		textKundNr.setBounds(80, 42, 86, 20);
		contentPane.add(textKundNr);
		textKundNr.setColumns(10);
		
		textFieldMO = new JTextField();
		textFieldMO.setBounds(718, 11, 76, 20);
		contentPane.add(textFieldMO);
		textFieldMO.setColumns(10);
		
		textFieldLO = new JTextField();
		textFieldLO.setBounds(718, 42, 76, 20);
		contentPane.add(textFieldLO);
		textFieldLO.setColumns(10);
		
		textFieldAffo = new JTextField();
		textFieldAffo.setBounds(718, 73, 76, 20);
		contentPane.add(textFieldAffo);
		textFieldAffo.setColumns(10);
		
		textFieldVinst = new JTextField();
		textFieldVinst.setBounds(718, 104, 76, 20);
		contentPane.add(textFieldVinst);
		textFieldVinst.setColumns(10);
		
		textExcel = new JTextField();
		textExcel.setBounds(608, 462, 86, 20);
		contentPane.add(textExcel);
		textExcel.setColumns(10);
		
		textMaskinKonsultNr = new JTextField();
		textMaskinKonsultNr.setBounds(618, 135, 76, 20);
		contentPane.add(textMaskinKonsultNr);
		textMaskinKonsultNr.setColumns(10);
		
		textMaskinKonsult = new JTextField();
		textMaskinKonsult.setBounds(618, 166, 100, 20);
		contentPane.add(textMaskinKonsult);
		textMaskinKonsult.setColumns(10);
		
		textPrisTime = new JTextField();
		textPrisTime.setBounds(618, 197, 100, 20);
		contentPane.add(textPrisTime);
		textPrisTime.setColumns(10);
	}
	
	private void comboBox()
	{
		comboBoxForetag = new JComboBox();
		comboBoxForetag.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				RetriveKundNr();
			}
		});
		comboBoxForetag.addPopupMenuListener(new PopupMenuListener()
		{
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) 
			{
				RetriveKund();
			}	
			public void popupMenuCanceled(PopupMenuEvent e) 
			{			
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) 
			{
			}
		});
		comboBoxForetag.setBounds(80, 11, 179, 20);
		comboBoxForetag.setSelectedItem(null);
		comboBoxForetag.setEditable(true);
		contentPane.add(comboBoxForetag);
	}
	
	private void buttons(JPanel MaskinPanel, JPanel TjänstPanel) 
	{
		JButton btnSpara = new JButton("Spara");
		btnSpara.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				Spara();
				dispose();
				FirstPage p = new FirstPage();
				p.setVisible(true);
			}
		});
		btnSpara.setBounds(705, 527, 89, 23);
		contentPane.add(btnSpara);	
		
		JButton btnImport = new JButton("Import");
		btnImport.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0)
			{
				Reader();
			}
		});
		btnImport.setBounds(605, 493, 89, 23);
		contentPane.add(btnImport);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				FirstPage p = new FirstPage();
				p.setVisible(true);	
			}
		});
		btnBack.setBounds(705, 493, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnNewMaskin = new JButton("Ny Maskin");
		btnNewMaskin.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				NewMaskin();
				RetriveMaskintList();
				CleanText();
			}
		});
		btnNewMaskin.setBounds(528, 228, 100, 23);
		contentPane.add(btnNewMaskin);
		
		JButton btnNewKonsult = new JButton("Ny Konsult");
		btnNewKonsult.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				NewKonsult();
				RetriveKonsultList();
				CleanText();
			}
		});
		btnNewKonsult.setBounds(652, 228, 100, 23);
		contentPane.add(btnNewKonsult);
		
		JButton btnRetrieve = new JButton("H\u00E4mta");
		btnRetrieve.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				RetriveKund();
				RetriveKundNr();
				RetriveMaskintList();
				RetriveKonsultList();
				RetriveProcent();
			}
		});
		btnRetrieve.setBounds(170, 41, 89, 23);
		contentPane.add(btnRetrieve);
		
		JButton btnDeliteMaskin = new JButton("Ta bort Maskin");
		btnDeliteMaskin.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				DeliteMaskin();
				CleanText();
				RetriveMaskintList();
			}
		});
		btnDeliteMaskin.setBounds(528, 297, 120, 23);
		contentPane.add(btnDeliteMaskin);
		
		JButton btnChangeMaskin = new JButton("\u00C4ndra Maskin");
		btnChangeMaskin.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{	
				ChangeMaskin();
				CleanText();
				RetriveMaskintList();
			}
		});
		btnChangeMaskin.setBounds(528, 263, 120, 23);
		contentPane.add(btnChangeMaskin);
		
		JButton btnChangeKonsult = new JButton("\u00C4ndra Konsult");
		btnChangeKonsult.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{	
				ChangeKonsult();
				CleanText();
				RetriveKonsultList();
			}
		});
		btnChangeKonsult.setBounds(652, 262, 120, 23);
		contentPane.add(btnChangeKonsult);
		
		JButton btnDeliteKonsult = new JButton("Ta bort Konsult");
		btnDeliteKonsult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeliteKonsult();
				CleanText();
				RetriveKonsultList();
			}
		});
		btnDeliteKonsult.setBounds(652, 297, 120, 23);
		contentPane.add(btnDeliteKonsult);
		
		JButton btnChangeProcent = new JButton("\u00C4ndra % Satser");
		btnChangeProcent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ChangeProcent();
			}
		});
		btnChangeProcent.setBounds(528, 331, 130, 23);
		contentPane.add(btnChangeProcent);
		
		JButton btnDeliteKund = new JButton("Ta Bort Kund");
		btnDeliteKund.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e) 
			{
				DelitCostemur();
				dispose();
				FirstPage p = new FirstPage();
				p.setVisible(true);
		        
			}
		});
		btnDeliteKund.setBounds(269, 41, 120, 23);
		contentPane.add(btnDeliteKund);
	}

	private void Spara()
	{
		String KundNamn = (String)comboBoxForetag.getSelectedItem();
		String KundNR = textKundNr.getText(); 
		if (KundNamn == null || textKundNr.getText().equals(""))
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte lägga till företaget.");
			
        }
		else 
		{
			int kundnr = Integer.parseInt(KundNR);		
			db.NyKund(KundNamn,kundnr);
		}
	}
	
	private void MaskinPanelLists(JPanel MaskinPanel)
	{
		listNRM = new JList();
		listNRM.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent arg0) 
			{
				if (listNRM.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					SelectNrTM(listselecter);
				}	
			}
		});
		MaskinPanel.add(listNRM);
		
		listMaskin = new JList();
		listMaskin.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listMaskin.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					SelectMaskin(listselecter);
				}
			}
		});
		MaskinPanel.add(listMaskin);
		
		listPris = new JList();
		listPris.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listPris.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					SelectPris(listselecter);
				}
			}
		});
		MaskinPanel.add(listPris);
	}
	
	private void KonsultPanelLists(JPanel TjänstPanel)
	{
		listNRT = new JList();
		listNRT.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (listNRT.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					SelectNrT(listselecter);
				}
			}
		});
		TjänstPanel.add(listNRT);
		
		listKonsult = new JList();
		listKonsult.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (listKonsult.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					SelectKonsult(listselecter);
				}
			}
		});
		TjänstPanel.add(listKonsult);
		
		listPrisTid = new JList();
		listPrisTid.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (listPrisTid.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					SelectPrisTid(listselecter);
				}
			}
		});
		TjänstPanel.add(listPrisTid);
	}
	

	private void CleanText()
	{
		textMaskinKonsultNr.setText(null);
		textMaskinKonsult.setText(null);
		textPrisTime.setText(null);
	}
	
	
	private void RetriveMaskintList()
	{
		if (comboBoxForetag.getSelectedItem() != null)
		{
            String KundNamn = comboBoxForetag.getSelectedItem().toString();
            String KundNR = textKundNr.getText();
            if(KundNamn == null || textKundNr.getText().equals(""))
    		{
    			JOptionPane.showMessageDialog(frame,"Kunde inte hämta lisat.");
    		}
    		else 
    		{
    			int kundnr = Integer.parseInt(KundNR);	
    			db.MaskinList(listNRM,listMaskin,listPris,kundnr);  
    		} 
        }
		else
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte hämta lisat.");
		}
	}
	
	private void RetriveKonsultList()
	{
		if (comboBoxForetag.getSelectedItem() != null)
		{
            String KundNamn = comboBoxForetag.getSelectedItem().toString();
            String KundNR = textKundNr.getText();
            if(KundNamn == null || textKundNr.getText().equals(""))
    		{
    			JOptionPane.showMessageDialog(frame,"Kunde inte hämta lisat.");
    		}
    		else 
    		{
    			int kundnr = Integer.parseInt(KundNR);
    			db.KonsultLista(listNRT, listKonsult, listPrisTid, kundnr); 
    		} 
        }
		else
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte hämta lisat.");
		}
	}
	
	private void RetriveProcent()
	{
		if (comboBoxForetag.getSelectedItem() != null)
		{
            String KundNamn = comboBoxForetag.getSelectedItem().toString();
            String KundNR = textKundNr.getText();
            if(KundNamn == null || textKundNr.getText().equals(""))
    		{
    			JOptionPane.showMessageDialog(frame,"Kunde inte hämta lisat.");
    		}
    		else 
    		{	
    			int kundnr = Integer.parseInt(KundNR);
    			db.GetProsent(textFieldMO,textFieldLO,textFieldAffo,textFieldVinst,kundnr);	
    		} 
        }
		else
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte hämta lisat.");
		}
	}
	
	private void RetriveKund() 
	{
		if (textKundNr.getText().equals(""))
		{
			db.RetriveKundejnr(comboBoxForetag);
		}
		else 
		{
			String Kundnr = textKundNr.getText();
			int kundnr = Integer.parseInt(Kundnr);
			db.RetriveKund(comboBoxForetag, kundnr);
		}
		
	}
	
	private void RetriveKundNr() 
	{
		if (comboBoxForetag.getSelectedItem() != null)
		{
            String kund = comboBoxForetag.getSelectedItem().toString();
            db.RetriveKundNr(kund, textKundNr);
        }	
	}

	
	private void NewMaskin()
	{
		String KundNR = textKundNr.getText();
		String NR = textMaskinKonsultNr.getText();
		String MaskinTjenst = textMaskinKonsult.getText();
		String PrisTime = textPrisTime.getText();
	    if(textKundNr.getText().equals("") || textMaskinKonsultNr.getText().equals("") ||  textMaskinKonsult.getText().equals("") ||  textPrisTime.getText().equals(""))
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte lägga till maskinen.");
		}
		else 
		{		
			int kundnr = Integer.parseInt(KundNR);
			int nr = Integer.parseInt(NR);
			int pristime = Integer.parseInt(PrisTime);
			db.NewMaskin(kundnr, nr, MaskinTjenst, pristime);
		} 
	}
		
	private void NewKonsult() 
	{
		String KundNR = textKundNr.getText();
		String NR = textMaskinKonsultNr.getText();
		String MaskinTjenst = textMaskinKonsult.getText();
		String PrisTime = textPrisTime.getText();
		if(textKundNr.getText().equals("") || textMaskinKonsultNr.getText().equals("") ||  textMaskinKonsult.getText().equals("") ||  textPrisTime.getText().equals(""))
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte lägga till tjänsten.");
		}
		else 
		{	
			int kundnr = Integer.parseInt(KundNR);
			int nr = Integer.parseInt(NR);
			int pristime = Integer.parseInt(PrisTime);
			db.NewKonsult(kundnr, nr, MaskinTjenst, pristime);
		} 	
	}

	
	private void SelectNrTM(int listselecter)
	{
		if(listselecter == 1)
		{
    		textMaskinKonsultNr.setText(listNRM.getSelectedValue().toString());
        	listMaskin.setSelectedIndex(listNRM.getSelectedIndex());
        	listPris.setSelectedIndex(listNRM.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listMaskin.setSelectedIndex(listNRM.getSelectedIndex());
        	listPris.setSelectedIndex(listNRM.getSelectedIndex());
        }
	
	}

	private void SelectMaskin(int listselecter)
	{
		if(listselecter == 1)
		{
    		textMaskinKonsult.setText(listMaskin.getSelectedValue().toString());
        	listNRM.setSelectedIndex(listMaskin.getSelectedIndex());
        	listPris.setSelectedIndex(listMaskin.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listNRM.setSelectedIndex(listMaskin.getSelectedIndex());
        	listPris.setSelectedIndex(listMaskin.getSelectedIndex());
        }
	}
	
	private void SelectPris(int listselecter)
	{
		if(listselecter == 1)
		{
    		textPrisTime.setText(listPris.getSelectedValue().toString());
        	listNRM.setSelectedIndex(listPris.getSelectedIndex());
        	listMaskin.setSelectedIndex(listPris.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listNRT.setSelectedIndex(listPris.getSelectedIndex());
        	listMaskin.setSelectedIndex(listPris.getSelectedIndex());
        }
	}
		
	private void SelectNrT(int listselecter) 
	{
		if(listselecter == 1)
		{
    		textMaskinKonsultNr.setText(listNRT.getSelectedValue().toString());
        	listKonsult.setSelectedIndex(listNRT.getSelectedIndex());
        	listPrisTid.setSelectedIndex(listNRT.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listKonsult.setSelectedIndex(listNRT.getSelectedIndex());
        	listPrisTid.setSelectedIndex(listNRT.getSelectedIndex());
        }
	}
	
	private void SelectKonsult(int listselecter) 
	{
		if(listselecter == 1)
		{
    		textMaskinKonsult.setText(listKonsult.getSelectedValue().toString());
        	listNRT.setSelectedIndex(listKonsult.getSelectedIndex());
        	listPrisTid.setSelectedIndex(listKonsult.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listNRT.setSelectedIndex(listKonsult.getSelectedIndex());
        	listPrisTid.setSelectedIndex(listKonsult.getSelectedIndex());
        }
	}
	
	private void SelectPrisTid(int listselecter) 
	{
		if(listselecter == 1)
		{
    		textPrisTime.setText(listPrisTid.getSelectedValue().toString());
        	listNRT.setSelectedIndex(listPrisTid.getSelectedIndex());
        	listKonsult.setSelectedIndex(listPrisTid.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listNRT.setSelectedIndex(listPrisTid.getSelectedIndex());
        	listKonsult.setSelectedIndex(listPrisTid.getSelectedIndex());
        }
	}
	
	
	private void ChangeMaskin() 
	{
		String KundNR = textKundNr.getText();
		String NR = textMaskinKonsultNr.getText();
		String Maskin = textMaskinKonsult.getText();
		String Pris = textPrisTime.getText();
		if(textKundNr.getText().equals("") || textMaskinKonsultNr.getText().equals("") ||  textMaskinKonsult.getText().equals("") ||  textPrisTime.getText().equals(""))
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte ändra maskinen.");
		}
		else 
		{	
			int kundnr = Integer.parseInt(KundNR);
			int pris = Integer.parseInt(Pris);
			int nr = Integer.parseInt(NR);
			db.ChangeMaskin(kundnr, Maskin, pris, nr);
		} 
	}
	
	private void ChangeKonsult() 
	{
		String KundNR = textKundNr.getText();
		String NR = textMaskinKonsultNr.getText();
		String Tjanst = textMaskinKonsult.getText();
		String Pris = textPrisTime.getText();
		if(textKundNr.getText().equals("") || textMaskinKonsultNr.getText().equals("") ||  textMaskinKonsult.getText().equals("") ||  textPrisTime.getText().equals(""))
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte ändra tjänsten.");
		}
		else 
		{	
			int kundnr = Integer.parseInt(KundNR);
			int pris = Integer.parseInt(Pris);
			int nr = Integer.parseInt(NR);
			db.ChangeKonsult(kundnr, Tjanst, pris,nr);
		} 
	}
	
	private void ChangeProcent()
	{	
		String KundNR = textKundNr.getText();
		String MO = textFieldMO.getText();
		String LO = textFieldLO.getText();
		String Affo = textFieldAffo.getText();
		String Vinst= textFieldVinst.getText();
		if(textKundNr.getText().equals("") || textFieldMO.getText().equals("") ||  textFieldLO.getText().equals("") ||  textFieldAffo.getText().equals("") ||  textFieldVinst.getText().equals(""))
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte ändra procent.");
		}
		else 
		{	
			int kundnr = Integer.parseInt(KundNR);
			int mo = Integer.parseInt(MO);
			int lo = Integer.parseInt(LO);
			int affo = Integer.parseInt(Affo);
			int vinst = Integer.parseInt(Vinst);
			db.ChangeProcent(kundnr, mo,lo,affo,vinst);
		}
	}
	
	
	private void DelitCostemur()
	{
		if (comboBoxForetag.getSelectedItem() != null)
		{
            String KundNamn = comboBoxForetag.getSelectedItem().toString();
            String KundNR = textKundNr.getText();
            if(KundNamn == null || textKundNr.getText().equals(""))
    		{
    			JOptionPane.showMessageDialog(frame,"Kunde inte tabort företaget.");
    		}
    		else 
    		{
    			int kundnr = Integer.parseInt(KundNR);		
    			db.DeliteKund(KundNamn, kundnr);  
    		} 
        }
		else
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte tabort företaget.");
		}
	}
	
	private void DeliteMaskin()
	{
		String KundNR = textKundNr.getText();
		String NR = textMaskinKonsultNr.getText();
		if(textKundNr.getText().equals("") || textMaskinKonsultNr.getText().equals(""))
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte tabort maskinen.");
		}
		else 
		{	
			int kundnr = Integer.parseInt(KundNR);
			db.DeliteMaskin(kundnr, NR);
		} 
	}

	private void DeliteKonsult()
	{
		String KundNR = textKundNr.getText();
		String NR = textMaskinKonsultNr.getText();
		if(textKundNr.getText().equals("") || textMaskinKonsultNr.getText().equals(""))
		{
			JOptionPane.showMessageDialog(frame,"Kunde inte tabort tjänsten.");
		}
		else 
		{	
			int kundnr = Integer.parseInt(KundNR);
			db.DeliteKonsult(kundnr,NR);
		} 
	}

	
	private void Reader() 
	{
		String Excel = textExcel.getText();
		listNRM.getSelectedValue();
		if(textExcel.getText().equals("") )
		{
			JOptionPane.showMessageDialog(frame,"Kunde lässa in fillen.");
		}
		else 
		{	
			ExcelReader(Excel,MaskinPanel,TjänstPanel,textKundNr);//,listNRM
		} 
	}
	
	private static void ExcelReader(String Excel,JPanel MaskinPanel,JPanel TjänstPanel,JTextField textKundNr )//JList listNRM 
	{
		try {

            FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\TBTE4HP12\\Documents\\" + Excel + ".xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            while (iterator.hasNext())
            {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) 
                {

                    Cell currentCell = cellIterator.next(); // curent cell utput string.
                    if (currentCell.getCellTypeEnum() == CellType.STRING) 
                    {
                        System.out.print(currentCell.getStringCellValue() + "\t");
                      
                    }
                    else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) 
                    {
                        System.out.print(currentCell.getNumericCellValue() + "\t");    
                    }

                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



