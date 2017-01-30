import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


import org.junit.Test;

public class MySqlConnTest {

	@Test
	public void testDbConnector() throws SQLException {
		
		Connection conn=null;
		
		conn=MySqlConn.dbConnector();
		
		assertNotNull(conn);
	}

}
