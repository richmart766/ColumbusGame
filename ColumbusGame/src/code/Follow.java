package code;
import java.awt.Point;
import java.util.Random;

public class Follow implements Strategies {
	Point pirateship;
	Point boat;
	Pirate pir;
	OceanMap Single;
	Random movement;
	public Follow(){
		movement = new Random();
	}
	//follows the boat with delayed movements
	@Override
	public void search(Pirate temp, OceanMap map, Point target) {

		pirateship = temp.Location();
		Single = map;
		boat = target;
		pir = temp;
		if(movement.nextInt(4)==1){
		MoveUD();
		MoveLR();
		}
	}
	public void MoveLR(){
		if(pirateship.x-boat.x<0){
			if(!Single.getIslands()[pirateship.x+1][pirateship.y]){
				pir.right();
			}
			
		}
		else if(pirateship.x==boat.x){
			
		}
		else{
			if(!Single.getIslands()[pirateship.x-1][pirateship.y]){
				pir.left();
				
			}
		}
	}
	public void MoveUD(){
		 if(pirateship.y-boat.y <0){
			 if(!Single.getIslands()[pirateship.x][pirateship.y+1]){
				 pir.up();
			 }
		}
		 else if(pirateship.y==boat.y){
			 
		 }
		else{
			if(!Single.getIslands()[pirateship.x][pirateship.y-1]){
				pir.down();
			}
		}
	}

}
