package code;

import java.awt.Point;
// Create search for the ship
public interface Strategies {
	public void search(Pirate temp, OceanMap map, Point target);
}
