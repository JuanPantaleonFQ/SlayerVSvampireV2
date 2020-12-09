package logic.GameObjects;

import logic.Game;


public class Dracula extends Vampire {
	
	//Atributtes:
	private static int DraculaOnBoard = 0;
	private int progress;
	
	//Constructor:
	public Dracula(int xx, int yy, Game g) {
		super(xx, yy, g);
		Dracula.DraculaOnBoard = 1;
		this.health = 5;
		this.info = "D";
		this.progress = 0;
	}
	
	//getters y setters para los draculas en el tablero en un instante
	public static int getDraculasOnBoard(){return DraculaOnBoard;}
	public static void setDraculasOnBoard(int draculaOnBoard){DraculaOnBoard = draculaOnBoard;}
	
	
	//metodos
	public boolean receiveSlayerAttack(int max) {
		this.health = this.health - max;
		return true;
	}
	
	
	//metodo de ataque para dracula
	public void DraculaAttack() {
		if (isAlive()) {
			IAttack other = game.getAttackableInPosition(x, y-1);
			if (other != null) {
				other.receiveDraculaAttack();
			}	
		}
		
		
	}
	//funcion que lo que hace es comprobar si ya hay un objeto dracula en el tablero
	public static boolean DraculaOnBoard(int max) {
		boolean fin = false;
		if(Dracula.DraculaOnBoard == 1) {
			fin = true;
		}
		return fin;
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
	
	
	
	
	
	
	

}
