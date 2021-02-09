package control.Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class AddBloodBankCommand extends Command{
	private int x;
	private int y; 
	private int z;
	public AddBloodBankCommand() {
		this.name = String.format("bank");
		this.shortcut = String.format("b");
		this.help = String.format("[b]ank <x> <y> <z>");
		this.details = String.format("add BankBlood in <x, y> and cost z");
	}
	
	public AddBloodBankCommand(int x, int y, int z) {
		this();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean execute(Game game) throws CommandExecuteException{
		boolean ok = false;
		try {
			ok = game.addDefensiveObject(x,y,z);
			game.computerActions();
		}
		catch (CommandExecuteException e) {
			throw new CommandExecuteException(e.getMessage() + "%n[ERROR]: Falied to add blood bank ", e.getCause());
		}
		return ok;
	}


	public Command parse(String[] commandWords) throws CommandParseException{
		if (this.matchCommandName(commandWords[0])) {
			if (commandWords.length != 4) {
				throw new CommandParseException("[ERROR]: Command " + this.name + ": " + Command.incorrectNumberOfArgsMsg);
			}
			else {
				try {
				this.y = Integer.parseInt(commandWords[2]);
	    		this.x = Integer.parseInt(commandWords[1]);
	    		this.z = Integer.parseInt(commandWords[3]);
	    		return new AddBloodBankCommand(this.x, this.y, this.z);
				}
				catch(NumberFormatException e) {
					throw new CommandParseException("[ERROR]: Command " + this.name + ": " + Command.incorrectArgsMsg);
				}
			}
		}
		return null;
	}

}
