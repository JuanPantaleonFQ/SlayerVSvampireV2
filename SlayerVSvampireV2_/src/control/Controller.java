package control;

import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import Exceptions.GameExceptions;
import control.Commands.Command;
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
    
    public void run() throws IOException,GameExceptions {
	    	boolean refreshDisplay = true;

	    while (!game.isFinished()){
	    		
        	  if (refreshDisplay) {
        		  printGame();
        	  }
        	  refreshDisplay = false;
			  System.out.println(prompt);	
			  String s = scanner.nextLine();
			  String[] parameters = s.toLowerCase().trim().split(" ");
			  System.out.println("[DEBUG] Executing: " + s);
			  try {
				Command command = CommandGenerator.parse(parameters);
				refreshDisplay = command.execute(game);
			  }catch(GameExceptions e) {System.out.format(e.getMessage() + "%n%n");}
			   /*
		      Command command = CommandGenerator.parse(parameters);
		      if (command != null) { 
		    	  		refreshDisplay = command.execute(game);
		       } 
		       else {
		    	   		System.out.println("[ERROR]: "+ unknownCommandMsg);
		       }*/
		}
	    
        	if (refreshDisplay) {
        		printGame();
        	}
    		System.out.println ("[Game over] " + game.getWinnerMessage());
    }

}

