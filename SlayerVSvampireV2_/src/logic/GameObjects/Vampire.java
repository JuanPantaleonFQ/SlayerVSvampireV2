package logic.GameObjects;


import logic.Game;

public class Vampire extends GameObject {
	protected static int vampiresOnB= 0;
	protected static int totalv = 0;
	protected int progress;
	
	public Vampire(int xx, int yy, Game g) {
		super(xx, yy, g);
		this.health = 5;
		this.progress = 0;
		Vampire.vampiresOnB++;
		Vampire.totalv++;
		this.info = "V";
	}
	
	public static void init() {
		Vampire.vampiresOnB = 0;
		Vampire.totalv = 0;
	}
	
	public static int getVampiresOnB() {
		return vampiresOnB;
	}

	public static int getTotalv() {
		return totalv;
	}


	public void advance() {
		this.progress++;
		if(progress == 2) {
			progress = 0;
			if (game.positionAvaible(x, y-1)) {
				this.y--;
			}
		}
		if(y == 0) {
			
			game.setFin(true);
			game.setWinnerMessage(1);
		}
	}
	
	
	public static boolean elementfinal(int max) {
		boolean fin = false;
		if(Vampire.vampiresOnB == 0 && Vampire.totalv == max) {
			fin = true;
		}
		return fin;
	}



	public void attack() {
		if(isAlive()) {
			IAttack other = game.getAttackableInPosition(x, y-1);
			if(other != null) {
				other.receiveVampireAttack(HARM);
			}
		}
	}
	
	public boolean receiveSlayerAttack(int max) {
		this.health = this.health - max;
		if (this.health == 0) {
			Vampire.vampiresOnB--;
		}
		return true;
	}
	
	public void receiveGarlicPush() {
		this.progress = 0;
		if (game.positionAvaible(this.x, this.y+1)) {
			this.y++;
			if (this.outOfBoard()) {
				Vampire.vampiresOnB--;
			}
		}
	}
	
	public void receiveFlashAttack() {
		this.health = 0;
		Vampire.vampiresOnB--;
	}
	
	public String serialize() {
		return this.info+";" + this.x + ";" + this.y+ ";" + this.health+";" + this.progress+ ";";
	}
	
}
