package logic.GameObjects;

import java.util.ArrayList;

public class GameObjectList {
	private ArrayList<GameObject> gameobjects;
	
	public GameObjectList() {
		this.gameobjects = new ArrayList<GameObject>();
	}
	
	public boolean positionAvaible(int x, int y) {
		boolean avaible = true;
		int i = 0;
		while( i < gameobjects.size() && avaible) {
			if(gameobjects.get(i).equals(x,y)) {
				avaible = false;
			}
			i++;
		}
		return avaible;
	}
	
	public void advance() {
		for(int i = 0; i < gameobjects.size(); i++) {
			gameobjects.get(i).advance();
		}
	}
	
	public void addnewObject(GameObject o) {
		gameobjects.add(o);
	}
	
	public IAttack getAttackableInPosition(int x, int y) {
		IAttack other = null;
		boolean found = false;
		int i = 0;
		while(!found && i < gameobjects.size() ) {
			if(gameobjects.get(i).equals(x,y) && gameobjects.get(i).isAlive()) {
				other = gameobjects.get(i);
				found = true;
			}
			i++;
		}
		return other;
	}
	
	public void attack() {
		for(int i = 0; i < gameobjects.size(); i++) {
			gameobjects.get(i).attack();
		}
	}
	
	public String getPositionToString(int x, int y) {
		String pos = "       ";
		boolean found = false;
		int i = 0;
		while(!found && i < gameobjects.size()) {
			if(gameobjects.get(i).equals(x,y)) {
				pos = gameobjects.get(i).toString();
				found = true;
			}
			i++;
		}
		return pos;
	}
	
	public void removeDeadObjects() {
		for(int i = 0; i < gameobjects.size(); i++) {
			if(!gameobjects.get(i).isAlive() || gameobjects.get(i).outOfBoard()) {
				gameobjects.remove(i);
			}
		}
	}

	public void garlicPush() {
		for(int i = 0; i < gameobjects.size(); i++) {
			if(gameobjects.get(i).isAlive()) {
				gameobjects.get(i).receiveGarlicPush();
			}
		}	
	}

	public void lightFlash() {
		for(int i = 0; i < gameobjects.size(); i++) {
			if(gameobjects.get(i).isAlive()) {
				gameobjects.get(i).receiveFlashAttack();
			}
		}
	}
	
	public String serialize() {
		String serialize = "";
		for(int i = 0; i < gameobjects.size(); i++) {
			if(gameobjects.get(i).isAlive()) {
				serialize += gameobjects.get(i).serialize() + "\n";
			}
		}
		return serialize;
	}


}
