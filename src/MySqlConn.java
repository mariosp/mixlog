
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

import javax.swing.JOptionPane;

public class MySqlConn {
	
    public static Connection dbConnector() {
    	Connection conn;
        try {
        	String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/busticket?useUnicode=true&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url,"root","1234");
            return conn;
        }catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, e);
        	return null;
        }
        
    }
}
