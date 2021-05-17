package game;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import soldier.core.AgeAbstractFactory;
import soldier.core.Equipment;
import soldier.core.Unit;
import soldier.core.UnitGroup;
import soldier.core.UnitObserver;


public class PlayerImpl extends SpriteImpl implements Player{
	
	private String name;
	private UnitGroup army;
	private AgeAbstractFactory armyFactory;
	
	
	public PlayerImpl(String name, AgeAbstractFactory armyFactory,Image image, Pane layer, double x ) {
		super(image,layer,x, Settings.SPRITE_Y, Settings.SPRITE_DX, Settings.SPRITE_DY);
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
			if(army.getEquipments().hasNext()) {
				Equipment e = army.getEquipments().next();
				this.army.removeEquipment(e);
				this.getCase().addEquipment(e);	
				}
	}
	@Override
	public void loseUnit() {
		if(army.subUnits().hasNext()) {
			Unit u = army.subUnits().next();
			this.army.removeUnit(u);
			this.getCase().addUnit(u);
		}
	}
	public void play() {
		int r =this.getNbCase();
		switch(r) {
		case Settings.LOOSE_UNIT_1_NBCASE : 
			this.loseUnit();
			break ;
		case Settings.LOOSE_UNIT_2_NBCASE : 
			this.loseUnit();
			break ;
		case Settings.BACK_2_NBCASE : 
			this.relocate(this.getNbCase()-2);
			break ;
		case Settings.BACK_6_NBCASE : 
			super.getImageView().setRotate(3*Settings.ROTATION);
			this.relocate(this.getNbCase()-6);
			break ;
		case Settings.FORWORD_2_NBCASE : 
			this.relocate(this.getNbCase()+2);
			break ;
		case Settings.BACK_STARTING_NBCASE : 
			super.getImageView().setRotate(0);
			this.relocate(0);
			break ;
		case Settings.LOOSE_EQUPIP_NBCASE : 
			this.loseEquipment();
			break ;
		case Settings.PICKUP_EQUPIP_NBCASE : 
			this.pickUpEquipment();
			break ;
		case Settings.APPEND_UNIT_NBCASE : 
			this.appendUnits();
			break ;
		default : 
			break;
		
		}
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", army=" + army + "]";
	}

	@Override
	public void addObserver(UnitObserver obs) {
		this.army.addObserver(obs);
		
	}


	
	 
	
	
	
	
	

}
