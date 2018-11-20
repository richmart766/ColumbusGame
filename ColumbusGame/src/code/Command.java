package code;

import java.awt.Point;

public interface Command {
	public void add(Command o);
	public void remove(Command o);
	public void move();
	public Point getLocation();
	public void SetBoundaries(int mx, int lx, int my, int ly);
}
