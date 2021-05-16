package test;

import game.Case;
import game.Player;
import game.PlayerImpl;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.Equipment;
import soldier.core.Unit;

public class BoardConsol {

	public static void main(String[] args) {
		AgeAbstractFactory factory = new AgeMiddleFactory();
		//Player p = new PlayerImpl("Toto", factory);
		
		//lSystem.out.println(p);
		
		Case c = new Case();
		
		System.out.println(c);
		Equipment equipment_1 = factory.attackWeapon();
		c.addEquipment(equipment_1);
		
		System.out.println(c);

	}

}
