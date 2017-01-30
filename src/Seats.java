import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class Seats {
	static int IDr;
	
	public void dicseats(int ticketnum){
		
		try {
			Statement stmt = MySqlConn.dbConnector().createStatement();
			
			
			 String sql="UPDATE busseats SET `seatsa`=`seatsa`-"+ticketnum+" WHERE `r_id`='"+IDr+"'";
			
			 stmt.executeUpdate(sql);
			 
			 
			 stmt.close();
			 
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//telos dicrseats
	
	public int seatsget(JComboBox<String> comboBoxTo,JComboBox<String> comboBoxFrom,JComboBox<String> comboBoxMonth,JComboBox<String> comboBoxYear,JComboBox<String> comboBoxDay,JComboBox<String> comboBoxHour,JComboBox<String> comboBoxMinutes,JComboBox<String> comboBoxTicketNum,int sumf,String ret){
		 int av = 0;
		try {
			Statement stmt = MySqlConn.dbConnector().createStatement();
			
			
	        
	        ResultSet rt=stmt.executeQuery("SELECT `r_id` FROM routes2 WHERE `from`='"
					+comboBoxFrom.getSelectedItem().toString()+"' AND `to`='"
					+comboBoxTo.getSelectedItem().toString()+"' AND `year`='"
					+comboBoxYear.getSelectedItem().toString()+"' AND `month`='"
					+comboBoxMonth.getSelectedItem().toString()+"' AND `day`='"
					+comboBoxDay.getSelectedItem().toString()+"' AND `hour`='"
					+comboBoxHour.getSelectedItem().toString()+"' AND `minutes`='"
					+comboBoxMinutes.getSelectedItem().toString()+"' AND `available`='1'");
	        
	        rt.next();
	  	  IDr=rt.getInt("r_id");
			
			
			 rt=stmt.executeQuery("SELECT * FROM busseats WHERE `r_id`='"+IDr+"'");
			
			 rt.next();
			 
			 av= rt.getInt(ret);
			 
			 stmt.close();
			 
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return av;
		
	}//telos seatsavailale
	
	
	
	public void addseats(int rid,int numtickets){
		
		try {
			Statement stmt = MySqlConn.dbConnector().createStatement();
			
			
			 String sql="UPDATE busseats SET `seatsa`=`seatsa`+"+numtickets+" WHERE `r_id`='"+rid+"'";
			
			 stmt.executeUpdate(sql);
			 
			 
			 stmt.close();
			 
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	int su(int cost,int ticketnum){
	
		return ticketnum*cost;
		
	}
	
	}

