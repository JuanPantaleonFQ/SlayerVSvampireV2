package control.Commands;

import javax.print.attribute.standard.NumberOfInterveningJobs;

import Exceptions.CommandParseException;
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
		if (!executed) {
			System.out.println(incorrectPosition);
			
		}
		
		
		return executed;
	}

	//como tenemos distintos tipos de vampire, hacemos que el basico es v, y el resto 
	//deben invocarse con argumentos.
	//(explosive,dracula,vampire)
	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if (this.matchCommandName(commandWords[0])) {
			if (commandWords.length != 4 && commandWords.length !=3) {
				throw new CommandParseException("[ERROR]: " + UnvalidArgsForParseMethod());
				
			}
			else if (commandWords.length == 3) {
				try {
					this.x = Integer.parseInt(commandWords[1]);		//la clase integer nos permite cambiar de tipo el string que hay en la posicion 2 del array commandWords.
				    this.y = Integer.parseInt(commandWords[2]);
				    this.type = "";
				} catch (NumberFormatException e) {
					//TODO: handle exception
					throw new CommandParseException("[ERROR]: " + UnvalidArgsForParseMethod())
				}
				return new AddVampireCommmand(this.type,this.x,this.y);
				
			}
			else {
				this.y = Integer.parseInt(commandWords[3]);
				this.x =  Integer.parseInt(commandWords[2]);
				if (commandWords[1].equalsIgnoreCase("d")) {
					this.type = "d";
					return new AddVampireCommmand(this.type,this.x,this.y);


				}
				else if(commandWords[1].equalsIgnoreCase("e")){
					this.type = "e";
					return new AddVampireCommmand(this.type,this.x,this.y);
					
				}
				else {
					System.out.println(nonexistentVampireType);
					return null;
				}
				//--------------------------------------------------------------------
				try {
					this.y = Integer.parseInt(commandWords[3]);
					this.x =  Integer.parseInt(commandWords[2]);
					if (commandWords[1].equalsIgnoreCase("d")) {
						this.type = "d";
						return new AddVampireCommmand(this.type,this.x, this.y);
					} else if(commandWords[1].equalsIgnoreCase("e")) {
						this.type = "e";
						return new AddVampireCommmand(this.type,this.x,this.y);
					}else{
						throw new CommandParseException("[ERROR]: " + UnvalidArgsForParseMethod());
					}
					
				} catch (NumberFormatException e) {
					//TODO: handle exception
					throw new CommandParseException("[ERROR]: " + UnvalidArgsForParseMethod());
				}

				
			}
			
		}
		return null;
	}
	

}
