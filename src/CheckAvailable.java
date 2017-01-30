import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class CheckAvailable {
	
	
	
	
static void checkava(){
	int rid;
	int day;
	int month;
	int year;
	int hour;
	int minutes;
		
	LocalDateTime a = LocalDateTime.now();
	 
	 int tday=a.getDayOfMonth();
	 
	 int tmonth=a.getMonthValue();
	 
	 int tyear=a.getYear();
	 
	 int thour=a.getHour();
	 
	 int tminutes=a.getMinute();
	 
	 
	 LocalDateTime nowtime=LocalDateTime.of(tyear, tmonth, tday, thour,tminutes);
	
	
		Statement stmt;
		try {
			stmt = MySqlConn.dbConnector().createStatement();
			
			
			ResultSet rt=stmt.executeQuery("SELECT * FROM routes2 WHERE `available`='1' ");
			 
			
			while(rt.next()){
				
				rid=rt.getInt("r_id");
				day=rt.getInt("day");
				month=rt.getInt("month");
				year=rt.getInt("year");
				hour=rt.getInt("hour");
				minutes=rt.getInt("minutes");
				
				LocalDateTime timeofl =LocalDateTime.of(year, month, day,hour,minutes);
				System.out.println(timeofl);
				if(nowtime.isAfter(timeofl)){
					
					String sql="UPDATE `routes2` SET `available`='0' WHERE `r_id`='"+rid+"'";
					 stmt.executeUpdate(sql);
					
				 }
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}//telos checkava
	

}
