package Utils;

import control.*;

public class CommandGenerator {
	//Una clase utilidad es aquella en la que todos los métodos son estáticos
	
	//atributtes:
	private AddCommand add;
	private HelpCommand help;
	private ResetCommand reset;
	private ExitCommand exit;
	private UpdateCommand update;
	
	//Constructor:
	private static Command[] availableCommands = {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand()
			};
	
	//Metodos:
	public static Command parseCommand(String[ ] commandWords) {
		
	}
	
	/*
	 * 
	 */
	
	public static String commandHelp() {
		
	}
	
	/*
	 * que tiene una estructura similar al método anterior, pero invocando el método helpText() de cada subclase de Command. Este
		método es invocado por el método execute de la clase HelpCommand.
	 */
	

}
