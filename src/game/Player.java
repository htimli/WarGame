package game;

import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public interface Player {

	String getName();

	UnitGroup getArmy();

	AgeAbstractFactory getArmyFactory();

}