package code;
import java.awt.Point;

public abstract class PirateFactory {
	int type;
	OceanMap map;
	Point ship;
	Pirate object;
	public PirateFactory(OceanMap temp, Point temps){
		map = temp;
		ship = temps;
	}
	
	//The Creation of the Pirate Ships
	public Pirate create(){
		return new Pirate(ship,map,type);
	}
	

}
