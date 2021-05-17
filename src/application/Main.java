package application;
	


import game.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import soldier.ages.AgeMiddleFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {

	Player player1 ;
	Player player2;
	
	Label commentsLabel;
	
	Image playerArmyImage;
	Image diceRollingImage;
	Image image3;
	
	Button rollingButton; 
	
	BorderPane root;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			 root = new BorderPane();    
			
			
			 loadImages(); 
			 
			 player1 = new PlayerImpl("Toto",new AgeMiddleFactory(),playerArmyImage, root);
			 player2 = new PlayerImpl("Toto",new AgeMiddleFactory(),image3, root);
			 
			 detectCasesPosition();		 
			 addWeapons();
		
			rollingButton = new Button();
		    rollingButton.setText("roll");		
			
		    
		    commentsLabel = new Label();
			commentsLabel.setFont(new Font("Arial", 30));
			
		    placeComponets();
		    
		    
		    

			rollingButton.setOnAction(new RollingButtonHandler(commentsLabel,(Sprite)player1,(Sprite)player2));
							
			root.setId("plateau");
						
			Scene scene = new Scene(root,Settings.SCENE_WIDTH ,Settings.SCENE_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("MyGame");
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void placeComponets() {
		HBox bottomHBox = new HBox(); 
		VBox rollingButtonDiceVBox = new VBox();
		
		
		rollingButtonDiceVBox.getChildren().add(new ImageView(diceRollingImage));
		rollingButtonDiceVBox.getChildren().add(rollingButton);
		rollingButtonDiceVBox.setAlignment(Pos.CENTER);
		
		
		bottomHBox.getChildren().add(rollingButtonDiceVBox);
		bottomHBox.getChildren().add(commentsLabel);
		bottomHBox.getStyleClass().add("box");
   
		
		root.setBottom(bottomHBox);
	}
	
	private void loadImages() {
		playerArmyImage = new Image(this.getClass().getResourceAsStream("/resources/images/army.png"),50,50,false,true);
		diceRollingImage = new Image(this.getClass().getResourceAsStream("/resources/images/dice_rolling.gif"),100,100,false,true);
		image3 = new Image(this.getClass().getResourceAsStream("/resources/images/Weapon.png"),60,25,false,true);
	}
	private void detectCasesPosition() {
		SpriteImpl detectorPosSprite = new SpriteImpl(playerArmyImage, root, 60, 45, 105, 68);
		detectorPosSprite.detectPositions();
	}
	private void addWeapons() {
		//TODO
		
		Sprite sprite3 = new SpriteImpl(image3, root, 60, 45, 105, 68);
		sprite3.put(7);	
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
