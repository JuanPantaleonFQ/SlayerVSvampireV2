package control.Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class LightFlashCommand extends Command {
	public LightFlashCommand() {
		this.name = String.format("light");
		this.shortcut = String.format("l");
		this.help = String.format("[l]ight");
		this.details = String.format("Eliminate all vampires from the board except Dracula");
	}

	public boolean execute(Game game) throws CommandExecuteException {
		boolean ok = false;
		try {
			ok = game.lightFlash();;
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
