package exceptions;

public class GameFinException extends GameException {

	private static final long serialVersionUID = 1L;
	
	public GameFinException () {super();}
	public GameFinException (String message) {super(message);}
	public GameFinException (String message, Throwable cause) {super(message, cause);}
	public GameFinException (Throwable cause) {super(cause);}
	public GameFinException (String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);}
}
