package control.Commands;

import logic.Game;

public class GarlicPushCommand extends Command {
	
	public GarlicPushCommand() {
		this.name = String.format("garlic");
		this.shortcut = String.format("g");
		this.help = String.format("[g]arlic");
		this.details = String.format("Push vampires one step back");
	}

	@Override
	public boolean execute(Game game) {
		boolean executed = false;
		executed = game.garlicPush();
		if (executed) {
			game.computerActions();
		}
		else {
			
			System.out.println(notEnoughtCoins);
			
		}
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		return this.parseNoParamsCommand(commandWords);
		
	}
	
	

}
