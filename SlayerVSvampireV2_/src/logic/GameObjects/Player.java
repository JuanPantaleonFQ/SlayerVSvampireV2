package logic.GameObjects;

public class Player {
	private int coins;
	
	//CONSTRUCTOR
	public Player() {
		this.coins = 50;
	}
	
	//Método que devuelve true si el numero de monedas del jugador es mayor o igual que un numero de monedas que se pasa por parametro, false en caso contrario
	public boolean areCoins(int x) { 							
		boolean are = true;
		if (this.coins < x) {
			are = false;
		}
		return are;
	}

	//Getter de Monedas
	public int getCoins() {
		return coins;
	}

	//Setter modificado de monedas, incrementa el numero de monedas pasadas en el parametro
	public void setCoins(int coins) {
		this.coins += coins;
	}
	
	//Método que reseta el valor de coins a 50
	public void resetCoins() {
		this.coins = 50;
	}
	
	
}