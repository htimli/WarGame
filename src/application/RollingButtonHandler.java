package application;

import game.Dice;
import game.Player;
import game.Sprite;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import soldier.core.Unit;
import soldier.core.UnitObserver;
import soldier.util.DeadUnitCounterObserver;

public class RollingButtonHandler implements EventHandler<ActionEvent>{
	private Label label ;
	private Player sprite1, sprite2, currentSprite;
	
	
	public RollingButtonHandler(Label label, Player sprite1, Player sprite2) {
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
		label.setText("[your step : "+step+"]");
		
		switchPlayers();
		
		for(int i=0 ; i<step ;i++) 
			((Sprite)currentSprite).moove();			
		currentSprite.play();
		if(sprite1.getCase() == sprite2.getCase()) {
			fight();
			Button b = (Button)arg0.getSource();
			b.setDisable(true);
		}
			
		
	}
	
	private void switchPlayers() {
		if(currentSprite == sprite2)
			currentSprite = sprite1;
		else 
			currentSprite = sprite2;
	}
	public void fight() {

		Unit team1 = sprite1.getArmy();
		Unit team2 = sprite2.getArmy();
		
		int round = 0;
		
	
		while(team1.alive() && team2.alive()) {
			label.setText("Round  #" + round++);
			float st1 = team1.strike();
			label.setText(team1.getName() + " attack with force : " + st1);
			team2.parry(st1);
			float st2 = team2.strike();
			label.setText(team2.getName() + " attack with force : " + st2);
			team1.parry(st2);
		}
		label.setText("The end ...  team " + (team1.alive() ? team1.getName() : team2.getName()) + " won." );
		
		
	}


}