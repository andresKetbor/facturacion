package exception;

public class ControllerException extends ServiceException {

    public ControllerException(){
        super();
    }

    public ControllerException(String mesagge){
        super(mesagge);
    }

    public ControllerException(Throwable cause){
        super(cause);
    }

    public ControllerException(String message, Throwable couse) {
        super(message, couse);
    }
}