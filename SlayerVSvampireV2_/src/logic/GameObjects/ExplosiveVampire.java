package logic.GameObjects;

import logic.Game;

public class ExplosiveVampire extends Vampire {

	public ExplosiveVampire(int xx, int yy, Game g) {
		super(xx, yy, g);
		this.info = "EV";
	}
	
	
	public String toString() {
		return this.info + " [" + this.health + "] ";
	}
	
	public boolean receiveSlayerAttack(int max) {
		this.health = this.health - max;
		if (this.health == 0) {
			Vampire.vampiresOnB--;
			this.damageExplosive();
		}
		return true;
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

}
