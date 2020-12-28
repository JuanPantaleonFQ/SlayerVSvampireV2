package logic.GameObjects;

import logic.Game;


public class Dracula extends Vampire {
	
	//Atributtes:
	private static boolean DraculaOnBoard = false;
		
	//Constructor:
	public Dracula(int xx, int yy, Game g) {
		super(xx, yy, g);
		Dracula.DraculaOnBoard = true;
		this.health = 5;
		this.info = "D";
		
	}
		
	
	//metodo de ataque para dracula
	public void attack() {
		if (isAlive()) {
			IAttack other = game.getAttackableInPosition(x, y-1);
			if (other != null) {
				other.receiveVampireAttack(HARMD);
			}	
		}
		
		
	}
	//funcion que lo que hace es comprobar si ya hay un objeto dracula en el tablero
	public static boolean Alive(){
		return DraculaOnBoard;
		
	}
	
	public void setAlive() {
		 Dracula.DraculaOnBoard = false;
	}
	
	
	
	public boolean receiveLightFlash() {
		return false;
	}
	
	
	
	
	

}
