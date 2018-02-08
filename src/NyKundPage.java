import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class NyKundPage extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMO;
	private JTextField textFieldLO;
	private JTextField textFieldAffo;
	private JTextField textFieldVinst;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NyKundPage frame = new NyKundPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NyKundPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSpara = new JButton("Spara");
		btnSpara.setBounds(605, 407, 89, 23);
		contentPane.add(btnSpara);
		
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
		
		JButton btnImport = new JButton("Import");
		btnImport.setBounds(605, 373, 89, 23);
		contentPane.add(btnImport);
		
		textField = new JTextField();
		textField.setBounds(80, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 42, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblKundNamn = new JLabel("Kund Namn");
		lblKundNamn.setBounds(10, 14, 75, 14);
		contentPane.add(lblKundNamn);
		
		JLabel lblKundNr = new JLabel("Kund Nr");
		lblKundNr.setBounds(10, 45, 60, 14);
		contentPane.add(lblKundNr);
		
		JPanel MaskinPanel = new JPanel();
		MaskinPanel.setBounds(10, 124, 249, 306);
		contentPane.add(MaskinPanel);
		MaskinPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JList listNRM = new JList();
		MaskinPanel.add(listNRM);
		
		JList listMaskin = new JList();
		MaskinPanel.add(listMaskin);
		
		JList listPris = new JList();
		MaskinPanel.add(listPris);
		
		JPanel TjänstPanel = new JPanel();
		TjänstPanel.setBounds(269, 124, 249, 306);
		contentPane.add(TjänstPanel);
		TjänstPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JList listNRT = new JList();
		TjänstPanel.add(listNRT);
		
		JList listTjanst = new JList();
		TjänstPanel.add(listTjanst);
		
		JList listPrisTid = new JList();
		TjänstPanel.add(listPrisTid);
		
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
	}
}
