package code;
import java.awt.Point;
import java.util.Random;

public class Lost implements Strategies {

	Point pirateship;
	Point boat;
	Pirate pir;
	OceanMap Single;
	Random randomizer;
	int rand;
	public Lost(){
		randomizer = new Random();
	}
	
	//mindlessly search for the pirate boat
	@Override
	public void search(Pirate temp, OceanMap map, Point target) {

		pirateship = temp.Location();
		Single = map;
		boat = target;
		pir = temp;
		if(pir.Location().distance(boat)<= 6){
			found();
		}
		else{
		MoveUD();
		MoveLR();
		}
	}
	
	public void found(){
		if(randomizer.nextInt(2)==1){
		MoveUD2();
		MoveLR2();
		}
	}
	
	public void lost(){
		MoveUD();
		MoveLR();
	}
	//Move the boat
	public void MoveLR(){
		rand = randomizer.nextInt(2);
		if(rand == 1){
			if(pirateship.x >0){
			if(!Single.getIslands()[pirateship.x-1][pirateship.y]){
				pir.left();
				
			}
			}
		}
		else{
			if(pirateship.x<9){
			if(!Single.getIslands()[pirateship.x+1][pirateship.y]){
				pir.right();
			}
			}
		}
	}
	public void MoveUD(){
		rand = randomizer.nextInt(2);
		if(rand == 1){
			if(pirateship.y <9){
			if(!Single.getIslands()[pirateship.x][pirateship.y+1]){
				 pir.up();
			 }
			}
		}
		else{
			if(pirateship.y >0){
			if(!Single.getIslands()[pirateship.x][pirateship.y-1]){
				pir.down();
			}
			}
		}
	}
	
	
	
	public void MoveLR2(){
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
	public void MoveUD2(){
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
