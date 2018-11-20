package code;
import java.awt.Point;
import java.util.Random;

public class OceanMap {
	
	private static OceanMap Singleton;
	//Choose to put the ship and pirate classes into OceanMap. That was a personal choice
	// I wanted everything movement wise to come from this so I choose to establish it here
	
	
	boolean[][] islands = new boolean[20][20];
	static int islcount;
	Random randomizer = new Random();
	Pirate pirate1;
	Pirate pirate2;	
	Ship boat;
	Point Win;
	int tracker;
	PirateFactory creator;
	Command area;
	Command monster;
	Command pool;
	Command pool2;
	
	// On start up it creates the islands and the pirates.
	// Also adds the pirateships to the boats observer list
	
	public OceanMap(int count){
		tracker = 0;
		islcount = count;
		Singleton = null;
		Win = new Point();
		islands();
		shipspot();
		Winner();
	}
	
	public void create(){
		tracker = 1;
		Singleton= getInstance();
		Singleton.SetMap(islands);
		Singleton.SetBoat(boat);
		creator = new Dumb(Singleton,boat.getShipLocation());
		pirate1 = creator.create();
		creator = new Smart(Singleton, boat.getShipLocation());
		pirate2 = creator.create();
		area = new Container(15, 5, 15, 5);
		pool = new Whirl(Singleton, boat.getShipLocation());
		pool2 = new Whirl(Singleton, boat.getShipLocation());
		monster = new Sea(Singleton,boat.getShipLocation());
		area.add(pool);
		area.add(pool2);
		area.add(monster);
		boat.registerObserver(pirate1);
		boat.registerObserver(pirate2);
	}

	public static OceanMap getInstance(){
		
	if(Singleton == null){
		Singleton = new OceanMap(islcount);
	}
	return Singleton;
	}
	// Puts the boat on a spot that does not contain Islands
	private void Winner(){
		//int x=0, y=0;
		//while(true){
			//x = randomizer.nextInt(20);
		//	y = randomizer.nextInt(20);
			//if(islands[x][y]== false ){
				Win.setLocation(19,19);
				//break;
			//}
		//	}
		}
	
	private void shipspot(){
		int x=0, y=0;
		//while(true){
			//x = randomizer.nextInt(20);
			//y = randomizer.nextInt(20);
			//if(islands[x][y]== false){
				boat = new Ship(x,y);
				//break;
			//}
			//}
		}
	
	
	
	
	// for retrieving island maps
	
	
	public boolean[][] getIslands(){
		return islands;
	}
	
	// To create Islands without putting them on other islands
	
	public void islands(){
		int pass = 0;
		for(int i =0; i<islcount; i++){
			while(pass ==0){
			int x = randomizer.nextInt(20);
			int y = randomizer.nextInt(20);
			if(islands[x][y]==false && (x != 0 && y != 1) && (x != 19 && y != 19)){
				islands[x][y]=true;
				pass++;
			}
			}
			pass--;
		}
	}
	
	// To retrieve the location of the character
	public Point getShip() {

		return boat.getShipLocation();
	}

	// Follwing 4 methods are purely the movements that are taken care of by the ship
	
	
	public void east() {

		if(boat.getShipLocation().x <19){
		if(Singleton.getIslands()[boat.getShipLocation().x+1][boat.getShipLocation().y]==false){
			boat.goEast();
			area.move();
		}
		}
	}

	public void west() {

		if(boat.getShipLocation().x >0){
		if(Singleton.getIslands()[boat.getShipLocation().x-1][boat.getShipLocation().y]==false){
		boat.goWest();
		area.move();
		}}
	}

	public void north() {

		if(boat.getShipLocation().y >0){
		if(Singleton.getIslands()[boat.getShipLocation().x][boat.getShipLocation().y-1]==false){
		boat.goNorth();
		area.move();
		}
		}
	}

	public void south() {

		if(boat.getShipLocation().y <19){
		if(Singleton.getIslands()[boat.getShipLocation().x][boat.getShipLocation().y+1]==false){
		boat.goSouth();
		area.move();
		}
	}
}
	///
	public void SetMap(boolean[][] temp){
		islands = temp;
	}
	public void SetBoat(Ship temp){
		boat = temp;
	}
	
	public void reset(){
		boat.reset();
	}
	
	// Retrieve location of each of the individual pirate ships
	public Point Finish(){
		return Win;
	}
	public Point SeaMonster(){
		return monster.getLocation();
	}
	public Point PirateOne(){
		return pirate1.Location();
	}
	public Point PirateTwo(){
		return pirate2.Location();
	}
	public Point Whirlpool1(){
		return pool.getLocation();
	}
	public Point Whirlpool2(){
		return pool2.getLocation();
	}
	
	// tester
	public boolean SingleTest(){
		return(Singleton == null);
	}
	
	public boolean SingleTest2(){
		return(Singleton.SingleTest() == false);
	}
	}
