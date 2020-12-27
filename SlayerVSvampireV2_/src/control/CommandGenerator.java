package control;
import control.Commands.AddCommand;
import control.Commands.Command;
import control.Commands.ExitCommand;
import control.Commands.GarlicPushCommand;
import control.Commands.HelpCommand;
import control.Commands.ResetCommand;
import control.Commands.SuperCoinsCommand;
import control.Commands.UpdateCommand;

public class CommandGenerator {
	private static Command[] avaibleCommands = {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new SuperCoinsCommand(),
			new GarlicPushCommand(),
	};
	

	public static Command parse(String[] parameters) {
		int i = 0;
		Command c = null;
		while(c == null && i < 7) {
			c = avaibleCommands[i].parse(parameters);
			i++;
		}
		return c;
	}
	
	public static String commandHelp() {
		String help = "";
		for(int i = 0; i<7; i++) {
			help = help + avaibleCommands[i].helpText();
		}
		return help;
	}
	
	
	

}
