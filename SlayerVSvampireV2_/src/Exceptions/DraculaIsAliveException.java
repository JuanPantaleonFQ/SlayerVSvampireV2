package Exceptions;

public class DraculaIsAliveException extends CommandExecuteException {

    public DraculaIsAliveException() {super();}
    public DraculaIsAliveException(String message){super(message);}
    public DraculaIsAliveException(String message,Throwable cause){super(message, cause);}
    
}
