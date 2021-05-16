package application;

import game.Dice;
import game.Sprite;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class RollingButtonHandler implements EventHandler<ActionEvent>{
	private Label label ;
	private Sprite sprite;
	
	
	public RollingButtonHandler(Label label, Sprite sprite) {
		super();
		this.label = label;
		this.sprite = sprite;
	}
	@Override
	public void handle(ActionEvent arg0) {
		Dice d = new Dice();
		int step = d.getRes();
		label.setText("your step => "+step);
		for(int i=0 ; i<step ;i++)
			sprite.moove();	
		
	}

}