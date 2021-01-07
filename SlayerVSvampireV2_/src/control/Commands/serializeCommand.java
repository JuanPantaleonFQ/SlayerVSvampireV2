package control.Commands;

import Exceptions.CommandExecuteException;
import Exceptions.CommandParseException;
import logic.Game;

public class serializeCommand extends Command {

    public serializeCommand(){
        this.name = String.format("serialize");
        this.shortcut = String.format("z");
        this.help = String.format("[z]erialize");
        this.details = String.format("Shows the serialized state of the game in the console");
        
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        System.out.println(game.serialize());
        return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        
        return null;
    }
    
}
