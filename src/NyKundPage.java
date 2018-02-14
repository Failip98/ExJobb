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
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
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
		
		JButton btnhemta = new JButton("H\u00E4mta");
		btnhemta.setBounds(176, 41, 89, 23);
		contentPane.add(btnhemta);
		
		
		
		
		
	}
	private void label()
	{
		JLabel lblMO = new JLabel("MO");
		lblMO.setBounds(552, 14, 46, 14);
		contentPane.add(lblMO);
		
		JLabel lblLO = new JLabel("LO");
		lblLO.setBounds(552, 45, 46, 14);
		contentPane.add(lblLO);
		
		JLabel lblAffo = new JLabel("Affo");
		lblAffo.setBounds(552, 76, 46, 14);
		contentPane.add(lblAffo);
		
		JLabel lblVinst = new JLabel("Vinst");
		lblVinst.setBounds(552, 107, 46, 14);
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
		lbllegtillNr.setBounds(540, 138, 46, 14);
		contentPane.add(lbllegtillNr);
		
		JLabel lbllegtillMaskintjenst = new JLabel("Maskin/Tj\u00E4nst");
		lbllegtillMaskintjenst.setBounds(540, 169, 46, 14);
		contentPane.add(lbllegtillMaskintjenst);
		
		JLabel lbllagtillpris = new JLabel("Pris/Time");
		lbllagtillpris.setBounds(540, 200, 46, 14);
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
		textFieldMO.setBounds(608, 11, 86, 20);
		contentPane.add(textFieldMO);
		textFieldMO.setColumns(10);
		
		textFieldLO = new JTextField();
		textFieldLO.setBounds(608, 42, 86, 20);
		contentPane.add(textFieldLO);
		textFieldLO.setColumns(10);
		
		textFieldAffo = new JTextField();
		textFieldAffo.setBounds(608, 73, 86, 20);
		contentPane.add(textFieldAffo);
		textFieldAffo.setColumns(10);
		
		textFieldVinst = new JTextField();
		textFieldVinst.setBounds(608, 104, 86, 20);
		contentPane.add(textFieldVinst);
		textFieldVinst.setColumns(10);
		
		textExcel = new JTextField();
		textExcel.setBounds(608, 308, 86, 20);
		contentPane.add(textExcel);
		textExcel.setColumns(10);
		
		textMaskinTjenstNr = new JTextField();
		textMaskinTjenstNr.setBounds(608, 135, 86, 20);
		contentPane.add(textMaskinTjenstNr);
		textMaskinTjenstNr.setColumns(10);
		
		textMaskinTjenst = new JTextField();
		textMaskinTjenst.setBounds(608, 166, 86, 20);
		contentPane.add(textMaskinTjenst);
		textMaskinTjenst.setColumns(10);
		
		textPrisTime = new JTextField();
		textPrisTime.setBounds(608, 197, 86, 20);
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
		btnSpara.setBounds(608, 407, 89, 23);
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
		btnImport.setBounds(608, 339, 89, 23);
		contentPane.add(btnImport);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//dispose();
				//FirstPage p = new FirstPage();
				//p.setVisible(true);
				System.out.println("hej");
			}
		});
		btnBack.setBounds(608, 373, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnNyMaskin = new JButton("Ny Maskin");
		btnNyMaskin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nymaskin();
			}
		});
		btnNyMaskin.setBounds(605, 228, 89, 23);
		contentPane.add(btnNyMaskin);
		
		JButton btnNewButton_1 = new JButton("Ny Tj\u00E4nst");
		btnNewButton_1.setBounds(605, 262, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
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
		
	}

	private void maskinpanellists(JPanel MaskinPanel)
	{
		listNRM = new JList();
		MaskinPanel.add(listNRM);
		
		listMaskin = new JList();
		MaskinPanel.add(listMaskin);
		
		listPris = new JList();
		MaskinPanel.add(listPris);
	}
	
	private void tjänstpanellists(JPanel TjänstPanel)
	{
		listNRT = new JList();
		TjänstPanel.add(listNRT);
		
		listTjanst = new JList();
		TjänstPanel.add(listTjanst);
		
		listPrisTid = new JList();
		TjänstPanel.add(listPrisTid);
	}

	private void filupmasiknlist()
	{
		
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
	
	private void nymaskin()
	{
		String KundNR = textKundNr.getText();
		String NR = textMaskinTjenstNr.getText();
		String MaskinTjenst = textMaskinTjenst.getText();
		String PrisTime = textPrisTime.getText();
		int kundnr = Integer.parseInt(KundNR);
		int nr = Integer.parseInt(NR);
		int pristime = Integer.parseInt(PrisTime);
		db.nymaskin(kundnr,nr,MaskinTjenst,pristime);
		cleanText();
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



