package code;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Container implements Command {
	int lowx;
	int lowy;
	int highy;
	int highx;
	List<Command> comp;
	
	public Container(int mx, int lx, int my, int ly){
		highx = mx;
		highy = my;
		lowx = lx;
		lowy = ly;
		comp = new LinkedList<Command>();
	}
	@Override
	public void add(Command o) {

		if(!comp.contains(o)){
			comp.add(o);
			o.SetBoundaries(highx, lowx, highy, lowy);
		}
	}

	@Override
	public void remove(Command o) {

		if(comp.contains(o)){
			comp.remove(o);
		}
	}

	@Override
	public void move() {

		for(Command temp: comp){
			temp.move();
		}
	}


	@Override
	public void SetBoundaries(int mx, int lx, int my, int ly) {
		highx = mx;
		highy = my;
		lowx = lx;
		lowy = ly;
	}
	
	public int size(){
		return comp.size();
	}
	@Override
	public Point getLocation() {
		// Testing Purposes
		return null;
	}

}
