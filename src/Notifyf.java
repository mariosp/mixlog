import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Notifyf extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	
	public Notifyf() {
		setTitle("ΠΡΟΣΘΗΚΗ ΑΝΑΚΟΙΝΩΣΕΩΝ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ΠΡΟΣΘΗΚΗ ΑΝΑΚΟΙΝΩΣΗΣ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 193, 32);
		contentPane.add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(10, 66, 366, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(10, 97, 366, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(10, 128, 366, 20);
		contentPane.add(t3);
		
		JButton btnNewButton = new JButton("ΤΕΛΟΣ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Statement stmt = MySqlConn.dbConnector().createStatement();
					
					String sql = "UPDATE notify SET `note`='"+t1.getText()+"' WHERE `n_id`='1'";
					stmt.executeUpdate(sql);
					
					sql = "UPDATE notify SET `note`='"+t2.getText()+"' WHERE `n_id`='2'";
					stmt.executeUpdate(sql);
					
					sql = "UPDATE notify SET `note`='"+t3.getText()+"' WHERE `n_id`='3'";
					stmt.executeUpdate(sql);
					stmt.close();
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
			
			
		});
		btnNewButton.setBounds(379, 284, 102, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ΑΚΥΡΩΣΗ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(267, 284, 102, 32);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("ΔΙΑΓΡΑΦΗ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				
			}
		});
		button.setBounds(382, 65, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("ΔΙΑΓΡΑΦΗ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t2.setText("");
			}
		});
		button_1.setBounds(382, 96, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("ΔΙΑΓΡΑΦΗ");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t3.setText("");
			}
		});
		button_2.setBounds(382, 127, 89, 23);
		contentPane.add(button_2);
		
		
		try {
			Statement stmt = MySqlConn.dbConnector().createStatement();
			
			ResultSet rt=stmt.executeQuery("SELECT * FROM notify");
			
			
				rt.next();
				t1.setText(rt.getString("note"));
				rt.next();
				t2.setText(rt.getString("note"));
				rt.next();
				t3.setText(rt.getString("note"));
				
				stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
