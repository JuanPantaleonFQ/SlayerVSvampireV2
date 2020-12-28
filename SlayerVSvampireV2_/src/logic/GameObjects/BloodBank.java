package logic.GameObjects;

import logic.Game;

public class BloodBank extends GameObject {

	
	public BloodBank(int xx, int yy,int zz, Game g) {
		super(xx, yy, g);
		this.info = "B";
		this.health = zz;
		
	}

	@Override
	public void attack() {
		game.setCoinsFromBloodBank((health+10)/100);
		
	}

	@Override
	protected void advance() {}

	@Override
	protected void setAlive() {}

	@Override
	protected void setCnt() {}
	
	

}
