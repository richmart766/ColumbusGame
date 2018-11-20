package code;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

// decided to create a subject interface style much like the cat and mouse game
// i enjoyed the control of it and being able to work with more observers easily so i adopted a bit of the idea
// I decided to create a list of observers in the class to create multiple ships that can be used at once
public class Ship implements Observer {
	Point place;
	List<Observer> observers = new LinkedList<Observer>();
	
	public Ship(int x, int y){
		place = new Point(x,y);
		
	}
	// Get the location of the ship
	public Point getShipLocation(){
		return place;
	}
	public void reset(){
		place.setLocation(0, 0);
	}
	//Tracks the movement of the ship and called update on all the obsevers
	public void goEast(){
		if(place.x<19){
			place.x++;
			update(place);
		}
	}
	public void goWest(){
		if(place.x>0){
			place.x--;
			update(place);
		}
	}
	public void goNorth(){
		if(place.y>0){
			place.y--;
			update(place);
		}
	}
	public void goSouth(){
		if(place.y<19){
			place.y++;
			update(place);
		}
	}
	
	
	//Register holds the observers in a list
	// followed by notifiers to call update on all the observers
	
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}
	
	@Override
	public void update(Point ship) {

		for (Observer pirate: observers){
			pirate.update(place);
		}
	}
}
