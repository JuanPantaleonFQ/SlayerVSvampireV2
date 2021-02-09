package control;

import java.io.IOException;
import java.util.Scanner;

import control.Commands.Command;
import exceptions.GameException;
import control.CommandGenerator;
import logic.Game;

public class Controller {
	
	public final String prompt = "Command > ";
	public static final String unknownCommandMsg ="Unknown command";

    private Game game;
    private Scanner scanner;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    	this.scanner = scanner;
    }
    
    public void  printGame() {
   	 System.out.println(game);
   }
    
    public void run() throws IOException, GameException {
	    	boolean refreshDisplay = true;

	    while (!game.isFinished()){
	    		
        	  if (refreshDisplay) {
        		  printGame();
        	  }
        	  refreshDisplay = false;
			  System.out.print(prompt);	
			  String s = scanner.nextLine();
			  String[] parameters = s.toLowerCase().trim().split(" ");
			  System.out.println("[DEBUG] Executing: " + s);
			  try {
			      Command command = CommandGenerator.parse(parameters);
			      refreshDisplay = command.execute(game);
			  } 
			  catch (GameException ex) {
		    	   		System.out.format(ex.getMessage() + "\n\n");
		       }
		}
	    
        	if (refreshDisplay) {
        		printGame();
        	}
    		System.out.println("[Game over] " + game.getWinnerMessage());
    }

}

