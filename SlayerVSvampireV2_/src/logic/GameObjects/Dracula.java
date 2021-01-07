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
	
	protected String getObjectSerialized() {
		int advancebinary;					// 1-> significa que en el proximo ciclo avanza. 0 -> significa que no avanza en el proximo ciclo.
		if (this.progress ==0) {
			advancebinary = 1;			
		}else{
			advancebinary = 0;
		}
		
		return (this.info + ";"+this.x+";"+this.y+";"+this.health+";"+ advancebinary);
	}
	
	
	
	

}
