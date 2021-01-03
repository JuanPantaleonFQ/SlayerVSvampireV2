package Exceptions;

public class CommandParseException extends GameExceptions {

    public CommandParseException() {super();}
    public CommandParseException(String message){super(message);}
    public CommandParseException(String message,Throwable cause){super(message, cause);}
    
}
