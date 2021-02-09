package logic.GameObjects;

import logic.Game;

public class Dracula extends Vampire{
	private static boolean alive = false;

	public Dracula(int xx, int yy, Game g) {
		super(xx, yy, g);
		this.info = "D";
		Dracula.alive = true;
	}
	
	public static void init() {
		Dracula.alive = false;
	}
	
	public static boolean alive() {
		return alive;
	}

	public boolean receiveSlayerAttack(int max) {
		this.health = this.health - max;
		if (this.health == 0) {
			Vampire.vampiresOnB--;
			Dracula.alive = false;
		}
		return true;
	}

	public void attack() {
		if(isAlive()) {
			IAttack other = game.getAttackableInPosition(x, y-1);
			if(other != null) {
				other.receiveVampireAttack(HARMD);
			}
		}
	}
	
	public void receiveFlashAttack() {
	}
	
	public void receiveGarlicPush() {
		this.progress = 0;
		if (game.positionAvaible(this.x, this.y+1)) {
			this.y++;
			if (this.outOfBoard()) {
				Vampire.vampiresOnB--;
				Dracula.alive = false;
			}
		}
	}


}
