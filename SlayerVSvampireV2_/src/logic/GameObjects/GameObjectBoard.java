package logic.GameObjects;
import java.util.ArrayList;

public class GameObjectBoard {
	private ArrayList<GameObject> gameobjects;
	
	public GameObjectBoard() {
		this.gameobjects = new ArrayList<GameObject>();
	}
	
	public boolean positionAvaible(int x, int y) {
		boolean avaible = true;
		int i = 0;
		while( i < GameObject.cnt && avaible) {
			if(gameobjects.get(i).equals(x,y)) {
				avaible = false;
			}
			i++;
		}
		return avaible;
	}
	
	public void advance() {
		for(int i = 0; i < GameObject.cnt; i++) {
			gameobjects.get(i).advance();
		}
	}
	
	public void addnewVampire(Vampire v) {
		gameobjects.add(v);
	}
	
	public void addnewSlayer(Slayer s) {
		gameobjects.add(s);
	}

	public IAttack getAttackableInPosition(int x, int y) {
		IAttack other = null;
		boolean found = false;
		int i = 0;
		while(!found && i < GameObject.getCnt() ) {
			if(gameobjects.get(i).equals2(x,y) && !gameobjects.get(i).equals(x,y+1)) {
				other = gameobjects.get(i);
				found = true;
			}
			i++;
		}
		return other;
	}

	public void attack() {
		for(int i = 0; i < GameObject.cnt; i++) {
			gameobjects.get(i).attack();
		}
	}

	public String getPositionToString(int x, int y) {
		String pos = "       ";
		boolean found = false;
		int i = 0;
		while(!found && i < GameObject.getCnt() ) {
			if(gameobjects.get(i).equals(x,y)) {
				pos = gameobjects.get(i).toString();
				found = true;
			}
			i++;
		}
		return pos;
	}
	
	public void removeDeadObjects() {
		for(int i = 0; i < GameObject.cnt; i++) {
			if(!gameobjects.get(i).isAlive()) {
				gameobjects.get(i).setCnt();
				gameobjects.remove(i);
			}
		}
	}
	
	
}
