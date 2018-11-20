package code;
import java.awt.Point;
import java.util.Random;

public class Sea implements Command {

	int lowx;
	int lowy;
	int highy;
	int highx;
	Point sea;
	Point boat;
	OceanMap Single;
	Random picker;
	
	public Sea(OceanMap temp, Point temps){
		Single = temp;
		sea = new Point();
		boat = temps;
		picker = new Random();
	}
	// Create Location of Sea monset
	
	public void setspot(){
		int x=0, y=0;
		while(true){
			x = picker.nextInt(highx-lowx+1)+lowx;
			y = picker.nextInt(highy-lowx+1)+lowy;
			if(Single.getIslands()[x][y]== false && !(boat.x==x && boat.y==y)){
				sea.x=x;
				sea.y=y;
				break;
			}
			}
	}
	// Get Locatiom
	public Point getLocation(){
		return sea;
	}
	@Override
	// Move the ship
		public void move() {

		int x = picker.nextInt(4);
		int y = picker.nextInt(4);
		if(x==3){
			if(sea.x+1<= highx && Single.getIslands()[sea.x+1][sea.y]== false){
				sea.x++;
			}
		}
		if(x==2){
			if(sea.x-1>= lowx && Single.getIslands()[sea.x-1][sea.y]== false){
				sea.x--;
			}
		}
		if(y==3){
			if(sea.y+1<= highy && Single.getIslands()[sea.x][sea.y+1]== false){
				sea.y++;
			}
		}
		if(y==2){
			if(sea.y-1>= lowy && Single.getIslands()[sea.x][sea.y-1]== false){
				sea.y--;
			}
		}
			
		
	}
    //set boundaries and location of the sea monster
	@Override
	public void SetBoundaries(int mx, int lx, int my, int ly) {

		highx = mx;
		highy = my;
		lowx = lx;
		lowy = ly;
		setspot();
	}
	
	
	// No point to any of these methods whirl pools do not move.
	@Override
	public void add(Command o) {


	}

	@Override
	public void remove(Command o) {


	}


}
