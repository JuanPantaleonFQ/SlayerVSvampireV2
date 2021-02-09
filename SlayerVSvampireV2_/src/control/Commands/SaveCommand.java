package control.Commands;

import java.io.*;
import java.util.Scanner;
import Exceptions.CommandExecuteException;
import Exceptions.CommandParseException;
import logic.Game;

public class SaveCommand extends Command {

    private String filename="";

    public SaveCommand(){
        this.name = String.format("save");
		this.shortcut = String.format("s");
		this.help = String.format("[s]ave <filename>");
		this.details = String.format("serialize the game state into a file ended with .data");
    }

    public SaveCommand(String nameOfFile){
        this();
        this.filename = nameOfFile;
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        filename += ".data";
        File fileout = new File(filename);      //creamos un fichero con el nombre de filename.data
        
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileout)); //hacemos que ese file sea un filewriter, y que pueda usar buffers con esta instruccion.
            String inputData = "Buffy the Vampire Slayer v3.0 \n" + game.serialize();
            fileWriter.write(inputData);
            fileWriter.close();
            System.out.println("“Game successfully saved in file: " + this.filename + ".data");
        } catch (IOException e) {
            throw new CommandExecuteException("[ERROR]: " + fileError);
        }
        return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        Command command = null;
        if (this.matchCommandName(commandWords[0])) {
            if (this.matchCommandName(commandWords[0])){
                if (commandWords.length != 2) {
                    throw new CommandParseException("[ERROR]: " + incorrectArgsMsg);
                }else{
                    
                   filename = commandWords[1];
                   command  = new SaveCommand(filename);
                }   
    
    
            }
                    
        }
        
        return command;
    }
    
}
