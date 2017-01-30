

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoutef extends JFrame {

	private JPanel addroutef;
	static JTextField textfrom;
	static JTextField textto;
	static JTextField textday;
	static JTextField textmonth;
	static JTextField textyear;
	static JTextField texthour;
	static JTextField textminutes;
	static JTextField textprice;
	static JTextField textseats;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddRoutef() {
		setTitle("ΠΡΟΣΘΗΚΗ ΔΡΟΜΟΛΟΓΙΟΥ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 315, 460);
		addroutef = new JPanel();
		addroutef.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addroutef);
		addroutef.setLayout(null);
		
		JLabel label = new JLabel("ΑΠΟ");
		label.setBounds(20, 27, 46, 14);
		addroutef.add(label);
		
		JLabel label_1 = new JLabel("ΠΡΟΣ");
		label_1.setBounds(20, 52, 46, 14);
		addroutef.add(label_1);
		
		textfrom = new JTextField();
		textfrom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		textfrom.setBounds(61, 24, 142, 20);
		addroutef.add(textfrom);
		textfrom.setColumns(10);
		
		textto = new JTextField();
		textto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		textto.setBounds(61, 52, 142, 20);
		addroutef.add(textto);
		textto.setColumns(10);
		
		textday = new JTextField();
		textday.setBounds(18, 131, 31, 20);
		addroutef.add(textday);
		textday.setColumns(10);
		
		textmonth = new JTextField();
		textmonth.setBounds(59, 131, 31, 20);
		addroutef.add(textmonth);
		textmonth.setColumns(10);
		
		textyear = new JTextField();
		textyear.setBounds(100, 131, 46, 20);
		addroutef.add(textyear);
		textyear.setColumns(10);
		
		JLabel label_2 = new JLabel("ΗΜ/Μ/ΕΤΟΣ");
		label_2.setBounds(35, 106, 97, 14);
		addroutef.add(label_2);
		
		JLabel label_3 = new JLabel("ΩΡΑ/ΛΕΠΤΑ (σε 24 μορφη)");
		label_3.setBounds(20, 170, 142, 14);
		addroutef.add(label_3);
		
		texthour = new JTextField();
		texthour.setColumns(10);
		texthour.setBounds(20, 197, 39, 20);
		addroutef.add(texthour);
		
		textminutes = new JTextField();
		textminutes.setBounds(71, 197, 39, 20);
		addroutef.add(textminutes);
		textminutes.setColumns(10);
		
		JLabel label_4 = new JLabel("ΤΙΜΗ ΕΙΣΙΤΗΡΙΟΥ");
		label_4.setBounds(20, 241, 112, 14);
		addroutef.add(label_4);
		
		textprice = new JTextField();
		textprice.setBounds(20, 266, 86, 20);
		addroutef.add(textprice);
		textprice.setColumns(10);
		
		JButton btncancel = new JButton("ΑΚΥΡΩΣΗ");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btncancel.setBounds(73, 376, 89, 34);
		addroutef.add(btncancel);
		
		JButton btnsubmit = new JButton("ΚΑΤΑΧΩΡΗΣΗ");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((AddDb.checkNotNull())==1){
					dispose();
				}
			}
		});
		btnsubmit.setBounds(184, 376, 105, 34);
		addroutef.add(btnsubmit);
		
		JLabel label_5 = new JLabel("ΑΡ.ΘΕΣΕΩΝ");
		label_5.setBounds(20, 300, 90, 14);
		addroutef.add(label_5);
		
		textseats = new JTextField();
		textseats.setBounds(20, 328, 86, 20);
		addroutef.add(textseats);
		textseats.setColumns(10);
	}
}
