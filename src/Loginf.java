import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;


import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loginf {

	private JFrame loginf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginf window = new Loginf();
					window.loginf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn=null;
	public Loginf() {
		initialize();
		conn=MySqlConn.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * Kanoume arxikopoihsh tou prwtou JFRAME loginf
	 * 
	 */
	private void initialize() {
		loginf = new JFrame();
		loginf.setResizable(false);
		loginf.setTitle("Εισοδος στο συστημα");
		loginf.setBounds(100, 100, 474, 318);
		loginf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginf.getContentPane().setLayout(null);
		
		JButton btnCashier = new JButton("ΤΑΜΙΑΣ");
		btnCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//loginf.dispose();
				Cashierf cashierf=new Cashierf();
				cashierf.setVisible(true);
						
			}
		});
		btnCashier.setBounds(54, 79, 140, 100);
		loginf.getContentPane().add(btnCashier);
		
		JButton btnAdmin = new JButton("ΔΙΑΧΕΙΡΙΣΤΗΣ");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//loginf.dispose();
				Adminf adminf=new Adminf();
				adminf.setVisible(true);
			}
		});
		btnAdmin.setBounds(265, 79, 140, 100);
		loginf.getContentPane().add(btnAdmin);
	}
}
