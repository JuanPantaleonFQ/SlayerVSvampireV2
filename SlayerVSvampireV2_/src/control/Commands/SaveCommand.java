package control.Commands;

import java.io.*;
import java.util.Scanner;
import Exceptions.CommandExecuteException;
import Exceptions.CommandParseException;
import logic.Game;

public class SaveCommand extends Command {
    private String filename="";

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the file name where you want to save the game: ");
        filename = scanner.nextLine();
        filename += ".data";
        File fileout = new File(filename);      //creamos un fichero con el nombre de filename.data

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileout)); //hacemos que ese file sea un filewriter, y que pueda usar buffers con esta instruccion.
            String inputData = "Buffy the Vampire Slayer v3.0 \n" + game.serialize();
            fileWriter.write(inputData);
            fileWriter.close();
        } catch (IOException e) {
            throw new CommandExecuteException("[ERROR]: " + fileError);
        }
        return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {

        
        return null;
    }
    
}
