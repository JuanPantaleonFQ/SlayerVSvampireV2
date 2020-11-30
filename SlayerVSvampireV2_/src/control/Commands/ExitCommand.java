package control.Commands;

import logic.Game;

public class ExitCommand extends Command{
	public ExitCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public boolean execute(Game game) {
		game.setFin(true);
		game.setWinnerMessage(0);
		return false;
	}

	
	public Command parse(String[] commandWords) {
		return this.parseNoParamsCommand(commandWords);
	}

}

