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

	protected String getObjectSerialized() {
		int advancebinary;					// 1-> significa que en el proximo ciclo avanza. 0 -> significa que no avanza en el proximo ciclo.
		if (this.progress ==0) {
			advancebinary = 1;			
		}else{
			advancebinary = 0;
		}
		
		return (this.info + ";"+this.x+";"+this.y+";"+this.health+";"+ advancebinary);
	}
	

}
