package logic;

import java.util.Random;


import exceptions.CommandExecuteException;
import exceptions.DraculaIsAliveException;
import exceptions.NoMoreVampiresException;
import exceptions.NotEnoughCoinsException;
import exceptions.UnvalidPositionException;
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
		Vampire.init();
		Dracula.init();
		init(this.seed);
	}
	
	
	//EJECUCION DE UN CICLO
	public void computerActions() throws DraculaIsAliveException {
		this.update();
		board.attack();
		this.addAttackObject();
		board.removeDeadObjects();
	}

	public void update() {
		this.cycles++;
		board.advance();
		if(r.nextFloat() <= 0.5 ) {
			player.setCoins(10);
		}
	}
	
	public void addAttackObject() throws DraculaIsAliveException {
		int posX;
		try {
			if (!Dracula.alive()){
				if(r.nextDouble() <= level.getVampireFrequency()) {
					posX = Math.abs(r.nextInt() % level.getDimX());
					if ((board.positionAvaible(posX, level.getDimY()-1)) && ((level.getNumberOfVampires()-Vampire.getTotalv()) > 0)) {
						board.addnewObject(new Dracula(posX, level.getDimY()-1, this));
					}
				}
			}
			else {
				throw new DraculaIsAliveException("[ERROR]: Dracula is already alive");
			}
		}
		
		catch(DraculaIsAliveException e) {}
		
		finally {
			if((r.nextDouble() <= level.getVampireFrequency())){
				posX = Math.abs(r.nextInt() % level.getDimX());
				if((board.positionAvaible(posX, level.getDimY()-1)) && ((level.getNumberOfVampires()-Vampire.getTotalv()) > 0)) {
					board.addnewObject(new Vampire(posX, level.getDimY()-1, this));
				}
			}
			
			if((r.nextDouble() <= level.getVampireFrequency())){
				posX = Math.abs(r.nextInt() % level.getDimX());
				if((board.positionAvaible(posX, level.getDimY()-1)) && ((level.getNumberOfVampires()-Vampire.getTotalv()) > 0))  {
					board.addnewObject(new ExplosiveVampire(posX, level.getDimY()-1, this));
				}
			}
		}
		
		
	}
	
	//metodo utilizado por el el comando addVampire
	public boolean addAttackObject(String type, int x, int y) throws CommandExecuteException {
		boolean ok = false;
		
		if (board.positionAvaible(x, y)) {
			if ((level.getNumberOfVampires()-Vampire.getTotalv()) > 0) {
				if(x <= level.getDimX()-1 && y < level.getDimY()) {
					if (type.equals("")) {
						board.addnewObject(new Vampire(x, y, this));
						ok=true;
					}
					else if (type.equalsIgnoreCase("d")) {
						if (!Dracula.alive()) {
							board.addnewObject(new Dracula(x,y, this));
							ok=true;
						}
						else {
							throw new DraculaIsAliveException("[ERROR]: Dracula is already alive");
						}
					}
					else if (type.equalsIgnoreCase("e")) {
						board.addnewObject(new ExplosiveVampire(x,y, this));
						ok= true;
					}
				}
				else {
					throw new UnvalidPositionException("[ERROR]: Position (" + x + "," + y + "): Out of board");

				}
			}
			else {
				throw new NoMoreVampiresException("[ERROR]: no more remainng vampires left");
			}
		}
		else {
			throw new UnvalidPositionException("[ERROR]: Position (" + x + "," + y + "): Exist bject already here");
		}
	
		return ok;
	}
	
	public boolean positionAvaible(int x, int y) {
		return board.positionAvaible(x, y);
	}
	
	public boolean addDefensiveObject(int x, int y) throws CommandExecuteException {
		boolean ok = false;
		if(player.areCoins(50)) {
			if (board.positionAvaible(x, y)) {
				if(x <= level.getDimX()-1 && y < level.getDimY()-1) {
					board.addnewObject(new Slayer(x,y,this));
					ok = true;
					player.setCoins(-50);
				}
				else {
					throw new UnvalidPositionException("[ERROR]: Position (" + x + "," + y + "): Out of board");
				}
			}
			else {
				throw new UnvalidPositionException("[ERROR]: Position (" + x + "," + y + "): Exist object already here");
			}
		}
		else {
			throw new NotEnoughCoinsException("[ERROR]: Add Slayer cost is 50: Not enough coins " );
		}
		return ok;
	}
	
	public boolean addDefensiveObject(int x, int y, int z) throws CommandExecuteException {
		boolean ok = false;
		if(player.areCoins(z)) {
			if(board.positionAvaible(x, y)) {
				if (x <= level.getDimX()-1 && y < level.getDimY()-1 && z > 0) {
					board.addnewObject(new BloodBank(x,y,z,this));
					ok = true;
					player.setCoins(-z);
				}
				else {
					throw new UnvalidPositionException("[ERROR]: Position (" + x + "," + y + "): Out of board");
				}
			}
			else {
				throw new UnvalidPositionException("[ERROR]: Position (" + x + "," + y + "): Exist object already here");
			}
		}
		else {
			throw new NotEnoughCoinsException("[ERROR]: Add Bank cost is"+ z +": Not enough coins " );
		}
		return ok;
	}
	
	
	public IAttack getAttackableInPosition (int x, int y) { 
		return board.getAttackableInPosition(x,y);
	}

	
	public String getPositionToString(int x, int y) {
		return board.getPositionToString(x,y);
	}

	public String getInfo() {
		String info = "Number of cycles: " + cycles + "\n" +
				"Coins: " + player.getCoins() + "\n" +
				"Remaining vampires: " + (level.getNumberOfVampires() - Vampire.getTotalv()) + "\n" +
				"Vampires on the board: " + Vampire.getVampiresOnB() + "\n";
		if (Dracula.alive()) {
			info += "Dracula is alive \n\n";
		}
		
		return info;
		
	}
	
	public String toString() {
		return printer.toString();
	}

	public int getDimY() {
		return level.getDimY();
	}
	
	public void setCoins(int num) {
		player.setCoins(num);
	}

	public boolean garlicPush() throws NotEnoughCoinsException {
		boolean ok = false;
		if(player.areCoins(10)) {
			player.setCoins(-10);
			board.garlicPush();
			ok= true;
		}
		else {
			throw new NotEnoughCoinsException("[ERROR]: Garlic Push cost is 10: Not enough coins " );
		}
		return ok;
	}

	public boolean lightFlash() throws NotEnoughCoinsException {
		boolean ok = false;
		if(player.areCoins(50)) {
			player.setCoins(-50);
			board.lightFlash();
			ok= true;
		}
		else {
			throw new NotEnoughCoinsException("[ERROR]: Light Flash cost is 50: Not enough coins " );
		}
		return ok;
	}
	
	public String serializeGame() {
		return "Cycles: " + this.cycles + "\n" +
					"Coins: " + player.getCoins() + "\n" +
					"Level: " + level.getName() + "\n" +
					"Remaining vampires: " + (level.getNumberOfVampires() - Vampire.getTotalv()) + "\n" +
					"Vampires on the board: " + Vampire.getVampiresOnB() + "\n\n" + 
					"Game Object List: \n" + 
					board.serialize();
	}
}
