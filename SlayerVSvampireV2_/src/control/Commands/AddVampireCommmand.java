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
		this.help = "[v]ampire  [<type>] <x><y>";
		
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
		game.
		
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		
		return null;
	}

}
