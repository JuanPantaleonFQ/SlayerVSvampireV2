package control.Commands;

import logic.Game;

public class GarlicPushCommand extends Command {
	
	public GarlicPushCommand() {
		this.name ="Garlic";
		this.details = "Push vampires one step back.";
		this.help ="[g]arlic";
		this.shortcut = "g";
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
