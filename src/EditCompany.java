import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class EditCompany extends JFrame {

	private JPanel contentPane;
	private JTextField tc;
	private JTextField ta;
	private JTextField tt;
	private JTextField tafm;
	private JTextField tdoy;

	
	public EditCompany() {
		setTitle("ΑΛΛΑΓΗ ΣΤΟΙΧΕΙΩΝ ΕΤΑΙΡΙΑΣ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 477, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lcompany = new JLabel("ΕΙΣΑΓΩΓΗ ΕΠΩΝΥΜΙΑΣ");
		lcompany.setBounds(10, 11, 131, 14);
		contentPane.add(lcompany);
		
		JLabel label = new JLabel("ΕΙΣΑΓΩΓΗ ΔΙΕΥΘΥΝΣΗΣ");
		label.setBounds(10, 38, 131, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("ΕΙΣΑΓΩΓΗ ΤΗΛΕΦΩΝΟΥ");
		label_1.setBounds(10, 64, 131, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("ΕΙΣΑΓΩΓΗ ΑΦΜ");
		label_2.setBounds(10, 89, 131, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("ΕΙΣΑΓΩΓΗ ΔΟΥ");
		label_3.setBounds(10, 114, 131, 14);
		contentPane.add(label_3);
		
		tc = new JTextField();
		tc.setBounds(141, 8, 274, 20);
		contentPane.add(tc);
		tc.setColumns(10);
		
		ta = new JTextField();
		ta.setColumns(10);
		ta.setBounds(141, 35, 274, 20);
		contentPane.add(ta);
		
		tt = new JTextField();
		tt.setColumns(10);
		tt.setBounds(141, 61, 274, 20);
		contentPane.add(tt);
		
		tafm = new JTextField();
		tafm.setColumns(10);
		tafm.setBounds(141, 86, 274, 20);
		contentPane.add(tafm);
		
		tdoy = new JTextField();
		tdoy.setColumns(10);
		tdoy.setBounds(141, 111, 274, 20);
		contentPane.add(tdoy);
		
		JButton btncan = new JButton("ΑΚΥΡΩΣΗ");
		btncan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btncan.setBounds(208, 268, 105, 42);
		contentPane.add(btncan);
		
		JButton btnfinish = new JButton("ΤΕΛΟΣ");
		btnfinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = MySqlConn.dbConnector().createStatement();
					
					String sql ="Truncate etairia";
					
					stmt.executeUpdate(sql);
					
					 sql = "INSERT INTO etairia(`name`,`address`,`tel`,`afm`,`doy`) VALUES ('"
				        		+tc.getText() + "', '" +
				        		ta.getText() + "', '" +
				        		tt.getText() +"','"+
				        		tafm.getText()+"','"+
				        		tdoy.getText()+"')";
					 
					 stmt.executeUpdate(sql);
					 stmt.close();
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnfinish.setBounds(334, 268, 105, 42);
		contentPane.add(btnfinish);
	}
}
