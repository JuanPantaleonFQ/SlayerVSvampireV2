package control.Commands;

import Exceptions.CommandParseException;
import logic.Game;

public class ExitCommand extends Command {
	public ExitCommand() {
		this.name = String.format("exit");
		this.shortcut = String.format("e");
		this.help = String.format("[e]xit");
		this.details = String.format("exit game");
	}

	public boolean execute(Game game) {
		game.setFin(true);
		game.setWinnerMessage(0);
		return false;
	}

	public Command parse(String[] commandWords) throws CommandParseException {
		return this.parseNoParamsCommand(commandWords);
	}

}

