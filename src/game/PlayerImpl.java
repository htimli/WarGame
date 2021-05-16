package game;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public class PlayerImpl extends SpriteImpl implements Player {
	
	private String name;
	private UnitGroup army;
	private AgeAbstractFactory armyFactory;
	
	
	public PlayerImpl(String name, AgeAbstractFactory armyFactory,Image image, Pane layer, double x, double y, double dx, double dy) {
		super(image,layer,x,y,dx,dy);
		this.name = name;
		this.armyFactory = armyFactory;
		this.army = new UnitGroup(name +"Army");
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public UnitGroup getArmy() {
		return army;
	}

	@Override
	public AgeAbstractFactory getArmyFactory() {
		return armyFactory;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", army=" + army + "]";
	} 
	
	
	
	
	

}
