package logic.GameObjects;

import logic.Game;

public class ExplosiveVampire extends Vampire {
	
	//Atributos de explosive
	private int progress;
	
	//Constructor
	public ExplosiveVampire(int xx, int yy, Game g) {
		super(xx, yy, g);
		this.health = 5;
		this.info = "EV";
		this.progress = 0;
		
		
	}
	//metodo para que avance el explosive vampire
	public void advance() {
		
	}

}
