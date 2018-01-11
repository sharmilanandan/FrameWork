package listenerDelete;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(DemoA.class)
public class TestListener {
	@Test
	public void testA(){
		Reporter.log("testA....",true);
	}

}
