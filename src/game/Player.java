package game;

import soldier.core.AgeAbstractFactory;
import soldier.core.Equipment;
import soldier.core.Unit;
import soldier.core.UnitGroup;

public interface Player {

	String getName();

	UnitGroup getArmy();

	AgeAbstractFactory getArmyFactory();
	
	void addEquipment(Equipment equipment);
	
	void addUnit(Unit unit);
	
	Case getCase();
	
	void pickUpEquipment();
	
	void appendUnits();
	
	void loseEquipment();
	
	void loseUnit();

}