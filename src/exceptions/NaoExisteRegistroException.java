package exceptions;

public class NaoExisteRegistroException extends Exception{
    public NaoExisteRegistroException(String message) {
        super(message);
    }
}
