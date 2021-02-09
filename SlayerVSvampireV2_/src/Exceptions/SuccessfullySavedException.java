package exceptions;

public class SuccessfullySavedException extends CommandExecuteException {
	private static final long serialVersionUID = 1L;
	
	public SuccessfullySavedException () {super();}
	public SuccessfullySavedException (String message) {super(message);}
	public SuccessfullySavedException (String message, Throwable cause) {super(message, cause);}
	public SuccessfullySavedException (Throwable cause) {super(cause);}
	public SuccessfullySavedException (String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);}
}
