package control.Commands;

import Exceptions.CommandParseException;
import logic.Game;

public class SuperCoinsCommand extends Command {

	public SuperCoinsCommand() {
		this.name = String.format("Coins");
		this.shortcut = String.format("c");
		this.help = String.format("[c]oins");
		this.details = String.format("Add 1000 coins to the player.");
	}

	@Override
	public boolean execute(Game game) {
		game.setCoins(1000);

		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		return this.parseNoParamsCommand(commandWords);
		
		 
		}

}
