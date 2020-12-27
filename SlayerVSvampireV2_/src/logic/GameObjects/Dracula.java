package logic.GameObjects;

import logic.Game;


public class Dracula extends Vampire {
	
	//Atributtes:
	private static boolean DraculaOnBoard = false;
	private int progress;
	
	//Constructor:
	public Dracula(int xx, int yy, Game g) {
		super(xx, yy, g);
		Dracula.DraculaOnBoard = true;
		this.health = 5;
		this.info = "D";
		this.progress = 0;
	}
		
	//metodos
	
	
	
	
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
	
	
	
	
	public void advance(){
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
	
	public boolean receiveFlashAttack() {
		return false;
	}
	
	
	
	
	

}
