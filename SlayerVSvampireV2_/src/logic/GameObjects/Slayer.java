package logic.GameObjects;

import logic.Game;

public class Slayer extends GameObject{
	public Slayer(int xx, int yy, Game g) {
		super(xx, yy, g);
		this.info = "S";
		this.health = 3;
	}

	public void advance() {} //no se implementa 

	
	

	boolean equals2(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	public void attack() {
		if(isAlive()) {
			IAttack other = game.getAttackableInPosition(x, y-1);
			if(other != null) {
				other.receiveSlayerAttack(HARM);
			}
		}
	}
	
	public boolean receiveVampireAttack(int max) {
		this.health = this.health - max;
		return true;
	}

	protected void setCnt() {
		GameObject.cnt--;
	}
	

	
}
