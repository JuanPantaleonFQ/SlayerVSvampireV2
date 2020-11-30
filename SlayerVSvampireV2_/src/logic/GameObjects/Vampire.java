package logic.GameObjects;


import logic.Game;

public class Vampire extends GameObject {
	private static int vampiresOnB= 0;
	private static int totalv = 0;
	private int progress;
	public Vampire(int xx, int yy, Game g) {
		super(xx, yy, g);
		this.health = 5;
		this.progress = 0;
		Vampire.vampiresOnB++;
		Vampire.totalv++;
		this.info = "V";
	}
	
	public boolean equals2(int x, int y) {
		return (this.x == x && this.y > (y+1));
	}
	
	public static int getVampiresOnB() {
		return vampiresOnB;
	}
	public static void setVampiresOnB(int vampiresOnB) {
		Vampire.vampiresOnB = vampiresOnB;
	}
	
	public static int getTotalv() {
		return totalv;
	}
	public static void setTotalv(int totalv) {
		Vampire.totalv = totalv;
	}
	
	public void setCnt() {
		GameObject.cnt--;
		Vampire.vampiresOnB--;
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
		return true;
	}
	
}
