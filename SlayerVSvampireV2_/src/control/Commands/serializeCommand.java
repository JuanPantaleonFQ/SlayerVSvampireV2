package control.Commands;


import exceptions.CommandParseException;
import logic.Game;

public class SerializeCommand extends Command{

	public SerializeCommand() {
		this.name = String.format("serialize");
		this.shortcut = String.format("z");
		this.help = String.format("[z]serialize");
		this.details = String.format("change screen output to plain text");
	}
	public boolean execute(Game game){
		System.out.println(game.serializeGame() + "\n\n");
		return false;
	}


	public Command parse(String[] commandWords) throws CommandParseException {
		return this.parseNoParamsCommand(commandWords);
	}

}
