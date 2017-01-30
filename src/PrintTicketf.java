

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PrintTicketf extends TicketSellf {

	private JPanel printticketf;
	static JLabel labelFirst;
	static  JLabel labelLast;
	static  JLabel labelTicketN;
	static  JLabel labelPay;
	static  JLabel labelTotal; 
	static  JLabel labelDate; 
	static JLabel labelb_id;
	
	/**
	 * Create the frame.
	 * @param textFieldCard 
	 */
	public PrintTicketf(JTextField textFieldLN,JTextField textFieldFN,JComboBox comboBoxTicketNum,int sumf,String select, JTextField textFieldCard) {
		setTitle("ΕΙΣΙΤΗΡΙΟ");
		setBounds(100, 100, 448, 366);
		printticketf = new JPanel();
		printticketf.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(printticketf);
		printticketf.setLayout(null);
		
		JButton btn1 = new JButton("ΤΕΛΟΣ");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TicketSellf ticketsellf =new TicketSellf();
				ticketsellf.setVisible(true);
			}
		});
		btn1.setBounds(276, 270, 151, 46);
		printticketf.add(btn1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 99, 417, 2);
		printticketf.add(separator);
		
		JLabel labelCompany = new JLabel("tes");
		labelCompany.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelCompany.setBounds(10, 2, 221, 24);
		printticketf.add(labelCompany);
		
		JLabel labelAddress = new JLabel("New label");
		labelAddress.setBounds(10, 37, 187, 14);
		printticketf.add(labelAddress);
		
		JLabel labelAfm = new JLabel("New label");
		labelAfm.setBounds(58, 60, 105, 14);
		printticketf.add(labelAfm);
		
		JLabel lblNewLabel = new JLabel("ΑΦΜ:");
		lblNewLabel.setBounds(10, 60, 36, 14);
		printticketf.add(lblNewLabel);
		
		JLabel label = new JLabel("ΔΟΥ:");
		label.setBounds(227, 60, 29, 14);
		printticketf.add(label);
		
		JLabel labelDoy = new JLabel("New label");
		labelDoy.setBounds(266, 60, 129, 14);
		printticketf.add(labelDoy);
		
		JLabel label_1 = new JLabel("ΤΗΛ:");
		label_1.setBounds(227, 37, 29, 14);
		printticketf.add(label_1);
		
		JLabel labelTel = new JLabel("New label");
		labelTel.setBounds(266, 37, 129, 14);
		printticketf.add(labelTel);
		
		JLabel label_2 = new JLabel("ΑΡ.ΕΙΣΙΤΗΡΙΟΥ");
		label_2.setBounds(240, 111, 81, 14);
		printticketf.add(label_2);
		
		JLabel labelb_id = new JLabel("");
		labelb_id.setBounds(331, 112, 48, 14);
		printticketf.add(labelb_id);
		
		JLabel labelLast = new JLabel("New label");
		labelLast.setBounds(10, 111, 95, 14);
		printticketf.add(labelLast);
		
		JLabel labelFirst = new JLabel("New label");
		labelFirst.setBounds(115, 111, 115, 14);
		printticketf.add(labelFirst);
		
		JLabel label_3 = new JLabel("ΑΡ. ΕΙΣΙΤΗΡΙΩΝ:");
		label_3.setBounds(10, 136, 95, 14);
		printticketf.add(label_3);
		
		JLabel labelTicketN = new JLabel("New label");
		labelTicketN.setBounds(115, 136, 55, 14);
		printticketf.add(labelTicketN);
		
		JLabel label_4 = new JLabel("ΠΛΗΡΩΜ. ΜΕ :");
		label_4.setBounds(10, 161, 95, 14);
		printticketf.add(label_4);
		
		JLabel labelPay = new JLabel("New label");
		labelPay.setBounds(115, 161, 105, 14);
		printticketf.add(labelPay);
		
		JLabel labelTotal = new JLabel("New label");
		labelTotal.setBounds(10, 186, 144, 14);
		printticketf.add(labelTotal);
		
		JLabel label_5 = new JLabel("ΗΜ.ΚΡΑΤΗΣΗΣ:");
		label_5.setBounds(240, 136, 81, 14);
		printticketf.add(label_5);
		
		JLabel labelDate = new JLabel("New label");
		labelDate.setBounds(238, 161, 168, 14);
		printticketf.add(labelDate);
		
		JLabel lblNewLabel_1 = new JLabel("ΠΡΟΣ :");
		lblNewLabel_1.setBounds(214, 211, 42, 14);
		printticketf.add(lblNewLabel_1);
		
		JLabel label_6 = new JLabel("ΑΠΟ :");
		label_6.setBounds(10, 211, 36, 14);
		printticketf.add(label_6);
		
		JLabel lblAna = new JLabel("ΗΜΕΡΟΜΗΝΙΑ ANAΧ :");
		lblAna.setBounds(10, 244, 134, 14);
		printticketf.add(lblAna);
		
		JLabel lDay = new JLabel("New label");
		lDay.setBounds(160, 244, 213, 14);
		printticketf.add(lDay);
		
		JLabel lblAnax = new JLabel("ΩΡΑ ANAX. :");
		lblAnax.setBounds(10, 270, 81, 14);
		printticketf.add(lblAnax);
		
		JLabel lHour = new JLabel("New label");
		lHour.setBounds(108, 269, 123, 14);
		printticketf.add(lHour);
		
		JLabel lFrom = new JLabel("New label");
		lFrom.setBounds(56, 211, 144, 14);
		printticketf.add(lFrom);
		
		JLabel lTo = new JLabel("New label");
		lTo.setBounds(266, 211, 156, 14);
		printticketf.add(lTo);
		
		if(select=="ΚΑΡΤΑ"){ //MONO AN EXEI EPILEXTHEI PLIROMI ME KARTA THA EMFANISTOYN ta 2 parakatw Jlabel
		
		JLabel label_9 = new JLabel("ΑΡ.ΚΑΡΤΑΣ");
		label_9.setBounds(10, 302, 90, 14);
		printticketf.add(label_9);
		
		JLabel lCard = new JLabel("New label");
		lCard.setBounds(80, 302, 117, 14);
		printticketf.add(lCard);
		
		
		lCard.setText(textFieldCard.getText().substring(textFieldCard.getText().length()-4)); //EMFANISH TELEYTAIWN 4ARWN PSIFION
		}
		
		
		
		
		labelLast.setText(textFieldLN.getText());
		labelFirst.setText(textFieldFN.getText());
		labelTicketN.setText(comboBoxTicketNum.getSelectedItem().toString());
		labelPay.setText(select);
		labelTotal.setText("ΣΥΝΟΛΟ :"+sumf+" E");
		labelb_id.setText(Prepare.bookedID);
		
		
		try {
			Statement stmt = MySqlConn.dbConnector().createStatement();
			
			ResultSet rt=stmt.executeQuery("SELECT * FROM routes2,booked WHERE `routes2`.`r_id`='"
					+Prepare.ID+"' AND `booked`.`b_id`='"
					+Prepare.bookedID+"'");
			
			rt.next();
			labelDate.setText(rt.getString("timebooked"));
			lFrom.setText(rt.getString("from"));
			lTo.setText(rt.getString("to"));
			lDay.setText(rt.getString("day")+"-"+rt.getString("month")+"-"+rt.getString("year"));
			lHour.setText(rt.getString("hour")+":"+rt.getString("minutes"));
			
			
			//eisagwgh stoixeiwn etairias
			rt=stmt.executeQuery("SELECT * FROM etairia");
			
			rt.next();
			labelCompany.setText(rt.getString("name"));
			labelAddress.setText(rt.getString("address"));
			labelTel.setText(rt.getString("tel"));
			labelAfm.setText(rt.getString("afm"));
			labelDoy.setText(rt.getString("doy"));
			
			
			
			
			stmt.close();
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
