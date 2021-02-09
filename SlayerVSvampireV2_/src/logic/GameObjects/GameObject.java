package logic.GameObjects;


import logic.Game;

public abstract class GameObject implements IAttack{
	protected int x;
	protected int y;
	protected int health;
	protected Game game;
	protected String info; //atributo utilizado para pintar el objeto en el tablero, no se utiliza en ningun otro metodo
	
	public GameObject(int xx, int yy, Game g) {
		this.x = xx;
		this.y = yy;
		this.game = g;
		
	}
	
	public boolean isAlive() {
		return (health > 0);
	}
	
	public boolean outOfBoard() {
		return (this.y == game.getDimY());
	}
	
	public boolean equals(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	protected abstract void advance();
	
	public String toString() {
		return " " + this.info + " [" + this.health + "] ";
	}
	
	protected abstract String serialize();

	
}
