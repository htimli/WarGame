package game;



public class Dice {
	
	
	private int res ;
	
	private final int  MIN = 1; 
	private final int  MAX = 6; 
	
	
	
	public int getRes() {
		res = (int) (MIN + (Math.random() * (MAX - MIN)));
		return res ;
	}
	
}
