package control.Commands;

import logic.Game;

public class ExitCommand extends Command{
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

	
	public Command parse(String[] commandWords) {
		return this.parseNoParamsCommand(commandWords);
	}

}

