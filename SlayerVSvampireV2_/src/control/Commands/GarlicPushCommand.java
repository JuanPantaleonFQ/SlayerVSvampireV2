package control.Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class GarlicPushCommand extends Command{
	public GarlicPushCommand() {
		this.name = String.format("garlic");
		this.shortcut = String.format("g");
		this.help = String.format("[g]arlic");
		this.details = String.format("Push vampires one position back");
	}

	public boolean execute(Game game) throws CommandExecuteException {
		boolean ok = false;
		try {
			ok = game.garlicPush();
			game.computerActions();
		}
		catch (CommandExecuteException e) {
			throw new CommandExecuteException(e.getMessage() + "%n[ERROR]: Falied to garlic pushh", e.getCause());
		}
		return ok;
	}


	public Command parse(String[] commandWords) throws CommandParseException {
		return this.parseNoParamsCommand(commandWords);
	}

}
