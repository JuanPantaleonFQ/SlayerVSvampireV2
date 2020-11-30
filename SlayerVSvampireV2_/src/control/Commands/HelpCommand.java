package control.Commands;

import logic.Game;

public class HelpCommand extends Command {

	public HelpCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public boolean execute(Game game) {
		System.out.println(Game.helpMsg);
		return false;
	}

	
	public Command parse(String[] commandWords) {
		return this.parseNoParamsCommand(commandWords);
	}

}
