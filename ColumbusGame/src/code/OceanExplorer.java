package code;

import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class OceanExplorer extends Application{
	final int dimensions = 20;
	final int scale = 50;
	boolean[][] oceanGrid;
	boolean[][]  isl;
	int gameover;
	Alert mess;
	Image shipImage;
	Image pirateImage;
	Image pirateImage2;
	Image GoldI;
	Image MonsterI;
	Image pool;
	Image pools;
	Image island;
	ImageView shipImageView;
	ImageView Pirate1;
	ImageView GoldV;
	ImageView pool1;
	ImageView pool2;
	ImageView Pirate2;
	ImageView islands;
	ImageView MonsterV;
	AnchorPane anchor;
	AnchorPane P1;
	AnchorPane P2;
	
	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {

		
		// Establish all the images that will be used into their own variables.
		mess = new Alert(AlertType.INFORMATION);
        mess.setTitle("Pirate Game");
        mess.setResizable(true);
		define();
		// Set the stage
		gameover = 0;
		Scene scene = new Scene(anchor,1000,1000);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Oh No PIRATES!!");
		oceanStage.show();
		
		//Creating and running the images 
		
		
		OceanMap test = new OceanMap(35);
		test.create();
		isl = test.getIslands();
		oceanGrid = new boolean[20][20];
		draw();
		setIslands();
		showship(anchor,test);
		showPirates(test);
		startSailing(scene,test);
		ShowComp(test);
	}


	// Create most of my variables and associated images
	public void define(){
		anchor = new AnchorPane();
		P1 = new AnchorPane();
		P2 = new AnchorPane();
		GoldI = new Image("Images//Gold.png",50,50,true,true);
		GoldV = new ImageView(GoldI);
		shipImage = new Image("Images//ship.png",50,50,true,true);
		shipImageView = new ImageView(shipImage);
		pool = new Image("Images//whirl.png",50,50,true,true);
		pool1 = new ImageView(pool);
		pools = new Image("Images//whirl.png",50,50,true,true);
		pool2 = new ImageView(pools);
		MonsterI = new Image("Images//Monster.png",50,50,true,true);
		MonsterV = new ImageView(MonsterI);
		pirateImage = new Image("Images//pirateShip.png",50,50,true,true);
		pirateImage2 = new Image("Images//smart.jpg",50,50,true,true);
		Pirate1 = new ImageView(pirateImage);
		Pirate2 = new ImageView(pirateImage2);
	}
	
	
	// Draw all the waters
	public void draw(){
		for(int x = 0; x < dimensions; x++){
			for(int y = 0; y < dimensions; y++){
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				rect.setStroke(Color.BLACK); // We want the black outline
				if(isl[x][y]==true){
					
					rect.setFill(Color.GREEN);
				}
				else{
				rect.setFill(Color.PALETURQUOISE); // Blue ocean
				}
				anchor.getChildren().add(rect); // Add to the node tree in the pane
			}
		}
	}
	
	//Place Island Images
	
	public void setIslands(){
		for(int x = 0; x < dimensions; x++){
			for(int y = 0; y < dimensions; y++){
				if(isl[x][y]==true){
					island = new Image("Images//island.jpg",50,50,true,true);
					islands = new ImageView(island);
					islands.setX(x * scale);
					islands.setY(y * scale);
					anchor.getChildren().add(islands);
				}
			}
		}
	}
	// Ship movement is tracked
	
	
	public void startSailing(Scene set, OceanMap map){
		
			set.setOnKeyPressed(new EventHandler<KeyEvent>(){
				public void handle(KeyEvent ke){
					if(gameover==0){
					switch(ke.getCode()){
					case RIGHT:
						map.east();
						break;
					case LEFT:
						map.west();
						break;
					case UP:
						map.north();
						break;
					case DOWN:
						map.south();
						break;
					default:
						break;
					}
					resetImage(map);
					done(map);
				}}
				
			});
		
		}
	
	public void done(OceanMap test){
		if(test.getShip().equals(test.PirateOne()) || test.getShip().equals(test.PirateTwo()) ||
				test.getShip().equals(test.SeaMonster())){
			System.out.println("yay");
			mess.setHeaderText("Game Over");
			
			mess.show();
			gameover = 1;
		}
		if(test.getShip().equals(test.Whirlpool1()) ||
				test.getShip().equals(test.Whirlpool2())){
			test.reset();
		}
		if(test.getShip().equals(test.Finish())){
			gameover = 1;
			mess.setHeaderText("You won!");
			
			mess.show();
		}
	}
	public void resetImage(OceanMap map){
		shipImageView.setX(map.getShip().x*scale);
		shipImageView.setY(map.getShip().y*scale);
		Pirate1.setX(map.PirateOne().x * scale);
		Pirate1.setY(map.PirateOne().y * scale);
		pool1.setX(map.Whirlpool1().x*scale);
		pool1.setY(map.Whirlpool1().y*scale);
		pool2.setX(map.Whirlpool2().x*scale);
		pool2.setY(map.Whirlpool2().y*scale);
		Pirate2.setX(map.PirateTwo().x * scale);
		Pirate2.setY(map.PirateTwo().y * scale);
		MonsterV.setX(map.SeaMonster().x*scale);
		MonsterV.setY(map.SeaMonster().y*scale);
		GoldV.setX(map.Finish().x*scale);
		GoldV.setY(map.Finish().y*scale);
	}
	// Create the ship image
	
	
	public void showship(AnchorPane pane, OceanMap test){
		
		shipImageView.setX(test.getShip().x * scale);
		shipImageView.setY(test.getShip().y * scale);
		anchor.getChildren().add(shipImageView);
	}
	
	//Create Pirate Images
	
	public void showPirates( OceanMap test){
		
		Pirate1.setX(test.PirateOne().x * scale);
		Pirate1.setY(test.PirateOne().y * scale);
		anchor.getChildren().add(Pirate1);
		Pirate2.setX(test.PirateTwo().x * scale);
		Pirate2.setY(test.PirateTwo().y * scale);
		anchor.getChildren().add(Pirate2);
	}
	public void ShowComp(OceanMap test){
		pool1.setX(test.Whirlpool1().x*scale);
		pool1.setY(test.Whirlpool1().y*scale);
		anchor.getChildren().add(pool1);
		pool2.setX(test.Whirlpool2().x*scale);
		pool2.setY(test.Whirlpool2().y*scale);
		anchor.getChildren().add(pool2);
		MonsterV.setX(test.SeaMonster().x*scale);
		MonsterV.setY(test.SeaMonster().y*scale);
		anchor.getChildren().add(MonsterV);
		GoldV.setX(test.Finish().x*scale);
		GoldV.setY(test.Finish().y*scale);
		anchor.getChildren().add(GoldV);
	}

}
