package logic.GameObjects;


import logic.GameObjects.GameObjectList;

public class GameObjectBoard {
	private GameObjectList list;
	
	public GameObjectBoard() {
		this.list = new GameObjectList();
	}
	
	public boolean positionAvaible(int x, int y) {
		return list.positionAvaible(x, y);
	}
	
	public void advance() {
		list.advance();
	}
	
	public void addnewObject(GameObject o) {
		list.addnewObject(o);
	}

	public IAttack getAttackableInPosition(int x, int y) {
		return list.getAttackableInPosition(x, y);
	}

	public void attack() {
		list.attack();
	}

	public String getPositionToString(int x, int y) {
		return list.getPositionToString(x, y);
	}
	
	public void removeDeadObjects() {
		list.removeDeadObjects();
	}
	
	
	
}
