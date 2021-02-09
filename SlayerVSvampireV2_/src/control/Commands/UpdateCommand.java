package control.Commands;

import exceptions.CommandParseException;
import exceptions.DraculaIsAliveException;
import logic.Game;

public class UpdateCommand extends Command{
	public UpdateCommand() {
		this.name = String.format("none");
		this.shortcut = String.format("n");
		this.help = String.format("[n]one | []");
		this.details = String.format("update");
	}

	public boolean execute(Game game) throws DraculaIsAliveException {
		 game.computerActions();
		return true;
	}
	
	//Metodo matchCommandName sobreescrito para tener en cuenta el intro
	protected boolean matchCommandName(String name) {
	    return this.shortcut.equalsIgnoreCase(name) || 
	        this.name.equalsIgnoreCase(name) || name.equalsIgnoreCase("");
	}

	
	public Command parse(String[] commandWords) throws CommandParseException {
		return this.parseNoParamsCommand(commandWords);
	}

}

