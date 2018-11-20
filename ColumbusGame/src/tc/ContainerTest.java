package tc;

import static org.junit.Assert.*;
import org.junit.Test;
import code.Container;
import code.Whirl;
import code.OceanMap;
import java.awt.Point;

public class ContainerTest {
	
	@Test
	public void ObjectList(){
		code.Container tester = new Container(10,2,10,2);
		assertTrue(tester.size()==0);
	}

	@Test
	public void ObjectHolder() {
		code.Container tester = new Container(10,2,10,2);
		code.Whirl testO1 = new Whirl(new OceanMap(20),new Point());
		code.Whirl testO2 = new Whirl(new OceanMap(20),new Point());
		tester.add(testO1);
		tester.add(testO2);
		assertTrue(tester.size()==2);
	}
	
	@Test
	public void ObjectRemover(){
		code.Container tester = new Container(10,2,10,2);
		code.Whirl testO1 = new Whirl(new OceanMap(20),new Point());
		code.Whirl testO2 = new Whirl(new OceanMap(20),new Point());
		tester.add(testO1);
		tester.add(testO2);
		tester.remove(testO2);
		tester.remove(testO1);
		assertTrue(tester.size()==0);
	}

}
