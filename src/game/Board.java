package game;

import java.util.HashMap;

public class Board {
	
	private  HashMap<Integer,Case> cases  ;

	
	
	
	public Board() {
			cases = new HashMap<>(); 
			for(int i=0 ; i<=34 ;i++) {
				cases.put(i, new Case());
			}
	}
	
	public Case getCase(int nbCase) {
		return cases.get(nbCase);
	}
	
	
	
	
}
