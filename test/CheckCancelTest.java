import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CheckCancelTest {

	@Test
	public void testCheckdate() {
		
		CheckCancel c0 =new CheckCancel();
		c0.year=2017;
		c0.month=1;
		c0.day=15;
		
		assertEquals("Result", 0, c0.checkdate());
		
		
		CheckCancel c1 =new CheckCancel();
		c1.year=2017;
		c1.month=2;
		c1.day=25;
		
		assertEquals("Result2", 1, c1.checkdate());
		
	}
	
	
	

}
