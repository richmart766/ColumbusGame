package tc;

import static org.junit.Assert.*;
import code.PirateFactory;
import code.Pirate;
import code.Dumb;
import code.Smart;
import code.OceanMap;
import org.junit.Test;
import java.awt.Point;

public class PirateFactoryTest {

	@Test
	public void FactoryMakerDumb() {
		code.PirateFactory creator = new Dumb(new OceanMap(20),new Point());
		code.Pirate temp = creator.create();
		assertTrue(temp.type()==0);
	}
	
	@Test
	public void FactoryMakerSmart(){
		code.PirateFactory creator = new Smart(new OceanMap(20),new Point());
		code.Pirate temp = creator.create();
		assertTrue(temp.type()==1);
	}

}
