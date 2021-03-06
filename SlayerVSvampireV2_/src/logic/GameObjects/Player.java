package logic.GameObjects;

public class Player {
	private int coins;
	
	//CONSTRUCTOR
	public Player() {
		this.coins = 50;
	}
	
	//M�todo que devuelve true si el numero de monedas del jugador es mayor o igual que 50, false en caso contrario
	public boolean areCoins(int num) { 							
		boolean ok = true;
		if (this.coins < num) {
			ok = false;
		}
		return ok;
	}

	//Getter de Monedas
	public int getCoins() {
		return coins;
	}

	//Setter modificado de monedas, incrementa el numero de monedas pasadas en el parametro
	public void setCoins(int coins) {
		this.coins += coins;
	}
	
	//M�todo que reseta el valor de coins a 50
	public void resetCoins() {
		this.coins = 50;
	}
	
	
}