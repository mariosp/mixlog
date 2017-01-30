import static org.junit.Assert.*;

import org.junit.Test;

public class SeatsTest {

	@Test
	public void testSu() {
		
		Seats tester = new Seats();
		
		assertEquals("Result", 30, tester.su(10, 3));
	}
	
	
	

}
