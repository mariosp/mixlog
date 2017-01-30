

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DropMode;

public class TicketSellf extends JFrame {

	private JPanel ticketsellf;
	static JTextField textFieldLN;
	static JTextField textFieldFN;
	static JTextField textFieldTel;
	static JTextField textFieldCard;
	static JComboBox<String> comboBoxDay;
	static JComboBox<String> comboBoxFrom;
	static JComboBox<String> comboBoxTo;
	static JComboBox<String> comboBoxMonth;
	int sumf;
	String select;
	
	
	
	
	public TicketSellf() {
		setTitle("ΕΚΔΟΣΗ ΕΙΣΙΤΗΡΙΟΥ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 524);
		ticketsellf = new JPanel();
		ticketsellf.setToolTipText("");
		ticketsellf.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ticketsellf);
		ticketsellf.setLayout(null);
		
		JLabel labelEpilogiDiadromis = new JLabel("ΕΠΙΛΟΓΗ ΔΙΑΔΡΟΜΗΣ");
		labelEpilogiDiadromis.setHorizontalAlignment(SwingConstants.LEFT);
		labelEpilogiDiadromis.setBounds(10, 0, 184, 30);
		ticketsellf.add(labelEpilogiDiadromis);
		
		JComboBox<String> comboBoxDay = new JComboBox<String>();
		JComboBox<String> comboBoxFrom = new JComboBox<String>();
		JComboBox<String> comboBoxTo = new JComboBox<String>();
		JComboBox<String> comboBoxMonth = new JComboBox<String>();
		JComboBox<String> comboBoxYear = new JComboBox<String>();
		JComboBox<String> comboBoxMinutes = new JComboBox<String>();
		JComboBox<String> comboBoxHour = new JComboBox<String>();
		JLabel textFieldSum = new JLabel("ΣΥΝΟΛΟ :");
		JComboBox comboBoxTicketNum = new JComboBox();
		JLabel lnotav = new JLabel("");
		
		
		
		comboBoxTo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED)){
					comboBoxDay.removeAllItems();
					comboBoxMonth.removeAllItems();
					comboBoxYear.removeAllItems();
					Prepare.changeBoxYear(comboBoxTo, comboBoxFrom, comboBoxYear);
			}
			}
		});
		comboBoxTo.setEnabled(true);
		
		comboBoxTo.setBounds(58, 100, 173, 20);
		ticketsellf.add(comboBoxTo);
		
		
		//JComboBox<String> comboBoxFrom = new JComboBox<String>();
		comboBoxFrom.setSelectedIndex(-1);
		comboBoxFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxTo.removeAllItems();
				comboBoxDay.removeAllItems();
				Prepare.changeBox(comboBoxTo, comboBoxFrom);
			}
		});
		
		comboBoxFrom.setToolTipText("");
		comboBoxFrom.setMaximumRowCount(20);
		comboBoxFrom.setBounds(58, 41, 173, 20);
		ticketsellf.add(comboBoxFrom);
		
		JLabel labelAPO = new JLabel("ΑΠΟ");
		labelAPO.setBounds(10, 42, 46, 14);
		ticketsellf.add(labelAPO);
		
		JLabel labelPROS = new JLabel("ΠΡΟΣ");
		labelPROS.setBounds(10, 103, 46, 14);
		ticketsellf.add(labelPROS);
		

		JLabel labelDay = new JLabel("ΕΠΙΛΟΓΗ ΗΜΕΡΑΣ/ΩΡΑΣ");
		labelDay.setBounds(10, 146, 154, 14);
		ticketsellf.add(labelDay);
		
		//JComboBox comboBoxDay = new JComboBox();
		comboBoxDay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED)){
					comboBoxHour.removeAllItems();
					Prepare.changeBoxHour(comboBoxTo, comboBoxFrom, comboBoxMonth, comboBoxYear, comboBoxDay, comboBoxHour);
				}
				
			}
		});
		comboBoxDay.setBounds(123, 177, 46, 20);
		ticketsellf.add(comboBoxDay);
		
		//JComboBox<String> comboBoxHour = new JComboBox<String>();
		comboBoxHour.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED)){
					comboBoxMinutes.removeAllItems();
					Prepare.changeBoxMinutes(comboBoxTo, comboBoxFrom, comboBoxMonth, comboBoxYear, comboBoxDay, comboBoxHour,comboBoxMinutes);
				}
				
			}
		});
		comboBoxHour.setBounds(194, 177, 60, 20);
		ticketsellf.add(comboBoxHour);
		
		JLabel labelTicketNumer = new JLabel("ΑΡΙΘΜΟΣ ΕΙΣΙΤΗΡΙΩΝ");
		labelTicketNumer.setBounds(10, 221, 143, 14);
		ticketsellf.add(labelTicketNumer);
		
		//comboBoxTicketNum = new JComboBox();
		comboBoxTicketNum.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxTicketNum.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED)){
					int ticketnum =Integer.valueOf((String)comboBoxTicketNum.getSelectedItem());
					
					Seats seat =new Seats();
					int ava=seat.seatsget(comboBoxTo, comboBoxFrom, comboBoxMonth, comboBoxYear, comboBoxDay, comboBoxHour, comboBoxMinutes, comboBoxTicketNum,sumf,"seatsa");
					if(ticketnum<=ava){
					int cost = (int)Prepare.changeBoxSum(comboBoxTo, comboBoxFrom, comboBoxMonth, comboBoxYear, comboBoxDay, comboBoxHour, comboBoxMinutes);
					int summ=seat.su(cost, ticketnum);
					textFieldSum.setText("ΤΟ ΣΥΝΟΛΟ ΕΙΝΑΙ: "+summ);
					sumf=summ;
					lnotav.setText("ΔΙΑΘΕΣΙΜΑ ΕΙΣΙΤΗΡΙΑ "+ava);
					}else{
						lnotav.setText("ΔΕΝ ΥΠΑΡΧΟΥΝ ΕΙΣΙΤΗΡΙΑ");
					}
				}
			}
		});
		comboBoxTicketNum.setBounds(10, 246, 46, 20);
		ticketsellf.add(comboBoxTicketNum);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 331, 539, 14);
		ticketsellf.add(separator);
		
		JLabel label_1 = new JLabel("ΕΠΩΝΥΜΟ");
		label_1.setBounds(10, 356, 67, 14);
		ticketsellf.add(label_1);
		
		textFieldLN = new JTextField();
		textFieldLN.setBounds(78, 353, 153, 20);
		ticketsellf.add(textFieldLN);
		textFieldLN.setColumns(10);
		
		JLabel label_2 = new JLabel("ΟΝΟΜΑ");
		label_2.setBounds(10, 386, 67, 14);
		ticketsellf.add(label_2);
		
		textFieldFN = new JTextField();
		textFieldFN.setColumns(10);
		textFieldFN.setBounds(78, 383, 153, 20);
		ticketsellf.add(textFieldFN);
		
		JLabel label_3 = new JLabel("ΤΗΛ");
		label_3.setBounds(10, 418, 67, 14);
		ticketsellf.add(label_3);
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(78, 411, 153, 20);
		ticketsellf.add(textFieldTel);
		
		JRadioButton rdbtnCash = new JRadioButton("ΜΕΤΡΗΤΑ");
		rdbtnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCard.setText("");
				textFieldCard.enable(false);
			}
		});
		rdbtnCash.setSelected(true);
		rdbtnCash.setBounds(287, 352, 109, 23);
		rdbtnCash.setActionCommand("ΜΕΤΡΗΤΑ");
		ticketsellf.add(rdbtnCash);
		
		JRadioButton rdbtnCard = new JRadioButton("ΚΑΡΤΑ");
		rdbtnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCard.enable(true);
			}
		});
		rdbtnCard.setBounds(415, 352, 109, 23);
		ticketsellf.add(rdbtnCard);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCash);
		group.add(rdbtnCard);
		
		textFieldCard = new JTextField();
		textFieldCard.setToolTipText("ΑΡΙΘΜΟΣ ΚΑΡΤΑΣ");
		textFieldCard.setEnabled(false);
		textFieldCard.setBounds(413, 383, 136, 20);
		ticketsellf.add(textFieldCard);
		textFieldCard.setColumns(10);
		
		//JLabel textFieldSum = new JLabel("ΣΥΝΟΛΟ :");
		textFieldSum.setBounds(297, 418, 164, 14);
		ticketsellf.add(textFieldSum);
		
		JButton btnPrint = new JButton("ΕΚΤΥΠΩΣΗ");
		btnPrint.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//Prepare.checkNotNull();
				Seats seat =new Seats();
				int ava=seat.seatsget(comboBoxTo, comboBoxFrom, comboBoxMonth, comboBoxYear, comboBoxDay, comboBoxHour, comboBoxMinutes, comboBoxTicketNum,sumf,"seatsa");
				int ticketnum =Integer.valueOf((String)comboBoxTicketNum.getSelectedItem());
				
				if(ticketnum<=ava){
				Prepare.submit(comboBoxTo, comboBoxFrom, comboBoxMonth, comboBoxYear, comboBoxDay, comboBoxHour, comboBoxMinutes, comboBoxTicketNum,sumf);
				seat.dicseats(ticketnum);
				if(rdbtnCash.isSelected())
					select= rdbtnCash.getText().toString();
				else
					select= rdbtnCard.getText().toString();
				dispose();
				PrintTicketf printticketf =new PrintTicketf(textFieldLN,textFieldFN,comboBoxTicketNum,sumf,select,textFieldCard);
				printticketf.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "ΔΕΝ ΥΠΑΡΧΟΥΝ ΤΟΣΑ Η` ΚΑΘΟΛΟΥ ΔΙΑΘΕΣΙΜΑ ΕΙΣΙΤΗΡΙΑ. ΚΑΝΤΕ ΕΛΕΝΧΟ ΔΙΑΘΕΣΙΜΩΝ ΕΙΣΙΤΗΡΙΩΝ", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			
			}
		});
		btnPrint.setBounds(451, 444, 98, 30);
		ticketsellf.add(btnPrint);
		
		JButton btnCancel = new JButton("ΑΚΥΡΩΣΗ");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(348, 444, 98, 30);
		ticketsellf.add(btnCancel);
		
		//JComboBox<String> comboBoxMonth = new JComboBox<String>();
		comboBoxMonth.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED)){
					comboBoxDay.removeAllItems();
					Prepare.changeBoxDay(comboBoxTo, comboBoxFrom, comboBoxMonth,comboBoxYear,comboBoxDay);
			}
			}
		});
		
		comboBoxMonth.setBounds(78, 177, 46, 20);
		ticketsellf.add(comboBoxMonth);
		
		//JComboBox<String> comboBoxYear = new JComboBox<String>();
		comboBoxYear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED)){
					comboBoxMonth.removeAllItems();
					Prepare.changeBoxMonth(comboBoxTo, comboBoxFrom, comboBoxMonth,comboBoxYear);
			}
			}
		});
		comboBoxYear.setBounds(10, 177, 67, 20);
		ticketsellf.add(comboBoxYear);
		
		
		
		//JComboBox comboBoxMinutes = new JComboBox();
		comboBoxMinutes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED)){
					int ticketnum =Integer.valueOf((String)comboBoxTicketNum.getSelectedItem());
					Seats seat =new Seats();
					int ava=seat.seatsget(comboBoxTo, comboBoxFrom, comboBoxMonth, comboBoxYear, comboBoxDay, comboBoxHour, comboBoxMinutes, comboBoxTicketNum,sumf,"seatsa");

					if(ticketnum<=ava){
					int cost = (int)Prepare.changeBoxSum(comboBoxTo, comboBoxFrom, comboBoxMonth, comboBoxYear, comboBoxDay, comboBoxHour, comboBoxMinutes);
					int summ=ticketnum*cost;
					
					textFieldSum.setText("ΤΟ ΣΥΝΟΛΟ ΕΙΝΑΙ: "+summ);
					sumf=summ;
					lnotav.setText("ΔΙΑΘΕΣΙΜΑ ΕΙΣΙΤΗΡΙΑ "+ava);
					}else 
					{
						lnotav.setText("ΔΕΝ ΥΠΑΡΧΟΥΝ ΕΙΣΙΤΗΡΙΑ");
					}
					
				}
				
			}
		});
		comboBoxMinutes.setBounds(256, 177, 60, 20);
		ticketsellf.add(comboBoxMinutes);
		
		//JLabel lnotav = new JLabel("");
		lnotav.setBounds(89, 246, 152, 30);
		ticketsellf.add(lnotav);
		
		Prepare.preparefrom(comboBoxFrom);
		
	}	
}
