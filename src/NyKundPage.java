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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
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



public class NyKundPage extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMO;
	private JTextField textFieldLO;
	private JTextField textFieldAffo;
	private JTextField textFieldVinst;
	private JTextField textKundNamn;
	private JTextField textKundNr;

	JPanel MaskinPanel;
	JPanel TjänstPanel;
	
	JList listNRM;
	JList listMaskin;
	JList listPris;
	JList listNRT;
	JList listTjanst;
	JList listPrisTid;
	static MySQLAccess db = new MySQLAccess();
	public JTextField textExcel;
	private JTextField textMaskinTjenstNr;
	private JTextField textMaskinTjenst;
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
		
		JPanel TjänstPanel = new JPanel();
		TjänstPanel.setBounds(269, 124, 249, 306);
		contentPane.add(TjänstPanel);
		TjänstPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		textfelds();
		label();
		butoms(MaskinPanel,TjänstPanel);
		maskinpanellists(MaskinPanel);
		tjänstpanellists(TjänstPanel);
		
		
		
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
		
		JLabel lblNRM = new JLabel("NR");
		lblNRM.setBounds(24, 99, 46, 14);
		contentPane.add(lblNRM);
		
		JLabel lblMaskin = new JLabel("Maskin");
		lblMaskin.setBounds(104, 99, 46, 14);
		contentPane.add(lblMaskin);
		
		JLabel lblPris = new JLabel("Pris / Time");
		lblPris.setBounds(184, 99, 75, 14);
		contentPane.add(lblPris);
		
		JLabel lblNRK = new JLabel("NR");
		lblNRK.setBounds(282, 99, 46, 14);
		contentPane.add(lblNRK);
		
		JLabel lblTjanst = new JLabel("Tj\u00E4nst");
		lblTjanst.setBounds(364, 99, 46, 14);
		contentPane.add(lblTjanst);
		
		JLabel lblPrisTid = new JLabel("Pris / Time");
		lblPrisTid.setBounds(432, 99, 75, 14);
		contentPane.add(lblPrisTid);
		
		JLabel lblKundNamn = new JLabel("Kund Namn");
		lblKundNamn.setBounds(10, 14, 75, 14);
		contentPane.add(lblKundNamn);
		
		JLabel lblKundNr = new JLabel("Kund Nr");
		lblKundNr.setBounds(10, 45, 60, 14);
		contentPane.add(lblKundNr);	
		
		JLabel lbllegtillNr = new JLabel("Nr");
		lbllegtillNr.setBounds(648, 138, 46, 14);
		contentPane.add(lbllegtillNr);
		
		JLabel lbllegtillMaskintjenst = new JLabel("Maskin/Tj\u00E4nst");
		lbllegtillMaskintjenst.setBounds(648, 166, 70, 14);
		contentPane.add(lbllegtillMaskintjenst);
		
		JLabel lbllagtillpris = new JLabel("Pris/Time");
		lbllagtillpris.setBounds(648, 200, 46, 14);
		contentPane.add(lbllagtillpris);
	}
	
	private void textfelds()
	{

		textKundNamn = new JTextField();
		textKundNamn.setBounds(80, 11, 86, 20);
		contentPane.add(textKundNamn);
		textKundNamn.setColumns(10);
		
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
		
		textMaskinTjenstNr = new JTextField();
		textMaskinTjenstNr.setBounds(718, 135, 76, 20);
		contentPane.add(textMaskinTjenstNr);
		textMaskinTjenstNr.setColumns(10);
		
		textMaskinTjenst = new JTextField();
		textMaskinTjenst.setBounds(718, 166, 76, 20);
		contentPane.add(textMaskinTjenst);
		textMaskinTjenst.setColumns(10);
		
		textPrisTime = new JTextField();
		textPrisTime.setBounds(718, 197, 76, 20);
		contentPane.add(textPrisTime);
		textPrisTime.setColumns(10);
		
	}

	private void butoms(JPanel MaskinPanel, JPanel TjänstPanel) 
	{
		JButton btnSpara = new JButton("Spara");
		btnSpara.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Spara();
				dispose();
				FirstPage p = new FirstPage();
				p.setVisible(true);
			}
		});
		btnSpara.setBounds(705, 527, 89, 23);
		contentPane.add(btnSpara);	
		
		JButton btnImport = new JButton("Import");
		btnImport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Excel = textExcel.getText();
				listNRM.getSelectedValue();
				test(Excel,MaskinPanel,TjänstPanel,textKundNr);//,listNRM
			}
		});
		btnImport.setBounds(605, 493, 89, 23);
		contentPane.add(btnImport);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				FirstPage p = new FirstPage();
				p.setVisible(true);
				
			}
		});
		btnBack.setBounds(705, 493, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnNyMaskin = new JButton("Ny Maskin");
		btnNyMaskin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nymaskin();
				cleanText();
			}
		});
		btnNyMaskin.setBounds(528, 228, 100, 23);
		contentPane.add(btnNyMaskin);
		
		JButton btnNewButton_1 = new JButton("Ny Tj\u00E4nst");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nytjanst();
				cleanText();
			}
		});
		btnNewButton_1.setBounds(652, 228, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnhemta = new JButton("H\u00E4mta");
		btnhemta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Maskinlist();
				hemtatjenstlist();
			}
		});
		btnhemta.setBounds(176, 41, 89, 23);
		contentPane.add(btnhemta);
		
		JButton btnTaBortMaskin = new JButton("Ta bort Maskin");
		btnTaBortMaskin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String KundNR = textKundNr.getText();
				String NR = textMaskinTjenstNr.getText();
				db.tabortmaskin(KundNR, NR);
				cleanText();
				hemtamaskinlist();
			}
		});
		btnTaBortMaskin.setBounds(528, 297, 120, 23);
		contentPane.add(btnTaBortMaskin);
		
		JButton btnandraMaskin = new JButton("\u00C4ndra Maskin");
		btnandraMaskin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String KundNR = textKundNr.getText();
				String Maskin = textMaskinTjenst.getText();
				String Pris = textPrisTime.getText();
				int kundnr = Integer.parseInt(KundNR);
				int pris = Integer.parseInt(Pris);		
				db.endramaskin(kundnr, Maskin, pris);
				cleanText();
				hemtamaskinlist();
				
			}
		});
		btnandraMaskin.setBounds(528, 263, 120, 23);
		contentPane.add(btnandraMaskin);
		
		JButton btnandraTjanst = new JButton("\u00C4ndra tj\u00E4nst");
		btnandraTjanst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String KundNR = textKundNr.getText();
				String Tjanst = textMaskinTjenst.getText();
				String Pris = textPrisTime.getText();
				int kundnr = Integer.parseInt(KundNR);
				int pris = Integer.parseInt(Pris);
				System.out.println(Tjanst);
				System.out.println(pris);
				db.endratjenst(kundnr, Tjanst, pris);
				cleanText();
				hemtatjenstlist();
			}
		});
		btnandraTjanst.setBounds(652, 262, 120, 23);
		contentPane.add(btnandraTjanst);
		
		JButton btnTaBortTjanst = new JButton("Ta bort tj\u00E4nst");
		btnTaBortTjanst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String KundNR = textKundNr.getText();
				String NR = textMaskinTjenstNr.getText();
				db.taborttjenst(KundNR,NR);
				cleanText();
				hemtatjenstlist();
			}
		});
		btnTaBortTjanst.setBounds(652, 297, 120, 23);
		contentPane.add(btnTaBortTjanst);
		
	}

	private void Spara()
	{
		String KundNamn = textKundNamn.getText();
		String KundNR = textKundNr.getText();
		int kundnr = Integer.parseInt(KundNR);
		db.NyKund(KundNamn, kundnr);
		String MO = textFieldMO.getText();
		String LO = textFieldLO.getText();
		String Affo = textFieldAffo.getText();
		String Vinst= textFieldAffo.getText();
		int mo = Integer.parseInt(MO);
		int lo = Integer.parseInt(LO);
		int affo = Integer.parseInt(Affo);
		int vinst = Integer.parseInt(Vinst);
		db.Procent(kundnr, mo, lo, affo, vinst);
		db.endraprocent(kundnr, mo,lo,affo,vinst);//fel sätt någon annnan stands
		
	}

	private void maskinpanellists(JPanel MaskinPanel)
	{
		listNRM = new JList();
		listNRM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (listNRM.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					veljnrm(listselecter);
				}
				
			}
		});
		MaskinPanel.add(listNRM);
		
		listMaskin = new JList();
		listMaskin.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listMaskin.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					veljmaskin(listselecter);
				}
			}
		});
		MaskinPanel.add(listMaskin);
		
		listPris = new JList();
		listPris.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				if (listPris.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					veljpris(listselecter);
				}
			}
		});
		MaskinPanel.add(listPris);
	}
	
	private void tjänstpanellists(JPanel TjänstPanel)
	{
		listNRT = new JList();
		listNRT.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listNRT.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					veljnrt(listselecter);
				}
			}
		});
		TjänstPanel.add(listNRT);
		
		listTjanst = new JList();
		listTjanst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listTjanst.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					veljtjenst(listselecter);
				}
			}
		});
		TjänstPanel.add(listTjanst);
		
		listPrisTid = new JList();
		listPrisTid.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listPrisTid.getSelectedIndex() == -1)
				{
			        //inget händer
				}
				else
				{
					veljpristid(listselecter);
				}
			}
		});
		TjänstPanel.add(listPrisTid);
	}

	private void Maskinlist()
	{
		hemtamaskinlist();
		hemtaprosent();
	}
	
	private void cleanText()
	{
		textMaskinTjenstNr.setText(null);
		textMaskinTjenst.setText(null);
		textPrisTime.setText(null);
	}
	
	private void hemtaprosent()
	{
		String KundNR = textKundNr.getText();
		int kundnr = Integer.parseInt(KundNR);
		db.getprosent(textFieldMO,textFieldLO,textFieldAffo,textFieldVinst,kundnr);
		
	}
	
	private void hemtamaskinlist()
	{
		String KundNR = textKundNr.getText();
		int kundnr = Integer.parseInt(KundNR);
		db.Maskinlist(listNRM,listMaskin,listPris,kundnr);
	}
	
	private void hemtatjenstlist()
	{
		String KundNR = textKundNr.getText();
		int kundnr = Integer.parseInt(KundNR);
		db.Tjanstlista(listNRT, listTjanst, listPrisTid, kundnr);
	}
	
	private void nymaskin()
	{
		String KundNR = textKundNr.getText();
		String NR = textMaskinTjenstNr.getText();
		String MaskinTjenst = textMaskinTjenst.getText();
		String PrisTime = textPrisTime.getText();
		int kundnr = Integer.parseInt(KundNR);
		int nr = Integer.parseInt(NR);
		int pristime = Integer.parseInt(PrisTime);	
		db.nymaskin(kundnr, nr, MaskinTjenst, pristime);
		db.Maskinlist(listNRM, listMaskin, listPris, kundnr);
	}
	
	private void nytjanst() 
	{
		String KundNR = textKundNr.getText();
		String NR = textMaskinTjenstNr.getText();
		String MaskinTjenst = textMaskinTjenst.getText();
		String PrisTime = textPrisTime.getText();
		int kundnr = Integer.parseInt(KundNR);
		int nr = Integer.parseInt(NR);
		int pristime = Integer.parseInt(PrisTime);
		db.nytjanst(kundnr, nr, MaskinTjenst, pristime);
		db.Tjanstlista(listNRT, listTjanst, listPrisTid, kundnr);
		
	}
	
	
	private void veljnrm(int listselecter)
	{
		if(listselecter == 1)
		{
    		textMaskinTjenstNr.setText(listNRM.getSelectedValue().toString());
        	listMaskin.setSelectedIndex(listNRM.getSelectedIndex());
        	listPris.setSelectedIndex(listNRM.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listMaskin.setSelectedIndex(listNRM.getSelectedIndex());
        	listPris.setSelectedIndex(listNRM.getSelectedIndex());
        }
	
	}


	private void veljmaskin(int listselecter)
	{
		if(listselecter == 1)
		{
    		textMaskinTjenst.setText(listMaskin.getSelectedValue().toString());
        	listNRM.setSelectedIndex(listMaskin.getSelectedIndex());
        	listPris.setSelectedIndex(listMaskin.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listNRM.setSelectedIndex(listMaskin.getSelectedIndex());
        	listPris.setSelectedIndex(listMaskin.getSelectedIndex());
        }
	}
	
	
	private void veljpris(int listselecter)
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
	
	
	private void veljnrt(int listselecter) 
	{
		if(listselecter == 1)
		{
    		textMaskinTjenstNr.setText(listNRT.getSelectedValue().toString());
        	listTjanst.setSelectedIndex(listNRT.getSelectedIndex());
        	listPrisTid.setSelectedIndex(listNRT.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listTjanst.setSelectedIndex(listNRT.getSelectedIndex());
        	listPrisTid.setSelectedIndex(listNRT.getSelectedIndex());
        }
	}
	
	private void veljtjenst(int listselecter) 
	{
		if(listselecter == 1)
		{
    		textMaskinTjenst.setText(listTjanst.getSelectedValue().toString());
        	listNRT.setSelectedIndex(listTjanst.getSelectedIndex());
        	listPrisTid.setSelectedIndex(listTjanst.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listNRT.setSelectedIndex(listTjanst.getSelectedIndex());
        	listPrisTid.setSelectedIndex(listTjanst.getSelectedIndex());
        }
	}
	
	private void veljpristid(int listselecter) 
	{
		if(listselecter == 1)
		{
    		textPrisTime.setText(listPrisTid.getSelectedValue().toString());
        	listNRT.setSelectedIndex(listPrisTid.getSelectedIndex());
        	listTjanst.setSelectedIndex(listPrisTid.getSelectedIndex());
		}
        else if(listselecter == 0)
        {
        	listNRT.setSelectedIndex(listPrisTid.getSelectedIndex());
        	listTjanst.setSelectedIndex(listPrisTid.getSelectedIndex());
        }
	}
	
	private static void test(String Excel,JPanel MaskinPanel,JPanel TjänstPanel,JTextField textKundNr )//JList listNRM 
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
                        //String[] myStringArray = {currentCell.getStringCellValue()};
                        //System.out.println(myStringArray);
                        //String ert = currentCell.getStringCellValue();
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



