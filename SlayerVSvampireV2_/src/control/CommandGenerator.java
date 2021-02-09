package control;
import control.Commands.AddBloodBankCommand;
import control.Commands.AddCommand;
import control.Commands.AddVampireCommand;
import control.Commands.Command;
import control.Commands.ExitCommand;
import control.Commands.GarlicPushCommand;
import control.Commands.HelpCommand;
import control.Commands.LightFlashCommand;
import control.Commands.ResetCommand;
import control.Commands.SaveCommand;
import control.Commands.SerializeCommand;
import control.Commands.SuperCoinsCommand;
import control.Commands.UpdateCommand;
import exceptions.CommandParseException;

public class CommandGenerator {
	private static Command[] avaibleCommands = {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new AddBloodBankCommand(),
			new GarlicPushCommand(),
			new LightFlashCommand(),
			new SuperCoinsCommand(),
			new AddVampireCommand(),
			new SerializeCommand(),
			new SaveCommand()
	};

	public static Command parse(String[] parameters) throws CommandParseException {
		int i = 0;
		Command c = null;
		while(c == null && i < 12) {
			c = avaibleCommands[i].parse(parameters);
			i++;
		}
		if (c == null) {
			throw new CommandParseException("[ERROR]: Unknow command: press H for HELP");
		}
		return c;
	}
	
	public static String commandHelp() {
		String help = "";
		for(int i = 0; i<12; i++) {
			help = help + avaibleCommands[i].helpText();
		}
		return help;
	}
	
	
	

}
