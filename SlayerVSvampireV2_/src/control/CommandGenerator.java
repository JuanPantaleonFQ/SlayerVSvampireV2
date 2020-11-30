package control;
import control.Commands.AddCommand;
import control.Commands.Command;
import control.Commands.ExitCommand;
import control.Commands.HelpCommand;
import control.Commands.ResetCommand;
import control.Commands.UpdateCommand;

public class CommandGenerator {
	private static Command[] avaibleCommands = {
			new AddCommand("add", "a", "", ""),
			new HelpCommand("help", "h", "", ""),
			new ResetCommand("reset", "r", "", ""),
			new ExitCommand("exit", "e", "", ""),
			new UpdateCommand("none", "n", "", "")
	};

	public static Command parse(String[] parameters) {
		int i = 0;
		Command c = null;
		while(c == null && i < 5) {
			c = avaibleCommands[i].parse(parameters);
			i++;
		}
		return c;
	}
	
	
	
	

}
