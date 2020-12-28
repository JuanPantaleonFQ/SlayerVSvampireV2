package logic.GameObjects;

public interface IAttack {
	public static final int HARM = 1;
	public static final int HARMD = 3;
	
	void attack();
	//metodos para que cada objeto reciva los ataques de la forma que deba
	default boolean receiveSlayerAttack(int damage) {return false;};
	default boolean receiveVampireAttack(int damage) {return false;};
	
	
	
	default boolean receiveLightFlash() {return false;};
	default boolean receiveGarlicPush() {return false;};
	
	default void damageExplosive() {};
	
}