package control.Commands;

import exceptions.CommandParseException;
import logic.Game;

public class SuperCoinsCommand extends Command{
	public SuperCoinsCommand() {
		this.name = String.format("coins");
		this.shortcut = String.format("c");
		this.help = String.format("[c]oins");
		this.details = String.format("add 1000 coins");
	}
	
	public boolean execute(Game game) {
		game.setCoins(1000);
		return true;
	}


	public Command parse(String[] commandWords) throws CommandParseException {
		
		return this.parseNoParamsCommand(commandWords);
	}

}
