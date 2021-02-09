package control.Commands;

import Exceptions.CommandExecuteException;
import Exceptions.CommandParseException;
import logic.Game;

public class SerializeCommand extends Command {

    public SerializeCommand(){
        this.name = String.format("serialize");
        this.shortcut = String.format("z");
        this.help = String.format("[z]erialize");
        this.details = String.format("shows the serialized state of the game.");
        
    }

    @Override
    public boolean execute(Game game){
        System.out.println(game.serialize() + "\n\n");                          
        return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        
        return this.parseNoParamsCommand(commandWords);
    }
    
}
