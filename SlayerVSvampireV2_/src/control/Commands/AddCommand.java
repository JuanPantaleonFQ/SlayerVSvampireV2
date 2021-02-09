package control.Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class AddCommand extends Command {
	private int x;
	private int y; 
	
	public AddCommand() {
		this.name = String.format("add");
		this.shortcut = String.format("a");
		this.help = String.format("[a]dd <x> <y>");
		this.details = String.format("add a slayer in position x, y");
	}
	
	public AddCommand(int x, int y) {
		this();
		this.x = x;
		this.y = y;
	}

	public boolean execute(Game game) throws CommandExecuteException {
		boolean ok = false;	
		try {
			ok = game.addDefensiveObject(x,y);
			game.computerActions();
		}
		catch (CommandExecuteException e) {
			throw new CommandExecuteException(e.getMessage() + "\n[ERROR]: Falied to add slayer ", e.getCause());
		}
		
		return ok;
	}


	public Command parse(String[] commandWords) throws CommandParseException {
		if (this.matchCommandName(commandWords[0])) {
			if (commandWords.length != 3) {
				throw new CommandParseException("[ERROR]: Command " + this.name + " : " + Command.incorrectNumberOfArgsMsg);
			}
			else {
				try {
				this.y = Integer.parseInt(commandWords[2]);
	    		this.x = Integer.parseInt(commandWords[1]);
	    		return new AddCommand(this.x, this.y);
				}
				catch(NumberFormatException e) {
					throw new CommandParseException("[ERROR]: Command " + this.name + " : unvalid argument, number expected: [a] <x> <y>", e);
				}
			}
		}
		return null;
	}
	
}
