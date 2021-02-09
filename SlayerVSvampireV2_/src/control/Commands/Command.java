package control.Commands;

import java.io.IOException;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public abstract class Command {

	  protected String name;
	  protected String shortcut;
	  protected String details; 
	  protected String help;

	  protected static final String incorrectNumberOfArgsMsg = "Incorrect number of arguments";
	  protected static final String incorrectArgsMsg = "Incorrect arguments format";

	  
	  public Command(){}
	  
	  public abstract boolean execute(Game game) throws CommandExecuteException, IOException;
	  
	  public abstract Command parse(String[] commandWords) throws CommandParseException;
	  
	  protected boolean matchCommandName(String name) {
		    return this.shortcut.equalsIgnoreCase(name) || 
		        this.name.equalsIgnoreCase(name);
	  }
	  
	  protected Command parseNoParamsCommand(String[] words) throws CommandParseException {
			if (matchCommandName(words[0])) {
				if (words.length != 1) {
					throw new CommandParseException("[ERROR]: Command " + name + ": " + incorrectNumberOfArgsMsg);
				}
				return this;
			}
			
			return null;
	  }
	  
	  public String helpText(){
	    return help + ": " + details + "\n";
	  }
}
