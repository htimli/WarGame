package game;



import soldier.core.AgeAbstractFactory;
import soldier.core.Equipment;
import soldier.core.Unit;
import soldier.core.UnitGroup;
import soldier.core.UnitObserver;

public interface Player {

	String getName();

	Unit getArmy();

	AgeAbstractFactory getArmyFactory();
	
	
	void play();
	
	void addEquipment(Equipment equipment);
	
	void addUnit(Unit unit);
	
	Case getCase();
	
	void pickUpEquipment();
	
	void appendUnits();
	
	void loseEquipment();
	
	void loseUnit();
	
	void addObserver(UnitObserver obs);

}