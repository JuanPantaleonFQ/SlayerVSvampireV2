package logic.GameObjects;

import logic.Game;

public class Slayer extends GameObject{
	public Slayer(int xx, int yy, Game g) {
		super(xx, yy, g);
		this.info = "S";
		this.health = 3;
	}

	public void advance() {} //no se implementa 

	protected void setCnt() {} //no se implementa
	

	boolean equals2(int x, int y) {
		return (this.x == x && this.y == y);
	}
	//tener bucle encima de other.reciveSlayeratack recibimos los interfaces que pedimos, y en cuanto un interFAZ devuelva true se para.
	public void attack() {
		if(isAlive()) {
			int i = this.y;
			boolean atacado = false;
			do {
				i++;
				IAttack other = game.getAttackableInPosition(x,i);
				if(other != null) {
					other.receiveSlayerAttack(HARM);
					atacado = true;
				}
				
			} while (i < game.getDimY() && !atacado);
			
		}
	}
	
	public boolean receiveVampireAttack(int max) {
		this.health = this.health - max;
		return true;
	}

	@Override
	protected void setAlive() {}

	@Override
	protected String getObjectSerialized() {
		// TODO Auto-generated method stub

		return (this.info+";"+this.x+";"+this.y+";"+this.health);
	}
	
	 
	

	
}
