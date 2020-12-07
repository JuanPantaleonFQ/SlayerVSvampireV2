package control.Commands;

import logic.Game;

public abstract class Command {

	  protected String name;
	  protected String shortcut;
	  protected String details; 	//como se ejecuta '[a]dd X Y'
	  protected String help;		// describir lo que hace el comando (este comando añade un slayer en la posicion X Y)

	  protected static final String incorrectNumberOfArgsMsg = "Incorrect number of arguments";
	  protected static final String incorrectArgsMsg = "Incorrect arguments format";
	  protected static final String incorrectPosition = "Incorrec position, element already exists or position is out of range";
	  
	  public Command(){}
	  
	  public abstract boolean execute(Game game);
	  
	  public abstract Command parse(String[] commandWords);
	  
	  protected boolean matchCommandName(String name) {
		    return this.shortcut.equalsIgnoreCase(name) || 
		        this.name.equalsIgnoreCase(name);
	  }
	  
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
	  
	  public String helpText(){
	    return help + ": " + details + "\n";
	  }
}
