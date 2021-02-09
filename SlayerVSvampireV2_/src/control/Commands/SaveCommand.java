package control.Commands;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import exceptions.SuccessfullySavedException;
import logic.Game;

public class SaveCommand extends Command {
	String file;
	
	public SaveCommand() {
		this.name = String.format("save");
		this.shortcut = String.format("s");
		this.help = String.format("[s]ave <filename>");
		this.details = String.format("save game in file <filename>");
	}
	
	public SaveCommand(String filename) {
		this();
		this.file = filename;
	}

	
	
	
	public boolean execute(Game game) throws CommandExecuteException, IOException {
		try(BufferedWriter salida = new BufferedWriter(new FileWriter(this.file + ".dat"));) {
			salida.write(game.serializeGame());
			throw new SuccessfullySavedException("Game successfully saved in file " + this.file + ".dat \n\n");
			//System.out.println("Game successfully saved in file " + this.file + ".dat \n\n");
		}
		catch (FileNotFoundException e) {
			throw new IOException(e.getCause());
		}
	}

	
	public Command parse(String[] commandWords) throws CommandParseException {
		if (this.matchCommandName(commandWords[0])) {
			if (commandWords.length != 2) {
				throw new CommandParseException("[ERROR]: Command " + this.name + " : " + Command.incorrectNumberOfArgsMsg);
			}
			else {
				try {
				this.file = commandWords[1];
	    		return new SaveCommand(this.file);
				}
				catch(NumberFormatException e) {
					throw new CommandParseException("[ERROR]: Command " + this.name + " : unvalid argument, number expected: [a] <x> <y>");
				}
			}
		}
		return null;
	}

}
