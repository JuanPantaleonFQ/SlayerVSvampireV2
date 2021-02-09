package exceptions;

public class NumberFormatException extends CommandParseException {
	
	private static final long serialVersionUID = 1L;
	
	public NumberFormatException () {super();}
	public NumberFormatException (String message) {super(message);}
	public NumberFormatException (String message, Throwable cause) {super(message, cause);}
	public NumberFormatException (Throwable cause) {super(cause);}
	public NumberFormatException (String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);}
}
