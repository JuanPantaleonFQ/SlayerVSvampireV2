package logic.GameObjects;


import logic.Game;

public abstract class GameObject implements IAttack{
	protected int x;
	protected int y;
	protected int health;
	protected Game game;
	protected static int cnt = 0;
	protected String info; //atributo utilizado para pintar el objeto en el tablero, no se utiliza en ningun otro metodo
	
	public GameObject(int xx, int yy, Game g) {
		this.x = xx;
		this.y = yy;
		this.game = g;
		GameObject.cnt++;
	}
	
	public boolean isAlive() {
		return (health > 0);
	}
	
	public boolean equals(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	
	public static int getCnt() {
		return cnt;
	}
	public static void setCnt(int n) {
		GameObject.cnt = n;
	}
	abstract protected void setCnt();
	
	abstract boolean equals2(int x, int y);
	abstract void advance();
	
	public String toString() {
		return " " + this.info + " [" + this.health + "] ";
	}
}
