package exceptions;

public class CommandExecuteException extends GameException {

	private static final long serialVersionUID = 1L;
	
	public CommandExecuteException () {super();}
	public CommandExecuteException (String message) {super(message);}
	public CommandExecuteException (String message, Throwable cause) {super(message, cause);}
	public CommandExecuteException (Throwable cause) {super(cause);}
	public CommandExecuteException (String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);}

}
