package control.Commands;

import Exceptions.CommandParseException;
import logic.Game;

public class AddCommand extends Command {
	private int x;
	private int y;
	
	public AddCommand() {
		this.name = String.format("add");
		this.shortcut = String.format("a");
		this.help = String.format("[a]dd <x> <y>");
		this.details = String.format("add a slayer in position x, y");
	}
	
	public AddCommand(int x, int y) {
		this();	//llama al constructor
		this.x = x;
		this.y = y;
	}

	public boolean execute(Game game) {
		boolean ok = false;
		ok = game.addDefensiveObject(x, y);
		if(ok) {
		 game.computerActions();
		}
		else {
			System.out.println(Command.incorrectPosition);
		}
		return ok;
	}


	//este es el antiguo metodo parse
	/*
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
	*/
	public Command parse(String[] commandWords) throws CommandParseException{
		Command command = null;
		if (this.matchCommandName(commandWords[0])){
			if (commandWords.length != 3) {
				throw new CommandParseException("[ERROR]: " + UnvalidArgsForParseMethod());
				
			}
			else{
				try {
					this.y = Integer.parseInt(commandWords[2]);
					this.x = Integer.parseInt(commandWords[1]);
				} catch (NumberFormatException e) {
					//TODO: handle exception
					throw new CommandParseException("[ERROR]: "+ UnvalidArgsForParseMethod());
				}
				command = new AddCommand(this.x, this.y);
			}

			
		}



		
		return command;
	}
	

}
