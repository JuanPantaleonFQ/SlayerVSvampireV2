package control.Commands;

import exceptions.CommandParseException;
import logic.Game;

public class ResetCommand extends Command {
	public ResetCommand() {
		this.name = String.format("reset");
		this.shortcut = String.format("r");
		this.help = String.format("[r]eset");
		this.details = String.format("reset game");
	}

	public boolean execute(Game game) {
		game.reset();
		return true;
	}

	
	public Command parse(String[] commandWords) throws CommandParseException {
		return this.parseNoParamsCommand(commandWords);
	}

}

