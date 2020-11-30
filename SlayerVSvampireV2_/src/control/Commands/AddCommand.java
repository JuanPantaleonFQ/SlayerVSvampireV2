package control.Commands;

import logic.Game;

public class AddCommand extends Command {
	int x;
	int y;
	public AddCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}


	public boolean execute(Game game) {
		boolean ok = false;
		ok = game.addSlayer(x,y);
		if(ok) {
		 game.computerActions();
		}
		else {
			System.out.println(Command.incorrectPosition);
		}
		return ok;
	}


	public Command parse(String[] commandWords) {
		if (this.matchCommandName(commandWords[0])) {
			if (commandWords.length != 3) {
				System.err.println(Command.incorrectArgsMsg);
				return null;
			}
			else {
				this.y = Integer.parseInt(commandWords[2]);
	    		this.x = Integer.parseInt(commandWords[1]);
	    		return this;
			}
		}
		return null;
	}
	

}
