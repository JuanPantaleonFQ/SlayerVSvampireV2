package logic;

import java.util.Random;


import logic.GameObjects.*;
import logic.GameObjects.GameObjectBoard;
import view.GamePrinter;
import view.IPrintable;

public class Game implements IPrintable{
	private Player player;
	private GameObjectBoard board;
	private Level level;
	private Random r;
	private boolean fin; 
	private int cycles;
	private GamePrinter printer;   
	private int winnerMessage;
	private Long seed;
	
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	//CONSTRUCTOR
	public Game(Long seed, Level level) {
		this.level = level;
		this.seed = seed;
		init(this.seed);
	}
	
	public void init(Long seed) {
		this.r = new Random(seed);
		this.fin = false;
		this.cycles = 0;
		this.player = new Player();
		this.board = new GameObjectBoard();
		this.printer = new GamePrinter(this, level.getDimY(), level.getDimX());
	}

	public String getWinnerMessage() {
		String message = "";
		if(this.winnerMessage == 0) {message = "Nobody win";}
		else if (this.winnerMessage == 1) { message = "Vampires win";}
		else if (this.winnerMessage == 2) {message = "Player win";}
		return message;
	}
	
	public void setWinnerMessage(int number) {
		this.winnerMessage = number;
	}
	
	public boolean isFinished() {
		if(Vampire.elementfinal(level.getNumberOfVampires())) {
			this.fin = true;
			this.winnerMessage = 2;
		}
		return this.fin;
	}
	
	public void setFin(boolean s) {
		this.fin = s;
	}
	
	public void reset() {
		Vampire.setTotalv(0);
		Vampire.setVampiresOnB(0);
		//deletevampires.
		init(this.seed);
	}
	
	
	//EJECUCION DE UN CICLO
	public void computerActions() {
		this.update();
		board.attack();
		this.addVampire();
		board.removeDeadObjects();
	}
	
	

	public void update() {
		this.cycles++;
		board.advance();
		if(r.nextFloat() <= 0.5 ) {
			if (this.cycles != 0) {
				player.setCoins(10);
			}
		}
	}
	
	public void attack() {
		board.attack();
	}
	
	public void addVampire() {
		int posX = Math.abs(r.nextInt() % level.getDimX()); 
		if((r.nextDouble() <= level.getVampireFrequency()) && (board.positionAvaible(posX, level.getDimY()-1)) && ((level.getNumberOfVampires()-Vampire.getTotalv()) > 0))  {
			board.addnewObject(new Vampire(posX, level.getDimY()-1 ,this));
		}
	}
	
	public boolean positionAvaible(int x, int y) {
		return board.positionAvaible(x, y);
	}
	
	public boolean addSlayer(int x, int y) {
		boolean ok = false;
		if(player.areCoins() && board.positionAvaible(x, y) && x <= level.getDimX()-1 && y < level.getDimY()-1) {
			board.addnewObject(new Slayer(x,y,this));
			ok = true;
			player.setCoins(-50);
		}
		return ok;
	}
	
	public IAttack getAttackableInPosition (int x, int y) {
		IAttack other;
		other = board.getAttackableInPosition(x,y);
		return other;
	}

	
	public String getPositionToString(int x, int y) {
		return board.getPositionToString(x,y);
	}

	public String getInfo() {
		return "Number of cycles: " + cycles + "\n" +
				"Coins: " + player.getCoins() + "\n" +
				"Remaining vampires: " + (level.getNumberOfVampires() - Vampire.getTotalv()) + "\n" +
				"Vampires on the board: " + Vampire.getVampiresOnB() + "\n\n";
	}
	
	public String toString() {
		return printer.toString();
	}
}
