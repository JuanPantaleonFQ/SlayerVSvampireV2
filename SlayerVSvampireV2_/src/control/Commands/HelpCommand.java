package control.Commands;

import control.CommandGenerator;
import logic.Game;

public class HelpCommand extends Command {

	public HelpCommand() {
		this.name = String.format("help");
		this.shortcut = String.format("h");
		this.help = String.format("[h]elp");
		this.details = String.format("show this help text");
	}

	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}

	
	public Command parse(String[] commandWords) {
		return this.parseNoParamsCommand(commandWords);
	}

}
