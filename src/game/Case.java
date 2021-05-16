package game;

import java.util.ArrayList;
import java.util.List;
import soldier.core.Equipment;
import soldier.core.Unit;

public class Case {
	
	private static int nextNumber = 0 ;
	private int number;
	private List<Equipment> equipments; 
	private Unit unit;
	
	
	
	public Case() {
		this.number = nextNumber++;
		this.equipments = new ArrayList<Equipment>();
	}

	public int getNbCase() {
		return number;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public Unit getUnit() {
		return unit;
	}

	public void addUnit(Unit unit) {
		this.unit = unit;
	}
	
	public void addEquipment(Equipment equipment) {
		this.equipments.add(equipment);
	}

	@Override
	public String toString() {
		return "Case [number=" + number + ", equipments=" + equipments + ", unit=" + unit + "]";
	}
	
	
	
	
	
	
	
	
}
