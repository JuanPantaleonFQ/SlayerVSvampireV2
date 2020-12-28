package control.Commands;

import logic.Game;

public class AddBloodBankCommand extends Command {
	
	private int x;
	private int y;
	private int z;
	
	public AddBloodBankCommand() {
		this.name = String.format("bank");
		this.shortcut = String.format("b");
		this.help = String.format("[b]ank <x> <y> <z>");
		this.details = String.format("add BankBlood in <x, y> and cost <z>");
		
	}

	public AddBloodBankCommand(int x, int y, int z) {
		this();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean execute(Game game) {
		boolean executed = false;
		executed = game.addDefensiveObject(x, y, z);
		if (executed) {
			game.update();
		}
		else {
			System.out.println(notEnoughtCoins);
		}
		
		
		return executed;
	}

	@Override
	public Command parse(String[] commandWords) {
		if (this.matchCommandName(commandWords[0])) {
			if (commandWords.length != 4) {
				System.err.println(Command.incorrectArgsMsg);
				return null;
			}
			else {
				this.y = Integer.parseInt(commandWords[2]);
	    		this.x = Integer.parseInt(commandWords[1]);
	    		this.z = Integer.parseInt(commandWords[3]);
	    		return new AddBloodBankCommand(this.x, this.y, this.z);
			}
		}
		return null;
	}

}
