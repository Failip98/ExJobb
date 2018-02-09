import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;



public class FirstPage extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage frame = new FirstPage();
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
	public FirstPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNyOder = new JButton("Ny Oder");
		btnNyOder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NyOderPage p = new NyOderPage();
				p.setVisible(true);
			}
		});
		btnNyOder.setBounds(170, 70, 120, 23);
		contentPane.add(btnNyOder);
		
		JButton btnNyKund = new JButton("Ny Kund");
		btnNyKund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NyKundPage p = new NyKundPage();
				p.setVisible(true);
				
			}
		});
		btnNyKund.setBounds(170, 104, 120, 23);
		contentPane.add(btnNyKund);
		
		JButton btnAndraKund = new JButton("\u00C4ndra Kund");
		btnAndraKund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NyKundPage p = new NyKundPage();
				p.setVisible(true);
			}
		});
		btnAndraKund.setBounds(170, 138, 120, 23);
		contentPane.add(btnAndraKund);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
		
		
	}
}
