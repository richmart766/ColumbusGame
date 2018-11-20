package code;
import java.awt.Point;
import java.util.Random;

// Establish all the variables that i will be using

public class Pirate implements Observer {
	Strategies strat;
	int strats;
	Point boat;
	Point pirateship;
	OceanMap Single;
	Random randomizer = new Random();
	// Stores the boats location and the islpands at the very start
	
	public Pirate( Point spot, OceanMap temps, int num){
		boat = spot;
		Single = temps;
		pirateship = new Point();
		piratespot();
		strats = num;
		setStrat(num);
		}
	// returns the location of the pirate ship
	public void setStrat(int temp){
		if(temp == 1){
			strat = new Follow();
		}
		else{
			strat = new Lost();
		}
	}
	public Point Location(){
		return pirateship; 
	}
	
	// creates the spot were the pirate ship will be placed without putting it on an island.
	
	public Point piratespot(){
		int x=0, y=0;
		while(true){
			x = randomizer.nextInt(20);
			y = randomizer.nextInt(20);
			if(Single.getIslands()[x][y]== false && !(boat.x==x && boat.y==y) && (x != 19 && y != 19)){
				pirateship.x=x;
				pirateship.y=y;
				break;
			}
			}
		return pirateship;
	}
	// Main observer call to update
	@Override
	public void update(Point ship) {

		boat = ship;
		moveship();
		}
	
	
	// the moveship method was inspired by the cat and mouse game.
	// I added the slowdown if statement like the cat aswell to make movement not so quick
	// It will also take into account the islands that have been placed.
	
	public void moveship(){
		if(true){
		//if(randomizer.nextInt(2)==1){
			strat.search(this, Single, boat);
		}
	}
	
	public void right(){
		if(pirateship.x<19){
		pirateship.x++;
		}
	}
	public void left(){
		if(pirateship.x >0){
		pirateship.x--;
		}
	}
	public void up(){
		if(pirateship.y <19){
		pirateship.y++;
		}
	}
	public void down(){
		if(pirateship.y >0){
		pirateship.y--;
		}
	}
	//Methods below control all the movements for the ship in each direction
	
	public int type(){
		return strats;
	}
	
	
	
	
}
