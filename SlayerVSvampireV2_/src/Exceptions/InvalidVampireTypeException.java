package exceptions;

public class InvalidVampireTypeException extends CommandParseException{

	private static final long serialVersionUID = 1L;
	
	public InvalidVampireTypeException () {super();}
	public InvalidVampireTypeException (String message) {super(message);}
	public InvalidVampireTypeException (String message, Throwable cause) {super(message, cause);}
	public InvalidVampireTypeException (Throwable cause) {super(cause);}
	public InvalidVampireTypeException (String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);}
	
	

}
