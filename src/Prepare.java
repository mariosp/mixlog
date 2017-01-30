
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import com.mysql.*; 

public class Prepare extends TicketSellf {
	static int ID;
	static String bookedID;

	static void preparefrom(JComboBox<String> comboBoxFrom){
		
		CheckAvailable.checkava();  //elenxos an exei perasei i ektelesi dromologiou alazei to available
		try {
			Statement stmt = MySqlConn.dbConnector().createStatement();
            ResultSet rs=stmt.executeQuery("SELECT DISTINCT `from` FROM routes2 WHERE `available`='1'");
            
            while (rs.next()) {  
              comboBoxFrom.addItem(rs.getString("from"));  
              
           }
            stmt.close();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
	}
	}
//telos preparefrom

static void changeBox(JComboBox<String> comboBoxTo,JComboBox<String> comboBoxFrom){
	
	try {
		Statement stmt = MySqlConn.dbConnector().createStatement();
        ResultSet rt=stmt.executeQuery("SELECT DISTINCT `from`,`to` FROM routes2 WHERE `from`='"+comboBoxFrom.getSelectedItem().toString()+"' AND `available`='1' ");
        
        while (rt.next()) {  
          comboBoxTo.addItem(rt.getString("to"));  
          
       }
        stmt.close();
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
	
}
}

static void changeBoxMonth(JComboBox<String> comboBoxTo,JComboBox<String> comboBoxFrom,JComboBox<String> comboBoxMonth,JComboBox<String> comboBoxYear){
	try {
		Statement stmt = MySqlConn.dbConnector().createStatement();
        ResultSet rt=stmt.executeQuery("SELECT DISTINCT `month` FROM routes2 WHERE `from`='"
        								+comboBoxFrom.getSelectedItem().toString()+
        								"' AND `to`='"
        								+comboBoxTo.getSelectedItem().toString()+"' AND `year`='"
        								+comboBoxYear.getSelectedItem().toString()+"' AND `available`='1' ");
       
        while (rt.next()) { 
        	
        	
          comboBoxMonth.addItem(rt.getString("month"));
          
       }
        stmt.close();
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
	
}
}//telos changeBoxDay


static void changeBoxDay(JComboBox<String> comboBoxTo,JComboBox<String> comboBoxFrom,JComboBox<String> comboBoxMonth,JComboBox<String> comboBoxYear,JComboBox<String> comboBoxDay){
	try {
		Statement stmt = MySqlConn.dbConnector().createStatement();
		 ResultSet rt=stmt.executeQuery("SELECT DISTINCT `day` FROM routes2 WHERE `from`='"
					+comboBoxFrom.getSelectedItem().toString()+"' AND `to`='"
					+comboBoxTo.getSelectedItem().toString()+"' AND `year`='"
					+comboBoxYear.getSelectedItem().toString()+"' AND `month`='"
					+comboBoxMonth.getSelectedItem().toString()+"' AND `available`='1' ");
		 
		 
        while (rt.next()) {  
          comboBoxDay.addItem(rt.getString("day"));
          
       }
        stmt.close();
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
	
}
}//telos changeBoxDay

static void changeBoxYear(JComboBox<String> comboBoxTo,JComboBox<String> comboBoxFrom,JComboBox<String> comboBoxYear){
	try {
		Statement stmt = MySqlConn.dbConnector().createStatement();
        ResultSet rt=stmt.executeQuery("SELECT DISTINCT `year` FROM routes2 WHERE `from`='"
        								+comboBoxFrom.getSelectedItem().toString()+
        								"' AND `to`='"
        								+comboBoxTo.getSelectedItem().toString()+"' AND `available`='1' ");
      
        while (rt.next()) {  
          comboBoxYear.addItem(rt.getString("year"));
          
       }
        stmt.close();
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
	
}
}//telos changeBoxYear

static void changeBoxHour(JComboBox<String> comboBoxTo,JComboBox<String> comboBoxFrom,JComboBox<String> comboBoxMonth,JComboBox<String> comboBoxYear,JComboBox<String> comboBoxDay,JComboBox<String> comboBoxHour){
	try {
		Statement stmt = MySqlConn.dbConnector().createStatement();
		 ResultSet rt=stmt.executeQuery("SELECT DISTINCT `hour` FROM routes2 WHERE `from`='"
					+comboBoxFrom.getSelectedItem().toString()+"' AND `to`='"
					+comboBoxTo.getSelectedItem().toString()+"' AND `year`='"
					+comboBoxYear.getSelectedItem().toString()+"' AND `month`='"
					+comboBoxMonth.getSelectedItem().toString()+"' AND `day`='"
					+comboBoxDay.getSelectedItem().toString()+"' AND `available`='1'");
		 
		 
        while (rt.next()) {  
          comboBoxHour.addItem(rt.getString("hour"));
          
       }
        stmt.close();
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
	
}
}//telos changeBoxHour

static void changeBoxMinutes(JComboBox<String> comboBoxTo,JComboBox<String> comboBoxFrom,JComboBox<String> comboBoxMonth,JComboBox<String> comboBoxYear,JComboBox<String> comboBoxDay,JComboBox<String> comboBoxHour,JComboBox<String> comboBoxMinutes){
	try {
		Statement stmt = MySqlConn.dbConnector().createStatement();
		 ResultSet rt=stmt.executeQuery("SELECT DISTINCT `minutes` FROM routes2 WHERE `from`='"
					+comboBoxFrom.getSelectedItem().toString()+"' AND `to`='"
					+comboBoxTo.getSelectedItem().toString()+"' AND `year`='"
					+comboBoxYear.getSelectedItem().toString()+"' AND `month`='"
					+comboBoxMonth.getSelectedItem().toString()+"' AND `day`='"
					+comboBoxDay.getSelectedItem().toString()+"' AND `hour`='"
					+comboBoxHour.getSelectedItem().toString()+"' AND `available`='1' ");
		 
		 
        while (rt.next()) {  
          comboBoxMinutes.addItem(rt.getString("minutes"));
          
       }
        stmt.close();
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
	
}
}//telos changeBoxMinutes

static int changeBoxSum(JComboBox<String> comboBoxTo,JComboBox<String> comboBoxFrom,JComboBox<String> comboBoxMonth,JComboBox<String> comboBoxYear,JComboBox<String> comboBoxDay,JComboBox<String> comboBoxHour,JComboBox<String> comboBoxMinutes){
	int price = 0;
	try {
		Statement stmt = MySqlConn.dbConnector().createStatement();
		 ResultSet rt=stmt.executeQuery("SELECT `cost` FROM routes2 WHERE `from`='"
					+comboBoxFrom.getSelectedItem().toString()+"' AND `to`='"
					+comboBoxTo.getSelectedItem().toString()+"' AND `year`='"
					+comboBoxYear.getSelectedItem().toString()+"' AND `month`='"
					+comboBoxMonth.getSelectedItem().toString()+"' AND `day`='"
					+comboBoxDay.getSelectedItem().toString()+"' AND `hour`='"
					+comboBoxHour.getSelectedItem().toString()+"' AND `minutes`='"
					+comboBoxMinutes.getSelectedItem().toString()+"' AND `available`='1' ");
		 
		 rt.next();
		 price=rt.getInt("cost");
		 stmt.close();
		 return price;
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
	
}
	return price;
}//telos changeBoxMinutes


static void checkNotNull(){
	if (textFieldLN.getText() == null || textFieldLN.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΕΠΙΘΕΤΟ", "ERROR", JOptionPane.ERROR_MESSAGE);
        textFieldLN.requestFocus();
        return;
    }
	
	if (textFieldFN.getText() == null || textFieldFN.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΟΝΟΜΑ", "ERROR", JOptionPane.ERROR_MESSAGE);
        textFieldFN.requestFocus();
        return;
    }
	
	if (textFieldTel.getText() == null || textFieldTel.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΤΗΛΕΦΩΝΟ", "ERROR", JOptionPane.ERROR_MESSAGE);
        textFieldTel.requestFocus();
        return;
    }
	
	if(textFieldCard.isEnabled()){
	if (textFieldCard.getText() == null || textFieldCard.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΑΡΙΘΜΟ ΚΑΡΤΑΣ", "ERROR", JOptionPane.ERROR_MESSAGE);
        textFieldCard.requestFocus();
        return;
    }
	}
	
}//telos checkNotNull


static void submit(JComboBox<String> comboBoxTo,JComboBox<String> comboBoxFrom,JComboBox<String> comboBoxMonth,JComboBox<String> comboBoxYear,JComboBox<String> comboBoxDay,JComboBox<String> comboBoxHour,JComboBox<String> comboBoxMinutes,JComboBox<String> comboBoxTicketNum,int sumf){
	try {
        Statement stmt = MySqlConn.dbConnector().createStatement();
        
        ResultSet rt=stmt.executeQuery("SELECT `r_id` FROM routes2 WHERE `from`='"
				+comboBoxFrom.getSelectedItem().toString()+"' AND `to`='"
				+comboBoxTo.getSelectedItem().toString()+"' AND `year`='"
				+comboBoxYear.getSelectedItem().toString()+"' AND `month`='"
				+comboBoxMonth.getSelectedItem().toString()+"' AND `day`='"
				+comboBoxDay.getSelectedItem().toString()+"' AND `hour`='"
				+comboBoxHour.getSelectedItem().toString()+"' AND `minutes`='"
				+comboBoxMinutes.getSelectedItem().toString()+"' AND `available`='1' ");
	 
	 rt.next();
	  ID=rt.getInt("r_id");
        
        
        
        
        String sql = "INSERT INTO booked(`lastname`,`firstname`,`tel`,`numtickets`,`r_id`) VALUES ('"
        		+textFieldLN.getText() + "', '" +
        		textFieldFN.getText() + "', '" +
        		textFieldTel.getText() +"','"+
        		comboBoxTicketNum.getSelectedItem().toString()+"','"+
        		ID+"')";
        
        stmt.executeUpdate(sql);
        rt=stmt.executeQuery("SELECT last_insert_id()");
        rt.next();
         bookedID =rt.getString("last_insert_id()");
        

         sql = "INSERT INTO payment(`total`,`cnumber`,`b_id`) VALUES ('"
        		+sumf+ "', '" +
        		textFieldCard.getText() + "', '" +
        		rt.getString("last_insert_id()")+"')";
        
        stmt.executeUpdate(sql);
        
        rt=stmt.executeQuery("SELECT last_insert_id()");
        rt.next();
        
        sql = "UPDATE booked SET `p_id`='"+
        		rt.getString("last_insert_id()")+"' WHERE `b_id`='"+
        		bookedID+"'";
       
        stmt.executeUpdate(sql);
        
        
        stmt.close();
        
        
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
	
}
	
} //telos sumbmit

}




