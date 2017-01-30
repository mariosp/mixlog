

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Adminf extends JFrame {

	private JPanel adminf;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Adminf() {
		setTitle("ΜΕΝΟΥ ΔΙΑΧΕΙΡΙΣΤΗ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 357);
		adminf = new JPanel();
		adminf.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(adminf);
		adminf.setLayout(null);
		
		JButton btnAddBusRoute = new JButton("ΠΡΟΣΘΗΚΗ ΔΡΟΜΟΛΟΓΙΟΥ");
		btnAddBusRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddRoutef addroutef = new AddRoutef();
				addroutef.setVisible(true);
			}
		});
		btnAddBusRoute.setBounds(10, 32, 212, 41);
		adminf.add(btnAddBusRoute);
		
		JButton button = new JButton("ΕΠΕΞΕΡΓΑΣΙΑ ΣΤΟΙΧΕΙΩΝ ΕΤΑΙΡΙΑΣ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditCompany editcompanyf = new EditCompany();
				editcompanyf.setVisible(true);
				
			}
		});
		button.setBounds(10, 162, 212, 41);
		adminf.add(button);
		
		JButton button_1 = new JButton("ΠΡΟΣΘΗΚΗ ΑΝΑΚΟΙΝΩΣΗΣ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notifyf notifyf = new Notifyf();
				notifyf.setVisible(true);
			}
		});
		button_1.setBounds(10, 98, 212, 41);
		adminf.add(button_1);
		
		JButton btnexitadmin = new JButton("ΕΞΟΔΟΣ ΜΕΝΟΥ ΔΙΑΧ");
		btnexitadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		
			}
		});
		btnexitadmin.setBounds(355, 259, 162, 48);
		adminf.add(btnexitadmin);
	}

}
