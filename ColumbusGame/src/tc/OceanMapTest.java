package tc;
import static org.junit.Assert.*;
import org.junit.Test;
import code.OceanMap;

public class OceanMapTest {

	@Test
	public void SingletonTest() {
		code.OceanMap tester = new OceanMap(20);
		tester.create();
		assertTrue(tester.SingleTest()==false);
	}
	@Test
	public void SingletonTest2(){
		code.OceanMap tester = new OceanMap(20);
		tester.create();
		assertTrue(tester.SingleTest2()==true);
	}

}
