import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JTextField;

public class CheckCancel {
	 int bid;
	 int rid;
	 int pid;
	 int numtickets;
	 String lastn;
	 String firstn;
	
	 String from;
	 String to;
	 int day;
	 int month;
	 int year;
	 int hour;
	 int minutes;
	
	 float total;
	 String cnumber;
	
	 int bsid;
	 int seatsa;
	
	
	
	
	void checkca(JTextField tid){
		
		Statement stmt;
		try {
			stmt = MySqlConn.dbConnector().createStatement();
			
			ResultSet rt=stmt.executeQuery("SELECT * FROM booked WHERE `b_id`='"+tid.getText()+"'");
			
			rt.next();
			bid=rt.getInt("b_id");
			lastn=rt.getString("lastname");
			firstn=rt.getString("firstname");
			numtickets=rt.getInt("numtickets");
			rid=rt.getInt("r_id");
			pid=rt.getInt("p_id");
			
			 rt=stmt.executeQuery("SELECT * FROM routes2 WHERE `r_id`='"+rid+"'");
			 
			 rt.next();
			 
				from=rt.getString("from");
				to=rt.getString("to");
				day=rt.getInt("day");
				month=rt.getInt("month");
				year=rt.getInt("year");
				hour=rt.getInt("hour");
				minutes=rt.getInt("minutes");
				
				rt=stmt.executeQuery("SELECT * FROM payment WHERE `b_id`='"+bid+"'");
				
				rt.next();
				 
				total=rt.getFloat("total");
				cnumber=rt.getString("cnumber");
				
				rt=stmt.executeQuery("SELECT * FROM busseats WHERE `r_id`='"+rid+"'");
				
				rt.next();
				
				bsid=rt.getInt("bs_id");
				seatsa=rt.getInt("seatsa");
				
				
				stmt.close();
				
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}//telos checkca
	
	

int checkdate(){
	
	 LocalDateTime a = LocalDateTime.now();
	 
	 int tday=a.getDayOfMonth();
	 
	 int tmonth=a.getMonthValue();
	 
	 int tyear=a.getYear();
	 
	 int thour=a.getHour();
	 
	 int tminutes=a.getMinute();
	 
	 //3 meres prin tin tin hmera tis ektelesis dromologiou
	 LocalDate nowday=LocalDate.of(tyear, tmonth, tday);
	 LocalDate dayofl =LocalDate.of(year, month, day);
	 LocalDate dayofcancel=dayofl.minusDays(3);
	 
	 
	 if(nowday.isBefore(dayofcancel)){
		 return 1;
	 }else{
		 return 0;
	 }
	 
	 
	 
	 
	 
	 
}


void delete(){
		Seats seatsd =new Seats();
		seatsd.addseats(rid,numtickets);
		
		try {
			Statement stmt = MySqlConn.dbConnector().createStatement();
		
		String sql="DELETE FROM `booked` WHERE `b_id`='"+bid+"'";
		
		 stmt.executeUpdate(sql);
		 
		 stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		
	}
}