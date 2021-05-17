package application;

import game.Dice;
import game.Sprite;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class RollingButtonHandler implements EventHandler<ActionEvent>{
	private Label label ;
	private Sprite sprite1, sprite2, currentSprite;
	
	
	public RollingButtonHandler(Label label, Sprite sprite1, Sprite sprite2) {
		super();
		this.label = label;
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		this.currentSprite = sprite2;
	}
	@Override
	public void handle(ActionEvent arg0) {
		Dice d = new Dice();
		int step = d.getRes();
		label.setText("your step => "+step);
		
		switchPlayers();
		
		for(int i=0 ; i<step ;i++)
			currentSprite.moove();	
		
	}
	
	private void switchPlayers() {
		if(currentSprite == sprite2)
			currentSprite = sprite1;
		else 
			currentSprite = sprite2;
	}

}