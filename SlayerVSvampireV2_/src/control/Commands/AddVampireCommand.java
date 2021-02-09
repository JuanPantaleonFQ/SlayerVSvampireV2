package control.Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import exceptions.InvalidVampireTypeException;
import logic.Game;

public class AddVampireCommand extends Command{
	private int x;
	private int y; 
	private String type;
	public AddVampireCommand() {
		this.name = String.format("vampire");
		this.shortcut = String.format("v");
		this.help = String.format("[v]ampire [<type>] <x> <y>");
		this.details = String.format("add a vampire (dracula or explosive) in position x, y");
	}
	public AddVampireCommand(String type, int xx, int yy) {
		this();
		this.type = type;
		this.x = xx;
		this.y = yy;
	}
	

	public boolean execute(Game game) throws CommandExecuteException {
		boolean ok = false;
		try {
		ok = game.addAttackObject(type,x,y);
		}
		catch (CommandExecuteException e) {
			throw new CommandExecuteException(e.getMessage() + "%n[ERROR]: Falied to add vampire ", e);
		}
		return ok;
	}


	public Command parse(String[] commandWords) throws CommandParseException {
		if (this.matchCommandName(commandWords[0])) {
			if (commandWords.length != 4 && commandWords.length != 3) {
				throw new CommandParseException("[ERROR]: Command " + this.name + " : " + Command.incorrectNumberOfArgsMsg);
			}
			else if (commandWords.length == 3){
				try {
					this.y = Integer.parseInt(commandWords[2]);
		    		this.x = Integer.parseInt(commandWords[1]);
		    		this.type = "";
		    		return new AddVampireCommand(this.type, this.x, this.y);
				}
				catch(NumberFormatException e) {
					throw new CommandParseException("[ERROR]: Command " + this.name + " : " + Command.incorrectArgsMsg);
				}
				
			}
			else {
				try {
					this.y = Integer.parseInt(commandWords[3]);
		    		this.x = Integer.parseInt(commandWords[2]);
					if (commandWords[1].equalsIgnoreCase("d")) {
						this.type = "d";
						return new AddVampireCommand(this.type, this.x, this.y);
					}
					else if(commandWords[1].equalsIgnoreCase("e")) {
						this.type = "e";
						return new AddVampireCommand(this.type, this.x, this.y);
					}
					else {
						throw new InvalidVampireTypeException("[ERROR]: invalid vampire type: <>normal <e>xplosive <d>racula ");
					}
				}
				catch(NumberFormatException e) {
					throw new CommandParseException("[ERROR]: Command " + this.name + " : " + Command.incorrectArgsMsg);
				}
			}
		}
		return null;
	}
	
}
