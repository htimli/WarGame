package game;

import java.util.HashMap;

public class Board {
	
	private  HashMap<Integer,Case> cases  ;

	
	
	
	public Board() {
			cases = new HashMap<>(); 
			for(int i=0 ; i<Settings.BOARD_NB_CASES ;i++) {
				cases.put(i, new Case());
			}
	}
	
	public Case getCase(int nbCase) {
		return cases.get(nbCase);
	}
	
	
	
	
}
