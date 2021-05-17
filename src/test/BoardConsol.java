package test;

import java.io.IOException;
import java.io.InputStream;

import game.Case;
import game.Player;
import game.PlayerImpl;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.Equipment;
import soldier.core.Unit;

public class BoardConsol {

	public static void main(String[] args) {
		
		Image playerArmyImage = new Image(new InputStream() {
			
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
		
		
		AgeAbstractFactory factory = new AgeMiddleFactory();
		PlayerImpl p = new PlayerImpl("Toto", factory , playerArmyImage,new BorderPane(),2 );
		
		
		Equipment equipment_1 = factory.attackWeapon();
		Equipment equipment_2 = factory.defenseWeapon();
		
		Unit unit1 = factory.infantryUnit("lolo");
		p.addUnit(unit1);
		System.out.println(p.getArmy().getEquipments());
		p.addEquipment(equipment_1);
		p.addEquipment(equipment_2);
		System.out.println(p.getArmy().getEquipments());
		
		p.loseEquipment();
		p.loseEquipment();
		System.out.println(p.getArmy().getEquipments());
		System.out.println(p.getCase());

		
		
		
		
		
	}

}
