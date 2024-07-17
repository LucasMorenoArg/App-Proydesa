package exceptions;

public class DAOException extends Exception{

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }


    @Override
    public String getMessage() {
        return "[DAOException] " + super.getMessage();
    }
}
