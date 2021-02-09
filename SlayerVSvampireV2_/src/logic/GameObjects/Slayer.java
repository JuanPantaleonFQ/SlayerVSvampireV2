package logic.GameObjects;

import logic.Game;

public class Slayer extends GameObject{
	public Slayer(int xx, int yy, Game g) {
		super(xx, yy, g);
		this.info = "S";
		this.health = 3;
	}

	public void advance() {};
	
	public void attack() {
		if(isAlive()) {
			int i = this.y;
			boolean ok = false;
			do {
				i++;
				IAttack other = game.getAttackableInPosition(x, i);
				if(other != null) {
					other.receiveSlayerAttack(HARM);
					ok = true;
				}
			} while (i < game.getDimY() && !ok);
		}
	}
	
	public boolean receiveVampireAttack(int max) {
		this.health = this.health - max;
		return true;
	}
	
	public String serialize() {
		return this.info+";" + this.x + ";" + this.y+ ";" + this.health+";";
	}
}
