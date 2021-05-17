package game;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import soldier.core.AgeAbstractFactory;
import soldier.core.Equipment;
import soldier.core.Unit;
import soldier.core.UnitGroup;

public class PlayerImpl extends SpriteImpl implements Player {
	
	private String name;
	private UnitGroup army;
	private AgeAbstractFactory armyFactory;
	
	
	public PlayerImpl(String name, AgeAbstractFactory armyFactory,Image image, Pane layer) {
		super(image,layer,Settings.SPRITE_X, Settings.SPRITE_Y, Settings.SPRITE_DX, Settings.SPRITE_DY);
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
	public void addEquipment(Equipment equipment) {
		this.army.addEquipment(equipment);
		
	}
	@Override
	public Case getCase() {
		return super.getCase();
	}
	@Override
	public void pickUpEquipment() {
		Case playerCase = this.getCase();
		if(playerCase.conatainsEquipment()) {
			this.addEquipment(playerCase.takeOffEquipement());
		}
	}
	@Override 
	public void appendUnits() {
		Case playerCase = this.getCase();
		if(playerCase.containsUnit()) {
			this.army.addUnit(playerCase.takeOffUnit());
		}
	}
	@Override
	public void addUnit(Unit unit) {
		this.army.addUnit(unit);
		
	}
	@Override
	public void loseEquipment() {
			Equipment e = army.getEquipments().next();
			this.army.removeEquipment(e);
			this.getCase().addEquipment(e);		
	}
	@Override
	public void loseUnit() {
		Unit u = army.subUnits().next();
		this.army.removeUnit(u);
		this.getCase().addUnit(u);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", army=" + army + "]";
	}


	
	 
	
	
	
	
	

}
