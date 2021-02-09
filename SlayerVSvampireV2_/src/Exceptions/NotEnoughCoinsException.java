package exceptions;

public class NotEnoughCoinsException extends CommandExecuteException {

	private static final long serialVersionUID = 1L;
	
	public NotEnoughCoinsException () {super();}
	public NotEnoughCoinsException (String message) {super(message);}
	public NotEnoughCoinsException (String message, Throwable cause) {super(message, cause);}
	public NotEnoughCoinsException (Throwable cause) {super(cause);}
	public NotEnoughCoinsException (String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);}
}
