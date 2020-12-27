package logic.GameObjects;

import logic.Game;

public class ExplosiveVampire extends Vampire {
	
	//Atributos de explosive
	
	
	//Constructor
	public ExplosiveVampire(int xx, int yy, Game g) {
		super(xx, yy, g);
		this.health = 5;
		this.info = "EV";
		
		
		
	}
	public void damageExplosive() {
		for (int i = (x-1); i < (x+2); i++) {
			for(int j = (y-1); j < (y+2); j++) {
				IAttack other = game.getAttackableInPosition(i, j);
				if(other != null) {
					other.receiveSlayerAttack(HARM);
				}
			}
		}
		
		
	}
	
	public String toString() {
		return this.info + " [" +this.health+  "] ";
	}
	

}
