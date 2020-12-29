package logic;

import java.util.Random;
import logic.GameObjects.*;
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
		this.addAttackObject();
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
	
	
	
	public void addAttackObject() {
		int posX;
		if (r.nextDouble() <= level.getVampireFrequency()) {
			posX = Math.abs(r.nextInt() % level.getDimX()); 
			if((board.positionAvaible(posX, level.getDimY()-1)) && ((level.getNumberOfVampires()-Vampire.getTotalv()) > 0))  {
				board.addnewObject(new Vampire(posX, level.getDimY()-1 ,this));
			}
		}
		
		if (!Dracula.Alive() && (r.nextDouble() <= level.getVampireFrequency())) {
			posX = Math.abs(r.nextInt() % level.getDimX());
			if ((board.positionAvaible(posX, level.getDimY()-1)) && ((level.getNumberOfVampires()-Vampire.getTotalv()) > 0)) {
				board.addnewObject(new Dracula(posX,level.getDimY()-1,this));
				System.out.println("Dracula is alive");
			}
			
		
		}
		if((r.nextDouble() <= level.getVampireFrequency())){
			posX = Math.abs(r.nextInt() % level.getDimX());
			if((board.positionAvaible(posX, level.getDimY()-1)) && ((level.getNumberOfVampires()-Vampire.getTotalv()) > 0))  {
				board.addnewObject(new ExplosiveVampire(posX, level.getDimY()-1, this));
			}
		}
		
		
		
	}
	
	public boolean addDefensiveObject(int x, int y) {
		boolean added = false;
		if (player.areCoins(50) && board.positionAvaible(x, y) && (x <= level.getDimX()-1) && (y <= level.getDimY()-1 )) {
			board.addnewObject(new Slayer(x,y,this));
			added = true;
			player.setCoins(-50);
			
		}
		return added;
	}
	
	public boolean addDefensiveObject(int x, int y, int z) {
		boolean added = false;
		if (player.areCoins(z) && board.positionAvaible(x, y) && (y < level.getDimY()) && (x < level.getDimX())) {
			player.setCoins(-z);
			board.addnewObject(new BloodBank(x,y,z, this));
			added = true;
			
		}
		return added;
	}
	//ESte metodo es utilizado por el comando para poder escoger que
	//vampire añadir y de que tipo:
	//metodo utilizado para el comando addvampireCommand:
	public boolean addAttackObject(String type,int xx,int yy) {
		boolean added = false;
		if (type.equals("d") && (board.positionAvaible(xx, yy)) && ((level.getNumberOfVampires()-Vampire.getTotalv())>0)&& (xx < level.getDimX())&& (yy < level.getDimY())) {
			if (Dracula.Alive()) {
				System.out.println("Dracula is already alive");
				added = false;
			}else{
			board.addnewObject(new Dracula(xx, yy, this));
			added = true;
			}
			
		}
		else if(type.equals("e") &&(board.positionAvaible(xx, yy)) &&((level.getNumberOfVampires()-Vampire.getTotalv())> 0 ) && (xx < level.getDimX()) && (yy < level.getDimY())){
			board.addnewObject(new ExplosiveVampire(xx, yy, this));
			added = true;
		}
		else if(type.equals("") && board.positionAvaible(xx, yy)&& (board.positionAvaible(xx, yy)) && ((level.getNumberOfVampires()-Vampire.getTotalv())>0)){
			board.addnewObject(new Vampire(xx, yy, this));
			added = true;

		}	
				
		return added; 
	}
	
	public boolean positionAvaible(int x, int y) {
		return board.positionAvaible(x, y);
	}
	
	
	
	public IAttack getAttackableInPosition (int x, int y) {
		IAttack other;
		other = board.getAttackableInPosition(x,y);
		return other;
	}

	
	public String getPositionToString(int x, int y) {
		return board.getPositionToString(x,y);
		
		
		
	}
	
	public int getDimY() {
		return level.getDimY();
	}
	public int getDimX() {
		return level.getDimX();
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

	public void setCoins(int coins) {
		player.setCoins(coins);
	}
	
	public boolean garlicPush() {
		boolean ok = false;
		if(player.areCoins(10)) {
			player.setCoins(-10);
			board.GarlicPush();
			ok= true;
		}
		return ok;
	}

	public boolean lightFlash() {
		boolean ok = false;
		if(player.areCoins(50)) {
			player.setCoins(-50);
			board.LightFlash();
			ok= true;
		}
		return ok;
	}

	public void setCoinsFromBloodBank(int i) {
		// TODO Auto-generated method stub
		player.setCoinsFromBloodBank(i);
		
	}
	
}
