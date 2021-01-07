package control.Commands;

import Exceptions.CommandParseException;
import logic.Game;

public class LightFlashCommand extends Command {
	public LightFlashCommand() {
		this.name = String.format("light");
		this.shortcut = String.format("l");
		this.help = String.format("[l]ight");
		this.details = String.format("Eliminate all vampires from the board except Dracula");
	}

	public boolean execute(Game game) {
		boolean ok = false;
		ok = game.lightFlash();
		if (ok) {
			game.computerActions();
		} else {
			System.err.println(notEnoughtCoins);
		}
		return ok;
	}

	public Command parse(String[] commandWords) throws CommandParseException {
		return this.parseNoParamsCommand(commandWords);
	}

}
