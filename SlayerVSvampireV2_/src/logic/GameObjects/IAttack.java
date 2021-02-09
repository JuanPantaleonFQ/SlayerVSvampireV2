package logic.GameObjects;

public interface IAttack {
	public static final int HARM = 1;
	public static final int HARMD = 3;
	
	void attack();
	

	default boolean receiveSlayerAttack(int damage) {return false;};
	default boolean receiveVampireAttack(int damage) {return false;};
	default void receiveGarlicPush() {};
	default void receiveFlashAttack() {};
	
	
	
	
}
