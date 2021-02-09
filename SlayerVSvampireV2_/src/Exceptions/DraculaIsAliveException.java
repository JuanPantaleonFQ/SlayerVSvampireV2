package exceptions;

public class DraculaIsAliveException extends CommandExecuteException {
	
	private static final long serialVersionUID = 1L;
	
	public DraculaIsAliveException () {super();}
	public DraculaIsAliveException (String message) {super(message);}
	public DraculaIsAliveException (String message, Throwable cause) {super(message, cause);}
	public DraculaIsAliveException (Throwable cause) {super(cause);}
	public DraculaIsAliveException (String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);}
}
