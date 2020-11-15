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
	
	
	private static Command[] availableCommands = {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand()
			};
	

}
