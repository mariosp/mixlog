

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class Cashierf extends JFrame {

	private JPanel cashierf;

	
	public Cashierf() {
		setResizable(false);
		setTitle("ΜΕΝΟΥ ΤΑΜΙΑ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 403);
		cashierf = new JPanel();
		cashierf.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cashierf);
		cashierf.setLayout(null);
		
		JButton btnTicketSell = new JButton("ΕΚΔΟΣΗ ΕΙΣΙΤΗΡΙΟΥ");
		btnTicketSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//cashierf.setVisible(false);
				TicketSellf ticketsellf =new TicketSellf();
				ticketsellf.setVisible(true);
			}
		});
		btnTicketSell.setBounds(10, 48, 166, 47);
		cashierf.add(btnTicketSell);
		
		JButton btnTicketCancellation = new JButton("ΑΚΥΡΩΣΗ ΕΙΣΙΤΗΡΙΟΥ");
		btnTicketCancellation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketCancellationf ticketc =new TicketCancellationf();
				ticketc.setVisible(true);
			}
		});
		btnTicketCancellation.setBounds(10, 129, 166, 47);
		cashierf.add(btnTicketCancellation);
		
		JButton btnNewButton = new JButton("ΕΞΟΔΟΣ ΜΕΝΟΥ ΤΑΜΙΑ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(371, 321, 166, 42);
		cashierf.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ΑΝΑΚΟΙΝΩΣΕΙΣ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(217, 11, 175, 27);
		cashierf.add(lblNewLabel);
		
		JLabel lb1 = new JLabel("");
		lb1.setVerticalAlignment(SwingConstants.TOP);
		lb1.setBounds(227, 35, 273, 66);
		cashierf.add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setVerticalAlignment(SwingConstants.TOP);
		lb2.setBounds(227, 118, 273, 72);
		cashierf.add(lb2);
		
		JLabel lb3 = new JLabel("");
		lb3.setVerticalAlignment(SwingConstants.TOP);
		lb3.setBounds(227, 205, 273, 72);
		cashierf.add(lb3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(227, 105, 259, 7);
		cashierf.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(227, 197, 259, 7);
		cashierf.add(separator_1);
		
		try {
			Statement stmt = MySqlConn.dbConnector().createStatement();
			
			ResultSet rt=stmt.executeQuery("SELECT * FROM notify");
			
			//Vazoyme HTML gia na mboresoume eukola na kanoume sto keimeno multiline
				rt.next();
				lb1.setText("<HTML>"+rt.getString("note")+"</HTML>");
				rt.next();
				lb2.setText("<HTML>"+rt.getString("note")+"</HTML>");
				rt.next();
				lb3.setText("<HTML>"+rt.getString("note")+"</HTML>");
				
				stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
