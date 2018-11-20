package code;

import java.awt.Point;
import java.util.Random;

public class Whirl implements Command {
	int lowx;
	int lowy;
	int highy;
	int highx;
	Point pool;
	Point boat;
	OceanMap Single;
	Random picker;
	
	public Whirl(OceanMap temp, Point temps){
		Single = temp;
		pool = new Point();
		boat = temps;
		picker = new Random();
	}
	//Create Location for Whirlpool
	public void setspot(){
		int x=0, y=0;
		while(true){
			x = picker.nextInt(highx-lowx+1)+lowx;
			y = picker.nextInt(highy-lowx+1)+lowy;
			if(Single.getIslands()[x][y]== false && !(boat.x==x && boat.y==y)){
				pool.x=x;
				pool.y=y;
				break;
			}
			}
	}
	//Get the point
	public Point getLocation(){
		return pool;
	}
	
	//Movement
	@Override
	public void move() {

		int x = picker.nextInt(2);
		if(x ==1){
		setspot();
		}
	}
	// Set the boundaries and location aswell
	@Override
	public void SetBoundaries(int mx, int lx, int my, int ly) {

		highx = mx;
		highy = my;
		lowx = lx;
		lowy = ly;
		setspot();
	}
	
	// Methods left over for testing purposes if needed
	@Override
	public void add(Command o) {


	}

	@Override
	public void remove(Command o) {


	}

	

}
