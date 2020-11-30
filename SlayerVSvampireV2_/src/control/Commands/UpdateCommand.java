package control.Commands;

import logic.Game;

public class UpdateCommand extends Command{
	public UpdateCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public boolean execute(Game game) {
		 game.computerActions();
		return true;
	}
	
	//Metodo matchCommandName sobreescrito para tener en cuenta el intro
	protected boolean matchCommandName(String name) {
	    return this.shortcut.equalsIgnoreCase(name) || 
	        this.name.equalsIgnoreCase(name) || name.equalsIgnoreCase("");
	}

	
	public Command parse(String[] commandWords) {
		return this.parseNoParamsCommand(commandWords);
	}

}

