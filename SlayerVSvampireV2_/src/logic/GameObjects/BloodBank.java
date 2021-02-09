package logic.GameObjects;

import logic.Game;

public class BloodBank extends GameObject{

	public BloodBank(int xx, int yy, int zz, Game g) {
		super(xx, yy, g);
		this.health = zz;
		this.info = "B";
	}


	public void attack() {
		game.setCoins((health*10)/100);
	}
	
	public void advance() {};
	public void setCnt() {};
	public void setAlive() {};
	
	public boolean receiveVampireAttack(int max) {
		this.health = 0;
		return true;
	}
	
	public String serialize() {
		return this.info+";" + this.x + ";" + this.y+ ";1;"+this.health+";";
	}



	
	
}
