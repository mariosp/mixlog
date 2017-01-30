
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.swing.*;

public class AddDb extends AddRoutef {

	static void addEntry(){
	try {
            Statement stmt = MySqlConn.dbConnector().createStatement();

            String sql = "INSERT INTO routes2 VALUES ("
            		+ "NULL" +",'"+
                    textfrom.getText() + "', '" +
                    textto.getText() + "', '" +
                    textday.getText() + "', '" +
                    textmonth.getText() + "', '" +
                    textyear.getText() + "', '" +
                    texthour.getText() + "', '" +
                    textminutes.getText() + "', '" +
                    textseats.getText() + "', '" +
                    textprice.getText() + "','1')";
            
            stmt.executeUpdate(sql);
            
            ResultSet rt=stmt.executeQuery("SELECT last_insert_id()");
            rt.next();
            System.out.println(rt.getString("last_insert_id()"));
            
            sql="INSERT INTO busseats(`seats`,`seatsa`,`r_id`)VALUES ('"
            		+textseats.getText()+ "','"
            		+textseats.getText()+"','"
            		+rt.getString("last_insert_id()")+"')";
            		
            stmt.executeUpdate(sql);
            
            
            stmt.close();
            
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
	}
		
		
	}
	
	static int checkNotNull(){
		if (textfrom.getText() == null || textfrom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΑΦΕΤΗΡΙΑ", "ERROR", JOptionPane.ERROR_MESSAGE);
            textfrom.requestFocus();
            return 0;
        }
		
		if (textto.getText() == null || textto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΠΡΟΟΡΙΣΜΟ", "ERROR", JOptionPane.ERROR_MESSAGE);
            textto.requestFocus();
            return 0;
        }
		
		if (textday.getText() == null || textday.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΗΜΕΡΑ", "ERROR", JOptionPane.ERROR_MESSAGE);
            textday.requestFocus();
            return 0;
        }
		
		if (textmonth.getText() == null || textmonth.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΜΗΝΑ", "ERROR", JOptionPane.ERROR_MESSAGE);
            textmonth.requestFocus();
            return 0;
        }
		
		if (textyear.getText() == null || textyear.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΕΤΟΣ", "ERROR", JOptionPane.ERROR_MESSAGE);
            textyear.requestFocus();
            return 0;
        }
		
		if (texthour.getText() == null || texthour.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΩΡΑ", "ERROR", JOptionPane.ERROR_MESSAGE);
            texthour.requestFocus();
            return 0;
        }
		
		if (textminutes.getText() == null || textminutes.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΛΕΠΤΑ", "ERROR", JOptionPane.ERROR_MESSAGE);
            textminutes.requestFocus();
            return 0;
        }
		
		if (textprice.getText() == null || textprice.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΤΙΜΗ ΕΙΣΙΤΗΡΙΟΥ", "ERROR", JOptionPane.ERROR_MESSAGE);
            textprice.requestFocus();
            return 0;
        }
		
		if (textseats.getText() == null || textseats.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ΕΙΣΑΓΕΤΕ ΑΡΙΘΜΟ ΘΕΣΕΩΝ", "ERROR", JOptionPane.ERROR_MESSAGE);
            textseats.requestFocus();
            return 0;
            
            
        }
		//afou egine o elenxos kaloume tin addentry gia na valoume to periexomeno stin vash
		addEntry();
		return 1;
		
	}//TELOS elenxou checkNotNull
	
	
	
	
}
