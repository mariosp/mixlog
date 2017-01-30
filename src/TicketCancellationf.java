import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketCancellationf extends JFrame {

	private JPanel contentPane;
	private JTextField tid;

	public TicketCancellationf() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ΑΚΥΡΩΣΗ ΕΙΣΙΤΗΡΙΟΥ ΜΠΟΡΕΙ ΝΑ ΓΙΝΕΙ ΜΟΝΟ 3 ΜΕΡΕΣ ΠΡΙΝ ΤΗΝ ΑΝΑΧΩΡΗΣΗ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(0, 0, 386, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ΑΚΥΡΩΣΗ ΜΕ ΑΡΙΘΜΟ ΕΙΣΙΤΗΡΙΟΥ");
		lblNewLabel_1.setBounds(10, 45, 226, 14);
		contentPane.add(lblNewLabel_1);
		
		tid = new JTextField();
		tid.setBounds(20, 70, 99, 20);
		contentPane.add(tid);
		tid.setColumns(10);
		
		JLabel lmes = new JLabel("");
		lmes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lmes.setBounds(0, 101, 409, 20);
		contentPane.add(lmes);
		
		JButton btnNewButton = new JButton("ΑΚΥΡΩΣΗ");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				CheckCancel checkcancel =new CheckCancel();
				checkcancel.checkca(tid);
				
				if(checkcancel.checkdate()==1){
					lmes.setText(" ΑΚΥΡΩΣΗ ΕΓΙΝΕ. ΤΟ ΕΠΙΣΤΡΕΦΟΜΕΝΟ ΠΟΣΟ ΕΙΝΑΙ: "+checkcancel.total);
					checkcancel.delete();
					
				}else
				lmes.setText("ΔΕΝ ΓΙΝΕΤΑΙ ΑΚΥΡΩΣΗ. ΕΧΕΙ ΠΕΡΑΣΕΙ Ο ΧΡΟΝΙΚΟΣ ΠΕΡΙΟΡΙΣΜΟΣ");
				
			}
		});
		btnNewButton.setBounds(148, 69, 121, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("ΕΠΙΣΤΡΟΦΗ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(288, 212, 121, 38);
		contentPane.add(button);
		
		
	}

}
