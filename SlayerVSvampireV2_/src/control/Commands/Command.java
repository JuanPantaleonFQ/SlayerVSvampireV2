package control.Commands;

import logic.Game;
import Exceptions.*;

public abstract class Command {

	  protected String name;
	  protected String shortcut;
	  protected String details; 	//como se ejecuta '[a]dd X Y'
	  protected String help;		// describir lo que hace el comando (este comando a�ade un slayer en la posicion X Y)

	  protected static final String incorrectNumberOfArgsMsg = "Incorrect number of arguments";
	  protected static final String incorrectArgsMsg = "Incorrect arguments format";
	  protected static final String incorrectPosition = "Incorrect position, element already exists or position is out of range";
	  protected static final String notEnoughtCoins = "You don't have enough coins";
	  
	  public Command(){}
	  
	  public abstract boolean execute(Game game) throws CommandExecuteException;
	  
	  public abstract Command parse(String[] commandWords) throws CommandParseException;
	  
	  protected boolean matchCommandName(String name) {
		    return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	  }

	  //antiguo metodo antes de añadir excepciones.
	  /*
	  protected Command parseNoParamsCommand(String[] words) {
			if (matchCommandName(words[0])) {
				if (words.length != 1) {
					System.err.println(incorrectArgsMsg);
					return null;
				}
				return this;
			}
			
			return null;
	  }
	  */

	  protected Command parseNoParamsCommand(String[] words) throws CommandParseException {
			if (matchCommandName(words[0])) {
				if (words.length != 1){
					throw new CommandParseException("[ERROR]: Command "+name+" :" + incorrectNumberOfArgsMsg);
				}else{
					return this;
				} 
			}
			return null;
		}


	  
	  public String helpText(){
	    return help + ": " + details + "\n";
	  }

	  public String UnvalidArgsForParseMethod(){
		  return("Unvalid argument for" + name +  "command, number expected: " + help);
	  }
}
