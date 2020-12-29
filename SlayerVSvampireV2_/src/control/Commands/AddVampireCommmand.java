package control.Commands;

import logic.Game;

public class AddVampireCommmand extends Command {
	
	private int x;
	private int y;
	private String type;
	
	public AddVampireCommmand() {
		this.name = String.format("vampire");
		this.details = "add vampire (dracula or explosive) in the position x,y";
		this.shortcut = "v";
		this.help = "[v]ampire [<type>] <x> <y>.";
		
	}
	//por conveniencia de constructores, se ejecutara primero el constructor de argumentos ya que este tiene una llamada al constructor sin argumentos
	// que lo hace a traves del this();
	public AddVampireCommmand(String type, int posx, int posy) {
		this();
		this.type = type;
		this.x = posx;
		this.y = posy;
		
	}

	@Override
	public boolean execute(Game game) {
		boolean executed = false;
		executed = game.addAttackObject(this.type,this.x,this.y);
		if (executed) {
			game.update();
			
		}
		else {
			
		}
		
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if (this.matchCommandName(commandWords[0])) {
			if (commandWords.length != 4 && commandWords.length !=3) {
				System.out.println(incorrectArgsMsg);
				return null;
				
			}
			else if (commandWords.length == 3) {
				this.x = Integer.parseInt(commandWords[1]);		//la clase integer nos permite cambiar de tipo el string que hay en la posicion 2 del array commandWords.
				this.y = Integer.parseInt(commandWords[2]);
				this.type = "";
				return new AddVampireCommmand(this.type,this.x,this.y);
				
			}
			else {
				this.y
				
			}
			
		}
		return null;
	}
	

}
